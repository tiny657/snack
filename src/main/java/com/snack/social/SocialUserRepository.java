package com.snack.social;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialUserRepository extends CrudRepository<SocialUser, Long> {

	SocialUser findByEmail(String email);
}
