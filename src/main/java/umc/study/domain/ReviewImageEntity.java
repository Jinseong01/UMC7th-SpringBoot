package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Table(name = "review_image")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewImageEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String imageUrl;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id ")
    private ReviewEntity reviewEntity;
}
