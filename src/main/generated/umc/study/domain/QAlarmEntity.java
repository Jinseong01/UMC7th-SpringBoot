package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlarmEntity is a Querydsl query type for AlarmEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlarmEntity extends EntityPathBase<AlarmEntity> {

    private static final long serialVersionUID = 1145694034L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlarmEntity alarmEntity = new QAlarmEntity("alarmEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isConfirmed = createBoolean("isConfirmed");

    public final StringPath title = createString("title");

    public final EnumPath<umc.study.domain.enums.AlarmType> type = createEnum("type", umc.study.domain.enums.AlarmType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUserEntity userEntity;

    public QAlarmEntity(String variable) {
        this(AlarmEntity.class, forVariable(variable), INITS);
    }

    public QAlarmEntity(Path<? extends AlarmEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlarmEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlarmEntity(PathMetadata metadata, PathInits inits) {
        this(AlarmEntity.class, metadata, inits);
    }

    public QAlarmEntity(Class<? extends AlarmEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity")) : null;
    }

}

