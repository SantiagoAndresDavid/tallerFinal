package view;

import dominio.Usuario;
import negocio.RegistroUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class VentanaIngresarUsuario extends JDialog {
    private JTextField tusuario, tContraseña;
    private JLabel lUsuario, lcontraseña, lImg;
    private JButton bIniciar, bregistrar;
    private JPanel panelDatos, panelImg;
    private Container contenedor;
    private RegistroUsuarios gestion;

    public VentanaIngresarUsuario(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestion = new RegistroUsuarios();
        this.setTitle("Iniciar Sesion - V1");
        this.setSize(500, 500);
        this.iniciarComponentes();
        //this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.contenedor.setBackground(Color.WHITE);
        this.iniciarLogo();
        this.iniciarPanelDatos();

    }

    private void iniciarLogo() {
        this.panelImg = new JPanel();
        this.panelImg.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.panelImg.setBackground(Color.WHITE);
        this.lImg = new JLabel();
        this.lImg.setIcon(new ImageIcon("src/view/imagenes/bus-travel-logo-template-260nw-1179704353.jpg"));
        this.panelImg.add(this.lImg);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(this.panelImg, BorderLayout.NORTH);
    }

    public void iniciarPanelDatos() {
        this.panelDatos = new JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        ImageIcon iconUsuario = new ImageIcon("src/view/imagenes/agregar-usuario.png");
        ImageIcon iconContraseña = new ImageIcon("src/view/imagenes/candado.png");
        this.panelDatos.setLayout(new GridLayout(9, 2, 10, 10));

        this.lUsuario = new JLabel("Ingrese el Usuario: ");
        this.lcontraseña = new JLabel("Ingrese la contrasela: ");
        this.lUsuario.setIcon(iconUsuario);
        this.lcontraseña.setIcon(iconContraseña);


        this.tusuario = new JTextField(null);
        this.tContraseña = new JPasswordField(null);

        this.bIniciar = new JButton("Iniciar");
        this.bIniciar.addActionListener(new ClickBotonIniciar());
        this.bIniciar.setEnabled(true);
        this.bregistrar = new JButton("Registrar");
        this.bregistrar.addActionListener(new ClickBotonRegistrar());
        this.bregistrar.setEnabled(true);


        this.panelDatos.add(this.lUsuario);
        this.panelDatos.add(this.tusuario);

        this.panelDatos.add(this.lcontraseña);
        this.panelDatos.add(this.tContraseña);

        this.panelDatos.add(this.bIniciar);
        this.panelDatos.add(this.bregistrar);
        this.panelDatos.setBackground(Color.WHITE);

        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);
    }

    public Usuario buscar() {
        String usuario = this.tusuario.getText();
        Usuario usuario1 = gestion.buscarPor(usuario);
        if(usuario1 == null){
            System.out.println("el usuario no existe");
        }
        return usuario1;
    }

    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    class ClickBotonIniciar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (buscar().getTipo().equals("Administrador")) {
                new VentanaPrincipalAdministrador();
            } else {
                new VentanaPrincipalInvitado();
            }
        }
    }

    public boolean registrar() {
        try {
            new VentanaRegistroUsuario(null, true);
        } catch (NumberFormatException e) {
            this.ventanaMsg(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }


    class ClickBotonRegistrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            registrar();
        }

    }

}
