package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiryResponseEntity is a Querydsl query type for InquiryResponseEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiryResponseEntity extends EntityPathBase<InquiryResponseEntity> {

    private static final long serialVersionUID = -1855330967L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInquiryResponseEntity inquiryResponseEntity = new QInquiryResponseEntity("inquiryResponseEntity");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QInquiryEntity inquiryEntity;

    public QInquiryResponseEntity(String variable) {
        this(InquiryResponseEntity.class, forVariable(variable), INITS);
    }

    public QInquiryResponseEntity(Path<? extends InquiryResponseEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInquiryResponseEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInquiryResponseEntity(PathMetadata metadata, PathInits inits) {
        this(InquiryResponseEntity.class, metadata, inits);
    }

    public QInquiryResponseEntity(Class<? extends InquiryResponseEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inquiryEntity = inits.isInitialized("inquiryEntity") ? new QInquiryEntity(forProperty("inquiryEntity"), inits.get("inquiryEntity")) : null;
    }

}

