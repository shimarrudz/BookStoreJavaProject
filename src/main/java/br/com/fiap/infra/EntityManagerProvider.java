package br.com.fiap.infra;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.glassfish.hk2.api.Factory;

public class EntityManagerProvider implements Factory<EntityManager> {

    private final EntityManagerFactory emf;
//    private final CloseableService closeableService;

    @Inject
    public EntityManagerProvider(EntityManagerFactory emf) {
        this.emf = emf;
//        this.closeableService = closeableService;
    }

    @Override
    public EntityManager provide() {
        final EntityManager em = emf.createEntityManager();
        return em;
    }

    @Override
    public void dispose(EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

}