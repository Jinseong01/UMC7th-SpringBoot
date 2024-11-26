package umc.study.repository.UserMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.UserMissionEntity;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMissionEntity, Long>, UserMissionRepositoryCustom {
    boolean existsByUserEntityIdAndMissionEntityId(Long userId, Long missionId);
    UserMissionEntity findByUserEntityIdAndMissionEntityId(Long userId, Long id);
}
