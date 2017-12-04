package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import logico.Controladora;
import logico.Empleo;
import logico.Empresa;
import logico.Perfil;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DatosMatch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel model;

	private ArrayList<Perfil> misPerfiles;
	private ArrayList<Empleo> misEmpleos;

	public DatosMatch(ArrayList<Perfil> perfiles, ArrayList<Empleo> empleos) {

		misPerfiles = perfiles;
		misEmpleos = empleos;

		setResizable(false);
		setTitle("Datos del Match");
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 11, 972, 512);
		contentPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] columns = { "Solicitante", "Empresa", "Empleo" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);

		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
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

		for (int i = 0; i < misPerfiles.size(); i++) {
			fila[0] = misPerfiles.get(i).getSolicitante().getCedula() + " - "
					+ misPerfiles.get(i).getSolicitante().getNombre() + " "
					+ misPerfiles.get(i).getSolicitante().getApellidos();
			fila[1] = misEmpleos.get(i).getEmpresa().getRnc() + " - " + misEmpleos.get(i).getEmpresa().getNombre();
			fila[2] = misEmpleos.get(i).getCodigo() + " - " + misEmpleos.get(i).getTitulo();
			model.addRow(fila);
		}

		table.setModel(model);
	}

}
