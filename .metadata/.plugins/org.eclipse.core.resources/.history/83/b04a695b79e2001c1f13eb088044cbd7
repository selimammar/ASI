package com.sp.repository;


import org.springframework.data.repository.CrudRepository;

import com.sp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}

