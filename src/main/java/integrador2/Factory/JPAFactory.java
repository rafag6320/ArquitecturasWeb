package integrador2.Factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class JPAFactory {
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = createEntityManagerFactory("Universidad");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public void close (){
        emf.close();
    }
}
