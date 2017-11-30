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
import logico.Graduado;
import logico.Obrero;
import logico.Perfil;
import logico.Tecnico;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListPerfil extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;
	private JTextField txtCedula;
	private JComboBox cbxFormacion;
	private Perfil perfil;

	public ListPerfil() {
		setResizable(false);
		setTitle("Listado de Perfiles");
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 60, 674, 317);
			contentPanel.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if (table.getSelectedRow() >= 0) {
								int index = table.getSelectedRow();
								String codigo = table.getModel().getValueAt(index, 0).toString();
							}
						}
					});
					table.setDefaultEditor(Object.class, null);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					model = new DefaultTableModel();
					String[] columns = { "C�digo", "C�dula - Nombre", "Formaci�n", "Experiencia", "Licencia",
							"movilidad geogr�fica" };
					model.setColumnIdentifiers(columns);
					scrollPane.setViewportView(table);
				}
			}
		}

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(314, 24, 46, 14);
		contentPanel.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setBounds(370, 20, 180, 23);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cedula = txtCedula.getText();
				loadTable(cbxFormacion.getSelectedItem().toString(), cedula);
			}
		});
		btnNewButton.setBounds(560, 20, 89, 23);
		contentPanel.add(btnNewButton);

		JLabel lblFormacin = new JLabel("Formaci\u00F3n:");
		lblFormacin.setBounds(10, 24, 67, 14);
		contentPanel.add(lblFormacin);

		cbxFormacion = new JComboBox();
		cbxFormacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cedula = txtCedula.getText();
				loadTable(cbxFormacion.getSelectedItem().toString(), cedula);
			}
		});
		cbxFormacion.setModel(
				new DefaultComboBoxModel(new String[] { "<Todos>", "Graduados", "T\u00E9cnicos", "Obreros" }));
		cbxFormacion.setBounds(87, 20, 180, 23);
		contentPanel.add(cbxFormacion);
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

			JButton btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter(perfil.getCodigo()));
						writer.write(perfil.getFecha());
						writer.newLine();
						writer.write("Código: " + perfil.getCodigo());
						writer.newLine();
						writer.write("Pertenece a: " + perfil.getSolicitante().getCedula() + " - "
								+ perfil.getSolicitante().getNombre() + " " + perfil.getSolicitante().getApellidos());
						writer.newLine();
						writer.close();

						JOptionPane.showMessageDialog(null, "Se ha guardado un archivo con los datos de este perfil",
								"Aviso", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnGuardar.setEnabled(false);
			buttonPane.add(btnGuardar);
			buttonPane.add(btnCerrar);
		}

		loadTable(cbxFormacion.getSelectedItem().toString(), "");
	}

	private void loadTable(String formacion, String cedula) {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Perfil perfil : Controladora.getInstance().getMisPerfiles()) {

			if (perfil instanceof Graduado
					&& (formacion.equalsIgnoreCase("Graduados") || formacion.equalsIgnoreCase("<Todos>"))) {

				if (cedula.equalsIgnoreCase("") || cedula.equalsIgnoreCase(perfil.getSolicitante().getCedula())) {
					fila[0] = perfil.getCodigo();
					fila[1] = perfil.getSolicitante().getCedula() + " - " + perfil.getSolicitante().getNombre() + " "
							+ perfil.getSolicitante().getApellidos();
					fila[2] = "Graduado";
					fila[3] = perfil.getExperiencia();
					fila[4] = (perfil.isLicencia()) ? "Si" : "No";
					fila[5] = (perfil.isMudarse()) ? "Si" : "No";

					model.addRow(fila);
				}
			}

			if (perfil instanceof Tecnico
					&& (formacion.equalsIgnoreCase("T�cnicos") || formacion.equalsIgnoreCase("<Todos>"))) {
				if (cedula.equalsIgnoreCase("") || cedula.equalsIgnoreCase(perfil.getSolicitante().getCedula())) {
					fila[0] = perfil.getCodigo();
					fila[1] = perfil.getSolicitante().getCedula() + " - " + perfil.getSolicitante().getNombre() + " "
							+ perfil.getSolicitante().getApellidos();
					fila[2] = "T�cnico";
					fila[3] = perfil.getExperiencia();
					fila[4] = (perfil.isLicencia()) ? "Si" : "No";
					fila[5] = (perfil.isMudarse()) ? "Si" : "No";

					model.addRow(fila);
				}
			}

			if (perfil instanceof Obrero
					&& (formacion.equalsIgnoreCase("Obreros") || formacion.equalsIgnoreCase("<Todos>"))) {
				if (cedula.equalsIgnoreCase("") || cedula.equalsIgnoreCase(perfil.getSolicitante().getCedula())) {
					fila[0] = perfil.getCodigo();
					fila[1] = perfil.getSolicitante().getCedula() + " - " + perfil.getSolicitante().getNombre() + " "
							+ perfil.getSolicitante().getApellidos();
					fila[2] = "Obrero";
					fila[3] = perfil.getExperiencia();
					fila[4] = (perfil.isLicencia()) ? "Si" : "No";
					fila[5] = (perfil.isMudarse()) ? "Si" : "No";

					model.addRow(fila);
				}
			}
		}

		table.setModel(model);
	}
}
