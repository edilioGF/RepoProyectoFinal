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

import logico.Controladora;
import logico.Solicitante;
import sun.applet.Main;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	private static JPanel pnlPastelSolicitantes;
	private static JPanel pnlPastelEmpleos;
	private static JTextField txtSolicitantes;
	private static JTextField txtSolicitudes;
	private static JTextField txtEmpresas;
	private static JTextField txtEmpleos;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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

		JMenuItem mntmPerfil = new JMenuItem("Solicitud");
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegPerfil perfil = new RegPerfil(null);
				perfil.setModal(true);
				perfil.setVisible(true);
			}
		});
		mnRegistrar.add(mntmPerfil);

		JMenu mnListado = new JMenu("Listar");
		menuBar.add(mnListado);

		JMenuItem mntmEmpleos = new JMenuItem("Empleos");
		mntmEmpleos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Solicitante solicitante = null;
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

		JMenuItem mntmSolicitudes = new JMenuItem("Solicitudes");
		mntmSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListSolicitud ls = new ListSolicitud();
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
		pnlPastelSolicitantes.setBounds(170, 58, 490, 240);
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

		JLabel lblSolicitudes = new JLabel("Solicitudes:");
		lblSolicitudes.setBounds(50, 86, 100, 14);
		pnlTotal.add(lblSolicitudes);

		txtSolicitudes = new JTextField();
		txtSolicitudes.setForeground(Color.BLUE);
		txtSolicitudes.setText("0");
		txtSolicitudes.setHorizontalAlignment(SwingConstants.CENTER);
		txtSolicitudes.setEditable(false);
		txtSolicitudes.setColumns(10);
		txtSolicitudes.setBounds(150, 82, 86, 23);
		pnlTotal.add(txtSolicitudes);

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
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u00C1reas Populares", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(765, 320, 300, 240);
		panel_1.add(panel_2);
		
		JLabel lblArea = new JLabel("Area1:");
		lblArea.setBounds(25, 28, 145, 14);
		panel_2.add(lblArea);
		
		JLabel lblArea_1 = new JLabel("Area2:");
		lblArea_1.setBounds(25, 70, 145, 14);
		panel_2.add(lblArea_1);
		
		JLabel lblArea_2 = new JLabel("Area3:");
		lblArea_2.setBounds(25, 112, 145, 14);
		panel_2.add(lblArea_2);
		
		JLabel lblArea_3 = new JLabel("Area4:");
		lblArea_3.setBounds(25, 154, 145, 14);
		panel_2.add(lblArea_3);
		
		JLabel lblArea_4 = new JLabel("Area5:");
		lblArea_4.setBounds(25, 196, 145, 14);
		panel_2.add(lblArea_4);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLUE);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(150, 24, 86, 23);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.BLUE);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(150, 66, 86, 23);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.BLUE);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(150, 108, 86, 23);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.BLUE);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(150, 150, 86, 23);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.BLUE);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(150, 192, 86, 23);
		panel_2.add(textField_4);

		// Stats hS = new Stats();
		// hS.start();
		loadStats();
	}

	public static void loadStats() {
		//pnlPastel.removeAll();
		//pnlBarras.removeAll();

		// TODO Auto-generated method stub
		// txtSolicitantes.setText(String.format("%d",
		// Controladora.getInstance().getMisSolicitantes().size()));
		// txtSolicitudes.setText(String.format("%d",
		// Controladora.getInstance().getMisSolicitudes().size()));
		txtEmpresas.setText(String.format("%d", Controladora.getInstance().getMisEmpresas().size()));
		txtEmpleos.setText(String.format("%d", Controladora.getInstance().getMisEmpleos().size()));

		// create a dataset...
		DefaultPieDataset dataPastel = new DefaultPieDataset();
		// dataPastel.setValue("Mujeres",
		// Controladora.getInstance().contarHombresMujeres()[0]);
		// dataPastel.setValue("Hombres",
		// Controladora.getInstance().contarHombresMujeres()[1]);

		DefaultCategoryDataset dataBarras = new DefaultCategoryDataset();
		dataBarras.setValue(8, "Matches", "23/11/2017");
		dataBarras.setValue(2, "Matches", "24/11/2017");
		dataBarras.setValue(5, "Matches", "25/11/2017");

		// create a chart...
		JFreeChart pastel = ChartFactory.createPieChart("Solicitantes", dataPastel, true, // legend?
				true, // tooltips?
				false // URLs?
		);

		pastel.setBackgroundPaint(new Color(0, 0, 0, 0));

		JFreeChart barras = ChartFactory.createBarChart("Matching", "Días", "Matches", dataBarras,
				PlotOrientation.VERTICAL, false, true, false);

		barras.setBackgroundPaint(new Color(0, 0, 0, 0));

		ChartPanel chartPastel = new ChartPanel(pastel, 480, 230, 480, 230, 480, 230, true, true, true, true, true,
				true);

		//ChartPanel chartBarras = new ChartPanel(barras, 480, 230, 480, 230, 480, 230, true, true, false, false, false,
				//true);

		//pnlPastel.add(chartPastel, BorderLayout.CENTER);
		//pnlPastel.validate();

		//pnlBarras.add(chartBarras, BorderLayout.CENTER);
		//pnlBarras.validate();

	}
}
