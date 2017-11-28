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
import logico.Solicitante;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListEmpleo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;
	private JButton btnDetalles;
	private String codigo;
	private Empleo empleo;

	/**
	 * Create the dialog.
	 */
	public ListEmpleo(Solicitante solicitante) {
		setTitle("Listado de Empleos");
		setBounds(100, 100, 700, 454);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 45, 664, 322);
		contentPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnDetalles.setEnabled(true);
				// btnSolicitar.setEnabled(true);

				int index = table.getSelectedRow();
				codigo = (String) table.getModel().getValueAt(index, 0);
				// empleo = Controladora.getInstance().buscarEmpleo(codigo);
			}
		});
		table.setDefaultEditor(Object.class, null);
		;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] columns = { "Título", "Vacantes", "Salario", "Nombre Empresa" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		scrollPane.setViewportView(table);

		JLabel lblreas = new JLabel("\u00C1reas:");
		lblreas.setBounds(28, 20, 90, 14);
		contentPanel.add(lblreas);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(102, 14, 28, 20);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnDetalles = new JButton("Detalles");
				btnDetalles.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DetallesEmpleo dtEmp = new DetallesEmpleo(empleo);
						setModal(false);
						dtEmp.setModal(true);
						dtEmp.setVisible(true);
					}
				});
				btnDetalles.setEnabled(false);
				buttonPane.add(btnDetalles);
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
		loadTable();
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Empleo empleo : Controladora.getInstance().getMisEmpleos()) {
			// if (tipo.equalsIgnoreCase("<Todas>") ||
			// tipo.equalsIgnoreCase(empleo.getArea())) {
			// fila[0] = empleo.getCodigo();
			fila[0] = empleo.getTitulo();
			fila[1] = empleo.getVacantes();
			fila[2] = empleo.getSalario();
			fila[3] = empleo.getEmpresa().getNombre();

			model.addRow(fila);
			// }
		}

		table.setModel(model);
	}
}
