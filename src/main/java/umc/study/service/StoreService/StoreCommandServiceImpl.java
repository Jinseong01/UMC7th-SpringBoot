package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.converter.StoreFoodConverter;
import umc.study.domain.FoodCategoryEntity;
import umc.study.domain.RegionEntity;
import umc.study.domain.StoreEntity;
import umc.study.domain.mapping.StoreFoodCategoryEntity;
import umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public StoreEntity addStore(StoreRequestDTO.AddDTO request) {
        // 사용자로부터 데이터 받아서 entity로 변환
        StoreEntity store = StoreConverter.toStore(request);

        // 지역 조회
        RegionEntity region = regionRepository.findById(request.getRegion()).get();

        // 선호 음식 리스트 조회
        List<FoodCategoryEntity> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).get();
                })
                .collect(Collectors.toList())
                ;

        // store - store_food - foodCategory
        // 선호 음식 카테고리 리스트를 통해 storeFood-foodCategory 매핑 테이블 설정
        List<StoreFoodCategoryEntity> storeFoodList = StoreFoodConverter.toStoreFoodList(foodCategoryList);

        // 연관관계 편의 메소드로 store와 storeFood 연관관계 설정
        storeFoodList.forEach(
                storeFood -> {storeFood.setStore(store);}
        );

        // TODO store_food 저장 로직

        // store - region
        store.setRegion(region);

        return storeRepository.save(store);
    }
}
