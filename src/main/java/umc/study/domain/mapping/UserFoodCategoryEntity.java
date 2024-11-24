package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.FoodCategoryEntity;
import umc.study.domain.UserEntity;
import umc.study.domain.common.BaseEntity;

@Table(name = "user_food_category")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserFoodCategoryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private FoodCategoryEntity foodCategoryEntity;

    public void setUser(UserEntity user){
        if(this.userEntity != null)
            user.getUserFoodCategoryEntityList().remove(this);
        this.userEntity = user;
        user.getUserFoodCategoryEntityList().add(this);
    }

    public void setFoodCategory(FoodCategoryEntity foodCategory){
        this.foodCategoryEntity = foodCategory;
    }
}
