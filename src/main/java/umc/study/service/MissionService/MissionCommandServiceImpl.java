package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MissionConverter;
import umc.study.domain.MissionEntity;
import umc.study.domain.StoreEntity;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public MissionEntity addMission(MissionRequestDTO.MissionAddDTO request, Long storeId) {
        // 사용자로부터 데이터 받아서 entity로 변환
        MissionEntity mission = MissionConverter.toMission(request);

        // 가게 조회
        StoreEntity store = storeRepository.findById(storeId).get();
        // mission - store 연관관계
        mission.setStore(store);

        return missionRepository.save(mission);
    }
}
