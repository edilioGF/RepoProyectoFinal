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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public RegSolicitante(Solicitante soli) {
		if (soli == null) {
			setTitle("Registro de Solicitante");
		} else {
			setTitle("Modificaci�n de Solicitante");
		}
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
		lblCdula.setBounds(10, 20, 135, 14);
		panel.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setBounds(10, 40, 177, 23);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 70, 135, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 90, 344, 23);
		panel.add(txtNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 120, 135, 14);
		panel.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(10, 140, 344, 23);
		panel.add(txtApellidos);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(10, 170, 135, 14);
		panel.add(lblFechaDeNacimiento);

		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setBounds(200, 170, 135, 14);
		panel.add(lblGnero);

		cbxGenero = new JComboBox();
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Masculino", "Femenino" }));
		cbxGenero.setBounds(200, 190, 154, 23);
		panel.add(cbxGenero);

		JLabel lblPasDeOrigen = new JLabel("Pa\u00EDs de Origen:");
		lblPasDeOrigen.setBounds(10, 220, 135, 14);
		panel.add(lblPasDeOrigen);

		cbxPaisOrigen = new JComboBox();
		cbxPaisOrigen.setBounds(10, 240, 154, 23);
		panel.add(cbxPaisOrigen);

		JLabel lblPasDeResidencia = new JLabel("Pa\u00EDs de Residencia: ");
		lblPasDeResidencia.setBounds(200, 220, 135, 14);
		panel.add(lblPasDeResidencia);

		cbxPaisResidencia = new JComboBox();
		cbxPaisResidencia.setBounds(200, 240, 154, 23);
		panel.add(cbxPaisResidencia);

		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(10, 190, 154, 23);
		panel.add(dateChooser);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSiguiente = new JButton("Siguiente");
				if (soli != null) {
					btnSiguiente.setText("Modificar");
				}
				btnSiguiente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (cbxGenero.getSelectedIndex() <= 0) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar un g�nero", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (cbxPaisOrigen.getSelectedIndex() <= 0) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar un pa�s de origen", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (cbxPaisResidencia.getSelectedIndex() <= 0) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar un pa�s de residencia", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (dateChooser.getDate() == null) {
							JOptionPane.showMessageDialog(null, "La fecha de nacimiento no es v�lida");
						} else {
							String cedula = txtCedula.getText();
							String nombre = txtNombre.getText();
							String apellidos = txtApellidos.getText();
							String genero = cbxGenero.getSelectedItem().toString();
							String paisOrigen = cbxPaisOrigen.getSelectedItem().toString();
							String paisResidencia = cbxPaisResidencia.getSelectedItem().toString();
							Date date = dateChooser.getDate();
							String str = new SimpleDateFormat("dd/MM/yyyy").format(date);
							String nacimiento = str;
							if (cedula.isEmpty() || nombre.isEmpty() || apellidos.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Le falto campos por completar", "Aviso",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							} else if (soli == null) {
								solicitante = new Solicitante(cedula, nombre, apellidos, nacimiento, genero, paisOrigen,
										paisResidencia);
								dispose();

								RegPerfil perfil = new RegPerfil(solicitante);
								perfil.setModal(true);
								perfil.setVisible(true);
							} else {
								soli.setCedula(cedula);
								soli.setNombre(nombre);
								soli.setApellidos(apellidos);
								soli.setGenero(genero);
								soli.setPaisOrigen(paisOrigen);
								soli.setPaisResidencia(paisResidencia);
								soli.setNacimiento(nacimiento);
								Controladora.getInstance().actualizarPerfiles(soli);
								ListSolicitante.loadTable("<Todos>", "");
								JOptionPane.showMessageDialog(null, "Se ha realizado la modificaci�n", "Informaci�n",
										JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}

						}

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
		if (soli != null) {
			try {
				loadSoli(soli);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

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

	private void loadSoli(Solicitante soli) throws ParseException {
		int i = 0;
		txtCedula.setText(soli.getCedula());
		txtNombre.setText(soli.getNombre());
		txtApellidos.setText(soli.getApellidos());
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(soli.getNacimiento());
		dateChooser.setDate(date);

		for (i = 0; i < cbxGenero.getItemCount(); i++) {
			if (cbxGenero.getItemAt(i).toString().equalsIgnoreCase(soli.getGenero())) {
				cbxGenero.setSelectedIndex(i);
			}
		}
		for (i = 0; i < cbxPaisOrigen.getItemCount(); i++) {
			if (cbxPaisOrigen.getItemAt(i).toString().equalsIgnoreCase(soli.getPaisOrigen())) {
				cbxPaisOrigen.setSelectedIndex(i);
			}
		}
		for (i = 0; i < cbxPaisResidencia.getItemCount(); i++) {
			if (cbxPaisResidencia.getItemAt(i).toString().equalsIgnoreCase(soli.getPaisResidencia())) {
				cbxPaisResidencia.setSelectedIndex(i);
			}
		}
	}

	private void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		cbxGenero.setSelectedIndex(0);
		cbxPaisOrigen.setSelectedIndex(0);
		cbxPaisResidencia.setSelectedIndex(0);
	}
}
