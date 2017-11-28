package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;

import logico.Empleo;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class DetallesEmpleo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTitulo;
	private JTextField txtSalario;
	private JTextField txtHorario;
	private JTextField txtRemoto;
	private JTextField txtLicencia;
	private JTextArea txtDescripcion;

	public DetallesEmpleo(Empleo empleo) {
		setTitle("Detalles de Empleo");
		setType(Type.UTILITY);
		setBounds(100, 100, 480, 395);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP,
					null, null));
			panel.setBounds(10, 11, 444, 301);
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblTi = new JLabel("T\u00EDtulo:");
			lblTi.setBounds(10, 20, 46, 14);
			panel.add(lblTi);

			JLabel lblNewLabel = new JLabel("Descripci\u00F3n:");
			lblNewLabel.setBounds(10, 60, 86, 14);
			panel.add(lblNewLabel);

			txtDescripcion = new JTextArea();
			txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtDescripcion.setOpaque(false);
			txtDescripcion.setEditable(false);
			txtDescripcion.setBounds(92, 59, 342, 55);
			panel.add(txtDescripcion);

			JLabel lblSalario = new JLabel("Salario:");
			lblSalario.setBounds(10, 135, 58, 14);
			panel.add(lblSalario);

			JLabel lblHorario = new JLabel("Horario:");
			lblHorario.setBounds(10, 175, 58, 14);
			panel.add(lblHorario);

			JLabel lblRemoto = new JLabel("Remoto:");
			lblRemoto.setBounds(10, 215, 58, 14);
			panel.add(lblRemoto);

			JLabel lblNewLabel_1 = new JLabel("Licencia:");
			lblNewLabel_1.setBounds(10, 255, 58, 14);
			panel.add(lblNewLabel_1);

			txtTitulo = new JTextField();
			txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			txtTitulo.setEditable(false);
			txtTitulo.setBounds(92, 20, 342, 23);
			panel.add(txtTitulo);
			txtTitulo.setColumns(10);

			txtSalario = new JTextField();
			txtSalario.setHorizontalAlignment(SwingConstants.CENTER);
			txtSalario.setEditable(false);
			txtSalario.setBounds(92, 131, 195, 23);
			panel.add(txtSalario);
			txtSalario.setColumns(10);

			txtHorario = new JTextField();
			txtHorario.setHorizontalAlignment(SwingConstants.CENTER);
			txtHorario.setEditable(false);
			txtHorario.setBounds(92, 171, 195, 23);
			panel.add(txtHorario);
			txtHorario.setColumns(10);

			txtRemoto = new JTextField();
			txtRemoto.setEditable(false);
			txtRemoto.setHorizontalAlignment(SwingConstants.CENTER);
			txtRemoto.setBounds(92, 211, 86, 23);
			panel.add(txtRemoto);
			txtRemoto.setColumns(10);

			txtLicencia = new JTextField();
			txtLicencia.setEditable(false);
			txtLicencia.setHorizontalAlignment(SwingConstants.CENTER);
			txtLicencia.setBounds(92, 251, 86, 23);
			panel.add(txtLicencia);
			txtLicencia.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		loadData(empleo);
	}

	public void loadData(Empleo empleo) {
		// textCodigo.setText(empleo.getCodigo());
		txtTitulo.setText(empleo.getTitulo());
		txtDescripcion.setText(empleo.getDescripcion());
		txtHorario.setText(empleo.getHoraInicial() + "-" + empleo.getHoraFinal());
		txtSalario.setText(String.format("$%.2f", empleo.getSalario()));

		if (empleo.isRemoto()) {
			txtRemoto.setText("Si");
		} else {
			txtRemoto.setText("No");
		}

		if (empleo.isLicencia()) {
			txtLicencia.setText("Si");
		} else {
			txtLicencia.setText("No");
		}

	}
}
