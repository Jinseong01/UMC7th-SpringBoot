package umc.study.service.MissionService;

import umc.study.domain.MissionEntity;
import umc.study.domain.enums.UserMissionStatus;
import java.util.List;

public interface MissionQueryService {
    List<MissionEntity> findMissionByUserIdAndUserMissionStatus(Long userId, UserMissionStatus userMissionStatus, int page, int size);

    Boolean exist(Long id);
}
