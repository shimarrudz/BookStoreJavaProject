package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;


public class BookRepository implements Repository<Book, Long> {

    private static volatile BookRepository instance;
    private EntityManager manager;

    private BookRepository(EntityManager manager) {
        this.manager = manager;
    }

    public static BookRepository of(EntityManager manager) {
        BookRepository result = instance;
        if (Objects.nonNull( result )) return result;

        synchronized (BookRepository.class) {
            if (Objects.isNull( instance )) {
                instance = new BookRepository( manager );
            }
            return instance;
        }
    }


    @Override
    public List<Book> findAll() {
        List<Book> list = manager.createQuery( "FROM Book" ).getResultList();
        return list;
    }

    @Override
    public Book findById(Long id) {
        Book book = manager.find( Book.class, id );
        return book;
    }

    @Override
    public List<Book> findByName(String texto) {
        String jpql = "SELECT a FROM Book a  where lower(a.name) LIKE CONCAT('%',lower(:name),'%')";
        Query query = manager.createQuery( jpql );
        query.setParameter( "name", texto );
        List<Book> list = query.getResultList();
        return list;
    }

    @Override
    public Book persist(Book book) {
        manager.getTransaction().begin();
        manager.persist( book );
        manager.getTransaction().commit();
        return book;
    }
}
