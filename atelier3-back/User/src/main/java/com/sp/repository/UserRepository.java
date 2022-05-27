package com.sp.repository;

import Common.cp.UserDTO;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDTO, Integer> {
    UserDTO findByEmail(String email);
}

