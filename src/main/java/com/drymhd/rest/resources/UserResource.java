package com.drymhd.rest.resources;

import com.drymhd.rest.dtos.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("user")
public class UserResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("create/{name}")
    @Transactional
    public Response UserGet(String name){
        User user = new User();
        user.name = name;
        user.persist();
        return  Response.ok(user).build();
    }
}
