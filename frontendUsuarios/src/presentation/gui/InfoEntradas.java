package presentation.gui;

import javax.swing.SpinnerNumberModel;
import business.clases.Evento;
import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;
import business.controller.Controller;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
import java.util.ArrayList;
import business.clases.*;

public class InfoEntradas extends JFrame {

	private JPanel contentPane;

	public InfoEntradas(Controller controller, Evento evento, ClienteDTO cliente) {
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
					InfoEntradas.this.dispose();
				} else {
					InfoCliente ventana1 = new InfoCliente(controller, cliente);
					ventana1.setVisible(true);
					InfoEntradas.this.dispose();
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
		ImageIcon icon = new ImageIcon("C:\\workspace\\imagenes\\ENTRADA.png");
		Image img = icon.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(117, 95, 633, 63);
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
				"..\\resources\\images\\estadio.png");
		Image image = imageIcon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
		lbl.setIcon(new ImageIcon(image));
		contentPane.add(lbl);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCliente ventana = new MenuCliente(controller, cliente);
				ventana.setVisible(true);
				InfoEntradas.this.dispose();
			}
		});
		btnBack.setBackground(new Color(178, 34, 34));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Stencil", Font.BOLD, 20));
		btnBack.setBounds(655, 464, 115, 29);
		contentPane.add(btnBack);

		int altura = 223;
		ArrayList<Precio> precios = evento.getPrecios();
		ArrayList<JSpinner> spinners = new ArrayList<>();
		for (int i = 0; i < precios.size(); i++) {

			JLabel lblEntrada = new JLabel(precios.get(i).getNombre());
			lblEntrada.setForeground(new Color(240, 230, 140));
			lblEntrada.setFont(new Font("Stencil", Font.BOLD, 16));
			lblEntrada.setBackground(new Color(248, 248, 255));
			lblEntrada.setBounds(21, altura, 400, 33);
			contentPane.add(lblEntrada);

			JLabel lblInformacion = new JLabel(
					"Precio: " + precios.get(i).getPrecio() + " euros   Disponibles: "
							+ precios.get(i).getDisponibles());
			lblInformacion.setForeground(Color.GRAY);
			lblInformacion.setFont(new Font("Arial", Font.PLAIN, 12));
			lblInformacion.setBounds(21, altura + 33, 400, 20);
			contentPane.add(lblInformacion);

			JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
			spinner.setBounds(400, altura, 32, 26);
			contentPane.add(spinner);
			spinners.add(spinner);

			altura += 70;
		}
		ArrayList<EntradaDTO> entradas = new ArrayList<EntradaDTO>();

		JButton btnNewButton_1 = new JButton("Compra");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cliente.getNombre() == null) {
					JOptionPane.showMessageDialog(InfoEntradas.this,
							"Para poder comprar entradas debes estar registrado");
					Inicio ventana1 = new Inicio(controller, cliente);
					ventana1.setVisible(true);
					InfoEntradas.this.dispose();
				} else {
					for (int i = 0; i < spinners.size(); i++) {
						int valorSpinner = (int) spinners.get(i).getValue();

						if (valorSpinner != 0) {
							for (int numero = 0; numero < valorSpinner; numero++) {
								Date fecha = new Date();
								EntradaDTO entrada = new EntradaDTO("", precios.get(i).getNombre(), fecha,
										precios.get(i), evento, cliente, false);
								entradas.add(entrada);
							}

						}
					}
					ArrayList<EntradaDTO> sarrerak = controller.comprarEntradas(entradas);
					for (int i = 0; i < sarrerak.size(); i++) {
						cliente.getEntradas().add(sarrerak.get(i));
					}
					DescargaEntrada pantalla = new DescargaEntrada(controller, cliente, evento, sarrerak);
					pantalla.setVisible(true);
					InfoEntradas.this.dispose();
				}

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
	}
}