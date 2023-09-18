package br.com.fiap.domain.resources;

import br.com.fiap.Main;
import br.com.fiap.domain.dto.PessoaJuridicaDTO;
import br.com.fiap.domain.entity.PessoaJuridica;
import br.com.fiap.domain.service.PessoaJuridicaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

@Path("/pj")
public class PessoaJuridicaResource implements Resource<PessoaJuridicaDTO, Long> {

    private PessoaJuridicaService service = PessoaJuridicaService.of( Main.PERSISTENCE_UNIT );

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findAll() {
        List<PessoaJuridica> all = service.findAll();

        return Response
                .status( Response.Status.OK )
                .entity( all.stream().map( PessoaJuridicaDTO::of ).toList() )
                .build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response findById(@PathParam("id") Long id) {
        PessoaJuridica  pessoa = service.findById( id );

        return Response
                .status( Response.Status.OK )
                .entity( PessoaJuridicaDTO.of( pessoa ) )
                .build();
    }


    @POST
    @Override
    public Response persist(PessoaJuridicaDTO pessoa) {
        PessoaJuridica persist = service.persist( PessoaJuridicaDTO.of( pessoa ) );

        URI uri = UriBuilder
                .fromMethod( PessoaJuridicaResource.class, "persist" )
                .build( persist.getNome() )
                .normalize();

        return Response
                .created( uri )
                .entity( PessoaJuridicaDTO.of( persist ) )
                .build();
    }
}
