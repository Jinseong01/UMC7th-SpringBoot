package umc.study.converter;

import umc.study.domain.FoodCategoryEntity;
import umc.study.domain.mapping.UserFoodCategoryEntity;
import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<UserFoodCategoryEntity> toUserPerferList(List<FoodCategoryEntity> foodCategoryList) {
        return foodCategoryList.stream()
                .map(food ->
                        UserFoodCategoryEntity.builder()
                            .foodCategoryEntity(food)
                            .build()
                )
                .collect(Collectors.toList())
                ;
    }
}
