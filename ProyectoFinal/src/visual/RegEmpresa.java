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
import javax.swing.border.EtchedBorder;

public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRnc;
	private JTextField txtNombre;
	private JComboBox cbxUbicacion;
	private JComboBox cbxTipo;

	public RegEmpresa(Empresa empr) {
		setResizable(false);
		if (empr == null) {
			setTitle("Registro de Empresa");
		} else {
			setTitle("Modificación de Empresa");
		}
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

		JLabel lblCdigo = new JLabel("RNC:");
		lblCdigo.setBounds(10, 20, 46, 14);
		panel.add(lblCdigo);

		txtRnc = new JTextField();
		txtRnc.setBounds(10, 40, 130, 20);
		panel.add(txtRnc);
		txtRnc.setColumns(10);

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
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
			    JButton okButton = new JButton("Siguiente");
			    if(empr != null){
			    	okButton.setText("Modificar");
			    }
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

						String codigo = txtRnc.getText();
						String nombre = txtNombre.getText();
						String ubicacion = cbxUbicacion.getSelectedItem().toString();
						String tipo = cbxTipo.getSelectedItem().toString();
						if (codigo.isEmpty() || nombre.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Le falto campos por completar", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if (empr == null) {
							Empresa empresa = new Empresa(codigo, nombre, ubicacion, tipo);
							dispose();
							RegEmpleo re = new RegEmpleo(empresa);
							re.setModal(true);
							re.setVisible(true);
						} else {
							empr.setNombre(nombre);
							empr.setRnc(codigo);
							empr.setUbicacion(ubicacion);
							empr.setTipo(tipo);
							ListEmpresa.loadTable("<Todos>");
							JOptionPane.showMessageDialog(null, "Se ha realizado la modificación", "Información",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
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
		if (empr != null) {
			loadEmpresa(empr);
		}
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

	private void loadEmpresa(Empresa empr) {
		int i = 0;
		txtRnc.setText(empr.getRnc());
		txtNombre.setText(empr.getNombre());
		for (i = 0; i < cbxUbicacion.getItemCount(); i++) {
			if (cbxUbicacion.getItemAt(i).toString().equalsIgnoreCase(empr.getUbicacion())) {
				cbxUbicacion.setSelectedIndex(i);
			}
		}
		for (i = 0; i < cbxTipo.getItemCount(); i++) {
			if (cbxTipo.getItemAt(i).toString().equalsIgnoreCase(empr.getTipo())) {
				cbxTipo.setSelectedIndex(i);
			}
		}

	}

	private void clean() {
		txtNombre.setText("");
		txtRnc.setText("");
		cbxUbicacion.setSelectedIndex(-1);
		cbxTipo.setSelectedIndex(-1);
		;

	}
}
