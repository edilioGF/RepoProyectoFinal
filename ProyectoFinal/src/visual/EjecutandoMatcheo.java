package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.HiloBarra;

import javax.swing.JProgressBar;
import javax.swing.border.EtchedBorder;

import com.sun.glass.ui.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjecutandoMatcheo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JProgressBar progressBar;
	private static JButton btnAceptar;

	/**
	 * Create the dialog.
	 */
	public EjecutandoMatcheo() {
		setTitle("Ejecutando Matcheo");
		setResizable(false);
		setBounds(100, 100, 450, 145);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setBounds(10, 11, 424, 50);
		contentPanel.add(progressBar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 72, 444, 44);
		contentPanel.add(panel);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setEnabled(false);
		panel.add(btnAceptar);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		load();
	}
	
	private void load() {
		// TODO Auto-generated method stub
		HiloBarra hilo = new HiloBarra();
		hilo.start();
	}

	public static void loadBar(int value)
	{
		progressBar.setStringPainted(true);
		progressBar.setValue(value);
		progressBar.setString(value + "%");
		
		if(value == 100)
		{
			progressBar.setString("Listo");
			btnAceptar.setEnabled(true);
		}
	}
}
