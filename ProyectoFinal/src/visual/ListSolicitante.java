package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Controladora;
import logico.Empresa;
import logico.Solicitante;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListSolicitante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;
	private JTextField txtCedula;
	private JComboBox cbxGenero;
	private JButton btnDesactivarEmpleo;
	private JButton btnModificar;
	private Solicitante solicitante;
	private JButton btnEliminar;


	/**
	 * Create the dialog.
	 */
	public ListSolicitante() {
		setResizable(false);
		setTitle("Listado de Solicitantes");
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 47, 974, 480);
			contentPanel.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					table = new JTable();
					table.setDefaultEditor(Object.class, null);
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if (table.getSelectedRow() >= 0) {
								btnModificar.setEnabled(true);
								btnEliminar.setEnabled(true);
								int index = table.getSelectedRow();
								String cedula = (String) table.getModel().getValueAt(index, 0);
								solicitante = Controladora.getInstance().buscarSolicitante(cedula);
								
								if (solicitante.isTrabajo()) {
									btnDesactivarEmpleo.setEnabled(true);
								} else {
									btnDesactivarEmpleo.setEnabled(false);
								}

								
							}
						}
					});
					scrollPane.setViewportView(table);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

					JLabel lblFormacin = new JLabel("G\u00E9nero:");
					lblFormacin.setBounds(10, 20, 64, 14);
					contentPanel.add(lblFormacin);

					cbxGenero = new JComboBox();
					cbxGenero.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							loadTable(cbxGenero.getSelectedItem().toString(), txtCedula.getText());
						}
					});
					cbxGenero.setModel(new DefaultComboBoxModel(new String[] { "<Todos>" }));
					cbxGenero.setBounds(84, 16, 250, 23);
					contentPanel.add(cbxGenero);

					JLabel lblCedula = new JLabel("C\u00E9dula:");
					lblCedula.setBounds(364, 20, 55, 14);
					contentPanel.add(lblCedula);

					txtCedula = new JTextField();
					txtCedula.setBounds(417, 16, 145, 23);
					contentPanel.add(txtCedula);
					txtCedula.setColumns(10);

					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String cedula = txtCedula.getText();

							loadTable(cbxGenero.getSelectedItem().toString(), cedula);
						}
					});
					btnBuscar.setBounds(571, 16, 89, 23);
					contentPanel.add(btnBuscar);
					String[] columns = { "C�dula", "Nombre", "Nacimiento", "Pa�s de Origen", "Pa�s de Residencia",
							"G�nero", "Trabajo", "Perfiles" };
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columns);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});

				btnDesactivarEmpleo = new JButton("Desactivar Empleo");
				btnDesactivarEmpleo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int op = JOptionPane.showConfirmDialog(null, "�Desea desactivar el empleo a este solicitante?",
								"Aviso", JOptionPane.OK_CANCEL_OPTION);
						if (op == JOptionPane.OK_OPTION) {
							if (solicitante.getMisPerfiles().size() == 1) {
								JOptionPane.showConfirmDialog(null,
										"Ya que el solicitante tiene un solo perfil, se eliminar� del sistema. �Desea continuar?",
										"Aviso", JOptionPane.OK_CANCEL_OPTION);
								Controladora.getInstance().eliminarSolicitante(solicitante);
								JOptionPane.showMessageDialog(null, "Se ha eliminado este solicitante con su perfil",
										"Aviso", JOptionPane.INFORMATION_MESSAGE);
							} else {
								solicitante.desactivarEmpleo();
								Controladora.getInstance().retirarSolicitante(solicitante);
								JOptionPane.showMessageDialog(null, "Se ha desactivado el empleo", "Aviso",
										JOptionPane.INFORMATION_MESSAGE);
							}

							btnDesactivarEmpleo.setEnabled(false);
							loadTable("<Todos>", "");
						}
					}
				});
				btnDesactivarEmpleo.setEnabled(false);
				buttonPane.add(btnDesactivarEmpleo);

				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int option = JOptionPane.showConfirmDialog(null,
								"�Est�s seguro de que desea eliminar este solicitante? Se eliminar�n sus perfiles",
								"Aviso", JOptionPane.INFORMATION_MESSAGE);
						if (option == JOptionPane.OK_OPTION) {
							Controladora.getInstance().eliminarSolicitante(solicitante);
							loadTable("<Todos>", "");
							btnEliminar.setEnabled(false);
							JOptionPane.showMessageDialog(null, "Se elimin� el solicitante y sus perfiles", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
						}

						Principal.loadStats();

					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
				
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						RegSolicitante rgSolicitante = new RegSolicitante(solicitante);
						rgSolicitante.setModal(true);
						rgSolicitante.setVisible(true);
					}
				});
				buttonPane.add(btnModificar);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}

		}
		load();
		loadTable(cbxGenero.getSelectedItem().toString(), txtCedula.getText());
	}

	private void load() {
		for (String genero : Controladora.getMisGeneros()) {
			cbxGenero.addItem(genero);
		}
	}

	static void loadTable(String mode, String mode2) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		String trabajo;

		for (Solicitante soli : Controladora.getInstance().getMisSolicitantes()) {

			if ((mode.equalsIgnoreCase(soli.getGenero()) || mode.equalsIgnoreCase("<Todos>"))
					&& (mode2.equalsIgnoreCase(soli.getCedula()) || mode2.equalsIgnoreCase(""))) {
				fila[0] = soli.getCedula();
				fila[1] = soli.getNombre() + " " + soli.getApellidos();
				fila[2] = soli.getNacimiento();
				fila[3] = soli.getPaisOrigen();
				fila[4] = soli.getPaisResidencia();
				fila[5] = soli.getGenero();
				if (soli.isTrabajo() == false) {
					trabajo = "No";
					fila[6] = trabajo;
				} else {
					trabajo = "Si";
					fila[6] = trabajo;
				}
				fila[7] = soli.getMisPerfiles().size();

				model.addRow(fila);
			}
		}

		table.setModel(model);
	}
}
