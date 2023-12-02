package com.drymhd.rest.services;

import com.drymhd.rest.dtos.User;
import com.drymhd.rest.repositories.UserRepository;

public class UserService {
    protected UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository();
    }

    public User get(String id) throws Exception{
        try{
            return  this.userRepository.get(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
