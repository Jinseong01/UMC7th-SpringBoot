package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Table(name = "region")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RegionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "regionEntity", cascade = CascadeType.ALL)
    private List<StoreEntity> storeEntityList = new ArrayList<>();
}
