package br.com.fiap.domain.resources;

import br.com.fiap.Main;
import br.com.fiap.domain.dto.BookDTO;
import br.com.fiap.domain.entity.Book;
import br.com.fiap.domain.service.BookService;
import br.com.fiap.infra.configuration.jwt.JsonTokenNeeded;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.List;




@Path("/book")
@JsonTokenNeeded //Necessita de um "privateKey" em Usuario type APIKey
public class BookResource implements Resource<BookDTO, Long> {

    @Context
    UriInfo uriInfo;

    private BookService service = BookService.of( Main.PERSISTENCE_UNIT );

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findAll() {
        List<Book> all = service.findAll();

        return Response
                .status( Response.Status.OK )
                .entity( all.stream().map( BookDTO::of ).toList() )
                .build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findById(@PathParam("id") Long id) {
        Book book = service.findById( id );

        return Response
                .status( Response.Status.OK )
                .entity( BookDTO.of( book ) )
                .build();
    }


    @POST
    @Override
    public Response persist(BookDTO book) {
        Book persist = service.persist( BookDTO.of( book ) );

        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI uri = ub.path( String.valueOf( persist.getId() ) ).build();

        return Response
                .created( uri )
                .entity( BookDTO.of( persist ) )
                .build();
    }
}
