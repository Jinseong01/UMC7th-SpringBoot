package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserFoodCategoryEntity is a Querydsl query type for UserFoodCategoryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserFoodCategoryEntity extends EntityPathBase<UserFoodCategoryEntity> {

    private static final long serialVersionUID = 677561420L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserFoodCategoryEntity userFoodCategoryEntity = new QUserFoodCategoryEntity("userFoodCategoryEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.study.domain.QFoodCategoryEntity foodCategoryEntity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.study.domain.QUserEntity userEntity;

    public QUserFoodCategoryEntity(String variable) {
        this(UserFoodCategoryEntity.class, forVariable(variable), INITS);
    }

    public QUserFoodCategoryEntity(Path<? extends UserFoodCategoryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserFoodCategoryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserFoodCategoryEntity(PathMetadata metadata, PathInits inits) {
        this(UserFoodCategoryEntity.class, metadata, inits);
    }

    public QUserFoodCategoryEntity(Class<? extends UserFoodCategoryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategoryEntity = inits.isInitialized("foodCategoryEntity") ? new umc.study.domain.QFoodCategoryEntity(forProperty("foodCategoryEntity")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new umc.study.domain.QUserEntity(forProperty("userEntity")) : null;
    }

}

