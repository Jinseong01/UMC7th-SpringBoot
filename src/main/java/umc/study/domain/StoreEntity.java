package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.StoreFoodCategoryEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Table(name = "store")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StoreEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(precision = 2, scale = 1, columnDefinition = "DECIMAL(2,1) DEFAULT 0.0")
    private BigDecimal score;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private RegionEntity regionEntity;

    @OneToMany(mappedBy = "storeEntity", cascade = CascadeType.ALL)
    private List<StoreFoodCategoryEntity> storeFoodCategoryEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "storeEntity", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "storeEntity", cascade = CascadeType.ALL)
    private List<MissionEntity> missionEntityList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", region=" + (regionEntity != null ? regionEntity.getName() : "N/A") + // region의 이름 출력
                '}';
    }

    public void setRegion(RegionEntity region){
        if(this.regionEntity != null) {
            region.getStoreEntityList().remove(this);
        }
        this.regionEntity = region;
        region.getStoreEntityList().add(this);
    }
}
