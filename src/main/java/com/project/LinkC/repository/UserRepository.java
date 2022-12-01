package com.project.LinkC.repository;

import org.springframework.stereotype.Repository;
import com.project.LinkC.model.User;


@Repository
public interface UserRepository extends BaseRepository<User> {

    User findByUsername(String username);

}
