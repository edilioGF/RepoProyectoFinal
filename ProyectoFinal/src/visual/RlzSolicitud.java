package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Controladora;
import logico.Empleo;
import logico.Solicitante;
import logico.Solicitud;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;

public class RlzSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtFecha;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JComboBox cbxIdioma;
	private JSpinner spnExp;
	private JCheckBox cbLicenc;
	private JCheckBox cbMudarse;
	private Solicitud solicitud;
	private Solicitante solicitante;

	/**
	 * Create the dialog.
	 */
	public RlzSolicitud(Empleo empleo, Solicitante solicitante2) {
		setResizable(false);
		setModal(true);
		setTitle("Realizar Solicitud");
		setBounds(100, 100, 379, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 356, 210);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 20, 59, 14);
		panel.add(lblCdigo);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(195, 20, 53, 14);
		panel.add(lblFecha);

		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(10, 70, 59, 14);
		panel.add(lblIdioma);

		JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de experiencia:");
		lblAosDeExperiencia.setBounds(195, 70, 128, 14);
		panel.add(lblAosDeExperiencia);

		JLabel lblLicenciaParaConducir = new JLabel("Licencia para conducir");
		lblLicenciaParaConducir.setBounds(10, 140, 135, 14);
		panel.add(lblLicenciaParaConducir);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(10, 40, 151, 23);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(195, 40, 151, 23);
		panel.add(txtFecha);
		txtFecha.setColumns(10);

		cbxIdioma = new JComboBox();
		cbxIdioma.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>" }));
		cbxIdioma.setBounds(10, 90, 151, 23);
		panel.add(cbxIdioma);

		spnExp = new JSpinner();
		spnExp.setBounds(195, 90, 105, 23);
		panel.add(spnExp);

		cbLicenc = new JCheckBox("");
		cbLicenc.setBounds(169, 136, 20, 23);
		panel.add(cbLicenc);

		JLabel lblDisposicinAMudarse = new JLabel("Disposici\u00F3n a mudarse");
		lblDisposicinAMudarse.setBounds(10, 170, 135, 14);
		panel.add(lblDisposicinAMudarse);

		cbMudarse = new JCheckBox("");
		cbMudarse.setBounds(169, 166, 20, 23);
		panel.add(cbMudarse);

		JLabel lblAos = new JLabel("A\u00F1os");
		lblAos.setBounds(304, 95, 42, 14);
		panel.add(lblAos);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n del Solicitante", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 232, 353, 195);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00E9dula:");
		lblNewLabel.setBounds(10, 20, 46, 14);
		panel_1.add(lblNewLabel);

		txtCedula = new JTextField();
		txtCedula.setBounds(10, 40, 209, 23);
		panel_1.add(txtCedula);
		txtCedula.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cedula = txtCedula.getText();
				solicitante = Controladora.getInstance().buscarSolicitante(cedula);
				txtNombre.setText(solicitante.getNombre());
				txtApellido.setText(solicitante.getApellidos());
			}
		});
		btnBuscar.setBounds(229, 39, 114, 25);
		panel_1.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 70, 58, 14);
		panel_1.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(10, 90, 333, 23);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setBounds(10, 120, 58, 14);
		panel_1.add(lblNewLabel_1);

		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBounds(10, 140, 333, 23);
		panel_1.add(txtApellido);
		txtApellido.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Terminar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (solicitante == null && solicitante2 == null) {
							JOptionPane.showMessageDialog(null, "Debe elegir un Solicitante");

						} else {
							String codigo = txtCodigo.getText();
							String idioma = cbxIdioma.getSelectedItem().toString();
							boolean licencia = cbLicenc.isSelected();
							boolean mudarse = cbMudarse.isSelected();
							int experiencia = Integer.valueOf(spnExp.getValue().toString());
							if (solicitante2 == null) {
								solicitud = new Solicitud(codigo, solicitante, idioma, licencia, mudarse, experiencia);
								empleo.getMisSolicitudes().add(solicitud);
								Controladora.getInstance().getMisSolicitudes().add(solicitud);

							} else {
								solicitud = new Solicitud(codigo, solicitante2, idioma, licencia, mudarse, experiencia);
								empleo.getMisSolicitudes().add(solicitud);
								Controladora.getInstance().getMisSolicitantes().add(solicitante2);
								Controladora.getInstance().getMisSolicitudes().add(solicitud);
							}
							JOptionPane.showMessageDialog(null, "La solicitud se ha realizado satisfactorimente");
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
		load();

		if (solicitante2 != null) {
			btnBuscar.setEnabled(false);
			txtCedula.setText(solicitante2.getCedula());
			txtCedula.setEditable(false);
			txtNombre.setText(solicitante2.getNombre());
			txtNombre.setEditable(false);
			txtApellido.setText(solicitante2.getApellidos());
			txtApellido.setEditable(false);
		}
	}

	private void load() {
		txtCodigo.setText("SOLI-" + (Controladora.getInstance().getMisSolicitudes().size() + 1));

		Date date = new Date();
		String str = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date);
		txtFecha.setText(str);
	}
}
