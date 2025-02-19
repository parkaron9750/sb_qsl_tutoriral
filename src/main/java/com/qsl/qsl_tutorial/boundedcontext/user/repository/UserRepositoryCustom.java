package com.qsl.qsl_tutorial.boundedcontext.user.repository;

import com.qsl.qsl_tutorial.boundedcontext.user.entity.SiteUser;

import java.util.List;

public interface UserRepositoryCustom  {
    SiteUser getQslUser(Long id);

    long getQslCount();

    SiteUser getQslOldUserAscOne();

    List<SiteUser> getQslOldUsersAsc();
}
