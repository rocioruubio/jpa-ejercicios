package Clases;

import Modelos.Critica;
import Modelos.Pelicula;
import org.jboss.jandex.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static Clases.NuevaPelicula.in;

public class NuevaCritica {
    static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jpa_filmoteca");
    static EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {
        em.getTransaction().begin();
        try {
            //hola

            NuevaCritica nuevaCritica = new NuevaCritica();
            System.out.println(nuevaCritica.findWithName());
            System.out.println("Escribe el id de la pelicula que quieres agregar criticas: ");
            Long id = Long.parseLong(in.readLine());
            Pelicula pelicula = em.find(Pelicula.class, id);
            if(pelicula == null){
                System.out.println("no existe esta pelicula");
            }else {
                System.out.println("Titulo de la pelicula: "+pelicula.getTitulo());
                System.out.println("Introduce tu nombre: ");
                String nombre = in.readLine();
                System.out.println("Introduce tu critica: ");
                String txcritica = in.readLine();
                System.out.println("Puntuacion: ");
                int puntuacion = in.read();
                Critica critica = new Critica(nombre, txcritica, puntuacion);
                critica.setId_pelicula(pelicula);
                em.persist(critica);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Error: " + ex.getMessage() + "\n\n");
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
    public List findWithName() {
        return em.createQuery(
                        "SELECT p from Pelicula p")
                .getResultList();
    }
}
