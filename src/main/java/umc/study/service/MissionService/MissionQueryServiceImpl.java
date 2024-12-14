package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.MissionEntity;
import umc.study.domain.ReviewEntity;
import umc.study.domain.StoreEntity;
import umc.study.domain.UserEntity;
import umc.study.domain.enums.UserMissionStatus;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final UserMissionRepository userMissionRepository;
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

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

    @Override
    public Boolean exist(Long id) {
        return missionRepository.existsById(id);
    }

    @Override
    public Page<MissionEntity> getStoreMissionList(Long storeId, Integer page) {
        StoreEntity store = storeRepository.findById(storeId).get();

        Page<MissionEntity> missionPage = missionRepository.findAllByStoreEntity(store, PageRequest.of(page, 10));

        return missionPage;
    }
}
