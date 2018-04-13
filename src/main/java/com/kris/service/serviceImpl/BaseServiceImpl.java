package com.kris.service.serviceImpl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kris.service.BaseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class BaseServiceImpl implements BaseService {

    private static BaseServiceImpl instance;

    public static synchronized BaseServiceImpl getInstance(){

        if(instance == null){
            instance = new BaseServiceImpl();
        }

        return instance;

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(){
        return "Resource Home";
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("{message}")
    public String getMessage(@PathParam("message") String message){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Message", message);

        return jsonObject.toString();

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("{message}")
    public String postMessage(String message){

        JsonObject o = new JsonObject();

        try {
            o = new JsonParser().parse(message).getAsJsonObject();
        } catch (IllegalStateException e){
            o.addProperty("Error", "Invalid Request");
        }

        return o.toString();

    }

}