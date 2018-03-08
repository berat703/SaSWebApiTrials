package com.sas.deneme.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.deneme.Dto.UsersDto;
import com.sas.deneme.Services.UsersService;
import com.sas.deneme.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody String jsonUser){
        try{
            Users user = new ObjectMapper().readValue(jsonUser,Users.class);
            this.userService.save(user);

       }catch (Exception e){

           return null;
       }
       return ResponseEntity.ok(HttpStatus.OK);
    }

}
