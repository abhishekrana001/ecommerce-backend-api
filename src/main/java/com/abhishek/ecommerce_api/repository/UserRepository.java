package com.abhishek.ecommerce_api.repository;


import com.abhishek.ecommerce_api.entity.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    User save(User user);
}
