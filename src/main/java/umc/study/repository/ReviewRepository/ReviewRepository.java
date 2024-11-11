package umc.study.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
