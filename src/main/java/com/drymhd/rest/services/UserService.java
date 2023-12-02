package com.drymhd.rest.services;

import com.drymhd.rest.dtos.User;
import com.drymhd.rest.repositories.UserRepository;
import com.drymhd.rest.utils.ExceptionResponse;

public class UserService {
    protected UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository();
    }

    public User show(String id) throws ExceptionResponse {
        try {
            return this.userRepository.show(id);
        } catch (ExceptionResponse e) {
            throw new ExceptionResponse(e.getMessage(), e.getCode());
        }
    }


    public User store(User user) throws ExceptionResponse {
        if(user == null){
            throw new ExceptionResponse("Bad request", 400);
        }
        try{
            return  this.userRepository.store(user);
        } catch (ExceptionResponse e){
            throw new ExceptionResponse(e.getMessage(), e.getCode());
        }
    }
    public User update(User user, String id) throws ExceptionResponse {
        if(user == null){
            throw new ExceptionResponse("Bad request", 400);
        }
        try{
            return this.userRepository.update(user, id);
        } catch (ExceptionResponse e){
            throw new ExceptionResponse(e.getMessage(), e.getCode());
        }
    }
    public User destroy(String id) throws ExceptionResponse {
        try{
            return this.userRepository.destroy(id);
        } catch (Exception e){
            throw new ExceptionResponse(e.getMessage(), 404);
        }
    }





}
