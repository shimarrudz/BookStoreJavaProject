package br.com.fiap;

import br.com.fiap.infra.EntityManagerFactoryProvider;
import br.com.fiap.infra.EntityManagerProvider;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {

    private static final String BASE_URI = "http://localhost/";

    @PersistenceContext
    static EntityManager manager;

    public static HttpServer startServer() {
//        EntityManagerFactoryProvider factory = new EntityManagerFactoryProvider( "oracle" );
//        EntityManagerProvider em = new EntityManagerProvider( factory.provide() );
//
//
//        manager = em.provide();
//        AuthorRepository authorRepository = AuthorRepository.of( manager );
//        BookRepository bookRepository = BookRepository.of( manager );
//        PessoaRepository pessoaRepository = PessoaRepository.of( manager );
//        PessoaService pessoaService = new PessoaService( pessoaRepository );
//        AuthorService authorService = new AuthorService( authorRepository );
//        BookService bookService = new BookService( bookRepository );
//        AuthorResource authorResource = new AuthorResource();
//        BookResource bookResource = new BookResource();


        final ResourceConfig rc = new ResourceConfig()
                .register(
                        new AbstractBinder() {
                            @Override
                            protected void configure() {
                                //  bindFactory( EntityManagerFactoryProvider.class ).in( Singleton.class );
                                //  bindFactory( EntityManagerProvider.class ).in( RequestScoped.class );
                                bindFactory( EntityManagerFactoryProvider.class )
                                        .to( EntityManagerFactory.class )
                                        .in( Singleton.class );
                                bindFactory( EntityManagerProvider.class )
                                        .to( EntityManager.class )
                                        .in( RequestScoped.class );
                            }
                        }
                ).packages( "br.com.fiap.domain.resources" );
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