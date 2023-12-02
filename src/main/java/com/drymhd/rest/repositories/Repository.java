package com.drymhd.rest.repositories;

import com.drymhd.rest.dtos.User;
import com.drymhd.rest.utils.ExceptionResponse;

public interface Repository {
    public User store(User user) throws ExceptionResponse;
    public User show(String id) throws ExceptionResponse;
    public User update(User user,String id) throws ExceptionResponse;

    public User destroy(String id) throws ExceptionResponse;

}
