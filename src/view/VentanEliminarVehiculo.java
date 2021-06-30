package view;

import dominio.Vehiculo;
import negocio.RegistroVehiculos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanEliminarVehiculo extends JDialog {
   private Container contenedor;
    private JPanel panelFiltro;
    private JScrollPane panelResultado;
    private JLabel lFiltro;
    private JTextField tFiltro;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton  bBuscar;
    private String titulos[]={"Tipo", "Numero de serie", "Numero de puertas", "modelo", "año","disponibilidad"};
    private RegistroVehiculos gestor;

    public VentanEliminarVehiculo(JFrame frame, boolean bln) {
        super(frame, bln);
        gestor = new RegistroVehiculos();
        this.setTitle("Ventana Eliminar ");
        this.iniciarComponentes();
        this.pack();
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());

        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.actualizarTabla();
    }

    public void iniciarPanelFiltro(){
        this.lFiltro = new JLabel("Ingrese el codigo: ");
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.tFiltro = new JTextField(10);
        this.bBuscar = new JButton("eliminar");
        this.bBuscar.addActionListener(new clickBotonEliminar());

        this.panelFiltro.add(this.lFiltro);
        this.panelFiltro.add(this.tFiltro);
        this.panelFiltro.add(this.bBuscar);

        this.contenedor.add(this.panelFiltro, BorderLayout.NORTH);
    }

    public void iniciarPanelResultado() {

        this.panelResultado = new JScrollPane();

        this.tabla = new JTable();
        this.modelo = new DefaultTableModel(null, this.titulos);
        this.tabla.setModel(modelo);
        this.panelResultado.setViewportView(this.tabla);

        this.contenedor.add(this.panelResultado, BorderLayout.CENTER);

    }


    public void actualizarTabla() {
        List<Vehiculo> listado = this.gestor.leer();
        this.modelo.setNumRows(0);
        for (Vehiculo vehiculo : listado) {
            String linea[] = {vehiculo.getTipo(),vehiculo.getAño(),vehiculo.getnAsientos(),vehiculo.getModelo(),
                    vehiculo.getAño(),vehiculo.getDisponibilidad()};
            this.modelo.addRow(linea);
        }

    }

    public void eliminar() {
        try {
            String filtro = this.tFiltro.getText();
            this.gestor.eliminar(filtro);
            this.ventanaMsg("Publicacion Eliminada con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException | NullPointerException nfe) {
            this.ventanaMsg(nfe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    class clickBotonEliminar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            eliminar();
        }

    }
}
