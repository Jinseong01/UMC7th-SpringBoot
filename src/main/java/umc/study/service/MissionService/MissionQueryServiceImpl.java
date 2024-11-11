package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.MissionEntity;
import umc.study.domain.enums.UserMissionStatus;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final UserMissionRepository userMissionRepository;

    @Override
    public List<MissionEntity> findMissionByUserIdAndUserMissionStatus(Long userId, UserMissionStatus userMissionStatus, int page, int size) {
        //1. 사용자 ID와 미션 진행 여부에 따른 UserMission리스트 필터링
        List<UserMissionEntity> filteredUserMissions = userMissionRepository.findUserMissionByUserIdAndUserMissionStatus(userId, userMissionStatus, page, size);

        //2. 필터링된 UserMissionEntity에서 Mission리스트만 선택
        List<MissionEntity> missionList = filteredUserMissions.stream()
                .map(userMission -> userMission.getMissionEntity())
                .toList();

        return missionList;
    }
}
