import Modelos.Autor;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.fail;

public class TextLazy {

    @Test
    public void init(){
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mensajes");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Autor autor = em.find(Autor.class, 1L);
            //em.getTransaction().commit();
            em.close();
            emf.close();
            System.out.println(autor.getMensajes());

        }catch (Exception e){
            e.printStackTrace();
            fail("Error");
        }
    }

}
