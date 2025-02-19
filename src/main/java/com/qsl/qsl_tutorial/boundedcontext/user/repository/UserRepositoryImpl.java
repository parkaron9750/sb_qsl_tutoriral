package com.qsl.qsl_tutorial.boundedcontext.user.repository;

import com.qsl.qsl_tutorial.boundedcontext.user.entity.SiteUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.qsl.qsl_tutorial.boundedcontext.user.entity.QSiteUser.siteUser;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public SiteUser getQslUser(Long id) {
        return queryFactory
                .selectFrom(siteUser)
                .where(siteUser.id.eq(id))
                .fetchOne();
    }

    @Override
    public long getQslCount() {
        return queryFactory
                .select(siteUser.count())
                .from(siteUser)
                .fetchOne();
    }
}
