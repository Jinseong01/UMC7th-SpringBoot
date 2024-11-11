package umc.study.service.UserService;

import umc.study.domain.UserEntity;

public interface UserQueryService {
    UserEntity findUser(Long userId);
}
