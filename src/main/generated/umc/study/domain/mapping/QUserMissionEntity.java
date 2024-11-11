package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserMissionEntity is a Querydsl query type for UserMissionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserMissionEntity extends EntityPathBase<UserMissionEntity> {

    private static final long serialVersionUID = 70367906L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserMissionEntity userMissionEntity = new QUserMissionEntity("userMissionEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.study.domain.QMissionEntity missionEntity;

    public final EnumPath<umc.study.domain.enums.UserMissionStatus> status = createEnum("status", umc.study.domain.enums.UserMissionStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.study.domain.QUserEntity userEntity;

    public QUserMissionEntity(String variable) {
        this(UserMissionEntity.class, forVariable(variable), INITS);
    }

    public QUserMissionEntity(Path<? extends UserMissionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserMissionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserMissionEntity(PathMetadata metadata, PathInits inits) {
        this(UserMissionEntity.class, metadata, inits);
    }

    public QUserMissionEntity(Class<? extends UserMissionEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.missionEntity = inits.isInitialized("missionEntity") ? new umc.study.domain.QMissionEntity(forProperty("missionEntity"), inits.get("missionEntity")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new umc.study.domain.QUserEntity(forProperty("userEntity")) : null;
    }

}

