package umc.study.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.FoodCategoryEntity;

public interface FoodCategoryRepository extends JpaRepository<FoodCategoryEntity, Long> {
}
