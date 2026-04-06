/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad04_naranjo_antonio;

/**
 *
 * @author anaranjo
 */
public class Concesionario {

    // Atributos
    private String cif;
    private String nombre;
    private String direccion;
    private String provincia;
    private String telefono;
    private Integer numTrabajadores;

    
    public Concesionario(){
    
    this.cif = null;
        this.nombre = null;
        this.direccion = null;
        this.provincia = null;
        this.telefono = null;
        this.numTrabajadores = null;
    }
    
    public Concesionario(String cif, String nombre, String direccion, String provincia, String telefono, Integer numTrabajadores) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.provincia = provincia;
        this.telefono = telefono;
        this.numTrabajadores = numTrabajadores;
    }

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
    
    @Override
    public String toString() {
        return "CIF: " + this.getCif() + " -> " + this.getNombre() + " (" + this.getProvincia() + ")";
    }

}
