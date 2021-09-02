import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

public class TestEmf {
    @Test
    public void createEntityManagerTest() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa_mensajes");
        EntityManager em = emf.createEntityManager();
        assertNotNull(em);
        em.close();
    }
}
