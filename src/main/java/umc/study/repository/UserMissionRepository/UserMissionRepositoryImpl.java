package umc.study.repository.UserMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMissionEntity;
import umc.study.domain.QRegionEntity;
import umc.study.domain.QStoreEntity;
import umc.study.domain.QUserEntity;
import umc.study.domain.enums.UserMissionStatus;
import umc.study.domain.mapping.QUserMissionEntity;
import umc.study.domain.mapping.UserMissionEntity;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserMissionRepositoryImpl implements UserMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QUserMissionEntity userMissionEntity = QUserMissionEntity.userMissionEntity;

    @Override
    public List<UserMissionEntity> findUserMissionByUserIdAndUserMissionStatus(Long userId, UserMissionStatus userMissionStatus, int page, int size) {
        BooleanBuilder bb = new BooleanBuilder();

        bb.and(userMissionEntity.userEntity.id.eq(userId));
        bb.and(userMissionEntity.status.eq(userMissionStatus));

        return jpaQueryFactory
                .selectFrom(userMissionEntity)
                .leftJoin(userMissionEntity.missionEntity.storeEntity)
                .fetchJoin() //즉시 로딩을 위해
                .where(bb)
                .offset((long) (page - 1) * size) // OFFSET: 페이지 번호 * 페이지 크기
                .limit(size)
                .fetch();
    }

    @Override
    public List<UserMissionEntity> findUserMissionByUserIdAndRegionIdAndUserMissionStatus(Long userId, Long regionId, UserMissionStatus userMissionStatus, int page, int size) {
        BooleanBuilder bb = new BooleanBuilder();

        bb.and(userMissionEntity.userEntity.id.eq(userId));
        bb.and(userMissionEntity.status.eq(userMissionStatus));

        QUserEntity user = QUserEntity.userEntity;
        QMissionEntity mission = QMissionEntity.missionEntity;
        QStoreEntity store = QStoreEntity.storeEntity;
        QRegionEntity region = QRegionEntity.regionEntity;

        return jpaQueryFactory
                .select(userMissionEntity)
                .from(userMissionEntity)
                .join(userMissionEntity.userEntity, user).fetchJoin()
                .join(userMissionEntity.missionEntity, mission).fetchJoin()
                .join(mission.storeEntity, store).fetchJoin()
                .join(store.regionEntity, region).fetchJoin()
                .where(bb)
                .fetch();
    }
}
