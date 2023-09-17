package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;

public class PessoaRepository extends AbstractRepository implements Repository<Pessoa, Long> {

    private static volatile PessoaRepository instance;

    private PessoaRepository(EntityManager manager) {
        super( manager );
    }

    public static PessoaRepository of(EntityManager manager) {
        PessoaRepository result = instance;
        if (Objects.nonNull( result )) return result;

        synchronized (PessoaRepository.class) {
            if (Objects.isNull( instance )) {
                instance = new PessoaRepository( manager );
            }
            return instance;
        }
    }


    @Override
    public List<Pessoa> findAll() {
        List<Pessoa> list = manager.createQuery( "FROM Pessoa" ).getResultList();
        return list;
    }

    @Override
    public Pessoa findById(Long id) {
        Pessoa pessoa = manager.find( Pessoa.class, id );
        return pessoa;
    }

    @Override
    public List<Pessoa> findByName(String texto) {
        String jpql = "SELECT p FROM Pessoa p  where lower(p.nome) LIKE CONCAT('%',lower(:nome),'%')";
        Query query = manager.createQuery( jpql );
        query.setParameter( "nome", texto );
        List<Pessoa> list = query.getResultList();

        return list;
    }

    @Override
    public Pessoa persist(Pessoa pessoa) {
        manager.getTransaction().begin();
        manager.persist( pessoa );
        manager.getTransaction().commit();
        return pessoa;
    }
}
