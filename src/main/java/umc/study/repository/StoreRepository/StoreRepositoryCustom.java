package umc.study.repository.StoreRepository;

import umc.study.domain.StoreEntity;

import java.util.List;


public interface StoreRepositoryCustom {
    List<StoreEntity> dynamicQueryWithBooleanBuilder(String name, Float score);
}
