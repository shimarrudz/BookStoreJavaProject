package br.com.fiap.infra;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

public class MyApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bindFactory( EntityManagerFactoryProvider.class )
                .to( EntityManagerFactory.class )
                .in( Singleton.class );
        bindFactory( EntityManagerProvider.class )
                .to( EntityManager.class )
                .in( RequestScoped.class );
    }
}