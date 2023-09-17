package br.com.fiap.infra;

import jakarta.inject.Named;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.glassfish.hk2.api.Factory;

import java.util.HashMap;
import java.util.Map;

public class EntityManagerFactoryProvider implements Factory<EntityManagerFactory> {

    private static final String PERSISTENT_UNIT = "oracle";
    private final EntityManagerFactory emf;

    public EntityManagerFactoryProvider(@Named(PERSISTENT_UNIT) String persistentUnit) {
        emf = Persistence.createEntityManagerFactory( persistentUnit, getProperties() );
    }

    @Override
    public EntityManagerFactory provide() {
        return emf;
    }

    @Override
    public void dispose(EntityManagerFactory instance) {
        instance.close();
    }


    static Map<String, Object> getProperties() {

        Map<String, String> env = System.getenv();

        Map<String, Object> properties = new HashMap<>();

        for (String chave : env.keySet()) {
            if (chave.contains( "USER_FIAP" )) {
                properties.put( "jakarta.persistence.jdbc.user", env.get( chave ) );
            }
            if (chave.contains( "PASSWORD_FIAP" )) {
                properties.put( "jakarta.persistence.jdbc.password", env.get( chave ) );
            }
            // Outras configurações de propriedade ....
        }
        return properties;
    }

} 