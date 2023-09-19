package br.com.fiap.domain.resources;

import br.com.fiap.Main;
import br.com.fiap.domain.dto.PessoaFisicaDTO;
import br.com.fiap.domain.entity.PessoaFisica;
import br.com.fiap.domain.service.PessoaFisicaService;
import br.com.fiap.infra.configuration.jwt.JsonTokenNeeded;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.List;
@JsonTokenNeeded //Necessita de um "privateKey" em Authorization type APIKey
@Path("/pf")
public class PessoaFisicaResource implements Resource<PessoaFisicaDTO, Long> {

    @Context
    UriInfo uriInfo;

    private PessoaFisicaService service = PessoaFisicaService.of( Main.PERSISTENCE_UNIT );

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findAll() {
        List<PessoaFisica> all = service.findAll();

        return Response
                .status( Response.Status.OK )
                .entity( all.stream().map( PessoaFisicaDTO::of ).toList() )
                .build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findById(@PathParam("id") Long id) {
        PessoaFisica pessoa = service.findById( id );

        return Response
                .status( Response.Status.OK )
                .entity( PessoaFisicaDTO.of( pessoa ) )
                .build();
    }


    @POST
    @Override
    public Response persist(PessoaFisicaDTO pessoa) {
        PessoaFisica persist = service.persist( PessoaFisicaDTO.of( pessoa ) );

        //https://docs.oracle.com/middleware/1213/wls/RESTF/develop-restful-service.htm#RESTF238
        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI uri = ub.path( String.valueOf( persist.getId() ) ).build();

        return Response
                .created( uri )
                .entity( PessoaFisicaDTO.of( persist ) )
                .build();
    }
}
