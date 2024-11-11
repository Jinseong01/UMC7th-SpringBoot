package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.UserEntity;
import umc.study.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    @Override
    public UserEntity findUser(Long userId) {
        return userRepository.findByUserId(userId);
    }
}
