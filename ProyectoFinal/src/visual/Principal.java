package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Paint;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javafx.scene.layout.Border;
import logico.Controladora;
import logico.Solicitante;
import sun.applet.Main;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	private static JPanel pnlPastelPerfiles;
	private static JPanel pnlPastelSolicitantes;
	private static JPanel pnlPastelEmpleos;
	private static JTextField txtSolicitantes;
	private static JTextField txtPerfiles;
	private static JTextField txtEmpresas;
	private static JTextField txtEmpleos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controladora.getInstance().loadData();
					Principal frame = new Principal();
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							try {
								Controladora.getInstance().saveData();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							System.exit(0);
						}
					});
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
		URL url = Main.class.getResource("/icon.png");
		ImageIcon icon = new ImageIcon(url);
		setIconImage(icon.getImage());

		setTitle("BOLSA DE EMPLEOS");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 458);

		// Dimensiones
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height - 50);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnRegistrar = new JMenu("Registrar");
		menuBar.add(mnRegistrar);

		JMenuItem mntmNewMenuItem = new JMenuItem("Empresa");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEmpresa re = new RegEmpresa();
				re.setModal(true);
				re.setVisible(true);
			}
		});
		mnRegistrar.add(mntmNewMenuItem);

		JMenuItem mntmEmpleo = new JMenuItem("Empleo\r\n");
		mntmEmpleo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEmpleo re = new RegEmpleo(null);
				re.setModal(true);
				re.setVisible(true);
			}
		});
		mnRegistrar.add(mntmEmpleo);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Solicitante");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegSolicitante rs = new RegSolicitante();
				rs.setModal(true);
				rs.setVisible(true);
			}
		});
		mnRegistrar.add(mntmNewMenuItem_1);

		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegPerfil perfil = new RegPerfil(null);
				perfil.setModal(true);
				perfil.setVisible(true);
			}
		});
		mnRegistrar.add(mntmPerfil);

		JMenu mnMatch = new JMenu("Match");
		menuBar.add(mnMatch);

		JMenuItem mntmEjecutar = new JMenuItem("Ejecutar");
		mntmEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Controladora.getInstance().verificarEmpleos() && Controladora.getInstance().verificarPerfiles()) {
					EjecutandoMatcheo em = new EjecutandoMatcheo();
					em.setModal(true);
					em.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "No es necesario ejecutar el proceso de matcheo", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		mnMatch.add(mntmEjecutar);

		JMenu mnListado = new JMenu("Listar");
		menuBar.add(mnListado);

		JMenuItem mntmEmpleos = new JMenuItem("Empleos");
		mntmEmpleos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListEmpleo le = new ListEmpleo(null);
				le.setModal(true);
				le.setVisible(true);
			}
		});

		JMenuItem mntmEmpresas = new JMenuItem("Empresas");
		mntmEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListEmpresa le = new ListEmpresa();
				le.setModal(true);
				le.setVisible(true);
			}
		});
		mnListado.add(mntmEmpresas);
		mnListado.add(mntmEmpleos);

		JMenuItem mntmSolicitantes = new JMenuItem("Solicitantes");
		mntmSolicitantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListSolicitante ls = new ListSolicitante();
				ls.setModal(true);
				ls.setVisible(true);
			}
		});
		mnListado.add(mntmSolicitantes);

		JMenuItem mntmSolicitudes = new JMenuItem("Perfiles");
		mntmSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPerfil ls = new ListPerfil();
				ls.setModal(true);
				ls.setVisible(true);
			}
		});
		mnListado.add(mntmSolicitudes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 638, 1360, 30);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Resumen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 1340, 616);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(170, 307, 1000, 2);
		panel_1.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(669, 58, 1, 500);
		panel_1.add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);

		pnlPastelSolicitantes = new JPanel();
		pnlPastelSolicitantes.setBounds(680, 320, 490, 240);
		panel_1.add(pnlPastelSolicitantes);

		pnlPastelEmpleos = new JPanel();
		pnlPastelEmpleos.setBounds(680, 58, 490, 238);
		panel_1.add(pnlPastelEmpleos);

		JPanel pnlTotal = new JPanel();
		pnlTotal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Total", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTotal.setBounds(275, 318, 300, 240);
		panel_1.add(pnlTotal);
		pnlTotal.setLayout(null);

		JLabel lblSolicitantes = new JLabel("Solicitantes:");
		lblSolicitantes.setBounds(50, 36, 100, 14);
		pnlTotal.add(lblSolicitantes);

		txtSolicitantes = new JTextField();
		txtSolicitantes.setForeground(Color.BLUE);
		txtSolicitantes.setHorizontalAlignment(SwingConstants.CENTER);
		txtSolicitantes.setText("0");
		txtSolicitantes.setEditable(false);
		txtSolicitantes.setBounds(150, 32, 86, 23);
		pnlTotal.add(txtSolicitantes);
		txtSolicitantes.setColumns(10);

		JLabel lblSolicitudes = new JLabel("Perfiles:");
		lblSolicitudes.setBounds(50, 86, 100, 14);
		pnlTotal.add(lblSolicitudes);

		txtPerfiles = new JTextField();
		txtPerfiles.setForeground(Color.BLUE);
		txtPerfiles.setText("0");
		txtPerfiles.setHorizontalAlignment(SwingConstants.CENTER);
		txtPerfiles.setEditable(false);
		txtPerfiles.setColumns(10);
		txtPerfiles.setBounds(150, 82, 86, 23);
		pnlTotal.add(txtPerfiles);

		JLabel lblEmpresas = new JLabel("Empresas:");
		lblEmpresas.setBounds(50, 136, 100, 14);
		pnlTotal.add(lblEmpresas);

		txtEmpresas = new JTextField();
		txtEmpresas.setForeground(Color.BLUE);
		txtEmpresas.setText("0");
		txtEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmpresas.setEditable(false);
		txtEmpresas.setColumns(10);
		txtEmpresas.setBounds(150, 132, 86, 23);
		pnlTotal.add(txtEmpresas);

		JLabel lblEmpleos = new JLabel("Empleos:");
		lblEmpleos.setBounds(50, 186, 100, 14);
		pnlTotal.add(lblEmpleos);

		txtEmpleos = new JTextField();
		txtEmpleos.setForeground(Color.BLUE);
		txtEmpleos.setText("0");
		txtEmpleos.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmpleos.setEditable(false);
		txtEmpleos.setColumns(10);
		txtEmpleos.setBounds(150, 182, 86, 23);
		pnlTotal.add(txtEmpleos);

		pnlPastelPerfiles = new JPanel();
		pnlPastelPerfiles.setBounds(170, 58, 489, 238);
		panel_1.add(pnlPastelPerfiles);

		loadStats();
	}

	public static void loadStats() {
		pnlPastelPerfiles.removeAll();
		pnlPastelSolicitantes.removeAll();
		pnlPastelEmpleos.removeAll();

		txtSolicitantes.setText(String.format("%d", Controladora.getInstance().getMisSolicitantes().size()));
		txtPerfiles.setText(String.format("%d", Controladora.getInstance().getMisPerfiles().size()));
		txtEmpresas.setText(String.format("%d", Controladora.getInstance().getMisEmpresas().size()));
		txtEmpleos.setText(String.format("%d", Controladora.getInstance().getMisEmpleos().size()));

		// create a dataset...
		DefaultPieDataset dataPastelSolicitantes = new DefaultPieDataset();
		dataPastelSolicitantes.setValue("Mujeres", Controladora.getInstance().contarHombresMujeres()[0]);
		dataPastelSolicitantes.setValue("Hombres", Controladora.getInstance().contarHombresMujeres()[1]);
		// create a chart...
		JFreeChart pastelSolicitantes = ChartFactory.createPieChart("Solicitantes (Género)", dataPastelSolicitantes,
				true, // legend?
				true, // tooltips?
				false // URLs?
		);
		pastelSolicitantes.setBackgroundPaint(new Color(0, 0, 0, 0));
		ChartPanel chartPastelSolicitantes = new ChartPanel(pastelSolicitantes, 480, 230, 480, 230, 480, 230, true,
				true, true, true, true, true);

		DefaultPieDataset dataPastelEmpleos = new DefaultPieDataset();
		dataPastelEmpleos.setValue("Graduados", Controladora.getInstance().contarDemanda()[0]);
		dataPastelEmpleos.setValue("Técnicos", Controladora.getInstance().contarDemanda()[1]);
		dataPastelEmpleos.setValue("Obreros", Controladora.getInstance().contarDemanda()[2]);

		JFreeChart pastelEmpleos = ChartFactory.createPieChart("Empleos (Demanda)", dataPastelEmpleos, true, true,
				false);
		pastelEmpleos.setBackgroundPaint(new Color(0, 0, 0, 0));
		ChartPanel chartPastelEmpleos = new ChartPanel(pastelEmpleos, 480, 230, 480, 230, 480, 230, true, true, true,
				true, true, true);

		DefaultPieDataset dataPastelPerfiles = new DefaultPieDataset();
		dataPastelPerfiles.setValue("Graduados", Controladora.getInstance().contarOferta()[0]);
		dataPastelPerfiles.setValue("Técnicos", Controladora.getInstance().contarOferta()[1]);
		dataPastelPerfiles.setValue("Obreros", Controladora.getInstance().contarOferta()[2]);
		JFreeChart pastelPerfiles = ChartFactory.createPieChart("Perfiles (Oferta)", dataPastelPerfiles, true, true,
				false);
		pastelPerfiles.setBackgroundPaint(new Color(0, 0, 0, 0));
		ChartPanel chartPastelPerfiles = new ChartPanel(pastelPerfiles, 480, 230, 480, 230, 480, 230, true, true, true,
				true, true, true);

		pnlPastelPerfiles.add(chartPastelPerfiles, BorderLayout.CENTER);
		pnlPastelPerfiles.validate();

		pnlPastelSolicitantes.add(chartPastelSolicitantes, BorderLayout.CENTER);
		pnlPastelSolicitantes.validate();

		pnlPastelEmpleos.add(chartPastelEmpleos, BorderLayout.CENTER);
		pnlPastelEmpleos.validate();
	}
}
