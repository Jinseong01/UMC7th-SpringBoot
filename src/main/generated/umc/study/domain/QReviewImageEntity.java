package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewImageEntity is a Querydsl query type for ReviewImageEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewImageEntity extends EntityPathBase<ReviewImageEntity> {

    private static final long serialVersionUID = -1002731036L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewImageEntity reviewImageEntity = new QReviewImageEntity("reviewImageEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final QReviewEntity reviewEntity;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewImageEntity(String variable) {
        this(ReviewImageEntity.class, forVariable(variable), INITS);
    }

    public QReviewImageEntity(Path<? extends ReviewImageEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewImageEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewImageEntity(PathMetadata metadata, PathInits inits) {
        this(ReviewImageEntity.class, metadata, inits);
    }

    public QReviewImageEntity(Class<? extends ReviewImageEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reviewEntity = inits.isInitialized("reviewEntity") ? new QReviewEntity(forProperty("reviewEntity"), inits.get("reviewEntity")) : null;
    }

}

