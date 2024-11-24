package umc.study.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryQueryServcie {

    private final FoodCategoryRepository foodCategoryRepository;

    public Boolean exist(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}
