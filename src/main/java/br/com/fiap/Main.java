package br.com.fiap;

import br.com.fiap.domain.entity.Author;
import br.com.fiap.domain.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();


        var bene = new Author(null, "Benefrancis");
        var raquel = new Author(null, "Raquel");
        var guilherme = new Author(null, "Guilherme");

        var livro = new Book();

        livro.setId(null)
                .setName("Java Mapeamento Objeto Relacional")
                .setLaunch(LocalDateTime.now())
                .setISBN(UUID.randomUUID().toString())
                .addAuthor(bene)
                .addAuthor(raquel)
                .addAuthor(guilherme);

        manager.getTransaction().begin();

        manager.persist(livro);

        manager.getTransaction().commit();


        manager.close();
        factory.close();

        System.out.println(livro);

    }
}