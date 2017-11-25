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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;

	private JComboBox cbxTipo;

	public ListEmpresa() {
		setResizable(false);
		setTitle("Listado de Empresas");
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 49, 678, 350);
		contentPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] columns = { "Código", "Nombre", "Ubicación", "Tipo" };
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
		cbxTipo.setBounds(80, 17, 250, 23);
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
				fila[0] = empresa.getCodigo();
				fila[1] = empresa.getNombre();
				fila[2] = empresa.getUbicacion();
				fila[3] = empresa.getTipo();

				model.addRow(fila);
			}
		}

		table.setModel(model);
	}
}
