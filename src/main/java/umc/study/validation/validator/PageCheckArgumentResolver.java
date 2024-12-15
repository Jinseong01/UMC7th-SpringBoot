package umc.study.validation.validator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.PageCheckHandler;
import umc.study.validation.annotation.CheckPage;

@Slf4j
@Component
@RequiredArgsConstructor
public class PageCheckArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 파라미터에 @CheckPage 어노테이션이 붙어 있는지 확인
        return parameter.hasParameterAnnotation(CheckPage.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        log.info("리졸버 실행");

        String pageParam = webRequest.getParameter("page");

        // 페이지 파라미터가 없을 경우
        if (pageParam == null || pageParam.isEmpty()) {
            throw new PageCheckHandler(ErrorStatus.PAGE_NOT_FOUND);
        }

        int page = Integer.parseInt(pageParam);

        // 페이지 파라미터가 0이하일 경우
        if (page <= 0) {
            throw new PageCheckHandler(ErrorStatus.PAGE_WRONG);
        }

        return page-1;
    }
}
