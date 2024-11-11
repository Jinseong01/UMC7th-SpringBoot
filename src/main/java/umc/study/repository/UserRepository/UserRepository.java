package umc.study.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {
}
