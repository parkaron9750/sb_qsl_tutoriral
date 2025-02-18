package com.qsl.qsl_tutorial.boundedcontext.user.repository;

import com.qsl.qsl_tutorial.boundedcontext.user.entity.SiteUser;

public interface UserRepositoryCustom  {
    SiteUser getQslUser(Long id);
}
