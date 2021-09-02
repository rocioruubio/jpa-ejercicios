package Modelos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue
    @Column(name = "autor_id")
    Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String correo;
    private String nombre;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch =
            FetchType.LAZY)
    private Set<Mensaje> mensajes = new HashSet<>();

    @Version
    private int version;

    public Autor() {
    }

    public Autor(String correo, String nombre) {
        this.correo = correo;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(Set<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        if (!correo.equals(autor.correo)) return false;
        if (!nombre.equals(autor.nombre)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = correo.hashCode();
        result = 31 * result + nombre.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", mensajes=" + mensajes +
                '}';
    }
}
