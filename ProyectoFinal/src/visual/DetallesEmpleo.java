package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetallesEmpleo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	public DetallesEmpleo() {
		setTitle("Detalles de Empleo");
		setType(Type.UTILITY);
		setBounds(100, 100, 307, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 271, 267);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblCdigo = new JLabel("C\u00F3digo:");
				lblCdigo.setBounds(10, 24, 46, 14);
				panel.add(lblCdigo);
			}
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(73, 19, 92, 22);
			panel.add(textArea);
			
			JLabel lblTi = new JLabel("T\u00EDtulo:");
			lblTi.setBounds(10, 54, 46, 14);
			panel.add(lblTi);
			
			JTextArea textArea_1 = new JTextArea();
			textArea_1.setBounds(73, 49, 163, 22);
			panel.add(textArea_1);
			
			JLabel lblNewLabel = new JLabel("Descripci\u00F3n:");
			lblNewLabel.setBounds(10, 84, 77, 14);
			panel.add(lblNewLabel);
			
			JTextArea textArea_2 = new JTextArea();
			textArea_2.setBounds(73, 79, 163, 52);
			panel.add(textArea_2);
			
			JLabel lblSalario = new JLabel("Salario:");
			lblSalario.setBounds(10, 144, 46, 14);
			panel.add(lblSalario);
			
			JTextArea textArea_3 = new JTextArea();
			textArea_3.setBounds(73, 139, 163, 22);
			panel.add(textArea_3);
			
			JLabel lblHorario = new JLabel("Horario:");
			lblHorario.setBounds(10, 174, 46, 14);
			panel.add(lblHorario);
			
			JTextArea textArea_4 = new JTextArea();
			textArea_4.setBounds(73, 169, 163, 22);
			panel.add(textArea_4);
			
			JLabel lblRemoto = new JLabel("Remoto:");
			lblRemoto.setBounds(10, 204, 46, 14);
			panel.add(lblRemoto);
			
			JTextArea textArea_5 = new JTextArea();
			textArea_5.setText("");
			textArea_5.setBounds(73, 199, 92, 22);
			panel.add(textArea_5);
			
			JLabel lblNewLabel_1 = new JLabel("Licencia:");
			lblNewLabel_1.setBounds(10, 229, 58, 14);
			panel.add(lblNewLabel_1);
			
			JTextArea textArea_6 = new JTextArea();
			textArea_6.setText("");
			textArea_6.setBounds(73, 229, 92, 22);
			panel.add(textArea_6);
		}
		{
			JPanel buttonPane = new JPanel();
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
	}
}
