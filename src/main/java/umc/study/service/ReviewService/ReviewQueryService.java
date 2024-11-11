package umc.study.service.ReviewService;

import umc.study.domain.ReviewEntity;

import java.math.BigDecimal;

public interface ReviewQueryService {
    ReviewEntity writeReview(Long userId, Long storeId, String content, BigDecimal score);
}
