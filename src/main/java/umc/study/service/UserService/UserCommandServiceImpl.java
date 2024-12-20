package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.converter.UserConverter;
import umc.study.converter.UserMissionConverter;
import umc.study.converter.UserPreferConverter;
import umc.study.domain.FoodCategoryEntity;
import umc.study.domain.MissionEntity;
import umc.study.domain.UserEntity;
import umc.study.domain.mapping.UserFoodCategoryEntity;
import umc.study.domain.mapping.UserMissionEntity;
import umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.UserMissionRepository.UserMissionRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserEntity joinMember(UserRequestDTO.JoinDto request) {
        // 사용자로부터 데이터 받아서 entity로 변환
        UserEntity user = UserConverter.toUser(request);

        user.encodePassword(passwordEncoder.encode(request.getLogin_password()));

        // 선호 음식 리스트 조회 (ID로 받기 때문에)
        List<FoodCategoryEntity> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                })
                .collect(Collectors.toList())
                ;

        // 선호 음식 카테고리 리스트를 통해 user - userPrefer - food_category의 userPrefer 매핑 테이블 설정
        List<UserFoodCategoryEntity> userPerferList = UserPreferConverter.toUserPerferList(foodCategoryList);

        // 연관관계 편의 메소드로 user와 userPrefer 연관관계 설정
        userPerferList.forEach(
                userPrefer -> {userPrefer.setUser(user);}
        );

        // TODO 매핑 테이블 저장 로직

        return userRepository.save(user);
    }

    @Override
    public UserMissionEntity addMission(Long userId, Long missionId) {
        UserMissionEntity userMission = UserMissionConverter.toUserMission();

        UserEntity user = userRepository.findById(userId).get();
        MissionEntity mission = missionRepository.findById(missionId).get();

        userMission.setUser(user);
        userMission.setMission(mission);

        return userMissionRepository.save(userMission);
    }
}
