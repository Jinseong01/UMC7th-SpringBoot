package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Role;
import umc.study.domain.enums.UserGender;
import umc.study.domain.enums.UserStatus;
import umc.study.domain.mapping.UserFoodCategoryEntity;
import umc.study.domain.mapping.UserMissionEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "user")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String login_id;

    @Column(nullable = false)
    private String login_password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(nullable = false)
    private Boolean isVerified;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private UserGender gender;

    @Column(nullable = false, length = 10)
    private String birthDay;

    @Column(nullable = false, length = 100)
    private String address;

    @ColumnDefault("0")
    private Integer point;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'ACTIVE'")
    private UserStatus status;

    private LocalDate inactiveAt;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<UserFoodCategoryEntity> userFoodCategoryEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<UserMissionEntity> userMissionEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<AlarmEntity> alarmEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<InquiryEntity> inquiryEntityList = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", point=" + point +
                ", isVerified=" + isVerified +
                '}';
    }

    @Enumerated(EnumType.STRING)
    private Role role;
    
    public void encodePassword(String password) {
        this.login_password = password;
    }
}
