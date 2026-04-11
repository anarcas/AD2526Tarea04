/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad04_naranjo_antonio;

/**
 * Representa un establecimiento comercial destinado a la venta de vehículos.
 * Esta clase gestiona la información básica del concesionario, incluyendo su
 * identificación fiscal, ubicación y personal a cargo.
 *
 * @author Antonio Naranjo Castillo (DAM - Acceso a Datos)
 * @since 11/04/2026
 * @version 1.0 (Tarea 04 - BD Objeto-Relacionales y Orientada a Objetos)
 */
public class Concesionario {

    // Atributos
    private String cif;
    private String nombre;
    private String direccion;
    private String provincia;
    private String telefono;
    private Integer numTrabajadores;

    // Método constructor sin argumentos
    public Concesionario() {
        this.cif = null;
        this.nombre = null;
        this.direccion = null;
        this.provincia = null;
        this.telefono = null;
        this.numTrabajadores = null;
    }

    // Método constructur
    public Concesionario(String cif, String nombre, String direccion, String provincia, String telefono, Integer numTrabajadores) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.provincia = provincia;
        this.telefono = telefono;
        this.numTrabajadores = numTrabajadores;
    }

    // Métodos setters y getters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getNumTrabajadores() {
        return numTrabajadores;
    }

    public void setNumTrabajadores(Integer numTrabajadores) {
        this.numTrabajadores = numTrabajadores;
    }

    // Método toString() (se emplea para rellenarar objetos JComboBox fundamentalmente)
    @Override
    public String toString() {
        return String.format("%-20s | CIF: %-9s",
                this.nombre,
                this.cif);
    }

    // Método toString() ampliado (personalizado para la aplicación de la tarea)
    public String toStringCompleto() {
        return String.format("%-18s | CIF: %-9s | Dir.: %-25s | Prov.: %-10s | Telf.: %-9s | Nº Trab.: %2d",
                this.nombre,
                this.cif,
                this.direccion,
                this.provincia,
                this.telefono,
                this.numTrabajadores);
    }

}
