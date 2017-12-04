package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import logico.Controladora;
import logico.Empresa;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;
	private JComboBox cbxTipo;
	private Empresa empresaList;
	private JButton btnEliminar;
	private JButton btnModificar;

	public ListEmpresa() {
		setResizable(false);
		setTitle("Listado de Empresas");
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 49, 972, 474);
		contentPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					btnEliminar.setEnabled(true);
					btnModificar.setEnabled(true);
					int index = table.getSelectedRow();
					String rnc = table.getModel().getValueAt(index, 0).toString();
					empresaList = Controladora.getInstance().buscarEmpresa(rnc);
				}
			}
		});
		table.setDefaultEditor(Object.class, null);
		;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] columns = { "RNC", "Nombre", "Ubicación", "Tipo" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);

		scrollPane.setViewportView(table);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(12, 22, 50, 15);
		contentPanel.add(lblTipo);

		cbxTipo = new JComboBox();
		cbxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadTable(cbxTipo.getSelectedItem().toString());
			}
		});
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] { "<Todos>" }));
		cbxTipo.setBounds(72, 18, 250, 23);
		contentPanel.add(cbxTipo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

			btnEliminar = new JButton("Eliminar");
			btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int op = JOptionPane.showConfirmDialog(null,
							"¿Desea eliminar esta empresa? Se eliminarán también sus empleos", "Aviso",
							JOptionPane.OK_CANCEL_OPTION);
					if (op == JOptionPane.OK_OPTION) {
						Controladora.getInstance().eliminarEmpleosEmpresa(empresaList);
						Controladora.getInstance().getMisEmpresas().remove(empresaList);
						// Se necesitan eliminar los empleos de esyta empresa
						loadTable("<Todos>");
						JOptionPane.showMessageDialog(null, "Se ha eliminado esta empresa y sus empleos", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}

					Principal.loadStats();
				}
			});
			
			btnModificar = new JButton("Modificar");
			btnModificar.setEnabled(false);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			buttonPane.add(btnModificar);
			buttonPane.add(btnEliminar);
			buttonPane.add(btnCerrar);
		}

		load();
		loadTable(cbxTipo.getSelectedItem().toString());
	}

	private void load() {
		for (String tipo : Controladora.getMisTiposDeEmpresa()) {
			cbxTipo.addItem(tipo);
		}
	}

	private void loadTable(String tipo) {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Empresa empresa : Controladora.getInstance().getMisEmpresas()) {
			if (tipo.equalsIgnoreCase("<Todos>") || tipo.equalsIgnoreCase(empresa.getTipo())) {
				fila[0] = empresa.getRnc();
				fila[1] = empresa.getNombre();
				fila[2] = empresa.getUbicacion();
				fila[3] = empresa.getTipo();

				model.addRow(fila);
			}
		}

		table.setModel(model);
	}
}
