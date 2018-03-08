package com.sas.deneme.controller;

import com.sas.deneme.Dto.UsersDto;
import com.sas.deneme.Services.UsersService;
import com.sas.deneme.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService userService;

    @RequestMapping
    public List<Users> getAll() {
        return this.userService.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public void addUser(UsersDto usersDto){
        Users users = new Users();
        users.setUsername(usersDto.getUsername());
        users.setName(usersDto.getName());
        users.setSurname(usersDto.getSurname());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        users.setSuperUser(false);
        userService.save(users);
    }

}
