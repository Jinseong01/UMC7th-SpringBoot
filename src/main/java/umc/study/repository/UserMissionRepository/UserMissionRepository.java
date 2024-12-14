package umc.study.repository.UserMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import umc.study.domain.MissionEntity;
import umc.study.domain.UserEntity;
import umc.study.domain.enums.UserMissionStatus;
import umc.study.domain.mapping.UserMissionEntity;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMissionEntity, Long>, UserMissionRepositoryCustom {
    boolean existsByUserEntityIdAndMissionEntityId(Long userId, Long missionId);
    UserMissionEntity findByUserEntityIdAndMissionEntityId(Long userId, Long id);

    Page<UserMissionEntity> findAllByUserEntityAndStatus(UserEntity user, UserMissionStatus status, PageRequest pageRequest);
}
