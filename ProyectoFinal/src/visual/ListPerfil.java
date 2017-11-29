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
import logico.Perfil;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListPerfil extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;
	private JTextField txtCedula;

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
							if(table.getSelectedRow() >= 0)
							{
								int index = table.getSelectedRow();
								//cedula = (String) table.getModel().getValueAt(index, 2);
							}
						}
					});
					table.setDefaultEditor(Object.class, null);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columns = {"Fecha", "Cédula - Nombre", "Licencia", "Remoto"};
					model = new DefaultTableModel();
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
				loadTable(cedula);
			}
		});
		btnNewButton.setBounds(560, 20, 89, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblFormacin = new JLabel("Formaci\u00F3n:");
		lblFormacin.setBounds(10, 24, 67, 14);
		contentPanel.add(lblFormacin);
		
		JComboBox cbxFormacion = new JComboBox();
		cbxFormacion.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Graduado", "Tecnicos", "Obreros"}));
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
			buttonPane.add(btnCerrar);
		}

		loadTable("");
	}

	private void loadTable(String cedula) {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Perfil perfil : Controladora.getInstance().getMisPerfiles()) {
			if (cedula.equalsIgnoreCase("") || cedula.equalsIgnoreCase(perfil.getSolicitante().getCedula())) {
				fila[0] = perfil.getFecha();
				fila[1] = perfil.getSolicitante().getCedula() + " - " + perfil.getSolicitante().getNombre() + " "
						+ perfil.getSolicitante().getApellidos();
				fila[2] = perfil.isLicencia();
				fila[3] = perfil.isMudarse();

				model.addRow(fila);
			}
		}

		table.setModel(model);
	}
}
