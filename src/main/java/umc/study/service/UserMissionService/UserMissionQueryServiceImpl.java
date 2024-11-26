package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.enums.UserMissionStatus;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMissionQueryServiceImpl implements UserMissionQueryService {

    private final UserMissionRepository userMissionRepository;

    @Override
    public List<UserMissionEntity> findUserMissionByUserIdAndRegionIdAndUserMissionStatus(Long userId, Long regionId, UserMissionStatus status, int page, int size) {
        List<UserMissionEntity> filteredUserMissions = userMissionRepository.findUserMissionByUserIdAndRegionIdAndUserMissionStatus(userId, regionId, status, page, size);

        return filteredUserMissions;
    }

    @Override
    public Boolean exist(Long missionId) {
        return userMissionRepository.existsByUserEntityIdAndMissionEntityId(1L, missionId);
    }

    @Override
    public UserMissionEntity find(Long missionId) {
        return userMissionRepository.findByUserEntityIdAndMissionEntityId(1L, missionId);
    }
}
