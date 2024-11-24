package umc.study.converter;

import umc.study.domain.FoodCategoryEntity;
import umc.study.domain.mapping.StoreFoodCategoryEntity;

import java.util.List;
import java.util.stream.Collectors;

public class StoreFoodConverter {
    public static List<StoreFoodCategoryEntity> toStoreFoodList(List<FoodCategoryEntity> foodCategoryList) {
        return foodCategoryList.stream()
                .map(food ->
                        StoreFoodCategoryEntity.builder()
                                .foodCategoryEntity(food)
                                .build()
                )
                .collect(Collectors.toList())
                ;
    }
}
