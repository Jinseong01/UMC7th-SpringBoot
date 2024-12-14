package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.ReviewEntity;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static ReviewEntity toReview(ReviewRequestDTO.ReviewAddDTO request) {
        return ReviewEntity.builder()
                .content(request.getContent())
                .score(request.getScore())
                .build()
                ;
    }

    public static ReviewResponseDTO.ReviewAddResultDTO toResultDTO(ReviewEntity review){
        return ReviewResponseDTO.ReviewAddResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build()
                ;
    }

    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(ReviewEntity review){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUserEntity().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }
    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<ReviewEntity> reviewList){

        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
