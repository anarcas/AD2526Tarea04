/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ad04_naranjo_antonio;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Clase para implementar una interfaz gráfica presentación de la aplicación de
 * gestión de concesionarios.
 * <p>
 * Esta clase extiende de {@link javax.swing.JFrame} para proporcionar una
 * interfaz gráfica de usuario (GUI) completa. Gestiona la interacción con el
 * usuario mediante el manejo de eventos de Swing, permitiendo la visualización,
 * filtrado y modificación de datos almacenados en la base de datos orientada a
 * objetos db4o.</p>
 * * <p>
 * Se comunica directamente con la clase {@link ManejadorBaseDatos} para separar
 * la lógica de negocio de la visualización.</p>
 *
 * @author Antonio Naranjo Castillo (DAM - Acceso a Datos)
 * @version 1.0 (Tarea 04 - BD Objeto-Relacionales y Orientada a Objetos)
 * @since 11/04/2026
 * @see javax.swing.JFrame
 * @see ManejadorBaseDatos
 */
public class InterfazGrafica extends javax.swing.JFrame {

    // Atributo para gestionar la BD
    private final ManejadorBaseDatos manejador;
    private final String nombreBaseDatos = "concesionarios";

    // Método constructor de la interfaz gráfica objeto JFrame
    public InterfazGrafica() {

        // Se inician los componentes de la interfaz
        initComponents();
        // Se ajusta el tamaño de la ventana al contenido
        this.pack();
        // Se centra la ventana en la pantalla (después de pack)
        this.setLocationRelativeTo(null);
        // Se inica el manejador de la base de datos solo  una vez al arrancar la interfaz
        manejador = new ManejadorBaseDatos(this.nombreBaseDatos);

        // Carga de datos iniciales de la base de objetos db4o
        // Solo cargamos si la base de datos está vacía
        if (manejador.consultarConcesionariosOrdenados().isEmpty()) {
            manejador.cargarDatosPrueba();
            System.out.println("Base de datos inicializada por primera vez.");
        } else {
            System.out.println("La base de datos ya contiene datos, se omite la carga inicial.");
        }

        // Cargamos los objetos JComboBox inicialmente
        rellenarComboConcesionario(jComboBoxConcesionario);
        rellenarComboConcesionario(jComboBoxBorrarConcesionario);
        rellenarComboConcesionario(jComboBoxConcesionarioOrdenarCoche);
        rellenarComboBorrarCoches();
        rellenarComboMarcasCoches();
    }

    // Método para rellenar el objeto JComboBox del panel concesionarios
    private void rellenarComboConcesionario(JComboBox<Concesionario> combo) {
        // Limpiar el combo si tenía datos previos
        combo.removeAllItems();
        // Obtener la listaMarcas de objetos de la clase Concesinarios
        List<Concesionario> lista = manejador.consultarConcesionarios();
        // Alimentar el combo con la listaMarcas de objetos Concesionarios
        for (Concesionario c : lista) {
            combo.addItem(c);
        }
    }

    // Método para limpiar los objetos JTextField del panel concesionarios
    private void limpiarCamposConcesionario() {
        jTextFieldCif.setText("");
        jTextFieldNombre.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldProvincia.setText("");
        jTextFieldTelefono.setText("");
        jSpinnerNumTrab.setValue(0);

        // Poner el foco de nuevo en el primer campo CIF del panel Concesionarios
        jTextFieldCif.requestFocus();
    }

    // Método para rellenar el objeto JCombox del panel coches
    private void rellenarComboBorrarCoches() {
        // Limpiar el combo si tenía datos previos
        jComboBoxBorrarCoche.removeAllItems();
        // Obtener la listaMarcas de objetos de la clase Coche
        List<Coche> lista = manejador.consultarCoches();
        // Alimentar el combo con la listaMarcas de objetos Coche
        for (Coche c : lista) {
            jComboBoxBorrarCoche.addItem(c);
        }
    }

    // Método para rellenar el objeto JComboBox de valores únicos de marcas de coches
    private void rellenarComboMarcasCoches() {
        // Limpiar el combo si tenía datos previos
        jComboBoxMarcaCoche.removeAllItems();
        // Obtener el listado de marcas únicas de los coches
        List<String> listaMarcas = manejador.consultarMarcaCocheValoresUnicos(manejador.consultarCoches());
        // Alimentar el combo con la listaMarcas de marcas únicas
        for (String marca : listaMarcas) {
            jComboBoxMarcaCoche.addItem(marca);
        }
    }

    // Método para limpiar los objetos JTextField del panel coches
    private void limpiarCamposCoche() {
        jTextFieldMatricula.setText("");
        jTextFieldMarca.setText("");
        jTextFieldModelo.setText("");
        jTextFieldKms.setText("");
        jTextFieldPrecio.setText("");

        // Reiniciar el ComboBox al primer elemento
        if (jComboBoxConcesionario.getItemCount() > 0) {
            jComboBoxConcesionario.setSelectedIndex(0);
        }

        // Poner el foco de nuevo en el primer campo Matrícula del panel Coches
        jTextFieldMatricula.requestFocus();
    }

    // Método para salir de la aplicación previamente cerrando la base de datos
    private void salir() {
        // Cerrar la base de datos si el objeto manejador no es nulo
        if (manejador != null) {
            manejador.cerraBaseDatos(this.nombreBaseDatos);
        }
        // Cerrar la aplicación por completo
        System.exit(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCif = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldProvincia = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jButtonGuardarConcesionario = new javax.swing.JButton();
        jSpinnerNumTrab = new javax.swing.JSpinner();
        jButtonLimpiarConcesionarios = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldMatricula = new javax.swing.JTextField();
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldKms = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jComboBoxConcesionario = new javax.swing.JComboBox<>();
        jButtonRegistrarCoche = new javax.swing.JButton();
        jButtonLimpiarCoches = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxBorrarCoche = new javax.swing.JComboBox<>();
        jComboBoxBorrarConcesionario = new javax.swing.JComboBox<>();
        jButtonEliminarConcesionario = new javax.swing.JButton();
        jButtonSuprimirCoche = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButtonSalir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jButtonMostrarConcesionarios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaListadoConcesionarios = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButtonMostrarCochesPorPrecio = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaListadoCochesPorConcesionario = new javax.swing.JTextArea();
        jComboBoxConcesionarioOrdenarCoche = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jButtonMostrarCochesPorKms = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaListadoCochesPorKms = new javax.swing.JTextArea();
        jTextFieldKmsRecorridos = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jButtonAplicarDescuentoCoche = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaListadoCochesPorMarca = new javax.swing.JTextArea();
        jComboBoxMarcaCoche = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONCESIONARIOS & COCHES - Base de datos orientada a objetos usando db4o ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("REGISTRAR Concesionarios (EJ. 1)");

        jLabel2.setText("CIF");

        jLabel3.setText("Nombre");

        jLabel4.setText("Dirección");

        jLabel5.setText("Provincia");

        jLabel6.setText("Teléfono");

        jLabel7.setText("Núm. Trab.");

        jTextFieldCif.setToolTipText("12345678A");

        jTextFieldNombre.setToolTipText("Nombre concesionario");

        jTextFieldDireccion.setToolTipText("Dirección concesionario");

        jTextFieldProvincia.setToolTipText("Provincia");

        jTextFieldTelefono.setToolTipText("123456789");

        jButtonGuardarConcesionario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonGuardarConcesionario.setText("Guardar");
        jButtonGuardarConcesionario.setToolTipText("Guardar Concesionario");
        jButtonGuardarConcesionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarConcesionarioActionPerformed(evt);
            }
        });

        jSpinnerNumTrab.setModel(new javax.swing.SpinnerNumberModel());
        jSpinnerNumTrab.setToolTipText("Número de trabajadores");

        jButtonLimpiarConcesionarios.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonLimpiarConcesionarios.setText("Limpiar");
        jButtonLimpiarConcesionarios.setToolTipText("Limpiar los campos de texto");
        jButtonLimpiarConcesionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarConcesionariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDireccion)
                            .addComponent(jTextFieldProvincia)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldCif, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jSpinnerNumTrab))
                                .addGap(0, 111, Short.MAX_VALUE))
                            .addComponent(jTextFieldNombre)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonLimpiarConcesionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGuardarConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinnerNumTrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardarConcesionario)
                    .addComponent(jButtonLimpiarConcesionarios))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("REGISTRAR Coches (EJ. 3)");

        jLabel9.setText("Matrícula");

        jLabel10.setText("Marca");

        jLabel11.setText("Modelo");

        jLabel12.setText("Kilómetros");

        jLabel13.setText("Precio");

        jLabel14.setText("Concesionario");

        jTextFieldMatricula.setToolTipText("1234 ABC");

        jTextFieldMarca.setToolTipText("Marca vehículo");

        jTextFieldModelo.setToolTipText("Modelo vehículo");

        jTextFieldKms.setToolTipText("Tipo dato Long");

        jTextFieldPrecio.setToolTipText("Tipo dato Double");

        jComboBoxConcesionario.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        jButtonRegistrarCoche.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonRegistrarCoche.setText("Registrar");
        jButtonRegistrarCoche.setToolTipText("Registrar Coche");
        jButtonRegistrarCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarCocheActionPerformed(evt);
            }
        });

        jButtonLimpiarCoches.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonLimpiarCoches.setText("Limpiar");
        jButtonLimpiarCoches.setToolTipText("Limpiar los campos de texto");
        jButtonLimpiarCoches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarCochesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonLimpiarCoches, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonRegistrarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(jTextFieldModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(jComboBoxConcesionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldKms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldKms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrarCoche)
                    .addComponent(jButtonLimpiarCoches))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("ELIMINAR OBJETOS de la base de objetos db4o (EJ. 2; 4)");

        jLabel16.setText("Concesionarios:");

        jLabel17.setText("Coches:");

        jComboBoxBorrarCoche.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        jComboBoxBorrarConcesionario.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        jButtonEliminarConcesionario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonEliminarConcesionario.setText("Eliminar");
        jButtonEliminarConcesionario.setToolTipText("Eliminar Concesionario");
        jButtonEliminarConcesionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarConcesionarioActionPerformed(evt);
            }
        });

        jButtonSuprimirCoche.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonSuprimirCoche.setText("Suprimir");
        jButtonSuprimirCoche.setToolTipText("Suprimir Coche");
        jButtonSuprimirCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuprimirCocheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxBorrarConcesionario, 0, 317, Short.MAX_VALUE)
                            .addComponent(jComboBoxBorrarCoche, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEliminarConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSuprimirCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxBorrarConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminarConcesionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxBorrarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSuprimirCoche))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonSalir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.setToolTipText("Salir de la aplicación");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jButtonSalir))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 255));
        jLabel18.setText("MOSTRAR todos los concesionarios ordenados por nombre (EJ. 5)");

        jButtonMostrarConcesionarios.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonMostrarConcesionarios.setText("Mostrar");
        jButtonMostrarConcesionarios.setToolTipText("Mostrar lista ordenada de Concesionarios");
        jButtonMostrarConcesionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarConcesionariosActionPerformed(evt);
            }
        });

        jTextAreaListadoConcesionarios.setEditable(false);
        jTextAreaListadoConcesionarios.setColumns(20);
        jTextAreaListadoConcesionarios.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextAreaListadoConcesionarios.setRows(5);
        jScrollPane1.setViewportView(jTextAreaListadoConcesionarios);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonMostrarConcesionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jButtonMostrarConcesionarios))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 255));
        jLabel19.setText("Mostrar todos los coches de un concesionario, ordenados por precio (EJ. 6)");

        jButtonMostrarCochesPorPrecio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonMostrarCochesPorPrecio.setText("Mostrar");
        jButtonMostrarCochesPorPrecio.setToolTipText("Mostrar lista ordenada de Concesionarios");
        jButtonMostrarCochesPorPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarCochesPorPrecioActionPerformed(evt);
            }
        });

        jTextAreaListadoCochesPorConcesionario.setEditable(false);
        jTextAreaListadoCochesPorConcesionario.setColumns(20);
        jTextAreaListadoCochesPorConcesionario.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextAreaListadoCochesPorConcesionario.setRows(5);
        jScrollPane2.setViewportView(jTextAreaListadoCochesPorConcesionario);

        jComboBoxConcesionarioOrdenarCoche.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jComboBoxConcesionarioOrdenarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonMostrarCochesPorPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConcesionarioOrdenarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMostrarCochesPorPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 255));
        jLabel20.setText("Mostrar todos los coches que hayan recorrido una distancia dada (EJ. 7)");

        jButtonMostrarCochesPorKms.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonMostrarCochesPorKms.setText("Mostrar");
        jButtonMostrarCochesPorKms.setToolTipText("Mostrar lista ordenada de Concesionarios");
        jButtonMostrarCochesPorKms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarCochesPorKmsActionPerformed(evt);
            }
        });

        jTextAreaListadoCochesPorKms.setEditable(false);
        jTextAreaListadoCochesPorKms.setColumns(20);
        jTextAreaListadoCochesPorKms.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextAreaListadoCochesPorKms.setRows(5);
        jScrollPane3.setViewportView(jTextAreaListadoCochesPorKms);

        jTextFieldKmsRecorridos.setToolTipText("Tipo dato Long");

        jLabel21.setText("Kilómetros");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldKmsRecorridos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonMostrarCochesPorKms, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMostrarCochesPorKms)
                    .addComponent(jTextFieldKmsRecorridos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 255));
        jLabel22.setText("Rebajar un 10% el precio de todos los coches de una marca (EJ. 8)");

        jButtonAplicarDescuentoCoche.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButtonAplicarDescuentoCoche.setText("Aplicar descuento");
        jButtonAplicarDescuentoCoche.setToolTipText("Aplicar descuento al precio de una marca concreta de coches");
        jButtonAplicarDescuentoCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAplicarDescuentoCocheActionPerformed(evt);
            }
        });

        jTextAreaListadoCochesPorMarca.setEditable(false);
        jTextAreaListadoCochesPorMarca.setColumns(20);
        jTextAreaListadoCochesPorMarca.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextAreaListadoCochesPorMarca.setRows(5);
        jScrollPane4.setViewportView(jTextAreaListadoCochesPorMarca);

        jComboBoxMarcaCoche.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jComboBoxMarcaCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAplicarDescuentoCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMarcaCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAplicarDescuentoCoche))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarConcesionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarConcesionarioActionPerformed
        // TODO add your handling code here:

        // Variable para almacenar el mensaje de salida
        String mensaje;
        try {
            // Obtener datos de los campos de texto
            String cif = jTextFieldCif.getText().trim().toUpperCase();
            String nombre = jTextFieldNombre.getText().trim();
            String dir = jTextFieldDireccion.getText().trim();
            String prov = jTextFieldProvincia.getText().trim();
            String tel = jTextFieldTelefono.getText().trim();
            int numTrab = (Integer) jSpinnerNumTrab.getValue();

            // Validar si los campos de textos están vacios y lanzar la excepción si fuera necesario
            if (cif.isEmpty() || nombre.isEmpty() || dir.isEmpty() || prov.isEmpty() || tel.isEmpty()) {
                mensaje = "Error: Todos los campos de texto del panel CONCESIONARIOS son obligatorios.";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Validar el CIF del concesionario con un formato adecuado según empresas españolas
            if (!cif.matches("^[A-Z][0-9]{7}[A-Z0-9]$")) {
                mensaje = "Error: El formato del CIF no es válido. Debe empezar por letra, seguido de 7 números y terminar en letra o número.";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Validar el número de teléfono
            if (!tel.matches("[0-9]{9}")) {
                mensaje = "Error: El campo teléfono debe tener exactamente 9 dígitos numéricos.";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Intento de registro en la base de datos
            manejador.registrarConcesionario(cif, nombre, dir, prov, tel, numTrab);
            // Registro con éxito
            JOptionPane.showMessageDialog(this, "Concesionario " + nombre + " guardado con éxito.");
            rellenarComboConcesionario(jComboBoxConcesionario);
            rellenarComboConcesionario(jComboBoxBorrarConcesionario);
            rellenarComboConcesionario(jComboBoxConcesionarioOrdenarCoche);
            limpiarCamposConcesionario();

        } catch (IllegalArgumentException ex) {
            // Capturar errores de validación previa (campos vacíos, formato número)
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalStateException ex) {
            // Capturar el error de CIF ya registrado en la base de datos
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error: CIF ya registrado", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            // Capturar errores genéricos no esperados
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error Crítico", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGuardarConcesionarioActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonRegistrarCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarCocheActionPerformed
        // TODO add your handling code here:

        // Variable para almacenar el mensaje de salida
        String mensaje;

        try {
            // Obtener y limpiar datos básicos
            String matricula = jTextFieldMatricula.getText().trim().toUpperCase();
            String marca = jTextFieldMarca.getText().trim();
            String modelo = jTextFieldModelo.getText().trim();

            // Comprobar si los campos de textos están vacios y lanzar la excepción si fuera necesario
            if (matricula.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
                mensaje = "Error: Todos los campos de texto del panel COCHES son obligatorios.";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Validar Matrícula (4 números, espacio, 3 letras permitidas para las matrículas de vehículos en España)
            if (!matricula.matches("^[0-9]{4}\\s[A-Z]{3}$")) {
                mensaje = "Error: Formato de matrícula incorrecto (Formato correcto: cuatro dígitos, espacio y tres letras -> Ej: 1234 FCK).";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Validar Kilómetros
            Long kms;
            try {
                kms = Long.parseLong(jTextFieldKms.getText().trim());
                if (kms <= 0) {
                    mensaje = "Error: Los kilómetros deben ser mayores a 0.";
                    System.err.println(mensaje);
                    throw new IllegalArgumentException(mensaje);
                }
            } catch (NumberFormatException e) {
                mensaje = "Error: los kilómetros debe introducir un número entero (tipo dato Long).";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Validar Precio
            Double precio;
            try {
                precio = Double.parseDouble(jTextFieldPrecio.getText().trim().replace(",", "."));
                if (precio <= 0) {
                    mensaje = "Error: El precio debe ser mayor que cero.";
                    System.err.println(mensaje);
                    throw new IllegalArgumentException(mensaje);
                }
            } catch (NumberFormatException e) {
                mensaje = "Error: El precio debe ser un número decimal válido (tipo dato Double).";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Obtener Concesionario del ComboBox
            Concesionario conceSeleccionado = (Concesionario) jComboBoxConcesionario.getSelectedItem();
            if (conceSeleccionado == null) {
                mensaje = "Error: Debe seleccionar un concesionario de la lista.";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Se intenta registrar el vehículo
            manejador.registrarCoche(matricula, marca, modelo, kms, precio, conceSeleccionado);

            JOptionPane.showMessageDialog(this, "Vehículo con matrícula " + matricula + " registrado correctamente.");
            rellenarComboBorrarCoches();
            rellenarComboMarcasCoches();
            limpiarCamposCoche();

        } catch (IllegalArgumentException ex) {
            // Capta error de validación
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalStateException ex) {
            // Capta error de duplicado o objeto ya registrado en la base de datos
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de duplicado", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            // Capta errores inesperados
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.toString());
        }
    }//GEN-LAST:event_jButtonRegistrarCocheActionPerformed

    private void jButtonEliminarConcesionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarConcesionarioActionPerformed
        // TODO add your handling code here:

        // Variable para almacenar el mensaje de salida
        String mensaje;

        try {
            Concesionario concesionarioSelecionado = (Concesionario) jComboBoxBorrarConcesionario.getSelectedItem();
            if (concesionarioSelecionado == null) {
                mensaje = "Error: No hay ningún concesionario seleccionado para borrar.";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Se extrae el CIF del concesionario a borrar
            String cif = concesionarioSelecionado.getCif();

            // Confirmación para eliminar el concesionario
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar el concesionario " + cif + "?",
                    "Confirmar borrado", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                manejador.borrarConcesionario(cif);
                JOptionPane.showMessageDialog(this, "Concesionario " + cif + "eliminado correctamente.");

                // Se actualiza la interfaz
                rellenarComboConcesionario(jComboBoxConcesionario);
                rellenarComboConcesionario(jComboBoxBorrarConcesionario);
                rellenarComboConcesionario(jComboBoxConcesionarioOrdenarCoche);
                limpiarCamposConcesionario();
            }

        } catch (IllegalStateException ex) {
            // Captar el error si el concesionario tiene coches a la venta en sus registros
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Condición de borrado", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            // Captar errores al eliminar
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
        }

    }//GEN-LAST:event_jButtonEliminarConcesionarioActionPerformed

    private void jButtonSuprimirCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuprimirCocheActionPerformed
        // TODO add your handling code here:

        // Variable para almacenar el mensaje de salida
        String mensaje;

        try {
            Coche cocheSelecionado = (Coche) jComboBoxBorrarCoche.getSelectedItem();

            if (cocheSelecionado == null) {
                mensaje = "Error: No existe ningún coche seleccionado a eliminar.";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Se obtiene la matrícula del coche
            String matricula = cocheSelecionado.getMatricula();
            // Confirmación para eliminar el coche
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar el coche " + matricula + "?",
                    "Confirmar borrado", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                manejador.borrarCoche(matricula);
                JOptionPane.showMessageDialog(this, "Coche con matrícula " + matricula + "eliminado correctamente.");

                // Limpiar los campos del panel de coches
                rellenarComboBorrarCoches();
                rellenarComboMarcasCoches();
                limpiarCamposCoche();
            }

        } catch (IllegalStateException ex) {
            // Error si el coche no existe
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de borrado", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            // Error si el campo está vacío
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            // Otros errores inesperados
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.toString());
        }
    }//GEN-LAST:event_jButtonSuprimirCocheActionPerformed

    private void jButtonLimpiarConcesionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarConcesionariosActionPerformed
        // TODO add your handling code here:
        limpiarCamposConcesionario();

    }//GEN-LAST:event_jButtonLimpiarConcesionariosActionPerformed

    private void jButtonLimpiarCochesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarCochesActionPerformed
        // TODO add your handling code here:
        limpiarCamposCoche();
    }//GEN-LAST:event_jButtonLimpiarCochesActionPerformed

    private void jButtonMostrarConcesionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarConcesionariosActionPerformed
        // TODO add your handling code here:

        // Obtener la listaMarcas ordenada desde el objeto manejador
        List<Concesionario> lista = manejador.consultarConcesionariosOrdenados();

        // Se hace uso de un objeto StringBuilder para construir el texto que se mostrará en una etiqueta JLabel
        StringBuilder sb = new StringBuilder();
        // Se añade un título inicial
        sb.append("=== LISTADO DE CONCESIONARIOS (Ordenados por nombre) ===\n\n");
        // Se construye el cuerpo del texto
        for (Concesionario c : lista) {
            sb.append("- ").append(c.toStringCompleto()).append("\n");
        }

        // Se muestra el resultado
        jTextAreaListadoConcesionarios.setText(sb.toString());
        // Posicionar el scroll al principio por defecto tras el volcado de datos
        jTextAreaListadoConcesionarios.setCaretPosition(0);

    }//GEN-LAST:event_jButtonMostrarConcesionariosActionPerformed

    private void jButtonMostrarCochesPorPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarCochesPorPrecioActionPerformed
        // TODO add your handling code here:

        // Variable para almacenar el mensaje de salida
        String mensaje;

        try {
            // Obtenemos el concesionario del ComboBox
            Concesionario concesionario = (Concesionario) jComboBoxConcesionarioOrdenarCoche.getSelectedItem();

            if (concesionario == null) {
                mensaje = "Error: Seleccione un concesionario primero.";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Se construye la listaMarcas de coches acorde a la consulta por medio del objeto manejador
            List<Coche> lista = manejador.consultarCochesPorConcesionarioOrdenados(concesionario);

            // Se construye el listado
            StringBuilder sb = new StringBuilder();
            sb.append("COCHES EN: ").append(concesionario.getNombre()).append("\n");
            sb.append("Ordenados por precio (Ascendente)\n");
            sb.append("--------------------------------------------------\n");

            if (lista.isEmpty()) {
                sb.append("No hay coches registrados en este concesionario.");
            } else {
                for (Coche coche : lista) {
                    sb.append("- ").append(coche.toStringSimplificadoPrecio()).append("\n");
                }
            }

            // Mostrar listado en el área de texto
            jTextAreaListadoCochesPorConcesionario.setText(sb.toString());
            jTextAreaListadoCochesPorConcesionario.setCaretPosition(0);

        } catch (IllegalArgumentException ex) {
            // Se capta el error de validación
            mensaje = "Error de validación: " + ex.getMessage();
            System.err.println(mensaje);
            JOptionPane.showMessageDialog(this, mensaje, "Faltan datos", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            // Captar errores inesperados
            mensaje = "Error en la consulta: " + ex.getMessage();
            System.err.println(mensaje);
            JOptionPane.showMessageDialog(this, "Error en la consulta: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonMostrarCochesPorPrecioActionPerformed

    private void jButtonMostrarCochesPorKmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarCochesPorKmsActionPerformed
        // TODO add your handling code here:

        // Variable para almacenar el mensaje de salida
        String mensaje;
        try {
            // Recoger texto y validar que no esté vacío
            String textoKm = jTextFieldKmsRecorridos.getText().trim();

            if (textoKm.isEmpty()) {
                mensaje = "Error: El campo de kilómetros no puede estar vacío.";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Validar que sea un número entero
            int km;
            try {
                km = Integer.parseInt(textoKm);
                if (km < 0) {
                    mensaje = "Error: Los kilómetros deben ser mayores a 0.";
                    System.err.println(mensaje);
                    throw new IllegalArgumentException(mensaje); // No hay km negativos
                }
            } catch (NumberFormatException e) {
                mensaje = "Error: los kilómetros debe introducir un número entero (tipo dato Long).";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Llamar al manejador para generar la listaMarcas de coches
            List<Coche> lista = manejador.consultarCochesPorKilometros(km);

            // Construir el listado de coches
            StringBuilder sb = new StringBuilder();
            sb.append("Vehículos con menos de ").append(km).append(" km:\n");
            sb.append("==============================================\n");

            if (lista.isEmpty()) {
                sb.append("No se han encontrado coches que cumplan el criterio.");
            } else {
                for (Coche coche : lista) {
                    sb.append("- ").append(coche.toStringSimplificadoKms()).append("\n");
                }
            }

            // Volcado de datos al JTextArea y resetear scroll
            jTextAreaListadoCochesPorKms.setText(sb.toString());
            jTextAreaListadoCochesPorKms.setCaretPosition(0);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de datos", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al consultar: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonMostrarCochesPorKmsActionPerformed

    private void jButtonAplicarDescuentoCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAplicarDescuentoCocheActionPerformed
        // TODO add your handling code here:

        // Variable para almacenar el mensaje de salida
        String mensaje;
        double descuento = 10d;

        try {
            // Obtenemos la marca del vehículo del ComboBox
            String marca = (String) jComboBoxMarcaCoche.getSelectedItem();

            if (marca == null) {
                mensaje = "Error: Seleccione una marca primero.";
                System.err.println(mensaje);
                throw new IllegalArgumentException(mensaje);
            }

            // Confirmación de seguridad
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Desea aplicar un " + descuento + "% de descuento a todos los " + marca + "?",
                    "Confirmar", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                // Se construye la lista de marcas de coches acorde a la consulta por medio del objeto manejador y se aplica el descuento del 10%
                List<Coche> listaActualizada = manejador.aplicarDescuentoPrecioCoche(descuento, marca);

                // Se construye el listado
                StringBuilder sb = new StringBuilder();
                sb.append("DESCUENTOS aplicados a la marca: ").append(marca).append("\n");
                sb.append("--------------------------------------------------\n");

                if (listaActualizada.isEmpty()) {
                    sb.append("No se encontraron coches de esta marca.");
                } else {
                    for (Coche c : listaActualizada) {
                        // Se añade al objeto StringBuilder
                        sb.append("- ").append(c.toStringSimplificadoPrecio()).append("\n");
                    }
                    //JOptionPane.showMessageDialog(this, "Precios actualizados con éxito.");
                }

                // Mostrar listado en el área de texto
                jTextAreaListadoCochesPorMarca.setText(sb.toString());
                jTextAreaListadoCochesPorMarca.setCaretPosition(0);
            }

        } catch (IllegalArgumentException ex) {
            // Se capta el error de validación
            mensaje = "Error de validación: " + ex.getMessage();
            System.err.println(mensaje);
            JOptionPane.showMessageDialog(this, mensaje, "Faltan datos", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            // Captar errores inesperados
            mensaje = "Error en la consulta: " + ex.getMessage();
            System.err.println(mensaje);
            JOptionPane.showMessageDialog(this, "Error en la consulta: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonAplicarDescuentoCocheActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAplicarDescuentoCoche;
    private javax.swing.JButton jButtonEliminarConcesionario;
    private javax.swing.JButton jButtonGuardarConcesionario;
    private javax.swing.JButton jButtonLimpiarCoches;
    private javax.swing.JButton jButtonLimpiarConcesionarios;
    private javax.swing.JButton jButtonMostrarCochesPorKms;
    private javax.swing.JButton jButtonMostrarCochesPorPrecio;
    private javax.swing.JButton jButtonMostrarConcesionarios;
    private javax.swing.JButton jButtonRegistrarCoche;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSuprimirCoche;
    private javax.swing.JComboBox<Coche> jComboBoxBorrarCoche;
    private javax.swing.JComboBox<Concesionario> jComboBoxBorrarConcesionario;
    private javax.swing.JComboBox<Concesionario> jComboBoxConcesionario;
    private javax.swing.JComboBox<Concesionario> jComboBoxConcesionarioOrdenarCoche;
    private javax.swing.JComboBox<String> jComboBoxMarcaCoche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinnerNumTrab;
    private javax.swing.JTextArea jTextAreaListadoCochesPorConcesionario;
    private javax.swing.JTextArea jTextAreaListadoCochesPorKms;
    private javax.swing.JTextArea jTextAreaListadoCochesPorMarca;
    private javax.swing.JTextArea jTextAreaListadoConcesionarios;
    private javax.swing.JTextField jTextFieldCif;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldKms;
    private javax.swing.JTextField jTextFieldKmsRecorridos;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldProvincia;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
