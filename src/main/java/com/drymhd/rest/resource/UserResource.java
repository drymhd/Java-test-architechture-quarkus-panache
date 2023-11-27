package com.drymhd.rest.resource;

import com.drymhd.rest.dto.UserDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;


@Path("/user")
public class UserResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("all")
    public Response UserGet(){
        ArrayList<UserDto> users = new ArrayList<UserDto>();
        users.add(new UserDto("Dary", "mahdi"));
        users.add(new UserDto("Dary", "mahdi"));
        users.add(new UserDto("Dary", "mahdi"));
        users.add(new UserDto("Dary", "mahdi"));
        return  Response.ok(users).build();
    }
}
