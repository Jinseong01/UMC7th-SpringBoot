package umc.study.converter;

import umc.study.domain.ReviewEntity;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewEntity toReview(ReviewRequestDTO.reviewDTO request) {
        return ReviewEntity.builder()
                .content(request.getContent())
                .score(request.getScore())
                .build()
                ;
    }

    public static ReviewResponseDTO.reviewDTO toResultDTO(ReviewEntity review){
        return ReviewResponseDTO.reviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build()
                ;
    }
}
