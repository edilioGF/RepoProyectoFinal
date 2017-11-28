package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import logico.Controladora;
import logico.Graduado;
import logico.Obrero;
import logico.Solicitante;
import logico.Tecnico;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;

public class RegSolicitante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JComboBox cbxPaisResidencia;
	private JComboBox cbxPaisOrigen;
	private JComboBox cbxGenero;
	private JDateChooser dateChooser;
	private Solicitante solicitante;

	/**
	 * Create the dialog.
	 */
	public RegSolicitante() {
		setTitle("Registro de Solicitante");
		setResizable(false);
		setBounds(100, 100, 390, 375);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 364, 287);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 23, 135, 14);
		panel.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setBounds(10, 46, 177, 23);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 73, 135, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 96, 344, 23);
		panel.add(txtNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 123, 135, 14);
		panel.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(10, 146, 344, 23);
		panel.add(txtApellidos);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(10, 173, 135, 14);
		panel.add(lblFechaDeNacimiento);

		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setBounds(200, 173, 135, 14);
		panel.add(lblGnero);

		cbxGenero = new JComboBox();
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Masculino", "Femenino" }));
		cbxGenero.setBounds(200, 196, 154, 23);
		panel.add(cbxGenero);

		JLabel lblPasDeOrigen = new JLabel("Pa\u00EDs de Origen:");
		lblPasDeOrigen.setBounds(10, 223, 135, 14);
		panel.add(lblPasDeOrigen);

		cbxPaisOrigen = new JComboBox();
		cbxPaisOrigen.setBounds(10, 246, 154, 23);
		panel.add(cbxPaisOrigen);

		JLabel lblPasDeResidencia = new JLabel("Pa\u00EDs de Residencia: ");
		lblPasDeResidencia.setBounds(200, 223, 135, 14);
		panel.add(lblPasDeResidencia);

		cbxPaisResidencia = new JComboBox();
		cbxPaisResidencia.setBounds(200, 246, 154, 23);
		panel.add(cbxPaisResidencia);

		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(10, 196, 154, 23);
		panel.add(dateChooser);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSiguiente = new JButton("Siguiente");
				btnSiguiente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (dateChooser.getDate() == null) {
							JOptionPane.showMessageDialog(null, "La fecha de nacimiento no es válida");
						} else {
							String cedula = txtCedula.getText();
							String nombre = txtNombre.getText();
							String apellidos = txtApellidos.getText();
							String genero = cbxGenero.getSelectedItem().toString();
							String paisOrigen = cbxPaisOrigen.getSelectedItem().toString();
							String paisResidencia = cbxPaisResidencia.getSelectedItem().toString();
							String nacimiento = dateChooser.getDateFormatString();
							/*
							 * if (rdbtnGraduado.isSelected()) { String
							 * areaEstudio =
							 * cbxAreaEstudio.getSelectedItem().toString();
							 * solicitante = new Graduado(cedula, nombre,
							 * apellidos, nacimiento, genero, paisOrigen,
							 * paisResidencia, areaEstudio); }
							 * 
							 * if (rdbtnTecnico.isSelected()) { String titulo =
							 * cbxTitulo.getSelectedItem().toString();
							 * solicitante = new Tecnico(cedula, nombre,
							 * apellidos, nacimiento, genero, paisOrigen,
							 * paisResidencia, titulo); }
							 * 
							 * if (rdbtnObrero.isSelected()) { String habilidad
							 * = cbxHabilidad.getSelectedItem().toString();
							 * solicitante = new Obrero(cedula, nombre,
							 * apellidos, nacimiento, genero, paisOrigen,
							 * paisResidencia, habilidad); }
							 */

							// Controladora.getInstance().getMisSolicitantes().add(solicitante);

						}
						dispose();
						// ListEmpleo empleo = new ListEmpleo(solicitante);
						// empleo.setVisible(true);

					}
				});
				buttonPane.add(btnSiguiente);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		loadCountries();
		loadPanel(true, false, false);

	}

	private void loadCountries() {
		String[] locales = Locale.getISOCountries();

		cbxPaisOrigen.addItem("<Seleccione>");
		cbxPaisResidencia.addItem("<Seleccione>");

		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);

			cbxPaisOrigen.addItem(obj.getDisplayCountry());
			cbxPaisResidencia.addItem(obj.getDisplayCountry());
		}
	}

	private void loadPanel(boolean graduado, boolean tecnico, boolean obrero) {
	}

	private void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		cbxGenero.setSelectedIndex(0);
		cbxPaisOrigen.setSelectedIndex(0);
		cbxPaisResidencia.setSelectedIndex(0);
		loadPanel(true, false, false);

	}
}
