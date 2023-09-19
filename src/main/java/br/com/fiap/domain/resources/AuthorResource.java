package br.com.fiap.domain.resources;

import br.com.fiap.Main;
import br.com.fiap.domain.dto.AuthorDTO;
import br.com.fiap.domain.entity.Author;
import br.com.fiap.domain.service.AuthorService;
import br.com.fiap.infra.configuration.jwt.JsonTokenNeeded;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.List;

@JsonTokenNeeded //Necessita de um "privateKey" em Authorization type APIKey
@Path("/author")
public class AuthorResource implements Resource<AuthorDTO, Long> {

    @Context
    UriInfo uriInfo;

    private AuthorService service = AuthorService.of( Main.PERSISTENCE_UNIT );

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findAll() {
        List<Author> all = service.findAll();

        return Response
                .status( Response.Status.OK )
                .entity( all.stream().map( AuthorDTO::of ).toList() )
                .build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findById(@PathParam("id") Long id) {
        Author author = service.findById( id );

        return Response
                .status( Response.Status.OK )
                .entity( AuthorDTO.of( author ) )
                .build();
    }


    @POST
    @Override
    public Response persist(AuthorDTO author) {
        Author persist = service.persist( AuthorDTO.of( author ) );
        //https://docs.oracle.com/middleware/1213/wls/RESTF/develop-restful-service.htm#RESTF238

        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI uri = ub.path( String.valueOf( persist.getId() ) ).build();

        return Response
                .created( uri )
                .entity( AuthorDTO.of( persist ) )
                .build();
    }
}
