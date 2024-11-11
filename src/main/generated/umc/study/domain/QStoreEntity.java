package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreEntity is a Querydsl query type for StoreEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreEntity extends EntityPathBase<StoreEntity> {

    private static final long serialVersionUID = -751420958L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreEntity storeEntity = new QStoreEntity("storeEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<MissionEntity, QMissionEntity> missionEntityList = this.<MissionEntity, QMissionEntity>createList("missionEntityList", MissionEntity.class, QMissionEntity.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final QRegionEntity regionEntity;

    public final ListPath<ReviewEntity, QReviewEntity> reviewEntityList = this.<ReviewEntity, QReviewEntity>createList("reviewEntityList", ReviewEntity.class, QReviewEntity.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigDecimal> score = createNumber("score", java.math.BigDecimal.class);

    public final ListPath<umc.study.domain.mapping.StoreFoodCategoryEntity, umc.study.domain.mapping.QStoreFoodCategoryEntity> storeFoodCategoryEntityList = this.<umc.study.domain.mapping.StoreFoodCategoryEntity, umc.study.domain.mapping.QStoreFoodCategoryEntity>createList("storeFoodCategoryEntityList", umc.study.domain.mapping.StoreFoodCategoryEntity.class, umc.study.domain.mapping.QStoreFoodCategoryEntity.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreEntity(String variable) {
        this(StoreEntity.class, forVariable(variable), INITS);
    }

    public QStoreEntity(Path<? extends StoreEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreEntity(PathMetadata metadata, PathInits inits) {
        this(StoreEntity.class, metadata, inits);
    }

    public QStoreEntity(Class<? extends StoreEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.regionEntity = inits.isInitialized("regionEntity") ? new QRegionEntity(forProperty("regionEntity")) : null;
    }

}

