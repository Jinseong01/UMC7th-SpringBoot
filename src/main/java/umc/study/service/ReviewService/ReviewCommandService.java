package umc.study.service.ReviewService;

import umc.study.domain.ReviewEntity;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    public ReviewEntity addReview(ReviewRequestDTO.ReviewAddDTO request, Long storeId);
}
