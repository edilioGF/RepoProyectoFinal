package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Controladora;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

public class RlzPerfil extends JDialog {

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
	private JPanel pnlGraduado;
	private JTextField txtFecha;
	private JComboBox cbxIdioma;
	private JSpinner spnExp;
	private JCheckBox cbMudarse;
	private JCheckBox cbLicencia;

	public RlzPerfil() {
		setTitle("Realizar Perfil");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 390, 614);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion del Solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 364, 151);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 23, 59, 14);
		panel.add(lblCdula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(60, 19, 177, 23);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(255, 18, 89, 25);
		panel.add(btnNewButton);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 65, 59, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(60, 62, 284, 23);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApelidos = new JLabel("Apellidos:");
		lblApelidos.setBounds(10, 110, 59, 14);
		panel.add(lblApelidos);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(60, 106, 284, 23);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formaci\u00F3n",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 394, 364, 70);
		contentPanel.add(panel_1);
		
		rdbtnGraduado = new JRadioButton("Graduado");
		rdbtnGraduado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(true,false,false);
			}
		});
		rdbtnGraduado.setSelected(true);
		rdbtnGraduado.setBounds(6, 23, 109, 23);
		panel_1.add(rdbtnGraduado);
		
		rdbtnTecnico = new JRadioButton("T\u00E9cnico");
		rdbtnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(false,true,false);
			}
		});
		rdbtnTecnico.setSelected(false);
		rdbtnTecnico.setBounds(138, 23, 94, 23);
		panel_1.add(rdbtnTecnico);
		
		rdbtnObrero = new JRadioButton("Obrero");
		rdbtnObrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(false,false,true);
			}
		});
		rdbtnObrero.setSelected(false);
		rdbtnObrero.setBounds(258, 23, 89, 23);
		panel_1.add(rdbtnObrero);
		
		pnlTecnico = new JPanel();
		pnlTecnico.setBorder(new TitledBorder(null, "T\u00E9cnico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTecnico.setBounds(10, 475, 364, 70);
		contentPanel.add(pnlTecnico);
		pnlTecnico.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo:");
		lblNewLabel.setBounds(10, 30, 54, 14);
		pnlTecnico.add(lblNewLabel);
		
		cbxTitulo = new JComboBox();
		cbxTitulo.setBounds(74, 27, 230, 20);
		pnlTecnico.add(cbxTitulo);
		
		pnlObrero = new JPanel();
		pnlObrero.setBorder(new TitledBorder(null, "Obrero", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlObrero.setBounds(10, 475, 364, 70);
		contentPanel.add(pnlObrero);
		pnlObrero.setLayout(null);
		
		JLabel lblHabilidad = new JLabel("Habilidad:");
		lblHabilidad.setBounds(10, 30, 73, 14);
		pnlObrero.add(lblHabilidad);
		
		JComboBox cbxHabilidad = new JComboBox();
		cbxHabilidad.setBounds(89, 27, 230, 20);
		pnlObrero.add(cbxHabilidad);
		
		JPanel pnlGraduado = new JPanel();
		pnlGraduado.setBorder(new TitledBorder(null, "Graduado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGraduado.setBounds(10, 475, 364, 70);
		contentPanel.add(pnlGraduado);
		pnlGraduado.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u00C1rea de Estudio:");
		lblNewLabel_1.setBounds(10, 30, 90, 14);
		pnlGraduado.add(lblNewLabel_1);
		
		cbxAestudio = new JComboBox();
		cbxAestudio.setBounds(108, 27, 230, 20);
		pnlGraduado.add(cbxAestudio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Laboral", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 173, 356, 210);
		contentPanel.add(panel_2);
		
		JLabel label_1 = new JLabel("Fecha:");
		label_1.setBounds(10, 21, 53, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Idioma:");
		label_2.setBounds(10, 70, 59, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("A\u00F1os de experiencia:");
		label_3.setBounds(195, 70, 128, 14);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Licencia para conducir");
		label_4.setBounds(10, 140, 135, 14);
		panel_2.add(label_4);
		
		txtFecha = new JTextField();
		txtFecha.setText("27/11/2017 19:28");
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(10, 36, 151, 23);
		panel_2.add(txtFecha);
		
		cbxIdioma = new JComboBox();
		cbxIdioma.setBounds(10, 90, 151, 23);
		panel_2.add(cbxIdioma);
		
		spnExp = new JSpinner();
		spnExp.setBounds(195, 90, 105, 23);
		panel_2.add(spnExp);
		
		cbLicencia = new JCheckBox("");
		cbLicencia.setBounds(169, 136, 20, 23);
		panel_2.add(cbLicencia);
		
		JLabel label_5 = new JLabel("Disposici\u00F3n a mudarse");
		label_5.setBounds(10, 170, 135, 14);
		panel_2.add(label_5);
		
		cbMudarse = new JCheckBox("");
		cbMudarse.setBounds(169, 166, 20, 23);
		panel_2.add(cbMudarse);
		
		JLabel label_6 = new JLabel("A\u00F1os");
		label_6.setBounds(304, 95, 42, 14);
		panel_2.add(label_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadPanel(true,false,false);
		load();
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

		for (String area : Controladora.getMisAreasDeEstudio()) {
			cbxAestudio.addItem(area);
		}

		for (String titulo : Controladora.getMisTitulos()) {
			cbxTitulo.addItem(titulo);
		}

		for (String habilidad : Controladora.getMisHabilidades()) {
			cbxHabilidad.addItem(habilidad);
		}
	}
}
