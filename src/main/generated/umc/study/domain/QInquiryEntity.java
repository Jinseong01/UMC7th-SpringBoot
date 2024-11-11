package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiryEntity is a Querydsl query type for InquiryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiryEntity extends EntityPathBase<InquiryEntity> {

    private static final long serialVersionUID = -276132152L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInquiryEntity inquiryEntity = new QInquiryEntity("inquiryEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<InquiryImageEntity, QInquiryImageEntity> inquiryImageEntityList = this.<InquiryImageEntity, QInquiryImageEntity>createList("inquiryImageEntityList", InquiryImageEntity.class, QInquiryImageEntity.class, PathInits.DIRECT2);

    public final QInquiryResponseEntity inquiryResponseEntity;

    public final StringPath title = createString("title");

    public final EnumPath<umc.study.domain.enums.InquiryType> type = createEnum("type", umc.study.domain.enums.InquiryType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUserEntity userEntity;

    public QInquiryEntity(String variable) {
        this(InquiryEntity.class, forVariable(variable), INITS);
    }

    public QInquiryEntity(Path<? extends InquiryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInquiryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInquiryEntity(PathMetadata metadata, PathInits inits) {
        this(InquiryEntity.class, metadata, inits);
    }

    public QInquiryEntity(Class<? extends InquiryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inquiryResponseEntity = inits.isInitialized("inquiryResponseEntity") ? new QInquiryResponseEntity(forProperty("inquiryResponseEntity"), inits.get("inquiryResponseEntity")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity")) : null;
    }

}

