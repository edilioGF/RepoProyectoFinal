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
import logico.Graduado;
import logico.Solicitante;
import logico.Tecnico;

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
	private JComboBox cbxFormacion;
	private JComboBox cbxAreas;

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

				int index = table.getSelectedRow();
				codigo = (String) table.getModel().getValueAt(index, 0);
				empleo = Controladora.getInstance().buscarEmpleo(codigo);
			}
		});
		table.setDefaultEditor(Object.class, null);
		;
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] columns = { "C�digo", "T�tulo", "Vacantes", "Salario", "Nombre Empresa" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		scrollPane.setViewportView(table);

		JLabel lblreas = new JLabel("\u00C1reas:");
		lblreas.setBounds(340, 20, 56, 14);
		contentPanel.add(lblreas);

		cbxAreas = new JComboBox();
		cbxAreas.setEnabled(false);
		cbxAreas.setModel(new DefaultComboBoxModel(new String[] { "<Todas>" }));
		cbxAreas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbxAreas.getSelectedIndex() >= 0) {
					loadTable(cbxFormacion.getSelectedItem().toString(), cbxAreas.getSelectedItem().toString());
				}
			}
		});
		cbxAreas.setBounds(390, 16, 210, 23);
		contentPanel.add(cbxAreas);

		JLabel lblNewLabel = new JLabel("Formaci\u00F3n Requerida:");
		lblNewLabel.setBounds(10, 20, 140, 14);
		contentPanel.add(lblNewLabel);

		cbxFormacion = new JComboBox();
		cbxFormacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbxFormacion.getSelectedItem().toString().equalsIgnoreCase("<Todas>")) {
					cbxAreas.setEnabled(false);
					cbxAreas.removeAllItems();

					loadTable("<Todas>", "");
				}
				if (cbxFormacion.getSelectedItem().toString().equalsIgnoreCase("Graduado")) {
					loadGraduado();
					loadTable(cbxFormacion.getSelectedItem().toString(), cbxAreas.getSelectedItem().toString());
				}
				if (cbxFormacion.getSelectedItem().toString().equalsIgnoreCase("T�cnico")) {
					loadTecnico();
					loadTable(cbxFormacion.getSelectedItem().toString(), cbxAreas.getSelectedItem().toString());
				}
				if (cbxFormacion.getSelectedItem().toString().equalsIgnoreCase("Obrero")) {
					loadObrero();
					loadTable(cbxFormacion.getSelectedItem().toString(), cbxAreas.getSelectedItem().toString());
				}

			}
		});
		cbxFormacion
				.setModel(new DefaultComboBoxModel(new String[] { "<Todas>", "Graduado", "T\u00E9cnico", "Obrero" }));
		cbxFormacion.setBounds(150, 16, 160, 23);
		contentPanel.add(cbxFormacion);
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
		loadTable("<Todas>", "");
	}

	private void loadGraduado() {
		cbxAreas.removeAllItems();
		cbxAreas.addItem("<Todas>");
		for (String c : Controladora.getMisAreasDeEstudio()) {
			cbxAreas.addItem(c);
		}
		cbxAreas.setEnabled(true);
	}

	private void loadTecnico() {
		cbxAreas.removeAllItems();
		cbxAreas.addItem("<Todas>");
		for (String c : Controladora.getMisTitulos()) {
			cbxAreas.addItem(c);
		}
		cbxAreas.setEnabled(true);

	}

	private void loadObrero() {
		cbxAreas.removeAllItems();
		cbxAreas.addItem("<Todas>");
		for (String c : Controladora.getMisHabilidades()) {
			cbxAreas.addItem(c);
		}
		cbxAreas.setEnabled(true);
	}

	private void loadTable(String p1, String p2) {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Empleo empleo : Controladora.getInstance().getMisEmpleos()) {
			if (p1.equalsIgnoreCase("<Todas>")) {
				fila[0] = empleo.getCodigo();
				fila[1] = empleo.getTitulo();
				fila[2] = empleo.getVacantes();
				fila[3] = empleo.getSalario();
				fila[4] = empleo.getEmpresa().getNombre();

				model.addRow(fila);
			} else if (p1.equalsIgnoreCase("Graduado") && empleo.isGraduado() && (p2.equalsIgnoreCase("<Todas>"))
					|| p2.equalsIgnoreCase(empleo.getArea())) {
				fila[0] = empleo.getCodigo();
				fila[1] = empleo.getTitulo();
				fila[2] = empleo.getVacantes();
				fila[3] = empleo.getSalario();
				fila[4] = empleo.getEmpresa().getNombre();

				model.addRow(fila);
			} else if (p1.equalsIgnoreCase("T�cnico") && empleo.isTecnico() && (p2.equalsIgnoreCase("<Todas>"))
					|| p2.equalsIgnoreCase(empleo.getTitulo())) {
				fila[0] = empleo.getCodigo();
				fila[1] = empleo.getTitulo();
				fila[2] = empleo.getVacantes();
				fila[3] = empleo.getSalario();
				fila[4] = empleo.getEmpresa().getNombre();

				model.addRow(fila);
			} else if (p1.equalsIgnoreCase("Obrero") && empleo.isObrero() && (p2.equalsIgnoreCase("<Todas>"))
					|| p2.equalsIgnoreCase(empleo.getHabilidad())) {
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
