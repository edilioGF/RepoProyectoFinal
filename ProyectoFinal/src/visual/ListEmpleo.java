package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Controladora;
import logico.Empleo;
import logico.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;

public class ListEmpleo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;
	private JComboBox cbxAreas;


	/**
	 * Create the dialog.
	 */
	public ListEmpleo() {
		setTitle("Listado de Empleos");
		setBounds(100, 100, 584, 407);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 57, 548, 267);
		contentPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] columns = { "Código", "Título", "Vacantes", "Salario" , "Nombre Empresa" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		scrollPane.setViewportView(table);
		
		JLabel lblArea = new JLabel("\u00C1rea:");
		lblArea.setBounds(10, 21, 46, 14);
		contentPanel.add(lblArea);
		
		cbxAreas = new JComboBox();
		cbxAreas.setModel(new DefaultComboBoxModel(new String[] {"<Todas>"}));
		cbxAreas.setBounds(55, 17, 287, 23);
		contentPanel.add(cbxAreas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton_1 = new JButton("Solicitar");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				buttonPane.add(btnNewButton_1);
			}
			{
				JButton btnNewButton = new JButton("Detalles");
				buttonPane.add(btnNewButton);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		load();
		loadTable(cbxAreas.getSelectedItem().toString());
	}
	private void load() {
		for (String area : Controladora.getMisTiposDeEmpresa()) {
			cbxAreas.addItem(area);
		}
	}

	private void loadTable(String tipo) {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Empleo empleo : Controladora.getInstance().getMisEmpleos()) {
			if (tipo.equalsIgnoreCase("<Todos>") || tipo.equalsIgnoreCase(empleo.getArea())) {
				fila[0] = empleo.getCodigo();
				fila[1] = empleo.getTitulo();
				fila[2] = empleo.getVacantes();
				fila[3] = empleo.getSalario();
				fila[4] = empleo.getEmpresa().getNombre();

				model.addRow(fila);
			}
		}

		table.setModel(model);
	}
}
