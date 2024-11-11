package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.ReviewEntity;
import umc.study.domain.StoreEntity;
import umc.study.domain.UserEntity;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserRepository.UserRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewEntity writeReview(Long userId, Long storeId, String content, BigDecimal score) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Null"));

        StoreEntity storeEntity = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store Null"));

        ReviewEntity reviewEntity = ReviewEntity.builder()
                .userEntity(userEntity)
                .storeEntity(storeEntity)
                .nickname(userEntity.getNickname())
                .content(content)
                .score(score)
                .build()
                ;

        return reviewRepository.save(reviewEntity);
    }
}
