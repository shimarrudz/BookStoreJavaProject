package br.com.fiap.domain.repository;

import jakarta.persistence.EntityManager;

public abstract class AbstractRepository{

    EntityManager manager;

    public AbstractRepository(EntityManager manager) {
        this.manager = manager;
    }
}
