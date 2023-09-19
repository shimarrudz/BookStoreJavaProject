package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Author;
import br.com.fiap.domain.repository.AuthorRepository;
import br.com.fiap.infra.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Objects;


public class AuthorService implements Service<Author, Long> {

    private static volatile AuthorService instance;

    private AuthorRepository repo;

    private AuthorService(AuthorRepository repo) {
        this.repo = repo;
    }


    public static AuthorService of(String persistenceUnit) {
        AuthorService result = instance;
        if (Objects.nonNull( result )) return result;

        synchronized (AuthorService.class) {
            if (Objects.isNull( instance )) {
                EntityManagerFactory factory = EntityManagerFactoryProvider.of( persistenceUnit ).provide();
                AuthorRepository authorRepository = AuthorRepository.of( factory.createEntityManager() );
                instance = new AuthorService( authorRepository );
            }
            return instance;
        }
    }


    @Override
    public List<Author> findAll() {
        return repo.findAll();
    }

    @Override
    public Author findById(Long id) {
        return repo.findById( id );
    }

    @Override
    public List<Author> findByName(String texto) {
        return repo.findByName( texto );
    }

    @Override
    public Author persist(Author author) {
        return repo.persist( author );
    }
}
