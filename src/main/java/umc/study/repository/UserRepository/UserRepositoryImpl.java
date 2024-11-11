package umc.study.repository.UserRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QUserEntity;
import umc.study.domain.UserEntity;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QUserEntity userEntity = QUserEntity.userEntity;

    @Override
    public UserEntity findByUserId(Long userId) {
        BooleanBuilder bb = new BooleanBuilder();

        bb.and(userEntity.id.eq(userId));

        return jpaQueryFactory
                .selectFrom(userEntity)
                .where(bb)
                .fetchOne();
    }
}
