package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Table(name = "review")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String nickName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal score;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreEntity storeEntity;

    @OneToOne(mappedBy = "reviewEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ReviewResponseEntity reviewResponseEntity;

    @OneToMany(mappedBy = "reviewEntity", cascade = CascadeType.ALL)
    private List<ReviewImageEntity> reviewImageEntityList = new ArrayList<>();
}
