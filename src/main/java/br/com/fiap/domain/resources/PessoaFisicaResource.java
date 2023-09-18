package br.com.fiap.domain.resources;

import br.com.fiap.Main;
import br.com.fiap.domain.dto.PessoaFisicaDTO;
import br.com.fiap.domain.entity.PessoaFisica;
import br.com.fiap.domain.service.PessoaFisicaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

@Path("/pf")
public class PessoaFisicaResource implements Resource<PessoaFisicaDTO, Long> {

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
        PessoaFisica  pessoa = service.findById( id );

        return Response
                .status( Response.Status.OK )
                .entity( PessoaFisicaDTO.of( pessoa ) )
                .build();
    }


    @POST
    @Override
    public Response persist(PessoaFisicaDTO pessoa) {
        PessoaFisica persist = service.persist( PessoaFisicaDTO.of( pessoa ) );

        URI uri = UriBuilder
                .fromMethod( PessoaFisicaResource.class, "persist" )
                .build( persist.getNome() )
                .normalize();

        return Response
                .created( uri )
                .entity( PessoaFisicaDTO.of( persist ) )
                .build();
    }
}
