package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 458);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		menuBar.add(mnRegistrar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Empresa");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEmpresa re = new RegEmpresa();
				re.setVisible(true);
			}
		});
		mnRegistrar.add(mntmNewMenuItem);
		
		JMenuItem mntmEmpleo = new JMenuItem("Empleo\r\n");
		mntmEmpleo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnRegistrar.add(mntmEmpleo);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Solicitante");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegSolicitante rs = new RegSolicitante();
				rs.setVisible(true);
			}
		});
		mnRegistrar.add(mntmNewMenuItem_1);
		
		JMenu mnRealizar = new JMenu("Realizar");
		menuBar.add(mnRealizar);
		
		JMenuItem mntmSolicitud = new JMenuItem("Solicitud");
		mntmSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RlzSolicitud rzs = new RlzSolicitud();
				rzs.setVisible(true);
			}
		});
		mnRealizar.add(mntmSolicitud);
		
		JMenu mnListado = new JMenu("Listado");
		menuBar.add(mnListado);
		
		JMenuItem mntmEmpleos = new JMenuItem("Empleos");
		mntmEmpleos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListEmpleo le = new ListEmpleo();
				le.setVisible(true);
			}
		});
		mnListado.add(mntmEmpleos);
		
		JMenuItem mntmSolicitantes = new JMenuItem("Solicitantes");
		mntmSolicitantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListSolicitante ls = new ListSolicitante();
				ls.setVisible(true);
			}
		});
		mnListado.add(mntmSolicitantes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
