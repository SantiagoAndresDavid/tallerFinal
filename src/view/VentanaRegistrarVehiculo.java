package view;

import dominio.Vehiculo;
import javafx.scene.image.Image;
import negocio.RegistroVehiculos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class VentanaRegistrarVehiculo extends JDialog {
    private JLabel lTipo, lnSerie, lnAsientos, lModelo, lAño, lDisponibilidad,lImg;
    private JTextField tTipo, tnSerie, tnAsientos, tModelo, tAño;
    private JRadioButton rHablitado, rDesabilitado, rMinibus, rAutobusDosPisos, rAutobusArticulado, rAutocar;
    private JButton bGuardar,bsubir;
    private Container contenedor;
    private JPanel panelDatos, panelBotones;
    private RegistroVehiculos gestor;
    private ButtonGroup grupoRadio;
    private ImageIcon subir;


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
        this.lImg = new JLabel("Imagen");

        this.tnSerie= new JTextField(null);
        this.tnAsientos = new JTextField(null);
        this.tModelo = new JTextField(null);
        this.tAño = new JTextField(null);

        this.rMinibus = new JRadioButton("Minibus");
        this.rMinibus.setSelected(true);
        this.rAutobusArticulado = new JRadioButton("Autobús articulado");
        this.rAutobusDosPisos = new JRadioButton("Autobús de dos pisos");
        this.rAutocar = new JRadioButton("Autocar");
        this.grupoRadio = new ButtonGroup();
        this.grupoRadio.add(this.rMinibus);
        this.grupoRadio.add(this.rAutobusArticulado);
        this.grupoRadio.add(this.rAutobusDosPisos);
        this.grupoRadio.add(this.rAutocar);


        this.rHablitado = new JRadioButton("Habilitado");
        this.rHablitado.setSelected(true);
        this.rDesabilitado = new JRadioButton("Desabilitado");
        this.grupoRadio = new ButtonGroup();
        this.grupoRadio.add(this.rHablitado);
        this.grupoRadio.add(this.rDesabilitado);

        JPanel paneTipo = new JPanel();
        paneTipo.setLayout(new FlowLayout());
        paneTipo.add(this.rMinibus);
        paneTipo.add(this.rAutobusArticulado);
        paneTipo.add(this.rAutobusDosPisos);
        paneTipo.add(this.rAutocar);


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

        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);

    }



    public void inicializarPanelBotones(){
        this.bsubir = new JButton("subir");
        this.bsubir.addActionListener(new clickBotonsubir());
        this.bsubir.setEnabled(true);
        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new ClickBotonGuardar());
        this.bGuardar.setEnabled(true);
        this.panelBotones = new JPanel();
        this.panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.panelBotones.setLayout(new GridLayout(2, 1, 5, 5));
        this.panelBotones.add(this.bsubir);
        this.panelBotones.add(this.bGuardar);
        this.contenedor.add(this.panelBotones, BorderLayout.SOUTH);
    }

    public ImageIcon subirImagen(){
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        this.subir = new ImageIcon(file.getAbsolutePath());
        return subir;
    }

    public Vehiculo leerComponentes() {
         String tipo = "";
        if(rMinibus.isSelected()){
             tipo = "Minibus";
        }else if (rAutobusArticulado.isSelected()){
             tipo = "Autobús articulado";
        }else if (rAutobusDosPisos.isSelected()){
             tipo = "Autobús de dos pisos";
        }else if (rAutocar.isSelected()){
            tipo = "Autocar";
        }

        String serie = this.tnSerie.getText();
        String asientos = this.tnAsientos.getText();
        String modelo = this.tModelo.getText();
        String año = this.tAño.getText();
        String disponibilidad = this.rHablitado.isSelected() ? "habilitado" : "desabilitado";
        ImageIcon imagen = this.subir;
        Vehiculo Vehiculo = new Vehiculo(tipo,serie,asientos,modelo,año,disponibilidad,imagen);
        return Vehiculo;
    }
    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    public void guardarVehiculo() {
        Vehiculo vehiculo = this.leerComponentes();
        this.gestor.insertar(vehiculo);
        this.ventanaMsg("Datos guardados con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
    }

    class ClickBotonGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            guardarVehiculo();
        }
    }

    class clickBotonsubir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            subirImagen();
        }
    }
}
