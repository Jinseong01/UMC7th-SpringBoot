package umc.study.service.UserService;

import umc.study.domain.UserEntity;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.web.dto.UserRequestDTO;

public interface UserCommandService {
    public UserEntity joinMember(UserRequestDTO.JoinDto request);

    public UserMissionEntity addMission(Long userId, Long missionId);
}
