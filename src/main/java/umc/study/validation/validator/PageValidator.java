//package umc.study.validation.validator;
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import umc.study.apiPayload.code.status.ErrorStatus;
//import umc.study.domain.mapping.UserMissionEntity;
//import umc.study.service.UserMissionService.UserMissionQueryService;
//import umc.study.validation.annotation.CheckPage;
//import umc.study.validation.annotation.ExistUM;
//
//@Component
//@RequiredArgsConstructor
//public class PageValidator implements ConstraintValidator<CheckPage, Integer> {
//
//    @Override
//    public void initialize(CheckPage constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }
//
//    @Override
//    public boolean isValid(Integer page, ConstraintValidatorContext context) {
//        // 페이지가 음수면
//        if (page <= 0) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_WRONG.toString()).addConstraintViolation();
//            return false;
//        }
//
//        return true;
//    }
//}
