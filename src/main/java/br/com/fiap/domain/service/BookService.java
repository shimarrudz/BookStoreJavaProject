package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Book;
import br.com.fiap.domain.repository.AuthorRepository;
import br.com.fiap.domain.repository.BookRepository;
import br.com.fiap.infra.EntityManagerFactoryProvider;
import br.com.fiap.infra.EntityManagerProvider;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.ws.rs.core.Context;

import java.util.List;
import java.util.Objects;


public class BookService implements Service<Book, Long> {


    private static volatile BookService instance;


    private BookRepository repo ;

    private BookService(BookRepository repo) {
        this.repo = repo;
    }

    public static BookService of(String persistenceUnit) {
        BookService result = instance;
        if (Objects.nonNull( result )) return result;

        synchronized (BookService.class) {
            if (Objects.isNull( instance )) {
                EntityManagerFactory factory = new EntityManagerFactoryProvider(persistenceUnit ).provide();
                BookRepository bookRepository = BookRepository.of( factory.createEntityManager() );
                instance = new BookService( bookRepository );
            }
            return instance;
        }
    }

    @Override
    public List<Book> findAll() {
        return repo.findAll();
    }

    @Override
    public Book findById(Long id) {
        return repo.findById( id );
    }

    @Override
    public List<Book> findByName(String texto) {
        return repo.findByName( texto );
    }

    @Override
    public Book persist(Book book) {
        return repo.persist( book );
    }
}
