package com.project.LinkC.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.LinkC.model.User;
import com.project.LinkC.repository.UserRepository;

@Service
public class UserService extends AbstractService<User, UserRepository> {

    public UserService(UserRepository repository) {
        super(repository);
    }

    @Transactional
    public User findByUsername(String username){
        return repository.findByUsername(username);
    }


}
