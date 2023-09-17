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

//    final String DATABASE = "oracle";
//
//    default EntityManager database() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory( DATABASE, getProperties() );
//        return factory.createEntityManager();
//    }
//



//    static Map<String, Object> getProperties() {
//
//        Map<String, String> env = System.getenv();
//
//        Map<String, Object> properties = new HashMap<>();
//
//        for (String chave : env.keySet()) {
//            if (chave.contains( "USER_FIAP" )) {
//                properties.put( "jakarta.persistence.jdbc.user", env.get( chave ) );
//            }
//            if (chave.contains( "PASSWORD_FIAP" )) {
//                properties.put( "jakarta.persistence.jdbc.password", env.get( chave ) );
//            }
//            // Outras configurações de propriedade ....
//        }
//        return properties;
//    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(U id);

    @POST
    public Response persist(T t);
}
