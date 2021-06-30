package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipalAdministrador extends JFrame {
    private JButton bConsultar, bEliminar,bReguistrar,bEditar;
    private Container contenedor;
    private JPanel panelBotones,panelImg,panelSaludo;
    private JLabel lImg,lSaludo;


    public VentanaPrincipalAdministrador() {
        this.setTitle("Menu administrador");
        this.setSize(300, 400);
        this.iniciarComponentes();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.contenedor.setBackground(Color.WHITE);
        this.iniciarLogo();
        this.iniciarBotonesAdministrador();

    }

    private void iniciarLogo(){
        this.panelImg = new JPanel();
        this.panelImg.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.panelImg.setBackground(Color.WHITE);
        this.lImg = new JLabel();
        this.lImg.setIcon(new ImageIcon("src/view/imagenes/bus-travel-logo-template-260nw-1179704353.jpg"));
        this.panelImg.add(this.lImg);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(this.panelImg, BorderLayout.NORTH);
    }


    public void iniciarBotonesAdministrador() {
        this.panelBotones = new JPanel();
        this.panelSaludo = new JPanel();
        this.panelSaludo.setLayout(new FlowLayout());
        this.panelSaludo.setBackground(Color.white);
        this.panelBotones.setLayout(new GridLayout(6,1, 5,5));
        this.panelBotones.setBackground(Color.WHITE);
        this.lSaludo = new JLabel("Bienvenido Usuario por favor eliga una opcion");
        this.panelSaludo.add(lSaludo);
        this.bConsultar = new JButton("Consultar");
        this.bConsultar.addActionListener(new ClickBotonBuscar());
        this.bConsultar.setEnabled(true);
        this.bEliminar = new JButton("Eliminar");
        this.bEliminar.addActionListener(new ClickBotonEliminar());
        this.bEliminar.setEnabled(true);
        this.bReguistrar = new JButton("Registrar");
        this.bReguistrar.addActionListener(new ClickBotonRegistrarVehiculo());
        this.bReguistrar.setEnabled(true);



        panelBotones.add(panelSaludo);
        panelBotones.add(bConsultar);
        panelBotones.add(bEliminar);
        panelBotones.add(bReguistrar);


        this.contenedor.add(this.panelBotones, BorderLayout.CENTER);

    }


    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    class ClickBotonRegistrarVehiculo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            new VentanaRegistrarVehiculo(null,true);
        }
    }

    class ClickBotonEliminar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            new VentanEliminarVehiculo(null,true);
        }
    }

    class ClickBotonBuscar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            new VentanaConsultarVehiculo(null,true);
        }
    }



}
