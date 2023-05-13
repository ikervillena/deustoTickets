package presentation.gui;

import business.clases.Evento;
import business.controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;

public class InfoEntradas extends JFrame {

	private JPanel contentPane;

	public InfoEntradas(Controller controller, Evento evento) {
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InfoCliente ventana1 = new InfoCliente(controller);
				ventana1.setVisible(true);
				InfoEntradas.this.dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Stencil", Font.BOLD, 40));
		menuBar.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Evento 1");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 215, 0));
		ImageIcon icon = new ImageIcon("C:\\workspace\\imagenes\\ENTRADA.png");
		Image img = icon.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(187, 93, 423, 63);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Entradas");
		lblNewLabel_2.setBackground(new Color(248, 248, 255));
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setFont(new Font("Stencil", Font.BOLD, 22));
		lblNewLabel_2.setBounds(153, 172, 150, 33);
		contentPane.add(lblNewLabel_2);

		JLabel lblDireccin = new JLabel("Ubicaci\u00F3n entrada");
		lblDireccin.setForeground(new Color(255, 215, 0));
		lblDireccin.setFont(new Font("Stencil", Font.BOLD, 22));
		lblDireccin.setBackground(new Color(248, 248, 255));
		lblDireccin.setBounds(462, 172, 271, 33);
		contentPane.add(lblDireccin);

		JLabel lbl = new JLabel("New label");
		lbl.setBounds(450, 208, 297, 227);
		ImageIcon imageIcon = new ImageIcon(
				"C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\estadio.png");
		Image image = imageIcon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
		lbl.setIcon(new ImageIcon(image));
		contentPane.add(lbl);

		JButton btnNewButton_1 = new JButton("Compra");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(new Color(255, 215, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Stencil", Font.BOLD, 20));
		ImageIcon icon1 = new ImageIcon(
				"C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\ENTRADA.png");
		Image img1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img1);
		btnNewButton_1.setIcon(icon);
		btnNewButton_1.setBounds(445, 464, 195, 29);
		contentPane.add(btnNewButton_1);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCliente ventana = new MenuCliente(controller);
				ventana.setVisible(true);
				InfoEntradas.this.dispose();
			}
		});
		btnBack.setBackground(new Color(178, 34, 34));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Stencil", Font.BOLD, 20));
		btnBack.setBounds(655, 464, 115, 29);
		contentPane.add(btnBack);

		/*
		 * Por cada tipo de entrada hay que hacer un for con esto para crear el contador
		 * y el nombre de entrada
		 */

		JSpinner spinner = new JSpinner();
		spinner.setBounds(341, 225, 32, 26);
		contentPane.add(spinner);

		JLabel lblEntrada = new JLabel("Entrada 1");
		lblEntrada.setForeground(new Color(240, 230, 140));
		lblEntrada.setFont(new Font("Stencil", Font.BOLD, 22));
		lblEntrada.setBackground(new Color(248, 248, 255));
		lblEntrada.setBounds(61, 223, 257, 33);
		contentPane.add(lblEntrada);

	}
}