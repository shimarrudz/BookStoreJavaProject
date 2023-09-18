package br.com.fiap.domain.resources;

import br.com.fiap.Main;
import br.com.fiap.domain.dto.BookDTO;
import br.com.fiap.domain.entity.Book;
import br.com.fiap.domain.service.BookService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

@Path("/book")
public class BookResource implements Resource<BookDTO, Long> {

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

        URI uri = UriBuilder
                .fromMethod( BookResource.class, "persist" )
                .build( persist.getName() )
                .normalize();

        return Response
                .created( uri )
                .entity( BookDTO.of( persist ) )
                .build();
    }
}
