package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodCategoryEntity is a Querydsl query type for FoodCategoryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodCategoryEntity extends EntityPathBase<FoodCategoryEntity> {

    private static final long serialVersionUID = 108954369L;

    public static final QFoodCategoryEntity foodCategoryEntity = new QFoodCategoryEntity("foodCategoryEntity");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<umc.study.domain.mapping.StoreFoodCategoryEntity, umc.study.domain.mapping.QStoreFoodCategoryEntity> storeFoodCategoryEntityList = this.<umc.study.domain.mapping.StoreFoodCategoryEntity, umc.study.domain.mapping.QStoreFoodCategoryEntity>createList("storeFoodCategoryEntityList", umc.study.domain.mapping.StoreFoodCategoryEntity.class, umc.study.domain.mapping.QStoreFoodCategoryEntity.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserFoodCategoryEntity, umc.study.domain.mapping.QUserFoodCategoryEntity> userFoodCategoryEntityList = this.<umc.study.domain.mapping.UserFoodCategoryEntity, umc.study.domain.mapping.QUserFoodCategoryEntity>createList("userFoodCategoryEntityList", umc.study.domain.mapping.UserFoodCategoryEntity.class, umc.study.domain.mapping.QUserFoodCategoryEntity.class, PathInits.DIRECT2);

    public QFoodCategoryEntity(String variable) {
        super(FoodCategoryEntity.class, forVariable(variable));
    }

    public QFoodCategoryEntity(Path<? extends FoodCategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodCategoryEntity(PathMetadata metadata) {
        super(FoodCategoryEntity.class, metadata);
    }

}

