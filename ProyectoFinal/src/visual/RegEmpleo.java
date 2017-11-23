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
import javax.swing.JLabel;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 40, 164, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(200, 20, 100, 14);
		panel.add(lblFecha);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(200, 40, 164, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(10, 70, 100, 14);
		panel.add(lblTtulo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 90, 354, 23);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 120, 100, 14);
		panel.add(lblDescripcin);
		
		JTextArea txtrEstoEsUna = new JTextArea();
		txtrEstoEsUna.setTabSize(5);
		txtrEstoEsUna.setWrapStyleWord(true);
		txtrEstoEsUna.setLineWrap(true);
		txtrEstoEsUna.setRows(3);
		txtrEstoEsUna.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrEstoEsUna.setBounds(10, 140, 354, 46);
		panel.add(txtrEstoEsUna);
		
		JLabel lblVacantes = new JLabel("Vacantes:");
		lblVacantes.setBounds(10, 193, 100, 14);
		panel.add(lblVacantes);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(10, 213, 70, 23);
		panel.add(spinner);
		
		JLabel lblExperiencia = new JLabel("Experiencia:");
		lblExperiencia.setBounds(100, 193, 100, 14);
		panel.add(lblExperiencia);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinner_1.setBounds(100, 213, 70, 23);
		panel.add(spinner_1);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(225, 193, 100, 14);
		panel.add(lblSalario);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(254, 213, 110, 23);
		panel.add(spinner_2);
		
		JLabel lblRds = new JLabel("RD$");
		lblRds.setBounds(225, 217, 46, 14);
		panel.add(lblRds);
		
		JLabel lblHoraInicial = new JLabel("Hora inicial:");
		lblHoraInicial.setBounds(10, 243, 100, 14);
		panel.add(lblHoraInicial);
		
		JLabel lblHoraFinal = new JLabel("Hora final:");
		lblHoraFinal.setBounds(100, 243, 100, 14);
		panel.add(lblHoraFinal);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(10, 260, 70, 23);
		panel.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(100, 260, 70, 23);
		panel.add(spinner_4);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(225, 243, 100, 14);
		panel.add(lblIdioma);
		
		JComboBox cbxIdioma = new JComboBox();
		cbxIdioma.setBounds(225, 260, 139, 23);
		panel.add(cbxIdioma);
		
		JLabel lblAos = new JLabel("A\u00F1os");
		lblAos.setBounds(175, 217, 46, 14);
		panel.add(lblAos);
		
		JLabel lblRemoto = new JLabel("Remoto:");
		lblRemoto.setBounds(10, 293, 70, 14);
		panel.add(lblRemoto);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(100, 289, 20, 23);
		panel.add(checkBox);
		
		JLabel lblLicencia = new JLabel("Licencia:");
		lblLicencia.setBounds(10, 317, 70, 14);
		panel.add(lblLicencia);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(100, 313, 20, 23);
		panel.add(checkBox_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Formaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 367, 125, 120);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnGraduado = new JRadioButton("Graduado");
		rdbtnGraduado.setBounds(6, 20, 109, 23);
		panel_1.add(rdbtnGraduado);
		
		JRadioButton rdbtnTcnico = new JRadioButton("T\u00E9cnico");
		rdbtnTcnico.setBounds(6, 50, 109, 23);
		panel_1.add(rdbtnTcnico);
		
		JRadioButton rdbtnObrero = new JRadioButton("Obrero");
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
		
		JComboBox cbxHabilidad = new JComboBox();
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
		
		JComboBox cbxTitulo = new JComboBox();
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
		
		JComboBox cbxAreaEstudio = new JComboBox();
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
		
		textField_3 = new JTextField();
		textField_3.setBounds(83, 20, 182, 23);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(275, 16, 89, 23);
		panel_2.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 50, 100, 14);
		panel_2.add(lblNombre);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(83, 50, 281, 23);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n:");
		lblUbicacin.setBounds(10, 80, 100, 14);
		panel_2.add(lblUbicacin);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(83, 80, 281, 23);
		panel_2.add(textField_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Terminar");
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
