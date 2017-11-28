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
import logico.Solicitud;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;


	public ListSolicitud() {
		setResizable(false);
		setTitle("Listado de Solicitudes");
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
					table.setDefaultEditor(Object.class, null);
					;
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columns = {"Código", "Fecha", "Cédula - Nombre" , "Licencia" , "Remoto"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columns);
					scrollPane.setViewportView(table);
				}
			}
		}
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
		
		loadTable();
	}
	private void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];

		for (Solicitud solicitud : Controladora.getInstance().getMisSolicitudes()) {
			//if (tipo.equalsIgnoreCase("<Todos>") || tipo.equalsIgnoreCase(solicitud.getTipo())) {
				fila[0] = solicitud.getCodigo();
				fila[1] = solicitud.getFecha();
				fila[2] = solicitud.getSolicitante().getCedula()+ " - " + solicitud.getSolicitante().getNombre()+ " " + solicitud.getSolicitante().getApellidos() ;
				fila[3] = solicitud.isLicencia();
				fila[4] = solicitud.isMudarse();

				model.addRow(fila);
			//}
		}

		table.setModel(model);
	}
}
