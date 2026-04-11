/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad04_naranjo_antonio;

/**
 *
 * @author Antonio Naranjo Castillo
 */
public class Coche {

    //Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private Long kms;
    private Double precio;
    private Concesionario concesionario;

    // Método contrustor sin argumentos
    public Coche() {
        this.matricula = null;
        this.marca = null;
        this.modelo = null;
        this.kms = null;
        this.precio = null;
        this.concesionario = null;
    }

    // Método constructor
    public Coche(String matricula, String marca, String modelo, Long kms, Double precio, Concesionario concesionario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kms = kms;
        this.precio = precio;
        this.concesionario = concesionario;
    }

    // Métodos setters y getters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getKms() {
        return kms;
    }

    public void setKms(Long kms) {
        this.kms = kms;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    // Método toString() (se emplea para rellenarar objetos JComboBox fundamentalmente)
    @Override
    public String toString() {
        return String.format("%-12s %-15s | Matrícula: %-8s | Concesionario: %-20s",
                this.marca,
                this.modelo,
                this.matricula,
                this.concesionario.getNombre());
    }

    // Método toString() simplificado para mostrar solo Kms (personalizado para la aplicación de la tarea)
    public String toStringSimplificadoKms() {
        return String.format("%-12s %-15s | Matrícula: %-8s | Kms: %-7d | CIF: %-20s",
                this.marca,
                this.modelo,
                this.matricula,
                this.kms,
                this.concesionario.getCif());
    }

    // Método toString() simplificado para mostrar solo PVP (personalizado para la aplicación de la tarea)
    public String toStringSimplificadoPrecio() {
        return String.format("%-12s %-15s | Matrícula: %-8s | PVP: %.2f €",
                this.marca,
                this.modelo,
                this.matricula,
                this.precio);
    }

}
