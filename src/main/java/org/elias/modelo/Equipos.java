package org.elias.modelo;

//import io.vertx.codegen.doc.Text;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "equipos", schema = "public")
public class Equipos {

    @Id
    @Column(name = "id")
    private  Integer id;

    @Column(name = "nombre")
    private String nombre;


    @Column(name = "pais")
    private  String pais;

    @Column(name = "jefe_equipo")
    private String jefeEquipo;

    @Column(name = "motor")
    private String motor;


   // @Column(name = "imagen_url")
   // private Text imagenUrl;

    @Column(name = "descripcion")
    private String descripcion;

    // Relación uno a muchos con la entidad Piloto


    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Pilotos> pilotos;

    // Getters y setters
    public List<Pilotos> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Pilotos> pilotos) {
        this.pilotos = pilotos;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getJefeEquipo() {
        return jefeEquipo;
    }

    public void setJefeEquipo(String jefeEquipo) {
        this.jefeEquipo = jefeEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
