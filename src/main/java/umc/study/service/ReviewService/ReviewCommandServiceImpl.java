package umc.study.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.*;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserRepository.UserRepository;
import umc.study.web.dto.ReviewRequestDTO;


@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public ReviewEntity addReview(ReviewRequestDTO.reviewDTO request, Long storeId) {
        // 사용자로부터 데이터 받아서 entity로 변환
        ReviewEntity review = ReviewConverter.toReview(request);

        // 가게 조회
        StoreEntity store = storeRepository.findById(storeId).get();
        // review - store 연관관계
        review.setStore(store);

        // 사용자
        UserEntity user = userRepository.findById(1L).get();
        // review - user 연관관계
        review.setUser(user);

        return reviewRepository.save(review);
    }
}
