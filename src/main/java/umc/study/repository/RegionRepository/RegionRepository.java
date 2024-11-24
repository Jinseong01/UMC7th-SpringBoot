package umc.study.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Long> {
}
