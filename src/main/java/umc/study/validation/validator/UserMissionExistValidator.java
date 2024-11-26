package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.service.UserMissionService.UserMissionQueryService;
import umc.study.validation.annotation.ExistMission;
import umc.study.validation.annotation.ExistUM;

@Component
@RequiredArgsConstructor
public class UserMissionExistValidator implements ConstraintValidator<ExistUM, Long> {

    private final UserMissionQueryService userMissionQueryService;

    @Override
    public void initialize(ExistUM constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        // id값이 존재하는지 체크 (없으면 false)
        boolean isValid = userMissionQueryService.exist(value);

        // 있으면
        if (isValid) {
            context.disableDefaultConstraintViolation();

            UserMissionEntity userMissionEntity  = userMissionQueryService.find(value);

            switch (userMissionEntity.getStatus()) {
                case COMPLETE :
                    context.buildConstraintViolationWithTemplate(ErrorStatus.UM_COMPLETE.toString()).addConstraintViolation();
                    break;
                case INPROGRESS :
                    context.buildConstraintViolationWithTemplate(ErrorStatus.UM_INPROGRESS.toString()).addConstraintViolation();
                    break;
            }
        }

        return !isValid;
    }
}
