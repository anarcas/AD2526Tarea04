/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad04_naranjo_antonio;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase encargada de la gestión de la persistencia de datos mediante db4o.
 * <p>
 * Actúa como la capa de acceso a datos (DAO), proporcionando métodos para la
 * inserción, consulta, actualización y borrado de objetos {@link Concesionario}
 * y {@link Coche}. Implementa el motor de consultas SODA para realizar
 * búsquedas filtradas en la base de datos orientada a objetos.</p>
 *
 * @author Antonio Naranjo Castillo (DAM - Acceso a Datos)
 * @version 1.0 (Tarea 04 - BD Objeto-Relacionales y Orientada a Objetos)
 * @since 11/04/2026
 */
public class ManejadorBaseDatos {

    // Atributo objeto contenedor de la base de datos
    private final ObjectContainer db;

    // Método constructor
    public ManejadorBaseDatos(String nombre) {
        String nombreArchivo = nombre + ".db4o";
        this.db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), nombreArchivo);
        System.out.println(String.format("%sBase de datos '%s' iniciada correctamente.%s", "\u001B[33m",nombre,"\u001B[0m"));
    }
    
     // Método para cargar datos iniciales en la base de objetos db4o (definidos aleatoriamente para realizar la presente tarea)
    public void cargarDatosPrueba() {
        try {
            // Definición de Concesionarios en Andalucía
            // Constructor: cif, nombre, direccion, provincia, telefono, numTrabajadores
            Concesionario c1 = new Concesionario("B41000001", "Sevilla Motor", "Av. de Jerez, 10", "Sevilla", "954123456", 12);
            Concesionario c2 = new Concesionario("B29000002", "Costa Sol Cars", "Calle Salitre, 45", "Málaga", "952987654", 15);
            Concesionario c3 = new Concesionario("B11000003", "Cádiz Auto", "Av. Cayetano del Toro, 5", "Cádiz", "956334455", 8);
            Concesionario c4 = new Concesionario("B18000004", "Granada Drive", "Camino de Ronda, 120", "Granada", "958667788", 10);
            Concesionario c5 = new Concesionario("B04000005", "Almería Wagen", "Ctra. de Ronda, 30", "Almería", "950112233", 7);

            // Almacenar Concesionarios
            this.db.store(c1);
            this.db.store(c2);
            this.db.store(c3);
            this.db.store(c4);
            this.db.store(c5);

            // Definición de Coches
            // Constructor: matricula, marca, modelo, kms (Long), precio (Double), concesionario
            // --- SEVILLA MOTOR ---
            this.db.store(new Coche("1111 AAA", "Tesla", "Model 3", 45000L, 35000.0, c1));
            this.db.store(new Coche("2222 BBB", "BYD", "Atto 3", 12000L, 31000.0, c1));
            this.db.store(new Coche("3333 CCC", "MG", "MG4 Electric", 8500L, 24500.0, c1));
            this.db.store(new Coche("4444 DDD", "Toyota", "Corolla 200h", 25000L, 28000.0, c1));
            this.db.store(new Coche("5555 EEE", "Hyundai", "IONIQ 5", 5000L, 42000.0, c1));

            // --- COSTA SOL CARS ---
            this.db.store(new Coche("6666 FFF", "Kia", "EV6", 15000L, 39500.0, c2));
            this.db.store(new Coche("7777 GGG", "Cupra", "Formentor", 32000L, 29000.0, c2));
            this.db.store(new Coche("8888 HHH", "Dacia", "Sandero Stepway", 18000L, 14500.0, c2));
            this.db.store(new Coche("9999 III", "Tesla", "Model Y", 20000L, 46000.0, c2));

            // --- CÁDIZ AUTO ---
            this.db.store(new Coche("0000 JJJ", "Renault", "Austral", 11000L, 32500.0, c3));
            this.db.store(new Coche("1234 KKK", "Peugeot", "E-2008", 14000L, 27000.0, c3));
            this.db.store(new Coche("5678 LLL", "Ford", "Mustang Mach-E", 9000L, 48000.0, c3));
            this.db.store(new Coche("9012 MMM", "Volkswagen", "ID.4", 28000L, 37000.0, c3));

            // --- GRANADA DRIVE ---
            this.db.store(new Coche("3456 NNN", "MG", "ZS EV", 35000L, 22000.0, c4));
            this.db.store(new Coche("7890 OOO", "Hyundai", "Tucson PHEV", 21000L, 34000.0, c4));
            this.db.store(new Coche("1357 PPP", "BMW", "iX1", 4000L, 52000.0, c4));
            this.db.store(new Coche("2468 QQQ", "Lexus", "UX 250h", 42000L, 31500.0, c4));

            // --- ALMERÍA WAGEN ---
            this.db.store(new Coche("8642 RRR", "Nissan", "Ariya", 7000L, 44000.0, c5));
            this.db.store(new Coche("9753 SSS", "Smart", "#1", 13000L, 33000.0, c5));
            this.db.store(new Coche("1590 TTT", "Volvo", "EX30", 2500L, 36500.0, c5));
            this.db.store(new Coche("2601 UUU", "Polestar", "2", 19000L, 41000.0, c5));

            System.out.println("Base de objetos cargada correctamente.");

        } catch (Exception e) {
            System.err.println("Error en carga de datos: " + e.getMessage());
        }
    }

    //Método para almacenar datos en la base de objetos db4o
    public void registrarConcesionario(String cif, String nombre, String dir, String prov, String tel, Integer num) {

        // Variable para almacenar el mensaje de salida
        String mensaje;

        // Se vuelve a comprobar exista CIF dada la importancia de la clave primaria de la entidad concesionario
        if (cif == null || cif.isEmpty()) {
            mensaje = "El campo de texto CIF no puede estar vacío.";
            System.err.println(mensaje);
            throw new IllegalArgumentException(mensaje);
        }
        // Se crea el prototipo de búsqueda usando solo el CIF considerando clave primaria de la entidad concesionario
        // Pasamos null en el resto para que Db4o solo filtre por el identificador único
        Concesionario concePrototipo = new Concesionario(cif, null, null, null, null, null);

        // Se consulta si existe
        ObjectSet res = this.db.queryByExample(concePrototipo);

        if (res.hasNext()) {
            // Si existe se lanza la excepción correspondiente
            mensaje = "ERROR: El concesionario con CIF " + cif + " ya está registrado.";
            System.err.println(mensaje);
            throw new IllegalStateException(mensaje);
        } else {
            // Si no existe se crea el objeto y se crea persistencia en la base de datos
            Concesionario conceNuevo = new Concesionario(cif, nombre, dir, prov, tel, num);
            this.db.store(conceNuevo);
        }
    }

    // Método para mostrar los concesionarios registrados en la base de datos
    public List<Concesionario> consultarConcesionarios() {
        // Prototipo de búsqueda
        Concesionario c = new Concesionario(null, null, null, null, null, null); // Prototipo de búsqueda

        // Consulta a la base de datos
        ObjectSet res = this.db.queryByExample(c); // Realización de consulta
        List<Concesionario> concesionarios = new ArrayList<>();

        while (res.hasNext()) {
            Concesionario con = (Concesionario) res.next();
            concesionarios.add(con);
        }

        // Mostrar concesionarios por consola
        mostrarConcesionarios(concesionarios);

        return concesionarios;

    }

    //Método para mostrar objetos recuperados de la base de objetos db4o
    public void mostrarConcesionarios(List<Concesionario> lista) {
        System.out.println("Número de concesionarios consultados: " + lista.size() + " concesionarios en la base de objetos.");
        for (Concesionario con : lista) {
            System.out.println("\t" + con);
        }
    }

    // Método para eliminar un concesionario definido por su clave primaria
    public void borrarConcesionario(String cif) {
        // Variable para almacenar el mensaje de salida
        String mensaje;

        // Se consulta a la base de objetos por el concesionario del cif indicado
        ObjectSet res = this.db.queryByExample(new Concesionario(cif, null, null, null, null, null));
        if (!res.hasNext()) {
            mensaje = "Error: No se encuentra el concesionario con CIF " + cif;
            System.err.println(mensaje);
            throw new IllegalStateException(mensaje);
        }

        // Se obtiene el objeto consultado en c a borrar
        Concesionario c = (Concesionario) res.next();
        // Se crea un prototipo de consulta para comprobar si el concesionario a borrar dispone de coches asociados
        Coche protoCoche = new Coche(null, null, null, null, null, c);
        ObjectSet resCoches = this.db.queryByExample(protoCoche);
        if (resCoches.hasNext()) {
            mensaje = "Error: No se puede eliminar el concesionario seleccionado, tiene coches a la venta.";
            System.err.println(mensaje);
            throw new IllegalStateException(mensaje);
        } else {
            // Si no hay coches se procede al borrado del concesionario
            this.db.delete(c); // Se elimina el objeto concesionario de la base de objetos
        }
    }

    // Método consulta de concesionarios ordenados por nombre
    public List<Concesionario> consultarConcesionariosOrdenados() {
        // Iniciar consulta SODA
        Query query = this.db.query();
        // Establecer la clase a la que se aplica la restricción
        query.constrain(Concesionario.class);
        // Aplicar la ordenación por el campo "nombre" de forma ascendente
        query.descend("nombre").orderAscending();
        // Se ejecuta la consulta
        ObjectSet res = query.execute();
        // Se convierte el objeto ObjectSet a una lista List de objetos concesionarios
        List<Concesionario> listaOrdenada = new ArrayList<>();
        while (res.hasNext()) {
            Concesionario con = (Concesionario) res.next();
            listaOrdenada.add(con);
        }
        // Se muestran los objetos Concesionarios por consola
        mostrarConcesionarios(listaOrdenada);

        return listaOrdenada;
    }

    // Método de consulta de coches por precio de un determinado concesionario
    public List<Coche> consultarCochesPorConcesionarioOrdenados(Concesionario concesionarioSeleccionado) {
        // Se inicia la consulta SODA
        Query query = this.db.query();

        // Se apunta a la clase Coche
        query.constrain(Coche.class);

        // Se restringe al atributo "concesionario" del objeto Coche
        query.descend("concesionario").constrain(concesionarioSeleccionado);

        // Se ordena por el atributo "precio"
        query.descend("precio").orderAscending();

        // Se ejecuta la consulta y se reconvierte a lista List
        ObjectSet res = query.execute();
        List<Coche> lista = new ArrayList<>();
        while (res.hasNext()) {
            lista.add((Coche) res.next());
        }

        // Mostrar en consola para depuración
        mostrarCoches(lista);

        return lista;
    }

    // Mostrar listado de coches que tengas menos de una determinada cantidad de kilómetros recorridos
    public List<Coche> consultarCochesPorKilometros(int kmMaximos) {
        // Se inicia la consulta SODA
        Query query = this.db.query();

        // Se restringe a la clase Coche
        query.constrain(Coche.class);

        // Se aplica restringe por el atributo "kilometros" menor que kmMaximos
        query.descend("kms").constrain(kmMaximos).smaller();

        // Se ejecuta la consulta y se reconvierte a lista List
        ObjectSet res = query.execute();
        List<Coche> lista = new ArrayList<>();
        while (res.hasNext()) {
            lista.add((Coche) res.next());
        }

        // Mostrar en consola para depuración
        mostrarCoches(lista);

        return lista;
    }

    // Mostrar listado de coches de una determinada marca
    public List<Coche> consultarCochesPorMarca(String marca) {
        // Se inicia la consulta SODA
        Query query = this.db.query();

        // Se restringe a la clase Coche
        query.constrain(Coche.class);

        // Se aplica restringe por el atributo "marca"
        query.descend("marca").constrain(marca);

        // Se ejecuta la consulta y se reconvierte a lista List
        ObjectSet res = query.execute();
        List<Coche> lista = new ArrayList<>();
        while (res.hasNext()) {
            lista.add((Coche) res.next());
        }

        // Mostrar en consola para depuración
        mostrarCoches(lista);

        return lista;
    }

    // Método para aplicar descuento sobre el precio de venta de los vehículos de una determinada marca
    public List<Coche> aplicarDescuentoPrecioCoche(double descuento, String marca) {
        // Variabre para almacenar el nuevo importe
        double nuevoPrecio;
        // Lista para almacenar los coches de la marca seleccionada
        List<Coche> lista = consultarCochesPorMarca(marca);

        // Se calcula en nuevo importe con descuento aplicado por cada coche de la marca seleccionada
        for (Coche c : lista) {
            nuevoPrecio = c.getPrecio() * (100d - descuento) / 100d;
            // Se establece el nuevo precio
            c.setPrecio(nuevoPrecio);
            // Se actualiza el nuevo importe en la base de objetos
            this.db.store(c);
        }

        return lista;
    }

    // Método para borrar un coche de la base de objetos db4o
    public void borrarCoche(String matricula) {
        // Variable para almacenar el mensaje de salida
        String mensaje;

        // Buscar el coche por su matrícula, se crea un prototipo de consulta
        Coche proto = new Coche(matricula, null, null, null, null, null);
        ObjectSet res = this.db.queryByExample(proto);

        if (res.hasNext()) {
            // Si existe, se recupera el objeto y se elimina
            Coche c = (Coche) res.next();
            this.db.delete(c);
            mensaje = "Coche con matrícula " + matricula + " eliminado de la base de objetos.";
            System.out.println(mensaje);
        } else {
            // Si no existe, se lanza excepción
            mensaje = "No se encontró ningún coche con la matrícula: " + matricula;
            System.err.println(mensaje);
            throw new IllegalStateException(mensaje);
        }
    }

    // Método para registrar un coche en la base de objetos db4o
    public void registrarCoche(String matricula, String marca, String modelo, Long kms, Double precio, Concesionario concesionario) {
        // Variable para almacenar el mensaje de salida
        String mensaje;

        // Prototipo para evitar matrículas duplicadas
        Coche protoCoche = new Coche(matricula, null, null, null, null, null);
        ObjectSet res = this.db.queryByExample(protoCoche);

        if (res.hasNext()) {
            mensaje = "Error: Ya existe un coche con matrícula " + matricula;
            System.err.println(mensaje);
            throw new IllegalStateException(mensaje);
        } else {
            // Crear y persistir el objeto. db4o guardará automáticamente la referencia al concesionario existente
            Coche nuevoCoche = new Coche(matricula, marca, modelo, kms, precio, concesionario);
            this.db.store(nuevoCoche);
        }
    }

    // Método para consultar coches
    public List<Coche> consultarCoches() {
        // Prototipo de búsqueda
        Coche prototipo = new Coche(null, null, null, null, null, null);

        // Consulta a la base de datos
        ObjectSet res = this.db.queryByExample(prototipo);
        List<Coche> listaCoches = new ArrayList<>();

        while (res.hasNext()) {
            Coche c = (Coche) res.next();
            listaCoches.add(c);
        }

        // Mostrar en consola para depuración
        mostrarCoches(listaCoches);

        return listaCoches;
    }

    // Método para consultar los valores únicos de las marcas de los coches 
    public List<String> consultarMarcaCocheValoresUnicos(List<Coche> coches) {

        // Se declara una lista de datos String que recogerá cada valor único de la marca de los coches
        List<String> listaMarcasUnicas;
        // Se declara un conjunto de datos (String) que recoge solo los valores únicos de las marcas de los coches
        Set<String> conjuntoMarcasUnicas = new LinkedHashSet<>();

        // Se añaden los valores únicos de las marcas de los coches al conjunto
        for (Coche coche : coches) {
            conjuntoMarcasUnicas.add(coche.getMarca());
        }
        // Se convierte el conjunto a lista de datos String
        listaMarcasUnicas = new ArrayList<>(conjuntoMarcasUnicas);

        return listaMarcasUnicas;
    }

    //Método para mostrar objetos Coche recuperados de la base de objetos db4o
    public void mostrarCoches(List<Coche> lista) {
        System.out.println("Número de coches consultados: " + lista.size() + " coches en la base de objetos.");
        for (Coche con : lista) {
            System.out.println("\t" + con);
        }
    }

    // Método para cerrar la base de objetos db4os
    public void cerraBaseDatos(String nombreBD) {
        if (this.db != null) {
            this.db.close();
            System.out.println(String.format("%sBase de datos '%s' cerrada correctamente.%s", "\u001B[33m",nombreBD,"\u001B[0m"));

        }
    }
    
}
