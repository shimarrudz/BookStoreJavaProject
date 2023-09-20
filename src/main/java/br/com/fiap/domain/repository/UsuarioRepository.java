package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;

public class UsuarioRepository implements Repository<Usuario, Long>{

    private static volatile UsuarioRepository instance;

    private EntityManager manager;

    private UsuarioRepository(EntityManager manager) {
        this.manager = manager;
    }

    public static UsuarioRepository of(EntityManager manager) {

        UsuarioRepository result = instance;

        if (Objects.nonNull( result )) return result;

        synchronized (UsuarioRepository.class) {
            if (Objects.isNull( instance )) {
                instance = new UsuarioRepository( manager );
            }
            return instance;
        }
    }

    public Usuario findByUsername(String  username) {
        String jpql = "FROM Usuario u  where lower(u.username) = :email";
        Query query = manager.createQuery( jpql );
        query.setParameter( "email", username.toLowerCase() );
        Usuario usuario = (Usuario) query.getResultList().stream().findFirst().orElse( null );
        return usuario;
    }


    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public List<Usuario> findByName(String texto) {
        return null;
    }

    @Override
    public Usuario persist(Usuario usuario) {
        return null;
    }
}
