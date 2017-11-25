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

public class ListEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;

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
		panel.setBounds(10, 60, 664, 307);
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
		loadTable();

		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
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
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Empresa empresa : Controladora.getInstance().getMisEmpresas()) {
			fila[0] = empresa.getCodigo();
			fila[1] = empresa.getNombre();
			fila[2] = empresa.getUbicacion();
			fila[3] = empresa.getTipo();

			model.addRow(fila);
		}

		table.setModel(model);
	}
}
