package umc.study.converter;

import umc.study.domain.mapping.UserMissionEntity;

public class UserMissionConverter {
    public static UserMissionEntity toUserMission(){
        return UserMissionEntity.builder()
                .build()
                ;
    }
}
