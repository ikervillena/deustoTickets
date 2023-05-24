package presentation.gui;

import business.controller.Controller;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import business.clases.*;

public class Scanear extends JFrame {

	private JPanel contentPane;
	private JPanel panelCamara;
	private WebcamPanel webcamPanel;

	public Scanear(Controller controller, Staff staff, Evento evento) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setForeground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 215, 0));
		menuBar.setBounds(61, 16, 709, 63);
		contentPane.add(menuBar);

		JLabel lblNewLabel = new JLabel("Eventos proximos");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 40));
		menuBar.add(lblNewLabel);

		Component verticalStrut = Box.createVerticalStrut(0);
		menuBar.add(verticalStrut);

		JButton btnNewButton = new JButton("Usuario");
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Stencil", Font.BOLD, 40));
		menuBar.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel(evento.getTitulo());
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 215, 0));
		ImageIcon icon = new ImageIcon(
				"C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\ENTRADA.png");
		Image img = icon.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(187, 93, 423, 63);
		contentPane.add(lblNewLabel_1);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuStaff ventana = new MenuStaff(controller, staff);
				ventana.setVisible(true);
				Scanear.this.dispose();
			}
		});
		btnBack.setBackground(new Color(178, 34, 34));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Stencil", Font.BOLD, 20));
		btnBack.setBounds(655, 464, 115, 29);
		contentPane.add(btnBack);

		panelCamara = new JPanel();
		panelCamara.setBounds(223, 172, 362, 249);
		contentPane.add(panelCamara);
		panelCamara.setLayout(new BorderLayout());

		webcamPanel = new WebcamPanel(Webcam.getWebcams().get(1));
		webcamPanel.setSize(new Dimension(480, 480));
		webcamPanel.setFPSDisplayed(true);
		webcamPanel.setDisplayDebugInfo(true);
		webcamPanel.setImageSizeDisplayed(true);
		webcamPanel.setMirrored(true);
		panelCamara.add(webcamPanel);

		ThreadLectorQR lectorQR = new ThreadLectorQR(webcamPanel, evento, controller);
		Thread t = new Thread(lectorQR);
		t.start();
	}
}