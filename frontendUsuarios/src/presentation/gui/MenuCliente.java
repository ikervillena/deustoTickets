package presentation.gui;

import business.clases.Evento;
import business.controller.Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import business.clases.*;

public class MenuCliente extends JFrame {

	private JPanel contentPane;

	public MenuCliente(Controller controller, Cliente cliente) {
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
				if (cliente.getNombre() == null) {
					Inicio ventana1 = new Inicio(controller, cliente);
					ventana1.setVisible(true);
					MenuCliente.this.dispose();
				} else {
					InfoCliente ventana1 = new InfoCliente(controller, cliente);
					ventana1.setVisible(true);
					MenuCliente.this.dispose();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Stencil", Font.BOLD, 40));
		menuBar.add(btnNewButton);

		/* Para hacer el filtro */

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(630, 86, 140, 26);
		contentPane.add(comboBox);
		ArrayList<Evento> eventos = controller.getEventos();

		int altura = 130;

		for (int i = 0; i < eventos.size(); i++) {
			Evento evento = eventos.get(i);
			JButton btnNewButto = new JButton(eventos.get(i).getTitulo());
			ImageIcon icon2 = new ImageIcon(
					"C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\ENTRADA.png");
			Image img2 = icon2.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH);
			icon2 = new ImageIcon(img2);
			btnNewButto.setIcon(icon2);
			btnNewButto.setBorder(null);
			btnNewButto.setBorderPainted(false);
			btnNewButto.setBackground(new Color(255, 222, 173));
			btnNewButto.setForeground(new Color(255, 255, 255));
			btnNewButto.setFont(new Font("Stencil", Font.PLAIN, 50));
			btnNewButto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InfoEvento ventana = new InfoEvento(controller, evento, cliente);
					ventana.setVisible(true);
					MenuCliente.this.dispose();
				}
			});
			btnNewButto.setBounds(61, altura, 709, 60);
			contentPane.add(btnNewButto);
			altura = altura + 70;
		}

	}

}
