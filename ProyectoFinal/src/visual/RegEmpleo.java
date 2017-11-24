package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
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
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;

public class RegEmpleo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtFecha;
	private JTextField txtTitulo;
	private JTextField textCodigoEmp;
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

	/**
	 * Create the dialog.
	 */
	public RegEmpleo() {
		setTitle("Registro de Empleo");
		setResizable(false);
		setBounds(100, 100, 400, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 374, 345);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 20, 100, 14);
		panel.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(10, 40, 164, 23);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(200, 20, 100, 14);
		panel.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(200, 40, 164, 23);
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
		rdbtnGraduado.setBounds(6, 20, 109, 23);
		panel_1.add(rdbtnGraduado);
		
		rdbtnTecnico = new JRadioButton("T\u00E9cnico");
		rdbtnTecnico.setBounds(6, 50, 109, 23);
		panel_1.add(rdbtnTecnico);
		
		rdbtnObrero = new JRadioButton("Obrero");
		rdbtnObrero.setBounds(6, 80, 109, 23);
		panel_1.add(rdbtnObrero);
		
		JPanel pnlObrero = new JPanel();
		pnlObrero.setLayout(null);
		pnlObrero.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Obrero", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlObrero.setBounds(145, 367, 239, 120);
		contentPanel.add(pnlObrero);
		
		JLabel lblHabilidad = new JLabel("Habilidad:");
		lblHabilidad.setBounds(10, 30, 100, 14);
		pnlObrero.add(lblHabilidad);
		
		cbxHabilidad = new JComboBox();
		cbxHabilidad.setBounds(10, 50, 219, 23);
		pnlObrero.add(cbxHabilidad);
		
		JPanel pnlTecnico = new JPanel();
		pnlTecnico.setLayout(null);
		pnlTecnico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00E9cnico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTecnico.setBounds(145, 367, 239, 120);
		contentPanel.add(pnlTecnico);
		
		JLabel lblTtulo_1 = new JLabel("T\u00EDtulo:");
		lblTtulo_1.setBounds(10, 30, 100, 14);
		pnlTecnico.add(lblTtulo_1);
		
		cbxTitulo = new JComboBox();
		cbxTitulo.setBounds(10, 50, 219, 23);
		pnlTecnico.add(cbxTitulo);
		
		JPanel pnlGraduado = new JPanel();
		pnlGraduado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Graduado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlGraduado.setBounds(145, 367, 239, 120);
		contentPanel.add(pnlGraduado);
		pnlGraduado.setLayout(null);
		
		JLabel lblreaDeEstudio = new JLabel("\u00C1rea de estudio:");
		lblreaDeEstudio.setBounds(10, 30, 100, 14);
		pnlGraduado.add(lblreaDeEstudio);
		
		cbxAreaEstudio = new JComboBox();
		cbxAreaEstudio.setBounds(10, 50, 219, 23);
		pnlGraduado.add(cbxAreaEstudio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informaci\u00F3n de Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 498, 374, 129);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(10, 20, 100, 14);
		panel_2.add(lblNewLabel);
		
		textCodigoEmp = new JTextField();
		textCodigoEmp.setBounds(83, 20, 182, 23);
		panel_2.add(textCodigoEmp);
		textCodigoEmp.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigoEmp = textCodigoEmp.getText();
				empresa = Controladora.getInstance().buscarEmpresa(codigoEmp);
				txtNombreEmp.setText(empresa.getNombre());
				txtUbicacionEmp.setText(empresa.getUbicacion());
			}
		});
		btnBuscar.setBounds(275, 16, 89, 23);
		panel_2.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 50, 100, 14);
		panel_2.add(lblNombre);
		
		txtNombreEmp = new JTextField();
		txtNombreEmp.setEditable(false);
		txtNombreEmp.setBounds(83, 50, 281, 23);
		panel_2.add(txtNombreEmp);
		txtNombreEmp.setColumns(10);
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n:");
		lblUbicacin.setBounds(10, 80, 100, 14);
		panel_2.add(lblUbicacin);
		
		txtUbicacionEmp = new JTextField();
		txtUbicacionEmp.setEditable(false);
		txtUbicacionEmp.setColumns(10);
		txtUbicacionEmp.setBounds(83, 80, 281, 23);
		panel_2.add(txtUbicacionEmp);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Terminar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(empresa == null){
						  JOptionPane.showMessageDialog(null, "Debe seleccionar una empresa");	
						}
						else{
							String codigo = txtCodigo.getText();
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
							
							if(graduado){
							String area = cbxAreaEstudio.getSelectedItem().toString();
							empleo = new Empleo(codigo, titulo, vacantes, descripcion, salario, horaInicial, horaFinal, false, idioma, experiencia, remoto, licencia, graduado, tecnico, obrero,"", area,"", empresa);
							}
							
							if(tecnico){
								String tituloTecnico = cbxTitulo.getSelectedItem().toString();
								empleo = new Empleo(codigo, titulo, vacantes, descripcion, salario, horaInicial, horaFinal, false, idioma, experiencia, remoto, licencia, graduado, tecnico, obrero, tituloTecnico, "", "", empresa);
							}
							
							if(obrero){
								String habilidad = cbxHabilidad.getSelectedItem().toString();
								empleo = new Empleo(codigo, titulo, vacantes, descripcion, salario, horaInicial, horaFinal, false, idioma, experiencia, remoto, licencia, graduado, tecnico, obrero, "", "", habilidad, empresa);
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
	}
}
