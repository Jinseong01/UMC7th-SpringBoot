package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.study.domain.ReviewEntity;

import java.math.BigDecimal;

public interface ReviewQueryService {
    ReviewEntity writeReview(Long userId, Long storeId, String content, BigDecimal score);
    Page<ReviewEntity> getReviewList(Long storeId, Integer page);

    Page<ReviewEntity> getMyReviewList(Long userId, Integer page);
}
