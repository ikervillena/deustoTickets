package presentation.gui;

import business.controller.Controller;
import business.clases.*;
import java.util.ArrayList;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuStaff extends JFrame {

	private JPanel contentPane;

	public MenuStaff(Controller controller, Staff a) {
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

		ArrayList<Evento> eventos1 = controller.getEventos();
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		for (int i = 0; i < eventos1.size(); i++) {
			if (!eventos1.get(i).getPrecios().isEmpty()) {
				eventos.add(eventos1.get(i));
			}
		}
		int altura = 100;

		for (int i = 0; i < eventos.size(); i++) {
			Evento evento = eventos.get(i);
			JButton btnNewButton_1 = new JButton(eventos.get(i).getTitulo());
			ImageIcon icon = new ImageIcon(
					"C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\ENTRADA.png");
			Image img = icon.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH);
			icon = new ImageIcon(img);
			btnNewButton_1.setIcon(icon);
			btnNewButton_1.setBorder(null);
			btnNewButton_1.setBorderPainted(false);
			btnNewButton_1.setBackground(new Color(255, 222, 173));
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setFont(new Font("Stencil", Font.PLAIN, 50));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InfoEventoStaff ventana = new InfoEventoStaff(controller, evento, a);
					ventana.setVisible(true);
					MenuStaff.this.dispose();
				}
			});
			btnNewButton_1.setBounds(61, altura, 709, 100);
			contentPane.add(btnNewButton_1);
			altura = altura + 110;
		}
	}

}