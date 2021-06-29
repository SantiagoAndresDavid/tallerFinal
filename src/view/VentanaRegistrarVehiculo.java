package view;

import dominio.Vehiculo;
import negocio.RegistroUsuarios;
import negocio.RegistroVehiculos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaRegistrarVehiculo extends JDialog {
    private JLabel lTipo, lnSerie, lnAsientos, lModelo, lAño, lDisponibilidad;
    private JTextField tTipo, tnSerie, tnAsientos, tModelo, tAño;
    private JRadioButton rHablitado, rDesabilitado,rCarro,rAutobus,rMoto,rCamion;
    private JButton bGuardar;
    private Container contenedor;
    private JPanel panelDatos, panelBotones;
    private RegistroVehiculos gestor;
    private ButtonGroup grupoRadio;


    public VentanaRegistrarVehiculo(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestor = new RegistroVehiculos();
        this.setTitle("Formulario Registro de Jugadores - V1");
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
        this.iniciarPanelDatos();
        this.inicializarPanelBotones();
    }

    public void iniciarPanelDatos() {
        this.panelDatos = new JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelDatos.setLayout(new GridLayout(9, 2, 15, 15));

        this.lTipo = new JLabel("Tipo de vehiculo:");
        this.lnSerie = new JLabel("Serie: ");
        this.lnAsientos = new JLabel("Numero de asientos: ");
        this.lModelo = new JLabel("Modelo: ");
        this.lAño = new JLabel("Año: ");
        this.lDisponibilidad = new JLabel("Disponibilidad: ");

        this.tnSerie= new JTextField(null);
        this.tnAsientos = new JTextField(null);
        this.tModelo = new JTextField(null);
        this.tAño = new JTextField(null);

        this.rCarro = new JRadioButton("carro");
        this.rCarro.setSelected(true);
        this.rMoto = new JRadioButton("moto");
        this.rAutobus = new JRadioButton("autobus");
        this.rCamion = new JRadioButton("camion");
        this.grupoRadio = new ButtonGroup();
        this.grupoRadio.add(this.rCarro);
        this.grupoRadio.add(this.rMoto);
        this.grupoRadio.add(this.rAutobus);
        this.grupoRadio.add(this.rCamion);


        this.rHablitado = new JRadioButton("Habilitado");
        this.rHablitado.setSelected(true);
        this.rDesabilitado = new JRadioButton("Desabilitado");
        this.grupoRadio = new ButtonGroup();
        this.grupoRadio.add(this.rHablitado);
        this.grupoRadio.add(this.rDesabilitado);

        JPanel paneTipo = new JPanel();
        paneTipo.setLayout(new FlowLayout());

        paneTipo.add(this.rCarro);
        paneTipo.add(this.rMoto);
        paneTipo.add(this.rAutobus);
        paneTipo.add(this.rCamion);


        this.panelDatos.add(this.lTipo);
        this.panelDatos.add(paneTipo);

        this.panelDatos.add(this.lnSerie);
        this.panelDatos.add(this.tnSerie);

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

    public void inicializarPanelBotones(){
        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new ClickBotonGuardar());
        this.bGuardar.setEnabled(true);
        this.panelBotones = new JPanel();
        this.panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.panelBotones.setLayout(new GridLayout(1, 1, 5, 5));
        this.panelBotones.add(this.bGuardar);
        this.contenedor.add(this.panelBotones, BorderLayout.SOUTH);
    }

    public Vehiculo leerComponentes() {
        String tipo = "";
        if(rCarro.isSelected()){
             tipo = "carro";
        }else if (rMoto.isSelected()){
             tipo = "moto";
        }else if (rAutobus.isSelected()){
             tipo = "moto";
        }else if (rCamion.isSelected()){
            tipo = "camion";
        }
        String serie = this.tnSerie.getText();
        String asientos = this.tnAsientos.getText();
        String modelo = this.tModelo.getText();
        String año = this.tAño.getText();
        String disponibilidad = this.rHablitado.isSelected() ? "habilitado" : "desabilitado";
        Vehiculo Vehiculo = new Vehiculo(tipo,serie,asientos,modelo,año,disponibilidad);
        return Vehiculo;
    }
    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    public void guardarVehiculo() {
        try {
            Vehiculo vehiculo = this.leerComponentes();
            this.gestor.insertar(vehiculo);
            this.ventanaMsg("Datos guardados con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            this.ventanaMsg(ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    class ClickBotonGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            guardarVehiculo();
        }
    }
}
