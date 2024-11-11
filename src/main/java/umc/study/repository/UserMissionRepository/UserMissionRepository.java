package umc.study.repository.UserMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.UserMissionEntity;

public interface UserMissionRepository extends JpaRepository<UserMissionEntity, Long>, UserMissionRepositoryCustom {
}
