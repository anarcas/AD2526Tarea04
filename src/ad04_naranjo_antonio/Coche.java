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

    public Coche(String matricula, String marca, String modelo, Long kms, Double precio, Concesionario concesionario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kms = kms;
        this.precio = precio;
        this.concesionario = concesionario;
    }

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

    @Override
    public String toString() {
        return String.format("%s %s | Matrícula: %s | Concesionario: %s",
                this.marca,
                this.modelo,
                this.matricula,
                this.concesionario.getNombre());
    }

    public String toStringSimplificadoKms() {
        return String.format("%s %s | Matrícula: %s | Kilómetros: %d",
                this.marca,
                this.modelo,
                this.matricula,
                this.kms);
    }

    public String toStringSimplificadoPrecio() {
        return String.format("%s %s | Matrícula: %s | Precio: %.2f €",
                this.marca,
                this.modelo,
                this.matricula,
                this.precio);
    }

}
