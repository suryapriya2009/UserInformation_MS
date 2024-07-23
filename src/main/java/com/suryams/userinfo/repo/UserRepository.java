package com.suryams.userinfo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suryams.userinfo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
