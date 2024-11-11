package umc.study.repository.UserMissionRepository;

import umc.study.domain.enums.UserMissionStatus;
import umc.study.domain.mapping.UserMissionEntity;

import java.util.List;

public interface UserMissionRepositoryCustom {
    List<UserMissionEntity> findUserMissionByUserIdAndUserMissionStatus(Long userId, UserMissionStatus userMissionStatus, int page, int size);

    List<UserMissionEntity> findUserMissionByUserIdAndRegionIdAndUserMissionStatus(Long userId, Long regionId, UserMissionStatus userMissionStatus, int page, int size);
}