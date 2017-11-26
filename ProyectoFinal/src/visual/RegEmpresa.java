package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;

import logico.Controladora;
import logico.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JComboBox cbxUbicacion;
	private JComboBox cbxTipo;

	public RegEmpresa() {
		setResizable(false);
		setTitle("Registro de Empresa");
		setBounds(100, 100, 307, 325);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 281, 241);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 20, 46, 14);
		panel.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 40, 130, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 70, 61, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 90, 261, 23);
		panel.add(txtNombre);

		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n:");
		lblUbicacin.setBounds(10, 120, 61, 14);
		panel.add(lblUbicacin);

		cbxUbicacion = new JComboBox();
		cbxUbicacion.setBounds(10, 140, 261, 23);
		panel.add(cbxUbicacion);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 170, 46, 14);
		panel.add(lblTipo);

		cbxTipo = new JComboBox();
		cbxTipo.setBounds(10, 190, 261, 23);
		panel.add(cbxTipo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cbxUbicacion.getSelectedIndex() <= 0) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar una ubicación", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (cbxTipo.getSelectedIndex() <= 0) {
							JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}

						String codigo = txtCodigo.getText();
						String nombre = txtNombre.getText();
						String ubicacion = cbxUbicacion.getSelectedItem().toString();
						String tipo = cbxTipo.getSelectedItem().toString();
						Empresa empresa = new Empresa(codigo, nombre, ubicacion, tipo);
						dispose();
						RegEmpleo re = new RegEmpleo(empresa);
						re.setModal(true);
						re.setVisible(true);
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
	}

	private void load() {
		String[] locales = Locale.getISOCountries();

		cbxUbicacion.addItem("<Seleccione>");

		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);

			cbxUbicacion.addItem(obj.getDisplayCountry());
		}

		cbxTipo.addItem("<Seleccione>");
		for (String tipo : Controladora.getMisTiposDeEmpresa()) {
			cbxTipo.addItem(tipo);
		}
	}

	private void clean() {
		txtNombre.setText("");
		txtCodigo.setText("");
		cbxUbicacion.setSelectedIndex(-1);
		cbxTipo.setSelectedIndex(-1);
		;

	}
}
