package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
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

	private JDateChooser dateChooser;
	private JComboBox cbxPaisResidencia;
	private JComboBox cbxPaisOrigen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegSolicitante dialog = new RegSolicitante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegSolicitante() {
		setTitle("Registro de Solicitante");
		setResizable(false);
		setBounds(100, 100, 390, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 364, 285);
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

		JComboBox cbxGenero = new JComboBox();
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Masculino", "Femenino" }));
		cbxGenero.setBounds(200, 190, 154, 23);
		panel.add(cbxGenero);

		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(10, 190, 154, 23);
		panel.add(dateChooser);

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 307, 364, 70);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnGraduado = new JRadioButton("Graduado");
		rdbtnGraduado.setBounds(9, 23, 109, 23);
		panel_1.add(rdbtnGraduado);
		
		JRadioButton rdbtnTcnico = new JRadioButton("T\u00E9cnico");
		rdbtnTcnico.setBounds(127, 23, 109, 23);
		panel_1.add(rdbtnTcnico);
		
		JRadioButton rdbtnObrero = new JRadioButton("Obrero");
		rdbtnObrero.setBounds(245, 23, 109, 23);
		panel_1.add(rdbtnObrero);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Graduado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 388, 364, 70);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00C1rea de Estudio:");
		lblNewLabel.setBounds(10, 28, 120, 14);
		panel_2.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 23, 230, 23);
		panel_2.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSiguiente = new JButton("Siguiente");
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
}
