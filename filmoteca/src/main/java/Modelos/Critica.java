package Modelos;

import javax.persistence.*;

@Entity
@Table(name = "critica")
public class Critica {
    @Id
    @GeneratedValue
    @Column(name = "idcritica")
    Long id;

    String critico;
    String texto;
    int valoracion;

    @ManyToOne
    @JoinColumn(name = "criticaList")
    Pelicula id_pelicula;

    public Critica() {
    }

    public Critica(String critico, String texto, int valoracion) {
        this.critico = critico;
        this.texto = texto;
        this.valoracion = valoracion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCritico() {
        return critico;
    }

    public void setCritico(String critico) {
        this.critico = critico;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public Pelicula getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Pelicula id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    @Override
    public String toString() {
        return "Critica{" +
                "id=" + id +
                ", critico='" + critico + '\'' +
                ", texto='" + texto + '\'' +
                ", valoracion=" + valoracion +
                ", id_pelicula=" + id_pelicula +
                '}';
    }
}
