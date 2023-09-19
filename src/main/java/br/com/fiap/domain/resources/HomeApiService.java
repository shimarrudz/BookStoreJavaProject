package br.com.fiap.domain.resources;

import br.com.fiap.domain.dto.User;
import br.com.fiap.infra.configuration.jwt.JwTokenHelper;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Objects;

@Path("/")
public class HomeApiService {

    @POST
    @Path(value = "authorization")
    @Produces(MediaType.APPLICATION_JSON)
    public Response authorizationService(User user) {
        if (Objects.isNull( user ))
            return Response.status( 401 ).entity( "User is required" ).build();
        if (user.username().isEmpty())
            return Response.status( 401 ).entity( "username field cannot be empty!" ).build();
        if (user.password().isEmpty())
            return Response.status( 401 ).entity( "password field cannot be empty!" ).build();
        String privateKey = JwTokenHelper.getInstance().generatePrivateKey( user.username(), user.password() );
        return Response.ok().entity( "You're authenticated successfully.\n" + user.username() + "\nPrivate key will be valid for 30 mins: \n" + privateKey ).build();
    }
}