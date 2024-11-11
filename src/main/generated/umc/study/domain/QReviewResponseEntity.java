package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewResponseEntity is a Querydsl query type for ReviewResponseEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewResponseEntity extends EntityPathBase<ReviewResponseEntity> {

    private static final long serialVersionUID = 164114686L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewResponseEntity reviewResponseEntity = new QReviewResponseEntity("reviewResponseEntity");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QReviewEntity reviewEntity;

    public QReviewResponseEntity(String variable) {
        this(ReviewResponseEntity.class, forVariable(variable), INITS);
    }

    public QReviewResponseEntity(Path<? extends ReviewResponseEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewResponseEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewResponseEntity(PathMetadata metadata, PathInits inits) {
        this(ReviewResponseEntity.class, metadata, inits);
    }

    public QReviewResponseEntity(Class<? extends ReviewResponseEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reviewEntity = inits.isInitialized("reviewEntity") ? new QReviewEntity(forProperty("reviewEntity"), inits.get("reviewEntity")) : null;
    }

}

