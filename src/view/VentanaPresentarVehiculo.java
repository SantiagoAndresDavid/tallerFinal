package view;

import dominio.Vehiculo;
import negocio.RegistroVehiculos;

import javax.swing.*;
import java.awt.*;

public class VentanaPresentarVehiculo extends JDialog {
    private JLabel lTipo, lnSerie, lnAsientos, lModelo, lAño, lDisponibilidad, lImg, tTipo, tnSerie, tnAsientos, tModelo, tAño, tDiponibilidad;
    private JPanel panelDatos,panelInfo;
    private JPanel panelImg;
    private Container Contenedor;
    private RegistroVehiculos gestor;

    public VentanaPresentarVehiculo(JFrame frame, boolean bln, String filtro) {
        super(frame, bln);
        this.setSize(500, 500);
        this.gestor = new RegistroVehiculos();
        this.setTitle("Mostrar");
        Vehiculo vehiculo = this.gestor.buscarPor(filtro);
        iniciarComponentes(vehiculo);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void iniciarComponentes(Vehiculo vehiculo) {
        this.Contenedor = this.getContentPane();
        this.Contenedor.setLayout(new BorderLayout());
        this.Contenedor.setBackground(Color.WHITE);
        iniciarPanelDatos(vehiculo);
    }
    public void iniciarPanelDatos(Vehiculo vehiculo) {
        this.panelDatos = new JPanel();
        this.panelImg = new JPanel();
        this.panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.panelInfo.setBackground(Color.WHITE);
        this.panelDatos.setLayout(new GridLayout(7, 2, 10, 10));

        this.lTipo = new JLabel("Tipo: ");
        this.lnSerie = new JLabel("numero Serie: ");
        this.lAño = new JLabel("Año: ");
        this.lnAsientos = new JLabel("Numero de Asientos: ");
        this.lModelo = new JLabel("Modelo: ");
        this.lAño = new JLabel("Año: ");
        this.lDisponibilidad = new JLabel("Disponiblildad: ");
        this.lImg = new JLabel(vehiculo.getImageIcon());

        this.tTipo = new JLabel(vehiculo.getTipo());
        this.tnSerie = new JLabel(vehiculo.getnSerie());
        this.tnAsientos = new JLabel(vehiculo.getnAsientos());
        this.tModelo = new JLabel(vehiculo.getModelo());
        this.tAño = new JLabel(vehiculo.getAño());
        this.tDiponibilidad = new JLabel(vehiculo.getDisponibilidad());


        this.panelDatos.add(this.lTipo);
        this.panelDatos.add(this.tTipo);

        this.panelDatos.add(this.lnSerie);
        this.panelDatos.add(this.tnSerie);

        this.panelDatos.add(this.lnAsientos);
        this.panelDatos.add(this.tnAsientos);

        this.panelDatos.add(this.lModelo);
        this.panelDatos.add(this.tModelo);

        this.panelDatos.add(this.lAño);
        this.panelDatos.add(this.tAño);

        this.panelDatos.add(this.lDisponibilidad);
        this.panelDatos.add(this.tDiponibilidad);



        panelDatos.setBackground(Color.WHITE);
        panelInfo.add(panelDatos);

        this.panelImg.add(lImg);
        panelImg.setBackground(Color.WHITE);

        this.Contenedor.add(this.panelInfo, BorderLayout.NORTH);
        this.Contenedor.add(this.panelImg, BorderLayout.EAST);
    }



}
