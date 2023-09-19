package br.com.fiap.domain.resources;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jvnet.hk2.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

@Contract
public interface Resource<T, U> {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(U id);

    @POST
    public Response persist(T t);
}
