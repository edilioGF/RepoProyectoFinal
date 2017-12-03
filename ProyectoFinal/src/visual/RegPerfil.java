package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Controladora;
import logico.Graduado;
import logico.Obrero;
import logico.Solicitante;
import logico.Tecnico;
import logico.Perfil;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;

public class RegPerfil extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JRadioButton rdbtnGraduado;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;
	private JComboBox cbxAestudio;
	private JComboBox cbxTitulo;
	private JComboBox cbxHabilidad;
	private JPanel pnlTecnico;
	private JPanel pnlObrero;
	private JComboBox cbxIdioma;
	private JSpinner spnExp;
	private JCheckBox cbMudarse;
	private JCheckBox cbLicencia;
	private JPanel pnlGraduado;
	private Solicitante soli;
	private Perfil perfil;
	private JTextField txtCodigo;
	private String codigo;

	public RegPerfil(Solicitante solicitante) {
		setTitle("Registrar Perfil");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 390, 630);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion del Solicitante", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel.setBounds(10, 89, 364, 140);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 25, 59, 14);
		panel.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setBounds(75, 21, 180, 23);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cedula = txtCedula.getText();
				soli = Controladora.getInstance().buscarSolicitante(cedula);

				if (soli == null) {
					JOptionPane.showMessageDialog(null, "No existe un solicitante con la cédula que ha ingresado",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {
					txtNombre.setText(soli.getNombre());
					txtApellido.setText(soli.getApellidos());
				}
			}
		});
		btnBuscar.setBounds(265, 20, 89, 25);
		panel.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 65, 59, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(75, 61, 279, 23);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApelidos = new JLabel("Apellidos:");
		lblApelidos.setBounds(10, 105, 59, 14);
		panel.add(lblApelidos);

		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBounds(75, 101, 279, 23);
		panel.add(txtApellido);
		txtApellido.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formaci\u00F3n",

				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 402, 364, 70);
		contentPanel.add(panel_1);

		rdbtnGraduado = new JRadioButton("Graduado");
		rdbtnGraduado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(true, false, false);
			}
		});
		rdbtnGraduado.setSelected(true);
		rdbtnGraduado.setBounds(23, 23, 90, 23);
		panel_1.add(rdbtnGraduado);

		rdbtnTecnico = new JRadioButton("T\u00E9cnico");
		rdbtnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(false, true, false);
			}
		});
		rdbtnTecnico.setSelected(false);
		rdbtnTecnico.setBounds(136, 23, 90, 23);
		panel_1.add(rdbtnTecnico);

		rdbtnObrero = new JRadioButton("Obrero");
		rdbtnObrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(false, false, true);
			}
		});
		rdbtnObrero.setSelected(false);
		rdbtnObrero.setBounds(249, 23, 90, 23);
		panel_1.add(rdbtnObrero);

		pnlGraduado = new JPanel();
		pnlGraduado.setBorder(new TitledBorder(null, "Graduado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGraduado.setBounds(10, 483, 364, 70);
		contentPanel.add(pnlGraduado);
		pnlGraduado.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u00C1rea de Estudio:");
		lblNewLabel_1.setBounds(10, 30, 124, 14);
		pnlGraduado.add(lblNewLabel_1);

		cbxAestudio = new JComboBox();
		cbxAestudio.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>" }));
		cbxAestudio.setBounds(144, 27, 210, 20);
		pnlGraduado.add(cbxAestudio);

		pnlTecnico = new JPanel();
		pnlTecnico
				.setBorder(new TitledBorder(null, "T\u00E9cnico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTecnico.setBounds(10, 483, 364, 70);
		contentPanel.add(pnlTecnico);
		pnlTecnico.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00EDtulo:");
		lblNewLabel.setBounds(10, 30, 54, 14);
		pnlTecnico.add(lblNewLabel);

		cbxTitulo = new JComboBox();
		cbxTitulo.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>" }));
		cbxTitulo.setBounds(144, 27, 210, 20);
		pnlTecnico.add(cbxTitulo);

		pnlObrero = new JPanel();
		pnlObrero.setBorder(new TitledBorder(null, "Obrero", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlObrero.setBounds(10, 483, 364, 70);
		contentPanel.add(pnlObrero);
		pnlObrero.setLayout(null);

		JLabel lblHabilidad = new JLabel("Habilidad:");
		lblHabilidad.setBounds(10, 30, 73, 14);
		pnlObrero.add(lblHabilidad);

		cbxHabilidad = new JComboBox();
		cbxHabilidad.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>" }));
		cbxHabilidad.setBounds(144, 27, 210, 20);
		pnlObrero.add(cbxHabilidad);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Laboral",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 240, 356, 151);
		contentPanel.add(panel_2);

		JLabel label_2 = new JLabel("Idioma:");
		label_2.setBounds(10, 23, 59, 14);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("A\u00F1os de experiencia:");
		label_3.setBounds(195, 23, 128, 14);
		panel_2.add(label_3);

		JLabel label_4 = new JLabel("Licencia para conducir");
		label_4.setBounds(10, 80, 135, 14);
		panel_2.add(label_4);

		cbxIdioma = new JComboBox();
		cbxIdioma.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>" }));
		cbxIdioma.setBounds(10, 46, 151, 23);
		panel_2.add(cbxIdioma);

		spnExp = new JSpinner();
		spnExp.setBounds(195, 46, 105, 23);
		panel_2.add(spnExp);

		cbLicencia = new JCheckBox("");
		cbLicencia.setBounds(169, 76, 20, 23);
		panel_2.add(cbLicencia);

		JLabel label_5 = new JLabel("Disposici\u00F3n a mudarse");
		label_5.setBounds(10, 103, 135, 14);
		panel_2.add(label_5);

		cbMudarse = new JCheckBox("");
		cbMudarse.setBounds(169, 99, 20, 23);
		panel_2.add(cbMudarse);

		JLabel label_6 = new JLabel("A\u00F1os");
		label_6.setBounds(304, 50, 42, 14);
		panel_2.add(label_6);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Informaci\u00F3n de Registro", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel_3.setBounds(10, 11, 364, 70);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 28, 59, 14);
		panel_3.add(lblCdigo);

		codigo = String.format("%s-%03d", "PER", Controladora.getInstance().getMisPerfiles().size() + 1);
		txtCodigo = new JTextField(codigo);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(75, 24, 100, 23);
		panel_3.add(txtCodigo);
		txtCodigo.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (txtCedula.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Debe buscar un solicitante primero", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (cbxIdioma.getSelectedIndex() <= 0) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar un idioma", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (cbxAestudio.getSelectedIndex() <= 0 && rdbtnGraduado.isSelected()) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar una área de estudio", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (cbxHabilidad.getSelectedIndex() <= 0 && rdbtnObrero.isSelected()) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar una habilidad", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (cbxTitulo.getSelectedIndex() <= 0 && rdbtnTecnico.isSelected()) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar un título", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (solicitante == null && soli == null) {
							JOptionPane.showMessageDialog(null, "Debe elegir un Solicitante");
						} else {
							String idioma = cbxIdioma.getSelectedItem().toString();
							boolean licencia = cbLicencia.isSelected();
							boolean mudarse = cbMudarse.isSelected();
							int experiencia = Integer.valueOf(spnExp.getValue().toString());

							if (soli == null) {
								if (rdbtnGraduado.isSelected()) {
									String areaEstudio = cbxAestudio.getSelectedItem().toString();
									Graduado perfil = new Graduado(codigo, solicitante, idioma, licencia, mudarse,
											experiencia, areaEstudio);
									solicitante.getMisPerfiles().add(perfil);
									Controladora.getInstance().getMisSolicitantes().add(solicitante);
									Controladora.getInstance().getMisPerfiles().add(perfil);
								} else if (rdbtnObrero.isSelected()) {
									String habilidad = cbxHabilidad.getSelectedItem().toString();
									Obrero perfil = new Obrero(codigo, solicitante, idioma, licencia, mudarse,
											experiencia, habilidad);
									solicitante.getMisPerfiles().add(perfil);
									Controladora.getInstance().getMisSolicitantes().add(solicitante);
									Controladora.getInstance().getMisPerfiles().add(perfil);
								} else if (rdbtnTecnico.isSelected()) {
									String titulo = cbxTitulo.getSelectedItem().toString();
									Tecnico perfil = new Tecnico(codigo, solicitante, idioma, licencia, mudarse,
											experiencia, titulo);
									solicitante.getMisPerfiles().add(perfil);
									Controladora.getInstance().getMisSolicitantes().add(solicitante);
									Controladora.getInstance().getMisPerfiles().add(perfil);
								}

							} else {
								if (rdbtnGraduado.isSelected()) {
									String areaEstudio = cbxAestudio.getSelectedItem().toString();
									Graduado perfil = new Graduado(codigo, soli, idioma, licencia, mudarse, experiencia,
											areaEstudio);
									Controladora.getInstance().buscarSolicitante(soli.getCedula()).getMisPerfiles()
											.add(perfil);
									Controladora.getInstance().getMisPerfiles().add(perfil);
								} else if (rdbtnObrero.isSelected()) {
									String habilidad = cbxHabilidad.getSelectedItem().toString();
									Obrero perfil = new Obrero(codigo, soli, idioma, licencia, mudarse, experiencia,
											habilidad);
									Controladora.getInstance().buscarSolicitante(soli.getCedula()).getMisPerfiles()
											.add(perfil);
									Controladora.getInstance().getMisPerfiles().add(perfil);
								} else if (rdbtnTecnico.isSelected()) {
									String titulo = cbxTitulo.getSelectedItem().toString();
									Tecnico perfil = new Tecnico(codigo, soli, idioma, licencia, mudarse, experiencia,
											titulo);
									Controladora.getInstance().buscarSolicitante(soli.getCedula()).getMisPerfiles()
											.add(perfil);
									Controladora.getInstance().getMisPerfiles().add(perfil);
								}
							}
							Principal.loadStats();
							JOptionPane.showMessageDialog(null, "Su perfil se ha registrado satisfactorimente");
							if (solicitante == null) {
								clear();
							} else {
								dispose();
								RegSolicitante rs = new RegSolicitante();
								rs.setModal(true);
								rs.setVisible(true);
							}
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
		loadPanel(true, false, false);
		load();

		if (solicitante != null) {
			txtCedula.setText(solicitante.getCedula());
			txtNombre.setText(solicitante.getNombre());
			txtApellido.setText(solicitante.getApellidos());

			txtCedula.setEditable(false);
			btnBuscar.setVisible(false);

		}
	}

	private void loadPanel(boolean graduado, boolean tecnico, boolean obrero) {
		rdbtnGraduado.setSelected(graduado);
		rdbtnTecnico.setSelected(tecnico);
		rdbtnObrero.setSelected(obrero);

		pnlGraduado.setVisible(graduado);
		pnlTecnico.setVisible(tecnico);
		pnlObrero.setVisible(obrero);
	}

	private void load() {

		Date date = new Date();
		String str = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date);

		for (String area : Controladora.getMisAreasDeEstudio()) {
			cbxAestudio.addItem(area);
		}

		for (String titulo : Controladora.getMisTitulos()) {
			cbxTitulo.addItem(titulo);
		}

		for (String habilidad : Controladora.getMisHabilidades()) {
			cbxHabilidad.addItem(habilidad);
		}

		String[] languages = Locale.getISOLanguages();

		for (String lang : languages) {
			Locale loc = new Locale(lang);
			String string = loc.getDisplayLanguage().substring(0, 1).toUpperCase()
					+ loc.getDisplayLanguage().substring(1);
			cbxIdioma.addItem(string);
		}

	}

	private void clear() {
		cbxIdioma.setSelectedIndex(0);
		spnExp.setValue(0);
		cbLicencia.setSelected(false);
		cbMudarse.setSelected(false);
		cbxHabilidad.setSelectedIndex(0);
		cbxAestudio.setSelectedIndex(0);
		cbxTitulo.setSelectedIndex(0);
		loadPanel(true, false, false);
	}
}
