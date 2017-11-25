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

public class ListSolicitante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;

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
					String[] columns = { "C�dula", "Nombre", "Fecha de nacimiento", "Reside","G�nero" };
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
		loadTable();
}
	
	private void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Solicitante solicitante : Controladora.getInstance().getMisSolicitantes()) {
			
				fila[0] = solicitante.getCedula();
				fila[1] = solicitante.getNombre();
				fila[2] = solicitante.getNacimiento();
				fila[3] = solicitante.getPaisResidencia();
				fila[4] = solicitante.getGenero();

				model.addRow(fila);
			}

			table.setModel(model);
		}
}
