package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.UserHandler;
import umc.study.apiPayload.exception.handler.UserMissionHandler;
import umc.study.converter.MissionConverter;
import umc.study.domain.MissionEntity;
import umc.study.domain.StoreEntity;
import umc.study.domain.UserEntity;
import umc.study.domain.enums.UserMissionStatus;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.MissionRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

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

    @Override
    public UserMissionEntity completeUserMission(Long userMissionId, Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));

        UserMissionEntity userMission = userMissionRepository.findByIdAndUserEntity(userMissionId, user)
                .orElseThrow(() -> new UserMissionHandler(ErrorStatus.UM_NOT_FOUND));

        if (userMission.getStatus().equals(UserMissionStatus.COMPLETE)) {
            throw new UserMissionHandler(ErrorStatus.UM_COMPLETE);
        }

        userMission.setStatus(UserMissionStatus.COMPLETE);

        return userMissionRepository.save(userMission);
    }
}
