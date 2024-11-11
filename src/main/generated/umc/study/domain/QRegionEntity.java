package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRegionEntity is a Querydsl query type for RegionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRegionEntity extends EntityPathBase<RegionEntity> {

    private static final long serialVersionUID = 992627193L;

    public static final QRegionEntity regionEntity = new QRegionEntity("regionEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<StoreEntity, QStoreEntity> storeEntityList = this.<StoreEntity, QStoreEntity>createList("storeEntityList", StoreEntity.class, QStoreEntity.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRegionEntity(String variable) {
        super(RegionEntity.class, forVariable(variable));
    }

    public QRegionEntity(Path<? extends RegionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegionEntity(PathMetadata metadata) {
        super(RegionEntity.class, metadata);
    }

}

