package umc.study.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.MissionEntity;

public interface MissionRepository extends JpaRepository<MissionEntity, Long> {
}
