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
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

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

	public RlzPerfil() {
		setTitle("Realizar Perfil");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 390, 395);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion del Solicitante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 364, 157);
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
		lblNombre.setBounds(10, 69, 59, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(60, 65, 284, 23);
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
		panel_1.setBounds(10, 175, 364, 70);
		contentPanel.add(panel_1);
		
		rdbtnGraduado = new JRadioButton("Graduado");
		rdbtnGraduado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPanel(true,false,false);
			}
		});
		rdbtnGraduado.setSelected(true);
		rdbtnGraduado.setBounds(9, 23, 109, 23);
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
		pnlTecnico.setBounds(10, 253, 364, 70);
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
		pnlObrero.setBounds(10, 253, 364, 70);
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
		pnlGraduado.setBounds(10, 253, 364, 70);
		contentPanel.add(pnlGraduado);
		pnlGraduado.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u00C1rea de Estudio:");
		lblNewLabel_1.setBounds(10, 30, 90, 14);
		pnlGraduado.add(lblNewLabel_1);
		
		cbxAestudio = new JComboBox();
		cbxAestudio.setBounds(108, 27, 230, 20);
		pnlGraduado.add(cbxAestudio);
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
