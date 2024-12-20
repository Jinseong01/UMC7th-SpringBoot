package umc.study.converter;

import umc.study.domain.UserEntity;
import umc.study.domain.enums.UserGender;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(UserEntity user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserResponseDTO.ChallengeMissionResultDTO toChallengeMissionResultDTO(UserMissionEntity userMission){
        return UserResponseDTO.ChallengeMissionResultDTO.builder()
                .userMissionId(userMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserEntity toUser(UserRequestDTO.JoinDto request){

        UserGender gender = null;

        switch (request.getGender()){
            case 1:
                gender = UserGender.MALE;
                break;
            case 2:
                gender = UserGender.FEMALE;
                break;
        }

        return UserEntity.builder()
                .login_id(request.getLogin_id())
                .login_password(request.getLogin_password())
                .email(request.getEmail())
                .name(request.getName())
                .nickname(request.getNickname())
                .phoneNumber(request.getPhoneNumber())
                .isVerified(false)
                .gender(gender)
                .birthDay(request.getBirthday())
                .address(request.getAddress())
                .userFoodCategoryEntityList(new ArrayList<>())
                .role(request.getRole())
                .build()
                ;
    }
}
