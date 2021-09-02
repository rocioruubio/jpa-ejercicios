package Modelos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "mensaje")
public class Mensaje {
    @Id
    @GeneratedValue
    @Column(name = "mensaje_id")
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Size(min = 3)
    private String texto;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "autor", nullable = false)
    private Autor autor;

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Mensaje() {

    }

    public Mensaje(String texto, Autor autor) {
        this.texto = texto;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", fecha=" + fecha +
                //", autor=" + autor +
                '}';
    }
}
