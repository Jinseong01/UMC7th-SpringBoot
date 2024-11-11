package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissionEntity is a Querydsl query type for MissionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissionEntity extends EntityPathBase<MissionEntity> {

    private static final long serialVersionUID = 1187831501L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissionEntity missionEntity = new QMissionEntity("missionEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> deadline = createDate("deadline", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> reward = createNumber("reward", Integer.class);

    public final QStoreEntity storeEntity;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserMissionEntity, umc.study.domain.mapping.QUserMissionEntity> userMissionEntityList = this.<umc.study.domain.mapping.UserMissionEntity, umc.study.domain.mapping.QUserMissionEntity>createList("userMissionEntityList", umc.study.domain.mapping.UserMissionEntity.class, umc.study.domain.mapping.QUserMissionEntity.class, PathInits.DIRECT2);

    public QMissionEntity(String variable) {
        this(MissionEntity.class, forVariable(variable), INITS);
    }

    public QMissionEntity(Path<? extends MissionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissionEntity(PathMetadata metadata, PathInits inits) {
        this(MissionEntity.class, metadata, inits);
    }

    public QMissionEntity(Class<? extends MissionEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.storeEntity = inits.isInitialized("storeEntity") ? new QStoreEntity(forProperty("storeEntity"), inits.get("storeEntity")) : null;
    }

}

