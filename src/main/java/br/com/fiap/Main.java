package br.com.fiap;

import br.com.fiap.domain.repository.AuthorRepository;
import br.com.fiap.domain.repository.BookRepository;
import br.com.fiap.domain.repository.PessoaRepository;
import br.com.fiap.domain.resources.AuthorResource;
import br.com.fiap.domain.resources.BookResource;
import br.com.fiap.domain.service.AuthorService;
import br.com.fiap.domain.service.BookService;
import br.com.fiap.domain.service.PessoaService;
import br.com.fiap.infra.EntityManagerFactoryProvider;
import br.com.fiap.infra.EntityManagerProvider;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {

    private static final String BASE_URI = "http://localhost/";

    public static HttpServer startServer() {
        EntityManagerFactoryProvider factory = new EntityManagerFactoryProvider( "oracle" );
        EntityManagerProvider em = new EntityManagerProvider( factory.provide() );
        AuthorRepository authorRepository = AuthorRepository.of( em.provide() );
        BookRepository bookRepository = BookRepository.of( em.provide() );
        PessoaRepository pessoaRepository = PessoaRepository.of( em.provide() );
//        PessoaService pessoaService = new PessoaService( pessoaRepository );
//        AuthorService authorService = new AuthorService( authorRepository );
//        BookService bookService = new BookService( bookRepository );
        AuthorResource authorResource = new AuthorResource();
        BookResource bookResource = new BookResource();


        final ResourceConfig rc = new ResourceConfig()
                .register( factory )
                .register( em )
//                .register( authorRepository )
//                .register( bookRepository )
//                .register( authorService )
//                .register( bookService )
//                .register( authorResource )
//                .register( bookResource )
//                .register( pessoaRepository )
//                .register( pessoaService )
                .packages( "br.com.fiap.domain.resources" );
        return GrizzlyHttpServerFactory.createHttpServer( URI.create( BASE_URI ), rc );
    }

    public static void main(String[] args) {

        final HttpServer server = startServer();
        System.out.println( String.format( "Bookstore app started with endpoints available as %s%nHit Ctrl-C to stop it....", BASE_URI ) );
        try {
            System.in.read();
            server.stop();
        } catch (IOException e) {
            throw new RuntimeException( e );
        }
    }


}