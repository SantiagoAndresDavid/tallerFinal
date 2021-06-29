package view;

import dominio.Vehiculo;
import negocio.RegistroVehiculos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaConsultarVehiculo extends JDialog {
    private Container contenedor;
    private JPanel panelFiltro;
    private JScrollPane panelResultado;
    private JLabel lFiltro;
    private JTextField tFiltro;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton bBuscar;
    private String titulos[] = {"Tipo", "Numero de serie", "Numero de puertas", "modelo", "año"};
    RegistroVehiculos gestor;


    public VentanaConsultarVehiculo(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestor = new RegistroVehiculos();
        this.setTitle("Consulta de vehiculo");
        this.iniciarComponentes();
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void activarComponentes() {
        this.bBuscar.setEnabled(true);
    }

    public void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.actualizarTabla();
        this.activarComponentes();
    }

    public void iniciarPanelFiltro() {
        this.lFiltro = new JLabel("Ingrese el numero de serie: ");
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.tFiltro = new JTextField(10);
        this.bBuscar = new JButton("Buscar");
        this.bBuscar.addActionListener(new ClickBotonGuardar());

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
            if (vehiculo.getDisponibilidad().equalsIgnoreCase("habilitado")) {
                String linea[] = {vehiculo.getTipo(), vehiculo.getnSerie(), vehiculo.getnAsientos(), vehiculo.getModelo(),
                        vehiculo.getAño()};
                this.modelo.addRow(linea);
            }
        }
    }

    public void buscar() {
        try {
            String filtro = this.tFiltro.getText();
            new VentanaPresentarVehiculo(null, true, filtro);
        } catch (NumberFormatException e) {
            this.ventanaMsg(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    class ClickBotonGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            buscar();
        }

    }
}
