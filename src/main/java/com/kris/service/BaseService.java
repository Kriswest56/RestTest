package com.kris.service;


import com.google.gson.JsonObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class BaseService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(){
        return "Resource Home";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public String getIt(@PathParam("name") String name){

        String param = name;

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Hello", param);

        return jsonObject.toString();

    }

}
