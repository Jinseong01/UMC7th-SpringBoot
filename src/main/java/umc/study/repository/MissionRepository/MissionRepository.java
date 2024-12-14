package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.MissionEntity;
import umc.study.domain.StoreEntity;

public interface MissionRepository extends JpaRepository<MissionEntity, Long> {
    Page<MissionEntity> findAllByStoreEntity(StoreEntity store, PageRequest pageRequest);
}
