package com.qsl.qsl_tutorial.boundedcontext.user.repository;

import com.qsl.qsl_tutorial.boundedcontext.user.entity.SiteUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.qsl.qsl_tutorial.boundedcontext.user.entity.QSiteUser.siteUser;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    /**
     * 단일 회원 조회
     * @param id
     * @return
     */
    @Override
    public SiteUser getQslUser(Long id) {
        return queryFactory
                .selectFrom(siteUser)
                .where(siteUser.id.eq(id))
                .limit(1)
                .fetchOne();
    }

    /**
     * 전체 회원수 조회
     * @return
     */
    @Override
    public long getQslCount() {
        return queryFactory
                .select(siteUser.count())
                .from(siteUser)
                .fetchOne();
    }

    /**
     * 오래된 회원 조회
     * @return
     */
    @Override
    public SiteUser getQslOldUserAscOne() {
        return queryFactory
                .selectFrom(siteUser)
                .orderBy(siteUser.id.asc())
                .limit(1)
                .fetchOne();
    }
}
