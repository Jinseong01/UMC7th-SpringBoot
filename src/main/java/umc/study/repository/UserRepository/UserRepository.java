package umc.study.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.UserEntity;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {
    Optional<UserEntity> findByEmail(String email);
}
