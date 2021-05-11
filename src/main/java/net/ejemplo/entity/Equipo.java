package net.ejemplo.entity;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Equipo {

    private int codEquipo;
    
    /*@NotEmpty
    @Size(min = 1, max = 20)*/
    private String nombre;
    
    /*@NotEmpty(message = "Password must not be blank.")
    @Size(min = 1, max = 10, message = "Password must between 1 to 10 Characters.")*/
    private String marca;
    private String modelo;
    private String placa;
    private String categoria;
    private Double horometro;
    private Integer kilometraje;
    private String anioFabricacion;    
    private String operativo;
    private String observaciones;
    private String descripcion;
    private String estadoEquipo;

    public Equipo() {}

    public int getCodEquipo() {
        return codEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCategoria() {
        return categoria;
    }

    public Double getHorometro() {
        return horometro;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public String getAnioFabricacion() {
        return anioFabricacion;
    }

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public String getOperativo() {
        return operativo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "codEquipo=" + codEquipo + ", nombre=" + nombre + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + ", categoria=" + categoria + ", horometro=" + horometro + ", kilometraje=" + kilometraje + ", anioFabricacion=" + anioFabricacion + ", estadoEquipo=" + estadoEquipo + ", operativo=" + operativo + ", observaciones=" + observaciones + ", descripcion=" + descripcion + '}';
    }

}
