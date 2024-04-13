package com.kahlua17.momo.domain.user.repository;

import com.kahlua17.momo.domain.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUuid(String uuid);
}