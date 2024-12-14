package umc.study.service.MissionService;

import umc.study.domain.MissionEntity;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public MissionEntity addMission(MissionRequestDTO.MissionAddDTO request, Long storeId);

    UserMissionEntity completeUserMission(Long userMissionId, Long userId);
}
