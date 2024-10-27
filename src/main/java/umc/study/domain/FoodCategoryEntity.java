package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.StoreFoodCategoryEntity;
import umc.study.domain.mapping.UserFoodCategoryEntity;

import java.util.ArrayList;
import java.util.List;

@Table(name = "food_category")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategoryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @OneToMany(mappedBy = "foodCategoryEntity", cascade = CascadeType.ALL)
    private List<StoreFoodCategoryEntity> storeFoodCategoryEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "foodCategoryEntity", cascade = CascadeType.ALL)
    private List<UserFoodCategoryEntity> userFoodCategoryEntityList = new ArrayList<>();
}
