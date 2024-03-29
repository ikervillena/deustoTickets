package presentation.gui;

import business.clases.Evento;
import business.clases.dto.ClienteDTO;
import business.controller.Controller;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import business.clases.*;
import javax.swing.UIManager;

public class InfoEvento extends JFrame {

	private JPanel contentPane;

	public InfoEvento(Controller controller, Evento evento, ClienteDTO cliente) {
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
					InfoEvento.this.dispose();
				} else {
					InfoCliente ventana1 = new InfoCliente(controller, cliente);
					ventana1.setVisible(true);
					InfoEvento.this.dispose();
				}
			}
		});
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
		lblNewLabel_1.setBounds(117, 95, 633, 63);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Acerca del evento");
		lblNewLabel_2.setBackground(new Color(248, 248, 255));
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setFont(new Font("Stencil", Font.BOLD, 22));
		lblNewLabel_2.setBounds(83, 172, 245, 33);
		contentPane.add(lblNewLabel_2);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n del evento");
		lblDireccin.setForeground(new Color(255, 215, 0));
		lblDireccin.setFont(new Font("Stencil", Font.BOLD, 22));
		lblDireccin.setBackground(new Color(248, 248, 255));
		lblDireccin.setBounds(462, 172, 271, 33);
		contentPane.add(lblDireccin);
		ArrayList<business.clases.Artista> a = controller.getArtistasDeEvento(evento);

		int altura = 318;
		for (int i = 0; i < a.size(); i++) {
			JButton btnArtista = new JButton(a.get(i).getNombre());
			btnArtista.setBounds(37, altura, 344, 15);
			contentPane.add(btnArtista);
			altura = altura + 20;
			int numero = i;
			btnArtista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String informacionArtista = "Nombre: " + a.get(numero).getNombre() + "\n"
							+ "Fecha de nacimiento: " + a.get(numero).getFecNac() + "\n"
							+ "Descripción: " + a.get(numero).getDescripcion();

					JTextArea textArea = new JTextArea(informacionArtista);
					textArea.setEditable(false);
					textArea.setLineWrap(true);
					textArea.setWrapStyleWord(true);

					JScrollPane scrollPane = new JScrollPane(textArea);
					scrollPane.setPreferredSize(new Dimension(300, 200));

					JOptionPane.showMessageDialog(InfoEvento.this, scrollPane, "Información del artista",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}

		JLabel lblDireccinDelEvento = new JLabel(evento.getEspacio().getDireccion());
		lblDireccinDelEvento.setBounds(462, 205, 332, 63);
		contentPane.add(lblDireccinDelEvento);

		JLabel lblArtistasDelEvento = new JLabel("Artistas del evento");
		lblArtistasDelEvento.setForeground(new Color(255, 215, 0));
		lblArtistasDelEvento.setFont(new Font("Stencil", Font.BOLD, 22));
		lblArtistasDelEvento.setBackground(new Color(248, 248, 255));
		lblArtistasDelEvento.setBounds(83, 280, 259, 33);
		contentPane.add(lblArtistasDelEvento);

		JButton btnInfoEvento = new JButton("Ver informacion del evento");
		btnInfoEvento.setBounds(37, 200, 344, 73);
		btnInfoEvento.setBackground(new Color(255, 215, 0));
		btnInfoEvento.setForeground(new Color(255, 255, 255));
		btnInfoEvento.setFont(new Font("Stencil", Font.BOLD, 18));
		contentPane.add(btnInfoEvento);

		btnInfoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea textArea = new JTextArea(evento.getDescripcion());
				textArea.setEditable(false);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

				JScrollPane scrollPane = new JScrollPane(textArea);
				scrollPane.setPreferredSize(new Dimension(400, 200));

				UIManager.put("OptionPane.background", new Color(255, 248, 220));
				UIManager.put("Panel.background", new Color(255, 248, 220));
				UIManager.put("OptionPane.messageForeground", Color.BLACK);

				JOptionPane.showMessageDialog(InfoEvento.this, scrollPane, "Informacion del evento",
						JOptionPane.PLAIN_MESSAGE);
			}
		});

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(
				"C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\Ubicacion.png"));
		lblNewLabel_3.setBounds(444, 272, 326, 176);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("ENTRADAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoEntradas ventana = new InfoEntradas(controller, evento, cliente);
				ventana.setVisible(true);
				InfoEvento.this.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 215, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Stencil", Font.BOLD, 20));
		ImageIcon icon1 = new ImageIcon(
				"C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\ENTRADA.png");
		Image img1 = icon1.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img1);
		btnNewButton_1.setIcon(icon);
		btnNewButton_1.setBounds(37, 423, 344, 63);
		contentPane.add(btnNewButton_1);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCliente ventana = new MenuCliente(controller, cliente);
				ventana.setVisible(true);
				InfoEvento.this.dispose();
				;
			}
		});
		btnBack.setBackground(new Color(178, 34, 34));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Stencil", Font.BOLD, 20));
		btnBack.setBounds(655, 464, 115, 29);
		contentPane.add(btnBack);

	}

}