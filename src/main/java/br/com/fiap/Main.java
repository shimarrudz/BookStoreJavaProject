package br.com.fiap;

import br.com.fiap.domain.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "oracle" );
        EntityManager manager = factory.createEntityManager();

        var holding = new PessoaJuridica();
        var bene = new PessoaFisica();
        var vinicius = new PessoaFisica();

        holding.setCnpj( "12313213/0001-21" ).setId( null )
                .setNome( "Holding Benezinho SA" )
                .setNascimento( LocalDate.now().minusYears( 5 ) );


        bene.setCpf( "213124164" )
                .setNome( "Benefrancis do Nascimento" )
                .setNascimento( LocalDate.of( 1977, 3, 8 ) )
                .setId( null );

        vinicius.setCpf( "131231321" )
                .setId( null )
                .setNome( "Vinicius Cruzeiro Barbosa" )
                .setNascimento( LocalDate.now().minusYears( 17 ) );


        System.out.println(holding);
        System.out.println(bene);
        System.out.println(vinicius);

        manager.close();
        factory.close();


    }

    private static Book newBook(EntityManager manager) {
        var bene = new Author( null, "Benefrancis" );
        var raquel = new Author( null, "Raquel" );
        var guilherme = new Author( null, "Guilherme" );

        var livro = new Book();

        livro.setId( null )
                .setName( "Java Mapeamento Objeto Relacional" )
                .setLaunch( LocalDateTime.now() )
                .setISBN( UUID.randomUUID().toString() )
                .addAuthor( bene )
                .addAuthor( raquel )
                .addAuthor( guilherme );

        manager.getTransaction().begin();

        manager.persist( livro );

        manager.getTransaction().commit();
        return livro;
    }
}