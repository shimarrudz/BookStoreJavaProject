package br.com.fiap;

import br.com.fiap.domain.entity.Author;
import br.com.fiap.domain.entity.Book;
import br.com.fiap.domain.entity.PessoaFisica;
import br.com.fiap.domain.entity.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "maria-db" );
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

        var authorBene = new Author();
        authorBene.setPessoa( bene );

        var authorVinicius = new Author();
        authorVinicius.setPessoa( vinicius );

        var livro = new Book();
        livro.setISBN( UUID.randomUUID().toString() )
                .setName( "Memórias de Benezinho" )
                .setLaunch( LocalDateTime.now() )
                .addAuthor( authorBene )
                .addAuthor( authorVinicius );


        manager.getTransaction().begin();
        manager.persist( holding );
        manager.persist( livro );
        manager.getTransaction().commit();


        System.out.println( holding );

        System.out.println( livro );

        manager.close();
        factory.close();

    }


}