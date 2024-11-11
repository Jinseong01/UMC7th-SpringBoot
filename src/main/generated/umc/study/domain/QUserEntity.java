package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = 956590608L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final ListPath<AlarmEntity, QAlarmEntity> alarmEntityList = this.<AlarmEntity, QAlarmEntity>createList("alarmEntityList", AlarmEntity.class, QAlarmEntity.class, PathInits.DIRECT2);

    public final StringPath birthDay = createString("birthDay");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.study.domain.enums.UserGender> gender = createEnum("gender", umc.study.domain.enums.UserGender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveAt = createDate("inactiveAt", java.time.LocalDate.class);

    public final ListPath<InquiryEntity, QInquiryEntity> inquiryEntityList = this.<InquiryEntity, QInquiryEntity>createList("inquiryEntityList", InquiryEntity.class, QInquiryEntity.class, PathInits.DIRECT2);

    public final BooleanPath isVerified = createBoolean("isVerified");

    public final StringPath login_id = createString("login_id");

    public final StringPath login_password = createString("login_password");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<ReviewEntity, QReviewEntity> reviewEntityList = this.<ReviewEntity, QReviewEntity>createList("reviewEntityList", ReviewEntity.class, QReviewEntity.class, PathInits.DIRECT2);

    public final EnumPath<umc.study.domain.enums.UserStatus> status = createEnum("status", umc.study.domain.enums.UserStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserFoodCategoryEntity, umc.study.domain.mapping.QUserFoodCategoryEntity> userFoodCategoryEntityList = this.<umc.study.domain.mapping.UserFoodCategoryEntity, umc.study.domain.mapping.QUserFoodCategoryEntity>createList("userFoodCategoryEntityList", umc.study.domain.mapping.UserFoodCategoryEntity.class, umc.study.domain.mapping.QUserFoodCategoryEntity.class, PathInits.DIRECT2);

    public final ListPath<umc.study.domain.mapping.UserMissionEntity, umc.study.domain.mapping.QUserMissionEntity> userMissionEntityList = this.<umc.study.domain.mapping.UserMissionEntity, umc.study.domain.mapping.QUserMissionEntity>createList("userMissionEntityList", umc.study.domain.mapping.UserMissionEntity.class, umc.study.domain.mapping.QUserMissionEntity.class, PathInits.DIRECT2);

    public QUserEntity(String variable) {
        super(UserEntity.class, forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata metadata) {
        super(UserEntity.class, metadata);
    }

}

