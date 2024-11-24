package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.study.service.FoodCategoryService.FoodCategoryQueryServcie;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    private final FoodCategoryRepository foodCategoryRepository;
    private final FoodCategoryQueryServcie foodCategoryQueryServcie;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        // id값이 다 존재하는지 체크 (없으면 false)
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryQueryServcie.exist(value));

        // 없으면
        if (!isValid) {
            // 기본 제약 조건 위반 메시지 비활성화
            context.disableDefaultConstraintViolation();

            // 커스텀 제약 조건 위반 메시지
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
