package umc.study.service.UserMissionService;

import umc.study.domain.enums.UserMissionStatus;
import umc.study.domain.mapping.UserMissionEntity;

import java.util.List;

public interface UserMissionQueryService {
    List<UserMissionEntity> findUserMissionByUserIdAndRegionIdAndUserMissionStatus(Long userId, Long regionId, UserMissionStatus status, int page, int size);

    Boolean exist(Long id);

    UserMissionEntity find(Long id);
}
