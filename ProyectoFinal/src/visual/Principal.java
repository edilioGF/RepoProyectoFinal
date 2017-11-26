package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Paint;

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

import hilo.Stats;
import logico.Controladora;
import logico.Solicitante;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
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

	private static JPanel pnlPastel;
	private static JPanel pnlBarras;
	private JTextField textField;
	private JTextField textField_1;
	private static JTextField txtEmpresas;
	private static JTextField txtEmpleos;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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

		JMenu mnRealizar = new JMenu("Realizar");
		menuBar.add(mnRealizar);

		JMenuItem mntmSolicitud = new JMenuItem("Solicitud");
		mntmSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListEmpleo le = new ListEmpleo(null);
				le.setModal(true);
				le.setVisible(true);
			}
		});
		mnRealizar.add(mntmSolicitud);

		JMenu mnListado = new JMenu("Listado");
		menuBar.add(mnListado);

		JMenuItem mntmEmpleos = new JMenuItem("Empleos");
		mntmEmpleos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Solicitante solicitante = null;
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
			public void actionPerformed(ActionEvent e) {
				ListSolicitante ls = new ListSolicitante();
				ls.setModal(true);
				ls.setVisible(true);
			}
		});
		mnListado.add(mntmSolicitantes);

		JMenuItem mntmSolicitudes = new JMenuItem("Solicitudes");
		mntmSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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

		pnlPastel = new JPanel();
		pnlPastel.setBounds(170, 58, 490, 240);
		panel_1.add(pnlPastel);

		pnlBarras = new JPanel();
		pnlBarras.setBounds(680, 58, 490, 238);
		panel_1.add(pnlBarras);

		JPanel pnlTotal = new JPanel();
		pnlTotal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Total", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTotal.setBounds(275, 318, 300, 240);
		panel_1.add(pnlTotal);
		pnlTotal.setLayout(null);

		JLabel lblSolicitantes = new JLabel("Solicitantes:");
		lblSolicitantes.setBounds(50, 36, 100, 14);
		pnlTotal.add(lblSolicitantes);

		textField = new JTextField();
		textField.setForeground(Color.BLUE);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("0");
		textField.setEditable(false);
		textField.setBounds(150, 32, 86, 23);
		pnlTotal.add(textField);
		textField.setColumns(10);

		JLabel lblSolicitudes = new JLabel("Solicitudes:");
		lblSolicitudes.setBounds(50, 86, 100, 14);
		pnlTotal.add(lblSolicitudes);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLUE);
		textField_1.setText("0");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(150, 82, 86, 23);
		pnlTotal.add(textField_1);

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

		JPanel pnlAreasPopulares = new JPanel();
		pnlAreasPopulares.setLayout(null);
		pnlAreasPopulares.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u00C1reas Populares",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlAreasPopulares.setBounds(775, 318, 300, 240);
		panel_1.add(pnlAreasPopulares);

		JLabel lblSolicitudes_1 = new JLabel("Solicitudes:");
		lblSolicitudes_1.setBounds(150, 22, 100, 14);
		pnlAreasPopulares.add(lblSolicitudes_1);

		JLabel lblreas = new JLabel("\u00C1reas:");
		lblreas.setBounds(25, 22, 100, 14);
		pnlAreasPopulares.add(lblreas);

		JLabel lblrea = new JLabel("\u00C1rea1");
		lblrea.setBounds(25, 58, 100, 14);
		pnlAreasPopulares.add(lblrea);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setText("0");
		textField_4.setForeground(Color.BLUE);
		textField_4.setEditable(false);
		textField_4.setBounds(150, 54, 86, 23);
		pnlAreasPopulares.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblrea_1 = new JLabel("\u00C1rea2");
		lblrea_1.setBounds(25, 94, 100, 14);
		pnlAreasPopulares.add(lblrea_1);

		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(Color.BLUE);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(150, 90, 86, 23);
		pnlAreasPopulares.add(textField_5);

		JLabel lblrea_2 = new JLabel("\u00C1rea3");
		lblrea_2.setBounds(25, 130, 100, 14);
		pnlAreasPopulares.add(lblrea_2);

		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setForeground(Color.BLUE);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(150, 126, 86, 23);
		pnlAreasPopulares.add(textField_6);

		JLabel lblrea_3 = new JLabel("\u00C1rea4");
		lblrea_3.setBounds(25, 166, 100, 14);
		pnlAreasPopulares.add(lblrea_3);

		textField_7 = new JTextField();
		textField_7.setText("0");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setForeground(Color.BLUE);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(150, 162, 86, 23);
		pnlAreasPopulares.add(textField_7);

		JLabel lblrea_4 = new JLabel("\u00C1rea5");
		lblrea_4.setBounds(25, 202, 100, 14);
		pnlAreasPopulares.add(lblrea_4);

		textField_8 = new JTextField();
		textField_8.setText("0");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setForeground(Color.BLUE);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(150, 198, 86, 23);
		pnlAreasPopulares.add(textField_8);

		Stats hS = new Stats();
		hS.start();
	}

	public static void loadStats() {
		// TODO Auto-generated method stub

		txtEmpresas.setText(String.format("%d", Controladora.getInstance().getMisEmpresas().size()));
		txtEmpleos.setText(String.format("%d", Controladora.getInstance().getMisEmpleos().size()));

		// create a dataset...
		DefaultPieDataset dataPastel = new DefaultPieDataset();
		dataPastel.setValue("Mujeres", Controladora.getInstance().contarHombresMujeres()[0]);
		dataPastel.setValue("Hombres", Controladora.getInstance().contarHombresMujeres()[1]);

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

		JFreeChart barras = ChartFactory.createBarChart("Matching", "D�as", "Matches", dataBarras,
				PlotOrientation.VERTICAL, false, true, false);

		barras.setBackgroundPaint(new Color(0, 0, 0, 0));

		ChartPanel chartPastel = new ChartPanel(pastel, 480, 230, 480, 230, 480, 230, true, true, true, true, true,
				true);

		ChartPanel chartBarras = new ChartPanel(barras, 480, 230, 480, 230, 480, 230, true, true, false, false, false,
				true);

		pnlPastel.add(chartPastel, BorderLayout.CENTER);
		pnlPastel.validate();

		pnlBarras.add(chartBarras, BorderLayout.CENTER);
		pnlBarras.validate();

	}
}
