package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.StoreEntity;
import umc.study.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;

    @Override
    public Optional<StoreEntity> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<StoreEntity> findStoresByNameAndScore(String name, Float score) {
        List<StoreEntity> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public StoreEntity findStoreByMissionId(Long missionId) {
        return null;
    }

    @Override
    public Boolean exist(Long id) {
        return storeRepository.existsById(id);
    }
}