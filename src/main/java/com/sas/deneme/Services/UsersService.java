package com.sas.deneme.Services;

import com.sas.deneme.Repository.UsersRepository;
import com.sas.deneme.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    public List<Users> getAll() {
        return this.userRepository.findAll();
    }

    public boolean checkUserExistence(String username) {
        return this.userRepository.checkUserExistence(username) != null;
    }

    public Users getByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    public void save(Users user) {
        this.userRepository.save(user);
    }

    public void deleteByUsername(String username) {
        this.userRepository.deleteUserByUsername(username);
    }

}
