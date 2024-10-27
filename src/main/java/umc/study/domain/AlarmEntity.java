package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.AlarmType;

@Table(name = "alarm")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AlarmEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isConfirmed;

    @Column(nullable = false, length = 40)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private AlarmType type;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
