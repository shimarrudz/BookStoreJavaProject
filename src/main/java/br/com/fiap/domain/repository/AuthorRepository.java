package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;


public class AuthorRepository implements Repository<Author, Long> {

    private static volatile AuthorRepository instance;


    @PersistenceContext
    private EntityManager manager;

    private AuthorRepository(EntityManager manager) {
        this.manager = manager;
    }


    public static AuthorRepository of(EntityManager manager) {
        AuthorRepository result = instance;
        if (Objects.nonNull( result )) return result;

        synchronized (AuthorRepository.class) {
            if (Objects.isNull( instance )) {
                instance = new AuthorRepository( manager );
            }
            return instance;
        }
    }


    @Override
    public List<Author> findAll() {
        //EntityManager manager = factory.createEntityManager();
        List<Author> list = manager.createQuery( "FROM Author" ).getResultList();
        //  manager.close();
        return list;
    }

    @Override
    public Author findById(Long id) {
        //  EntityManager manager = factory.createEntityManager();
        Author author = manager.find( Author.class, id );
        //  manager.close();
        return author;
    }

    @Override
    public List<Author> findByName(String texto) {
        //  EntityManager manager = factory.createEntityManager();
        String jpql = "SELECT a FROM Author a join fetch a.pessoa p where lower(p.nome) LIKE CONCAT('%',lower(:nome),'%')";
        Query query = manager.createQuery( jpql );
        query.setParameter( "nome", texto );
        List<Author> list = query.getResultList();
        // manager.close();
        return list;
    }

    @Override
    public Author persist(Author author) {
        //   EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist( author );
        manager.getTransaction().commit();
        return author;
    }
}
