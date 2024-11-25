package umc.study.service.StoreService;

import umc.study.domain.StoreEntity;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<StoreEntity> findStore(Long id);
    List<StoreEntity> findStoresByNameAndScore(String name, Float score);
    StoreEntity findStoreByMissionId(Long missionId);

    public Boolean exist(Long id);
}
