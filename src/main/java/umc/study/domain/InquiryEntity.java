package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.InquiryType;

import java.util.ArrayList;
import java.util.List;

@Table(name = "inquiry")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class InquiryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private InquiryType type;

    @Column(nullable = false, length = 40)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne(mappedBy = "inquiryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private InquiryResponseEntity inquiryResponseEntity;

    @OneToMany(mappedBy = "inquiryEntity", cascade = CascadeType.ALL)
    private List<InquiryImageEntity> inquiryImageEntityList = new ArrayList<>();
}
