package com.drymhd.rest.endpoints.v1;

import com.drymhd.rest.dtos.User;
import com.drymhd.rest.services.UserService;
import com.drymhd.rest.utils.ExceptionResponse;
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
    public Response store(User user){
        try{
            return  Response.ok(this.userService.store(user)).build();
        } catch (ExceptionResponse e){
            return  Response.status(e.getCode()).entity(e.getMessage()).build();
        }
    }


    @POST
    @Path("user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(User user,String id){
        try{
            return  Response.ok(this.userService.update(user, id)).build();
        } catch (ExceptionResponse e){
            return  Response.status(e.getCode()).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("user/{id}")
    public Response show(String id){
        try{
            return  Response.ok(this.userService.show(id)).build();
        } catch (ExceptionResponse e){
            return  Response.status(e.getCode()).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("user/{id}")
    @Transactional
    public Response destroy(String id){
        try{
            return  Response.ok(this.userService.show(id)).entity("Sukses menghapus data").build();
        } catch (ExceptionResponse e){
            return  Response.status(e.getCode()).entity(e.getMessage()).build();
        }
    }

}
