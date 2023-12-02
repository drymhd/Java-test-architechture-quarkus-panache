package com.drymhd.rest.repositories;

import com.drymhd.rest.dtos.User;

public class UserRepository {

    public User get(String id) throws Exception {
        try{
        User user = User.findById(id);
        if(user == null){
            throw new Exception("slebew");
        }
        return user;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
