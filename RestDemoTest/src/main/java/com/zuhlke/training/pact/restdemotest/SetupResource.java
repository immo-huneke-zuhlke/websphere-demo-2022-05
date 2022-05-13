package com.zuhlke.training.pact.restdemotest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Path("")
public class SetupResource {

    @GET
    public Response setup(RequestBody requestBody) {
        return Response.status(Response.Status.OK).entity("Test").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeState(RequestBody requestBody) {


        try{
            String stateName = requestBody.getState();
            StateMaker.dispatch(stateName);
        } catch (InvocationTargetException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        } catch (IllegalAccessException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

        return Response.status(Response.Status.OK).build();
    }


}