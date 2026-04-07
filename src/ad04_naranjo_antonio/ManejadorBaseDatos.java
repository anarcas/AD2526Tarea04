/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad04_naranjo_antonio;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anaranjo
 */
public class ManejadorBaseDatos {

    // Atributo
    private final ObjectContainer db;

    // Método constructor
    public ManejadorBaseDatos(String nombre) {
        String nombreArchivo = nombre + ".db4o";
        this.db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), nombreArchivo);
        System.out.println(String.format("Base de datos %s iniciada correctamente.", nombre));
    }

    //Método para almacenar datos en la Base de Objetos.
    public void registrarConcesionario(String cif, String nombre, String dir, String prov, String tel, Integer num) {

        // Se vuelve a comprobar exista CIF dada la importancia de la clave primaria de la entidad concesionario
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
        }
    }

    // Método para mostrar los concesionarios registrados en la base de datos
    public List<Concesionario> consultarConcesionarios() {
        Concesionario c = new Concesionario(null, null, null, null, null, null); // Prototipo de búsqueda
        ObjectSet res = this.db.queryByExample(c); // Realización de consulta
        List<Concesionario> concesionarios = new ArrayList<>();
        while (res.hasNext()) {
            Concesionario con = (Concesionario) res.next();
            concesionarios.add(con);
        }
        return concesionarios;
    }

    //Método para mostrar objetos recuperados de la Base de Objetos
    public void mostrarConsulta(List<Concesionario> lista) {
        System.out.println("Recuperados " + lista.size() + " Objetos");
        for (Concesionario con : lista) {
            System.out.println(con);
        }
    }

    // Método para eliminar un concesionario
    public void borrarConcesionario(String cif) {
        // Se consulta a la base de objetos por el concesionario del cif indicado
        ObjectSet res = db.queryByExample(new Concesionario(cif, null, null, null, null, null));
        if (!res.hasNext()) {
            throw new IllegalStateException("ERROR: No se encuentra el concesionario con CIF " + cif);
        }

        // Se obtiene el objeto consultado en c a borrar
        Concesionario c = (Concesionario) res.next();
        // Se crea un prototipo de consulta para comprobar si el concesionario a borrar dispone de coches asociados
        Coche protoCoche = new Coche(null, null, null, null, null, c);
        ObjectSet resCoches = db.queryByExample(protoCoche);
        if (resCoches.hasNext()) {
            throw new IllegalStateException("No se puede eliminar: El concesionario tiene coches vinculados.");
        } else {
            // Si no hay coches se procede al borrado del concesionario
            db.delete(c); // Se elimina el objeto concesionario de la base de objetos
        }
    }

    // Método para borrar un coche
    public void borrarCoche(String matricula) {
        // Buscar el coche por su matrícula, se crea un prototipo de consulta
        Coche proto = new Coche(matricula, null, null, null, null, null);
        ObjectSet res = db.queryByExample(proto);

        if (res.hasNext()) {
            // Si existe, se recupera el objeto y se elimina
            Coche c = (Coche) res.next();
            db.delete(c);
            System.out.println("Coche con matrícula " + matricula + " eliminado de la BD.");
        } else {
            // Si no existe, se lanza excepción
            throw new IllegalStateException("No se encontró ningún coche con la matrícula: " + matricula);
        }
    }

    // Método para registrar un coche
    public void registrarCoche(String matricula, String marca, String modelo, Long kms, Double precio, Concesionario conce) {
        // Prototipo para evitar matrículas duplicadas
        Coche protoCoche = new Coche(matricula, null, null, null, null, null);
        ObjectSet res = db.queryByExample(protoCoche);

        if (res.hasNext()) {
            throw new IllegalStateException("ERROR: Ya existe un coche con la matrícula " + matricula);
        } else {
            // Crear y persistir el objeto. db4o guardará automáticamente la referencia al concesionario existente
            Coche nuevoCoche = new Coche(matricula, marca, modelo, kms, precio, conce);
            db.store(nuevoCoche);
        }
    }

    // Método para consultar coches
    public List<Coche> consultarCoches() {
        // Prototipo de búsqueda
        Coche proto = new Coche(null, null, null, null, null, null);

        // Consulta a la base de datos
        ObjectSet res = this.db.queryByExample(proto);
        List<Coche> listaCoches = new ArrayList<>();

        while (res.hasNext()) {
            Coche c = (Coche) res.next();
            listaCoches.add(c);
        }

        // Mostrar en consola para depuración
        System.out.println("Número de coches consultados: " + listaCoches.size() + " coches en la BD.");

        return listaCoches;
    }

    // Método cerrar base de datos
    public void cerraBaseDatos(String nombreBD) {
        if (this.db != null) {
            this.db.close();
            System.out.println(String.format("Base de datos %s cerrada correctamente.", nombreBD));

        }
    }
}
