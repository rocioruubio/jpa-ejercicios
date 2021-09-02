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

public class NuevoAutorMensaje {
    public static void main(String[] args) {
        Autor autor;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mensajes");
        EntityManager em = emf.createEntityManager();
        em = emf.createEntityManager();
// Marcamos el comienzo de la transacción
        em.getTransaction().begin();
        try {
// Pedimos datos del autor
            String email = leerTexto("Introduce el correo electrónico: ");
            String nombre = leerTexto("Introduce nombre: ");
            autor = new Autor(nombre, email);
// Lo añadimos a la BD
            em.persist(autor);
            System.out.println("Identificador del autor: " + autor.getId());
            Long idAutor = autor.getId();
// Creamos el mensaje
            String mensajeStr = leerTexto("Introduce mensaje: ");
            Mensaje mens = new Mensaje(mensajeStr, autor);
// Establecemos los campos
            mens.setFecha(new Date());
// Y lo guardamos en la BD
            em.persist(mens);
            Long idMensaje = mens.getId();
            System.out.println("Identificador del mensaje: " + idMensaje);
// Cerramos la transacción y el entity manager
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
