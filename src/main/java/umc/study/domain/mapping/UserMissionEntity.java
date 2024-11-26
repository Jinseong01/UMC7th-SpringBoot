package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.study.domain.MissionEntity;
import umc.study.domain.RegionEntity;
import umc.study.domain.UserEntity;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.UserMissionStatus;

@Table(name = "user_mission")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
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

    public void setUser(UserEntity user){
        if(this.userEntity != null) {
            user.getUserMissionEntityList().remove(this);
        }
        this.userEntity = user;
        user.getUserMissionEntityList().add(this);
    }

    public void setMission(MissionEntity mission){
        if(this.missionEntity != null) {
            mission.getUserMissionEntityList().remove(this);
        }
        this.missionEntity = mission;
        mission.getUserMissionEntityList().add(this);
    }
}
