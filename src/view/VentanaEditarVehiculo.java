package view;

import dominio.Usuario;
import dominio.Vehiculo;
import negocio.RegistroVehiculos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaEditarVehiculo extends JDialog {
    /*private JLabel lTipo,lnAsientos, lModelo, lAño, lDisponibilidad;
    private JTextField tTipo,tnAsientos, tModelo, tAño;
    private JRadioButton rHablitado, rDesabilitado;
    private JButton bGuardar;
    private Container contenedor;
    private JPanel panelDatos, panelBotones;
    private RegistroVehiculos gestor;
    private ButtonGroup grupoRadio;

    public VentanaEditarVehiculo(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestor = new RegistroVehiculos();
        this.setTitle("Editar - V1");
        //this.setSize(400, 500);
        this.iniciarComponentes();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        String buscar = JOptionPane.showInputDialog("Ingrese el codigo del vehiculo");
        this.iniciarPanelDatos();
        this.inicializarPanelBotones(this.buscarPor(buscar));
    }

    public void iniciarPanelDatos() {
        this.panelDatos = new JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelDatos.setLayout(new GridLayout(9, 2, 15, 15));

        this.lTipo = new JLabel("Tipo de vehiculo:");
        this.lnAsientos = new JLabel("Numero de asientos: ");
        this.lModelo = new JLabel("Modelo: ");
        this.lAño = new JLabel("Año: ");
        this.lDisponibilidad = new JLabel("Disponibilidad: ");

        this.tTipo = new JTextField(null);
        this.tnAsientos = new JTextField(null);
        this.tModelo = new JTextField(null);
        this.tAño = new JTextField(null);

        this.rHablitado = new JRadioButton("Habilitado");
        this.rHablitado.setSelected(true);
        this.rDesabilitado = new JRadioButton("Desabilitado");
        this.grupoRadio = new ButtonGroup();
        this.grupoRadio.add(this.rHablitado);
        this.grupoRadio.add(this.rDesabilitado);

        this.panelDatos.add(this.lTipo);
        this.panelDatos.add(this.tTipo);

        this.panelDatos.add(this.lnAsientos);
        this.panelDatos.add(this.tnAsientos);

        this.panelDatos.add(this.lModelo);
        this.panelDatos.add(this.tModelo);

        this.panelDatos.add(this.lAño);
        this.panelDatos.add(this.tAño);

        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new FlowLayout());

        panelOpciones.add(this.rHablitado);
        panelOpciones.add(this.rDesabilitado);


        this.panelDatos.add(this.lDisponibilidad);
        this.panelDatos.add(panelOpciones);
        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);

    }

    public void inicializarPanelBotones(Vehiculo vehiculo){
        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new ClickBotonGuardar());
        this.bGuardar.setEnabled(true);
        this.panelBotones = new JPanel();
        this.panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.panelBotones.setLayout(new GridLayout(1, 1, 5, 5));
        this.panelBotones.add(this.bGuardar);
        this.contenedor.add(this.panelBotones, BorderLayout.SOUTH);
    }

    public Vehiculo buscarPor(String buscar){
        return gestor.buscarPor(buscar);
    }

    public Vehiculo leerComponentes(Vehiculo vehiculo) {
        vehiculo.setTipo(this.tTipo.getText());
        vehiculo.setnAsientos(this.tnAsientos.getText());
        vehiculo.setModelo(this.tModelo.getText());
        vehiculo.setAño(this.tAño.getText());
        vehiculo.setDisponibilidad(this.rHablitado.isSelected() ? "hablitado" : "desabilitado");
        return vehiculo;
    }
    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    public void guardarVehiculo(Vehiculo vehiculo) {
        try {
            this.gestor.insertar(this.leerComponentes(vehiculo));
            this.ventanaMsg("Datos Modificado con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            this.ventanaMsg(ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }


     class ClickBotonGuardar implements ActionListener {

         @Override
         public void actionPerformed(ActionEvent e) {
             guardarVehiculo();
         }
     }*/
}
