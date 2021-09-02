package clasesDAO;

import Modelos.Pelicula;

import javax.persistence.EntityManager;

public class DaoPelicula {
    EntityManager em;

    public DaoPelicula(EntityManager em) {
        this.em = em;
    }

    public Pelicula create(Pelicula pelicula) {
        em.getTransaction().begin();
        em.persist(pelicula);
        em.getTransaction().commit();
        return pelicula;
    }

    public Pelicula update(Pelicula pelicula, Long id) {
        em.getTransaction().begin();
        Pelicula pelicula1 = em.find(Pelicula.class, id);
        if (pelicula1 == null) {
            System.out.println("no existe la peli");
        } else {
            pelicula1.setEstreno(pelicula.getEstreno());
            pelicula1.setCriticaList(pelicula.getCriticaList());
            pelicula1.setPais(pelicula.getPais());
            pelicula1.setPresupuesto(pelicula.getPresupuesto());
            pelicula1.setRecaudacion(pelicula.getRecaudacion());
            pelicula1.setTitulo(pelicula.getTitulo());
            em.persist(pelicula1);
            em.getTransaction().commit();
        }
        return pelicula1;
    }

    public boolean delete(Pelicula pelicula) {
        em.getTransaction().begin();
        Pelicula pelicula1 = em.find(Pelicula.class, pelicula.getId());
        if (pelicula1 == null) {
            System.out.println("no existe la peli");
            return false;
        } else {
            em.remove(pelicula1);
            em.getTransaction().commit();
            return true;
        }
    }

    public Pelicula find(Long id) {
        em.getTransaction().begin();
        Pelicula pelicula = em.find(Pelicula.class, id);
        if (pelicula == null) {
            System.out.println("no existe la peli");
            return null;
        } else {
            return pelicula;
        }
    }


}
