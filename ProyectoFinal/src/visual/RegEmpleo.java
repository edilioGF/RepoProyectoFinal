package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.Controladora;
import logico.Empleo;
import logico.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;

public class RegEmpleo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFecha;
	private JTextField txtTitulo;
	private JTextField txtCodigoEmp;
	private JTextField txtNombreEmp;
	private JTextField txtUbicacionEmp;
	private JTextArea txtDescripcion;
	private JSpinner spnVacantes;
	private JSpinner spnExp;
	private JSpinner spnSalario;
	private JSpinner spnHoraInicial;
	private JSpinner spnHoraFinal;
	private JComboBox cbxIdioma;
	private JCheckBox cbRemoto;
	private JCheckBox cbLicencia;
	private JRadioButton rdbtnGraduado;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;
	private JComboBox cbxHabilidad;
	private JComboBox cbxTitulo;
	private JComboBox cbxAreaEstudio;
	private Empresa empresa;
	private Empleo empleo;

	private JPanel pnlGraduado;
	private JPanel pnlTecnico;
	private JPanel pnlObrero;

	private JButton btnBuscar;

	/**
	 * Create the dialog.
	 */
	public RegEmpleo(Empresa emp) {
		setTitle("Registro de Empleo");
		setResizable(false);
		setBounds(100, 100, 400, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 374, 345);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 20, 100, 14);
		panel.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(10, 40, 177, 23);
		panel.add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(10, 70, 100, 14);
		panel.add(lblTtulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 90, 354, 23);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 120, 100, 14);
		panel.add(lblDescripcin);

		txtDescripcion = new JTextArea();
		txtDescripcion.setTabSize(5);
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setRows(3);
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDescripcion.setBounds(10, 140, 354, 46);
		panel.add(txtDescripcion);

		JLabel lblVacantes = new JLabel("Vacantes:");
		lblVacantes.setBounds(10, 193, 100, 14);
		panel.add(lblVacantes);

		spnVacantes = new JSpinner();
		spnVacantes.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnVacantes.setBounds(10, 213, 70, 23);
		panel.add(spnVacantes);

		JLabel lblExperiencia = new JLabel("Experiencia:");
		lblExperiencia.setBounds(100, 193, 100, 14);
		panel.add(lblExperiencia);

		spnExp = new JSpinner();
		spnExp.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spnExp.setBounds(100, 213, 70, 23);
		panel.add(spnExp);

		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(225, 193, 100, 14);
		panel.add(lblSalario);

		spnSalario = new JSpinner();
		spnSalario.setBounds(254, 213, 110, 23);
		panel.add(spnSalario);

		JLabel lblRds = new JLabel("RD$");
		lblRds.setBounds(225, 217, 46, 14);
		panel.add(lblRds);

		JLabel lblHoraInicial = new JLabel("Hora inicial:");
		lblHoraInicial.setBounds(10, 243, 100, 14);
		panel.add(lblHoraInicial);

		JLabel lblHoraFinal = new JLabel("Hora final:");
		lblHoraFinal.setBounds(100, 243, 100, 14);
		panel.add(lblHoraFinal);

		spnHoraInicial = new JSpinner();
		spnHoraInicial.setBounds(10, 260, 70, 23);
		panel.add(spnHoraInicial);

		spnHoraFinal = new JSpinner();
		spnHoraFinal.setBounds(100, 260, 70, 23);
		panel.add(spnHoraFinal);

		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(225, 243, 100, 14);
		panel.add(lblIdioma);

		cbxIdioma = new JComboBox();
		cbxIdioma.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		cbxIdioma.setBounds(225, 260, 139, 23);
		panel.add(cbxIdioma);

		JLabel lblAos = new JLabel("A\u00F1os");
		lblAos.setBounds(175, 217, 46, 14);
		panel.add(lblAos);

		JLabel lblRemoto = new JLabel("Remoto:");
		lblRemoto.setBounds(10, 293, 70, 14);
		panel.add(lblRemoto);

		cbRemoto = new JCheckBox("");
		cbRemoto.setBounds(100, 289, 20, 23);
		panel.add(cbRemoto);

		JLabel lblLicencia = new JLabel("Licencia:");
		lblLicencia.setBounds(10, 317, 70, 14);
		panel.add(lblLicencia);

		cbLicencia = new JCheckBox("");
		cbLicencia.setBounds(100, 313, 20, 23);
		panel.add(cbLicencia);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Formaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 367, 125, 120);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		rdbtnGraduado = new JRadioButton("Graduado");
		rdbtnGraduado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadPanel(true, false, false);
			}
		});
		rdbtnGraduado.setBounds(6, 20, 109, 23);
		panel_1.add(rdbtnGraduado);

		rdbtnTecnico = new JRadioButton("T\u00E9cnico");
		rdbtnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(false, true, false);
			}
		});
		rdbtnTecnico.setBounds(6, 50, 109, 23);
		panel_1.add(rdbtnTecnico);

		rdbtnObrero = new JRadioButton("Obrero");
		rdbtnObrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(false, false, true);
			}
		});
		rdbtnObrero.setBounds(6, 80, 109, 23);
		panel_1.add(rdbtnObrero);

		pnlGraduado = new JPanel();
		pnlGraduado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Graduado",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlGraduado.setBounds(145, 367, 239, 120);
		contentPanel.add(pnlGraduado);
		pnlGraduado.setLayout(null);

		JLabel lblreaDeEstudio = new JLabel("\u00C1rea de estudio:");
		lblreaDeEstudio.setBounds(10, 30, 100, 14);
		pnlGraduado.add(lblreaDeEstudio);

		cbxAreaEstudio = new JComboBox();
		cbxAreaEstudio.setBounds(10, 50, 219, 23);
		pnlGraduado.add(cbxAreaEstudio);

		pnlTecnico = new JPanel();
		pnlTecnico.setLayout(null);
		pnlTecnico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00E9cnico",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTecnico.setBounds(145, 367, 239, 120);
		contentPanel.add(pnlTecnico);

		JLabel lblTtulo_1 = new JLabel("T\u00EDtulo:");
		lblTtulo_1.setBounds(10, 30, 100, 14);
		pnlTecnico.add(lblTtulo_1);

		cbxTitulo = new JComboBox();
		cbxTitulo.setBounds(10, 50, 219, 23);
		pnlTecnico.add(cbxTitulo);

		pnlObrero = new JPanel();
		pnlObrero.setLayout(null);
		pnlObrero.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Obrero", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlObrero.setBounds(145, 367, 239, 120);
		contentPanel.add(pnlObrero);

		JLabel lblHabilidad = new JLabel("Habilidad:");
		lblHabilidad.setBounds(10, 30, 100, 14);
		pnlObrero.add(lblHabilidad);

		cbxHabilidad = new JComboBox();
		cbxHabilidad.setBounds(10, 50, 219, 23);
		pnlObrero.add(cbxHabilidad);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informaci\u00F3n de Empresa", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel_2.setBounds(10, 498, 374, 129);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("RNC:");
		lblNewLabel.setBounds(10, 30, 100, 14);
		panel_2.add(lblNewLabel);

		txtCodigoEmp = new JTextField();
		txtCodigoEmp.setBounds(83, 26, 182, 23);
		panel_2.add(txtCodigoEmp);
		txtCodigoEmp.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigoEmp = txtCodigoEmp.getText();
				empresa = Controladora.getInstance().buscarEmpresa(codigoEmp);
				txtNombreEmp.setText(empresa.getNombre());
				txtUbicacionEmp.setText(empresa.getUbicacion());
			}
		});
		btnBuscar.setBounds(275, 26, 89, 23);
		panel_2.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 60, 100, 14);
		panel_2.add(lblNombre);

		txtNombreEmp = new JTextField();
		txtNombreEmp.setEditable(false);
		txtNombreEmp.setBounds(83, 56, 281, 23);
		panel_2.add(txtNombreEmp);
		txtNombreEmp.setColumns(10);

		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n:");
		lblUbicacin.setBounds(10, 90, 100, 14);
		panel_2.add(lblUbicacin);

		txtUbicacionEmp = new JTextField();
		txtUbicacionEmp.setEditable(false);
		txtUbicacionEmp.setColumns(10);
		txtUbicacionEmp.setBounds(83, 86, 281, 23);
		panel_2.add(txtUbicacionEmp);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Terminar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (empresa == null && emp == null) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar una empresa");
						} else {
							// String codigo = txtCodigo.getText();
							String titulo = txtTitulo.getText();
							int vacantes = Integer.valueOf(spnVacantes.getValue().toString());
							String descripcion = txtDescripcion.getText();
							int salario = Integer.valueOf(spnSalario.getValue().toString());
							int horaInicial = Integer.valueOf(spnHoraInicial.getValue().toString());
							int horaFinal = Integer.valueOf(spnHoraFinal.getValue().toString());
							String idioma = cbxIdioma.getSelectedItem().toString();
							int experiencia = Integer.valueOf(spnExp.getValue().toString());
							boolean remoto = cbRemoto.isSelected();
							boolean licencia = cbLicencia.isSelected();
							boolean graduado = rdbtnGraduado.isSelected();
							boolean tecnico = rdbtnTecnico.isSelected();
							boolean obrero = rdbtnObrero.isSelected();

							if (graduado) {
								String area = cbxAreaEstudio.getSelectedItem().toString();
								empleo = new Empleo(titulo, vacantes, descripcion, salario, horaInicial, horaFinal,
										false, idioma, experiencia, remoto, licencia, graduado, tecnico, obrero, "",
										area, "", empresa);
							}

							if (tecnico) {
								String tituloTecnico = cbxTitulo.getSelectedItem().toString();
								empleo = new Empleo(titulo, vacantes, descripcion, salario, horaInicial, horaFinal,
										false, idioma, experiencia, remoto, licencia, graduado, tecnico, obrero,
										tituloTecnico, "", "", empresa);
							}

							if (obrero) {
								String habilidad = cbxHabilidad.getSelectedItem().toString();
								empleo = new Empleo(titulo, vacantes, descripcion, salario, horaInicial, horaFinal,
										false, idioma, experiencia, remoto, licencia, graduado, tecnico, obrero, "", "",
										habilidad, empresa);
							}

							if (emp != null) {
								empleo.setEmpresa(emp);
								Controladora.getInstance().addEmpresa(emp);
							}
							Controladora.getInstance().addEmpleo(empleo);

							JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);

							if (emp != null) {
								dispose();
								RegEmpresa re = new RegEmpresa();
								re.setModal(true);
								re.setVisible(true);
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
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		load();
		loadPanel(true, false, false);

		if (emp != null) {
			btnBuscar.setVisible(false);
			txtCodigoEmp.setEditable(false);
			txtCodigoEmp.setText(emp.getRnc());
			txtNombreEmp.setText(emp.getNombre());
			txtUbicacionEmp.setText(emp.getUbicacion());
		}
	}

	private void load() {

		Date date = new Date();
		String str = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date);
		txtFecha.setText(str);

		for (String area : Controladora.getMisAreasDeEstudio()) {
			cbxAreaEstudio.addItem(area);
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

	private void loadPanel(boolean graduado, boolean tecnico, boolean obrero) {
		rdbtnGraduado.setSelected(graduado);
		rdbtnTecnico.setSelected(tecnico);
		rdbtnObrero.setSelected(obrero);

		pnlGraduado.setVisible(graduado);
		pnlTecnico.setVisible(tecnico);
		pnlObrero.setVisible(obrero);
	}
}
