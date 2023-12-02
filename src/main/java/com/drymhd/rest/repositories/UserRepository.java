package com.drymhd.rest.repositories;

import com.drymhd.rest.dtos.User;
import com.drymhd.rest.utils.ExceptionResponse;
import jakarta.ws.rs.core.Response;

public class UserRepository implements Repository {

    public User show(String id) throws ExceptionResponse {
        try{
        User user = User.findById(id);
        if(user == null){
            throw new ExceptionResponse("Tidak ada data", 404);
        }
        return user;
        } catch (Exception e){
            throw new ExceptionResponse(e.getMessage(), 500);
        }
    }

    public User store(User user) throws ExceptionResponse{
        try {
            user.persist();
            return user;
        } catch (Exception e){
            throw new ExceptionResponse(e.getMessage(), 500);
        }

    }
    public User update(User user, String id) throws ExceptionResponse{
        try {
            User data = show(id);
            data.name = user.name;
            data.persist();
            return data;
        } catch (ExceptionResponse e){
            throw  e;
        }
    }
    public User destroy(String id) throws ExceptionResponse{
        try {
            User data = show(id);
            data.delete();
            return data;
        } catch (ExceptionResponse e){
            throw  e;
        }
    }

}
