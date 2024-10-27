package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.UserMissionEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "mission")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MissionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Integer reward;

    private LocalDate deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreEntity storeEntity;

    @OneToMany(mappedBy = "missionEntity", cascade = CascadeType.ALL)
    private List<UserMissionEntity> userMissionEntityList = new ArrayList<>();
}
