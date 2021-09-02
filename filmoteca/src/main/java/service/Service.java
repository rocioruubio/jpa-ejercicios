package service;

import Modelos.Pelicula;
import clasesDAO.DaoPelicula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Service {
    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jpa_filmoteca");
    EntityManager em = emf.createEntityManager();
    DaoPelicula daoPelicula = new DaoPelicula(em);

    public void createPelicula (String titulo, Date estreno, Double presupuesto, Double recaudacion, String pais){
        Pelicula pelicula = new Pelicula(titulo, estreno, presupuesto, recaudacion, pais);
        daoPelicula.create(pelicula);
        em.close();
        emf.close();
    }

    public void actualizarPelicula (Long id, String titulo, Date estreno, Double presupuesto, Double recaudacion, String pais){
        Pelicula pelicula = new Pelicula(titulo, estreno, presupuesto, recaudacion, pais);
        daoPelicula.update(pelicula, id);
        em.close();
        emf.close();
    }

    public void borrarPelicula (Long id){
        Pelicula pelicula = em.find(Pelicula.class, id);
        daoPelicula.delete(pelicula);
        em.close();
        emf.close();
    }

    public void findPelicula (Long id){
        System.out.println(daoPelicula.find(id));
    }
}
