package Clases;

import Modelos.Autor;
import Modelos.Mensaje;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class NuevoMensaje {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("jpa_mensajes");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            System.out.println("--Añadiendo mensaje a un usuario");
            Long idAutor = Long
                    .valueOf(leerTexto("Introduce identificador de usuario: "));
            Autor autor = em.find(Autor.class, idAutor);
            if (autor == null) {

                System.out.println("Usuario no existente");
            } else {
                System.out.println("Usuario " + autor.getNombre());
                String mensajeStr = leerTexto("Introduce mensaje: ");
                Mensaje mens = new Mensaje(mensajeStr, autor);
                mens.setFecha(new Date());
                mens.setAutor(autor);
                em.persist(mens);
                System.out.println("Identificador del mensaje: " + mens.getId());
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Error: " + ex.getMessage() + "\n\n");
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
    static private String leerTexto(String mensaje) {
        String texto;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(mensaje);
            texto = in.readLine();
        } catch (IOException e) {
            texto = "Error";
        }
        return texto;
    }
}
