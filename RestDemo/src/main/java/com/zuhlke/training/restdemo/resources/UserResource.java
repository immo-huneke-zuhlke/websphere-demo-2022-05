package com.zuhlke.training.restdemo.resources;

import com.zuhlke.training.restdemo.entity.User;
import com.zuhlke.training.restdemo.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Path("/{id : (\\d+)?}")
    @Produces( MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id) {
        if( id == null || id.trim().length() == 0 ) {
            List<User> users = userService.getUsers();
            if(users == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Something went wrong!!!").build();
            }
            return Response.status(Response.Status.ACCEPTED).entity(users).build();
        }
        User user = userService.getUser(Long.parseLong(id));// new User(1,"test","test email");
        if(user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for id: " + id).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity(user).build();
    }
}