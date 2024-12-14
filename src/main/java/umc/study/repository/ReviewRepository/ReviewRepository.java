package umc.study.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.ReviewEntity;
import umc.study.domain.StoreEntity;
import umc.study.domain.UserEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    Page<ReviewEntity> findAllByStoreEntity(StoreEntity store, PageRequest pageRequest);
    Page<ReviewEntity> findAllByUserEntity(UserEntity user, PageRequest pageRequest);
}
