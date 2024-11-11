package umc.study.repository.UserRepository;

import umc.study.domain.UserEntity;

public interface UserRepositoryCustom {
    UserEntity findByUserId(Long userId);
}
