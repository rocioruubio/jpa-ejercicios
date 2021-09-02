package Clases;

import Modelos.Pelicula;
import clasesDAO.DaoPelicula;
import service.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.PlatformLoggingMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NuevaPelicula {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("jpa_filmoteca");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Service service = new Service();

            System.out.println("Introduce el titulo de la pelicula: ");
            String titulo = in.readLine();

            System.out.println("Introduce el estreno de la pelicula: ");
            Date estreno = new SimpleDateFormat("dd/MM/yyyy").parse(in.readLine());

            System.out.println("Introduce el presupuesto de la pelicula: ");
            Double presupuesto = Double.parseDouble(in.readLine());

            System.out.println("Introduce la recaudacion de la pelicula: ");
            Double recaudacion = Double.parseDouble(in.readLine());

            System.out.println("Introduce el pais de la pelicula: ");
            String pais = in.readLine();

            //Crear una pelicula
//            service.createPelicula(titulo, estreno, presupuesto, recaudacion, pais);

            //Actualizar una pelicula
//            System.out.println("Introduce el id de la pelicula: ");
//            Long id = Long.parseLong(in.readLine());
//
//            service.actualizarPelicula(id, titulo, estreno, presupuesto, recaudacion, pais);

            //Borrar una pelicula
//            System.out.println("Introduce el id de la pelicula: ");
//            Long id = Long.parseLong(in.readLine());
//            service.borrarPelicula(id);

            //Buscar una pelicula
            System.out.println("Introduce el id de la pelicula: ");
            Long id = Long.parseLong(in.readLine());
            service.findPelicula(id);



        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Error: " + ex.getMessage() + "\n\n");
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
