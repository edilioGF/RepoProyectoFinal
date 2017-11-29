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
	private JComboBox cbxFormacion;

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
					lblFormacin.setBounds(10, 22, 64, 14);
					contentPanel.add(lblFormacin);
					
					cbxFormacion = new JComboBox();
					cbxFormacion.setModel(new DefaultComboBoxModel(new String[] {"<Todos>"}));
					cbxFormacion.setBounds(84, 18, 250, 23);
					contentPanel.add(cbxFormacion);
					
					JLabel lblCedula = new JLabel("C\u00E9dula:");
					lblCedula.setBounds(383, 22, 55, 14);
					contentPanel.add(lblCedula);
					
					txtCedula = new JTextField();
					txtCedula.setBounds(448, 19, 114, 23);
					contentPanel.add(txtCedula);
					txtCedula.setColumns(10);
					
					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String cedula = txtCedula.getText();
							
							if(Controladora.getInstance().buscarSolicitante(cedula) != null){
								table.setModel(model);
								Solicitante solicitante = Controladora.getInstance().buscarSolicitante(cedula);
								fila[0] = solicitante.getCedula();
								fila[1] = solicitante.getNombre();
								fila[2] = solicitante.getNacimiento();
								fila[3] = solicitante.getPaisResidencia();
								fila[4] = solicitante.getGenero();

								model.addRow(fila);
								table.setModel(model);
							}
							
						}
					});
					btnBuscar.setBounds(571, 18, 89, 23);
					contentPanel.add(btnBuscar);
					String[] columns = { "Cédula", "Nombre", "Fecha de nacimiento", "Reside","Género" };
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
		loadTable(cbxFormacion.getSelectedItem().toString());
}
	
	private void load() {
		for (String genero : Controladora.getMisGeneros()) {
			cbxFormacion.addItem(genero);
		}
	}
	private void loadTable(String genero) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		
		for (Solicitante solicitante : Controladora.getInstance().getMisSolicitantes()) {
			if (genero.equalsIgnoreCase("<Todos>") || genero.equalsIgnoreCase(solicitante.getGenero())) {
				fila[0] = solicitante.getCedula();
				fila[1] = solicitante.getNombre();
				fila[2] = solicitante.getNacimiento();
				fila[3] = solicitante.getPaisResidencia();
				fila[4] = solicitante.getGenero();

				model.addRow(fila);
			}
		}
		

			table.setModel(model);
		}
}
