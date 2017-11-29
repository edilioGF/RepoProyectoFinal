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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class ListSolicitante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;
	private JTextField txtCedula;
	private JComboBox cbxGenero;

	/**
	 * Create the dialog.
	 */
	public ListSolicitante() {
		setTitle("Listado de Solicitantes");
		setBounds(100, 100, 685, 428);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 47, 650, 298);
			contentPanel.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					table = new JTable();
					scrollPane.setViewportView(table);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

					JLabel lblFormacin = new JLabel("G\u00E9nero:");
					lblFormacin.setBounds(10, 20, 64, 14);
					contentPanel.add(lblFormacin);

					cbxGenero = new JComboBox();
					cbxGenero.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							loadTable(cbxGenero.getSelectedItem().toString());
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

							loadTable(cedula);
						}
					});
					btnBuscar.setBounds(571, 16, 89, 23);
					contentPanel.add(btnBuscar);
					String[] columns = { "Cédula", "Nombre", "Fecha de Nacimiento", "País de Origen",
							"País de Residencia", "Género" , "Trabajo"  , "Cant.Perfiles" };
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columns);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}

		}
		load();
		loadTable(cbxGenero.getSelectedItem().toString());
	}

	private void load() {
		for (String genero : Controladora.getMisGeneros()) {
			cbxGenero.addItem(genero);
		}
	}

	private void loadTable(String mode) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		String trabajo;
		
		for (Solicitante soli : Controladora.getInstance().getMisSolicitantes()) {
			if (mode.equalsIgnoreCase(soli.getGenero()) || mode.equalsIgnoreCase(soli.getCedula())
					|| mode.equalsIgnoreCase("<Todos>")) {
				fila[0] = soli.getCedula();
				fila[1] = soli.getNombre() + " " + soli.getApellidos();
				fila[2] = soli.getNacimiento();
				fila[3] = soli.getPaisOrigen();
				fila[4] = soli.getPaisResidencia();
				fila[5] = soli.getGenero();
				if(soli.isTrabajo() == false){
					trabajo = "No";
				fila[6] = trabajo;
				}else{
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
