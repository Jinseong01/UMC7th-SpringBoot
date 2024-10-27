package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.MissionEntity;
import umc.study.domain.UserEntity;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.UserMissionStatus;

@Table(name = "user_mission")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMissionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'INPROGRESS'")
    private UserMissionStatus status;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    // 외래키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private MissionEntity missionEntity;
}
