package Modelos;

import jdk.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue
    @Column(name = "idpelicula")
    Long id;

    String titulo;
    Date estreno;
    Double presupuesto;
    Double recaudacion;
    String pais;

    @OneToMany(mappedBy = "id_pelicula")
    List<Critica> criticaList;

    public Pelicula() {
    }

    public Pelicula(String titulo, Date estreno, Double presupuesto, Double recaudacion, String pais) {
        this.titulo = titulo;
        this.estreno = estreno;
        this.presupuesto = presupuesto;
        this.recaudacion = recaudacion;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getEstreno() {
        return estreno;
    }

    public void setEstreno(Date estreno) {
        this.estreno = estreno;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(Double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Critica> getCriticaList() {
        return criticaList;
    }

    public void setCriticaList(List<Critica> criticaList) {
        this.criticaList = criticaList;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", estreno=" + estreno +
                ", presupuesto=" + presupuesto +
                ", recaudacion=" + recaudacion +
                ", pais='" + pais + '\'' +
                ", id_critica=" + criticaList +
                '}';
    }
}
