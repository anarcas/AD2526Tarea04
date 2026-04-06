/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad04_naranjo_antonio;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/**
 *
 * @author anaranjo
 */
public class ManejadorBaseDatos {

    // Atributo
    private ObjectContainer db;

    // Método constructor
    public ManejadorBaseDatos(String nombre) {
        String nombreArchivo = nombre + ".db4o";
        this.db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), nombreArchivo);
    }

    //Método para almacenar datos en la Base de Objetos.
    public void registrarConcesionario(String cif, String nombre, String dir, String prov, String tel, Integer num) {

        if (cif == null || cif.isEmpty()) {
            throw new IllegalArgumentException("El CIF no puede estar vacío.");
        }
        // Se crea el prototipo de búsqueda usando solo el CIF considerando clave primaria de la entidad concesionario
        // Pasamos null en el resto para que Db4o solo filtre por el identificador único
        Concesionario concePrototipo = new Concesionario(cif, null, null, null, null, null);

        // Se consulta si existe
        ObjectSet<Concesionario> res = this.db.queryByExample(concePrototipo);

        if (res.hasNext()) {
            // Si existe se lanza la excepción correspondiente
            throw new IllegalStateException("ERROR: El concesionario con CIF " + cif + " ya está registrado.");
        } else {
            // Si no existe se crea el objeto y se crea persistencia en la base de datos
            Concesionario conceNuevo = new Concesionario(cif, nombre, dir, prov, tel, num);
            this.db.store(conceNuevo);
            System.out.println("Registro realizado con éxito: " + nombre);
        }
    }

    // Método para mostrar los concesionarios registrados en la base de datos
    public ObjectSet<Concesionario> consultarConcesionarios() {
        Concesionario c = new Concesionario(null, null, null, null, null, null); //prototipo de búsqueda
        ObjectSet<Concesionario> res = this.db.queryByExample(c); //realización de consulta
        mostrarConsulta(res);//obtención de resultados
        return res;
    }

    //Método para mostrar objetos recuperados de la Base de Objetos
    public void mostrarConsulta(ObjectSet resul) {
        System.out.println("Recuperados " + resul.size() + " Objetos");
        while (resul.hasNext()) {
            System.out.println(resul.next());
        }
    }

    // Método cerrar base de datos
    public void cerraBaseDatos() {
        if (this.db != null) {
            this.db.close();
            System.out.println("Base de datos cerrada correctamente.");

        }
    }
}
