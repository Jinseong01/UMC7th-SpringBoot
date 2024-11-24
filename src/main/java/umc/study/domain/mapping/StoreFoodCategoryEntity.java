package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.FoodCategoryEntity;
import umc.study.domain.StoreEntity;
import umc.study.domain.UserEntity;
import umc.study.domain.common.BaseEntity;

@Table(name = "store_food_category")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StoreFoodCategoryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private FoodCategoryEntity foodCategoryEntity;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreEntity storeEntity;

    public void setStore(StoreEntity store){
        if(this.storeEntity != null)
            store.getStoreFoodCategoryEntityList().remove(this);
        this.storeEntity = store;
        store.getStoreFoodCategoryEntityList().add(this);
    }
}
