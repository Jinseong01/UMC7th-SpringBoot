package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiryImageEntity is a Querydsl query type for InquiryImageEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiryImageEntity extends EntityPathBase<InquiryImageEntity> {

    private static final long serialVersionUID = -22731431L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInquiryImageEntity inquiryImageEntity = new QInquiryImageEntity("inquiryImageEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final QInquiryEntity inquiryEntity;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QInquiryImageEntity(String variable) {
        this(InquiryImageEntity.class, forVariable(variable), INITS);
    }

    public QInquiryImageEntity(Path<? extends InquiryImageEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInquiryImageEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInquiryImageEntity(PathMetadata metadata, PathInits inits) {
        this(InquiryImageEntity.class, metadata, inits);
    }

    public QInquiryImageEntity(Class<? extends InquiryImageEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inquiryEntity = inits.isInitialized("inquiryEntity") ? new QInquiryEntity(forProperty("inquiryEntity"), inits.get("inquiryEntity")) : null;
    }

}

