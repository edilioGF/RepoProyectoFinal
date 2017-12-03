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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.border.EtchedBorder;

public class ListEmpleo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;
	private String codigo;
	private Empleo empleo;
	private JComboBox cbxFormacion;
	private JComboBox cbxAreas;
	private JButton btnGuardar;
	private JButton btnEliminar;

	/**
	 * Create the dialog.
	 */
	public ListEmpleo(Solicitante solicitante) {
		setResizable(false);
		setTitle("Listado de Empleos");
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 45, 974, 482);
		contentPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					btnGuardar.setEnabled(true);
					btnEliminar.setEnabled(true);
					int index = table.getSelectedRow();
					String codigo = table.getModel().getValueAt(index, 0).toString();
					empleo = Controladora.getInstance().buscarEmpleo(codigo);
				}
			}
		});
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] columns = { "Código", "Título", "Salario", "Nombre Empresa", "Idioma", "Año de Experiencia", "Horario",
				"Vacantes" };
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
				if (cbxFormacion.getSelectedItem().toString().equalsIgnoreCase("Técnico")) {
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
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});

				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							BufferedWriter writer = new BufferedWriter(new FileWriter(empleo.getCodigo() + ".txt"));
							writer.write("Fecha: " + empleo.getFecha());
							writer.newLine();
							writer.write("Código: " + empleo.getCodigo());
							writer.newLine();
							writer.write("Pertenece a: " + empleo.getEmpresa().getRnc() + " - "
									+ empleo.getEmpresa().getNombre());
							writer.newLine();
							writer.newLine();
							writer.write("Estado: ");
							if (empleo.isSatisfecho()) {
								writer.write("Satisfecho");
							} else {
								writer.write("No satisfecho");
							}
							writer.newLine();
							writer.write("Idioma: " + empleo.getIdioma());
							writer.newLine();
							writer.write("Empleo para: ");

							if (empleo.isGraduado()) {
								writer.write("Graduado");
								writer.newLine();
								writer.write("Área de Estudio: " + empleo.getArea());
							} else if (empleo.isTecnico()) {
								writer.write("Técnico");
								writer.newLine();
								writer.write("Título: " + empleo.getTituloTecnico());
							} else {
								writer.write("Obrero");
								writer.newLine();
								writer.write("Habilidad: " + empleo.getHabilidad());
							}
							writer.newLine();
							writer.write("Experienca: " + empleo.getExperiencia());
							writer.newLine();
							writer.write("Vacantes: " + empleo.getVacantes());
							writer.newLine();
							if (empleo.isLicencia()) {
								writer.write("Licencia: " + "Sí");
							} else {
								writer.write("Licencia: " + "No");
							}
							writer.newLine();
							if (empleo.isRemoto()) {
								writer.write("Remoto: " + "Sí");
							} else {
								writer.write("Remoto: " + "No");
							}
							writer.newLine();
							writer.write("Empleados: " + empleo.getEmpleados().size());

							writer.newLine();
							writer.newLine();
							for (Solicitante empleado : empleo.getEmpleados()) {
								writer.write(empleado.getCedula() + " - " + empleado.getNombre() + " "
										+ empleado.getApellidos());
								writer.newLine();
							}
							writer.close();

							JOptionPane.showMessageDialog(null,
									"Se ha guardado un archivo con la información de este empleo", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (Controladora.getInstance().buscarEmpresa(empleo.getEmpresa().getRnc()).getMisEmpleos()
								.size() == 1) {
							JOptionPane.showMessageDialog(null, "La Empresa debe tener al menos 1 empleo", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}

						int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este empleo?", "Aviso",
								JOptionPane.OK_CANCEL_OPTION);
						if (op == JOptionPane.OK_OPTION) {
							Controladora.getInstance().getMisEmpleos().remove(empleo);
							loadTable("<Todas>", "");
							JOptionPane.showMessageDialog(null, "Se ha eliminado este empleo", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
						}
						
						Principal.loadStats();
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
				btnGuardar.setEnabled(false);
				buttonPane.add(btnGuardar);
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
				fila[2] = empleo.getSalario();
				fila[3] = empleo.getEmpresa().getNombre();
				fila[4] = empleo.getIdioma();
				fila[5] = empleo.getExperiencia();
				fila[6] = empleo.getHoraInicial() + "-" + empleo.getHoraFinal();
				fila[7] = empleo.getVacantes();

				model.addRow(fila);
			} else if (p1.equalsIgnoreCase("Graduado") && empleo.isGraduado() && (p2.equalsIgnoreCase("<Todas>"))
					|| p2.equalsIgnoreCase(empleo.getArea())) {
				fila[0] = empleo.getCodigo();
				fila[1] = empleo.getTitulo();
				fila[2] = empleo.getSalario();
				fila[3] = empleo.getEmpresa().getNombre();
				fila[4] = empleo.getIdioma();
				fila[5] = empleo.getExperiencia();
				fila[6] = empleo.getHoraInicial() + "-" + empleo.getHoraFinal();
				fila[7] = empleo.getVacantes();

				model.addRow(fila);
			} else if (p1.equalsIgnoreCase("Técnico") && empleo.isTecnico() && (p2.equalsIgnoreCase("<Todas>"))
					|| p2.equalsIgnoreCase(empleo.getTitulo())) {
				fila[0] = empleo.getCodigo();
				fila[1] = empleo.getTitulo();
				fila[2] = empleo.getSalario();
				fila[3] = empleo.getEmpresa().getNombre();
				fila[4] = empleo.getIdioma();
				fila[5] = empleo.getExperiencia();
				fila[6] = empleo.getHoraInicial() + "-" + empleo.getHoraFinal();
				fila[7] = empleo.getVacantes();

				model.addRow(fila);
			} else if (p1.equalsIgnoreCase("Obrero") && empleo.isObrero() && (p2.equalsIgnoreCase("<Todas>"))
					|| p2.equalsIgnoreCase(empleo.getHabilidad())) {
				fila[0] = empleo.getCodigo();
				fila[1] = empleo.getTitulo();
				fila[2] = empleo.getSalario();
				fila[3] = empleo.getEmpresa().getNombre();
				fila[4] = empleo.getIdioma();
				fila[5] = empleo.getExperiencia();
				fila[6] = empleo.getHoraInicial() + "-" + empleo.getHoraFinal();
				fila[7] = empleo.getVacantes();

				model.addRow(fila);
			}
		}

		table.setModel(model);
	}
}
