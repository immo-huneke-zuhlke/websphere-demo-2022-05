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

@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Path("{id}")
    @Produces( MediaType.APPLICATION_JSON)
    public Response retrieveSomething(@PathParam("id") String id) {
        if(id == null || id.trim().length() == 0) {
            return Response.serverError().entity("ID cannot be blank").build();
        }
        User user = userService.getUser(Long.parseLong(id));// new User(1,"test","test email");
        if(user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for id: " + id).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity(user).build();
    }
}