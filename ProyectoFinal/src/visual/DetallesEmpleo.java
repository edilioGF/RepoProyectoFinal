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

public class DetallesEmpleo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField txtTitulo;
	private JTextField txtSalario;
	private JTextField txtHorario;
	private JTextField txtRemoto;
	private JTextField txtLicencia;
	private JTextArea txtaDescripcion;

	
	public DetallesEmpleo(Empleo empleo) {
		setTitle("Detalles de Empleo");
		setType(Type.UTILITY);
		setBounds(100, 100, 480, 411);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 444, 317);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblCdigo = new JLabel("C\u00F3digo:");
				lblCdigo.setBounds(10, 24, 46, 14);
				panel.add(lblCdigo);
			}
			
			JLabel lblTi = new JLabel("T\u00EDtulo:");
			lblTi.setBounds(10, 65, 46, 14);
			panel.add(lblTi);
			
			JLabel lblNewLabel = new JLabel("Descripci\u00F3n:");
			lblNewLabel.setBounds(10, 107, 86, 14);
			panel.add(lblNewLabel);
			
		    txtaDescripcion = new JTextArea();
			txtaDescripcion.setEditable(false);
			txtaDescripcion.setBounds(92, 102, 342, 52);
			panel.add(txtaDescripcion);
			
			JLabel lblSalario = new JLabel("Salario:");
			lblSalario.setBounds(10, 171, 58, 14);
			panel.add(lblSalario);
			
			JLabel lblHorario = new JLabel("Horario:");
			lblHorario.setBounds(10, 207, 58, 14);
			panel.add(lblHorario);
			
			JLabel lblRemoto = new JLabel("Remoto:");
			lblRemoto.setBounds(10, 245, 58, 14);
			panel.add(lblRemoto);
			
			JLabel lblNewLabel_1 = new JLabel("Licencia:");
			lblNewLabel_1.setBounds(10, 281, 58, 14);
			panel.add(lblNewLabel_1);
			
			textCodigo = new JTextField();
			textCodigo.setEditable(false);
			textCodigo.setBounds(92, 20, 149, 23);
			panel.add(textCodigo);
			textCodigo.setColumns(10);
			
			txtTitulo = new JTextField();
			txtTitulo.setEditable(false);
			txtTitulo.setBounds(92, 62, 342, 23);
			panel.add(txtTitulo);
			txtTitulo.setColumns(10);
			
			txtSalario = new JTextField();
			txtSalario.setEditable(false);
			txtSalario.setBounds(92, 167, 195, 23);
			panel.add(txtSalario);
			txtSalario.setColumns(10);
			
			txtHorario = new JTextField();
			txtHorario.setEditable(false);
			txtHorario.setBounds(92, 203, 195, 23);
			panel.add(txtHorario);
			txtHorario.setColumns(10);
			
			txtRemoto = new JTextField();
			txtRemoto.setEditable(false);
			txtRemoto.setHorizontalAlignment(SwingConstants.CENTER);
			txtRemoto.setBounds(92, 241, 86, 23);
			panel.add(txtRemoto);
			txtRemoto.setColumns(10);
			
			txtLicencia = new JTextField();
			txtLicencia.setEditable(false);
			txtLicencia.setHorizontalAlignment(SwingConstants.CENTER);
			txtLicencia.setBounds(92, 277, 86, 23);
			panel.add(txtLicencia);
			txtLicencia.setColumns(10);
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
		loadData(empleo);
	}
	
	public void loadData(Empleo empleo){
		//textCodigo.setText(empleo.getCodigo());
		txtTitulo.setText(empleo.getTitulo());
		txtaDescripcion.setText(empleo.getDescripcion());
		txtHorario.setText(empleo.getHoraInicial()+"-"+empleo.getHoraFinal());
		txtSalario.setText(String.format("$%.2f", empleo.getSalario()));
		
		if(empleo.isRemoto()){
			txtRemoto.setText("Si");
		}
		else{
			txtRemoto.setText("No");
		}
		
		if(empleo.isLicencia()){
			txtLicencia.setText("Si");
		}
		else{
			txtLicencia.setText("No");
		}
	
		
	}
}
