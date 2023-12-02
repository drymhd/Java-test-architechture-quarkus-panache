package com.drymhd.rest.endpoints.v1;

import com.drymhd.rest.dtos.User;
import com.drymhd.rest.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/v1/")
public class UserEndpoint {
    protected UserService userService;

    UserEndpoint(){
        this.userService = new UserService();
    }
    @POST
    @Path("user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response UserCreate(User user){

        if(user.name == null){
            return  Response.status(Response.Status.BAD_REQUEST).build();
        }
        user.persist();
        return  Response.ok(user).build();
    }


    @POST
    @Path("user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response UserCreate(User user,String id){

        if(user.name == null){
            return  Response.status(Response.Status.BAD_REQUEST).build();
        }
        user.persist();
        return  Response.ok(user).build();
    }

    @GET
    @Path("user/{id}")
    public Response UserGet(String id){
        try{
            User user = this.userService.get(id);
            return  Response.ok(user).build();
        } catch (Exception e){
            return  Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("user/{id}")
    @Transactional
    public Response UserDelete(String id){
        User user = User.findById(id);
        user.delete();
        return  Response.ok("Sukses menghapus data "+user.name).build();
    }

}
