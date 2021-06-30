package view;

import Exepciones.ExcepcionAcessoDatos;
import dominio.Usuario;
import negocio.RegistroUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaRegistroUsuario extends JDialog {
    private JTextField tusuario,tContraseña;
    private JLabel lUsuario,lcontraseña,lTipo;
    private JButton bregistrar;
    private JPanel panelDatos;
    private JRadioButton rInvitado,rAdmin;
    private ButtonGroup grupoRadio;
    private Container contenedor;
    private RegistroUsuarios gestion;

    public VentanaRegistroUsuario(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestion = new RegistroUsuarios();
        this.setTitle("Iniciar Sesion - V1");
        this.setSize(300, 300);
        this.iniciarComponentes();
        //this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.iniciarPanelDatos();
    }

    public void iniciarPanelDatos() {
        this.panelDatos = new JPanel();
        this.panelDatos.setLayout(new GridLayout(9, 1, 5, 5));


        this.lUsuario = new JLabel("Ingrese el Usuario: ");
        this.lcontraseña = new JLabel("Ingrese la contrasela: ");
        this.lTipo = new JLabel("Ingrese el Tipo De Usuario");

        this.rInvitado = new JRadioButton("Invitado");
        this.rInvitado.setSelected(true);
        this.rAdmin = new JRadioButton("Administrador");
        this.grupoRadio = new ButtonGroup();
        this.grupoRadio.add(this.rAdmin);
        this.grupoRadio.add(this.rInvitado);


        this.tusuario = new JTextField(null);
        this.tContraseña = new JTextField(null);

        this.bregistrar = new JButton("Registrar");
        this.bregistrar.addActionListener(new ClickBotonRegistrar());
        this.bregistrar.setEnabled(true);



        this.panelDatos.add(this.lUsuario);
        this.panelDatos.add(this.tusuario);

        this.panelDatos.add(this.lcontraseña);
        this.panelDatos.add(this.tContraseña);

        this.panelDatos.add(this.lTipo);
        this.panelDatos.add(this.rAdmin);
        this.panelDatos.add(this.rInvitado);

        this.panelDatos.add(this.bregistrar);

        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);
    }

    public boolean insertar() {
        try {
            String nombre = this.tusuario.getText();
            String contraseña = this.tContraseña.getText();
            String tipo = this.rAdmin.isSelected()?"Administrador":"Invitado";
            Usuario usuario = new Usuario(nombre,contraseña,tipo);
            gestion.insertar(usuario);
            this.ventanaMsg("Datos guardados con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (ExcepcionAcessoDatos excepcionAcessoDatos) {
            excepcionAcessoDatos.printStackTrace();
        }
        return false;
    }

    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    class ClickBotonRegistrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            insertar();
        }
    }


}
