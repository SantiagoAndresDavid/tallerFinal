package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipalInvitado extends JFrame  {
    private JButton bConsultar, bReguistrar;
    private Container contenedor;
    private JPanel panelBotones,panelImg,panelFrase;
    private JLabel lImg,lSaludo;


    public VentanaPrincipalInvitado() {
        this.setTitle("Menu Invitado");
        this.setSize(300, 400);
        this.inicializarBotonoesInvitado();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void inicializarBotonoesInvitado() {
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
        this.panelFrase = new JPanel();
        panelFrase.setLayout(new FlowLayout());
        panelFrase.setBackground(Color.WHITE);
        this.panelBotones.setLayout(new GridLayout(6,1, 5,5));
        this.panelBotones.setBackground(Color.WHITE);
        this.lSaludo = new JLabel("Bienvenido Usuario por favor eliga una opcion");
        this.panelFrase.add(lSaludo);
        this.bConsultar = new JButton("Consulta");
        this.bConsultar.addActionListener(new ClickBotonBuscar());
        this.bConsultar.setEnabled(true);
        this.bReguistrar = new JButton("Registrar");
        this.bReguistrar.addActionListener(new ClickBotonRegistrarVehiculo());
        this.bReguistrar.setEnabled(true);

        panelBotones.add(panelFrase);
        panelBotones.add(bConsultar);
        panelBotones.add(bReguistrar);

        this.contenedor.add(this.panelBotones, BorderLayout.CENTER);

    }

    class ClickBotonRegistrarVehiculo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            new VentanaRegistrarVehiculo(null,true);
        }
    }

    class ClickBotonBuscar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            new VentanaConsultarVehiculo(null,true);
        }
    }

}
