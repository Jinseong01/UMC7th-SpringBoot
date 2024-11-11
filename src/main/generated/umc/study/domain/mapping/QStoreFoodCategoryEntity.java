package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreFoodCategoryEntity is a Querydsl query type for StoreFoodCategoryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreFoodCategoryEntity extends EntityPathBase<StoreFoodCategoryEntity> {

    private static final long serialVersionUID = 1728610014L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreFoodCategoryEntity storeFoodCategoryEntity = new QStoreFoodCategoryEntity("storeFoodCategoryEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.study.domain.QFoodCategoryEntity foodCategoryEntity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.study.domain.QStoreEntity storeEntity;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreFoodCategoryEntity(String variable) {
        this(StoreFoodCategoryEntity.class, forVariable(variable), INITS);
    }

    public QStoreFoodCategoryEntity(Path<? extends StoreFoodCategoryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreFoodCategoryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreFoodCategoryEntity(PathMetadata metadata, PathInits inits) {
        this(StoreFoodCategoryEntity.class, metadata, inits);
    }

    public QStoreFoodCategoryEntity(Class<? extends StoreFoodCategoryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategoryEntity = inits.isInitialized("foodCategoryEntity") ? new umc.study.domain.QFoodCategoryEntity(forProperty("foodCategoryEntity")) : null;
        this.storeEntity = inits.isInitialized("storeEntity") ? new umc.study.domain.QStoreEntity(forProperty("storeEntity"), inits.get("storeEntity")) : null;
    }

}

