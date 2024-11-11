package umc.study.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.StoreEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Long>, StoreRepositoryCustom {
}