package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Pessoa;
import br.com.fiap.domain.repository.PessoaRepository;
import br.com.fiap.infra.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Objects;

public class PessoaService implements Service<Pessoa, Long> {

    private static volatile PessoaService instance;

    private PessoaRepository repo;


    private PessoaService(PessoaRepository repo) {
        this.repo = repo;
    }


    public static PessoaService of(String persistenceUnit) {
        PessoaService result = instance;
        if (Objects.nonNull( result )) return result;

        synchronized (PessoaService.class) {
            if (Objects.isNull( instance )) {
                EntityManagerFactory factory = EntityManagerFactoryProvider.of( persistenceUnit ).provide();
                PessoaRepository pessoaRepository = PessoaRepository.of( factory.createEntityManager() );
                instance = new PessoaService( pessoaRepository );
            }
            return instance;
        }
    }

    @Override
    public List<Pessoa> findAll() {
        return repo.findAll();
    }

    @Override
    public Pessoa findById(Long id) {
        return repo.findById( id );
    }


    @Override
    public List<Pessoa> findByName(String texto) {
        return repo.findByName( texto );
    }

    @Override
    public Pessoa persist(Pessoa book) {
        return repo.persist( book );
    }
}
