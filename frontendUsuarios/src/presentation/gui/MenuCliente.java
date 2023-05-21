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
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import business.clases.*;

public class MenuCliente extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox1;

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

		String[] opciones = { "Seleccione opcion", "Filtrar por Espacio", "Filtrar por Artista" };
		comboBox = new JComboBox<>(opciones);
		comboBox.setBounds(460, 86, 140, 26);
		getContentPane().add(comboBox);

		comboBox1 = new JComboBox<>();
		comboBox1.setBounds(600, 86, 180, 26);
		getContentPane().add(comboBox1);

		ArrayList<Evento> eventos = controller.getEventos();
		ArrayList<JButton> botonesEventos = new ArrayList<>();
		visualizarEventos(eventos, controller, cliente, botonesEventos);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = (String) comboBox.getSelectedItem();
				String seleccion2 = (String) comboBox1.getSelectedItem();

				if (seleccion.equals("Filtrar por Artista")) {
					comboBox1.removeAllItems();
					comboBox1.addItem("---");
					ArrayList<String> artistasExistentes = new ArrayList<>();

					for (int i = 0; i < eventos.size(); i++) {
						ArrayList<Artista> artistas = eventos.get(i).getArtistas();
						for (int x = 0; x < artistas.size(); x++) {
							String nombreArtista = artistas.get(x).getNombre();
							if (!artistasExistentes.contains(nombreArtista)) {
								comboBox1.addItem(nombreArtista);
								artistasExistentes.add(nombreArtista);
							}
						}
					}
				} else if (seleccion.equals("Filtrar por Espacio")) {
					comboBox1.removeAllItems();
					comboBox1.addItem("---");
					ArrayList<String> espaciosExistentes = new ArrayList<>();

					for (int a = 0; a < eventos.size(); a++) {
						Espacio espacio = eventos.get(a).getEspacio();
						String nombreEspacio = espacio.getNombre();
						if (!espaciosExistentes.contains(nombreEspacio)) {
							comboBox1.addItem(nombreEspacio);
							espaciosExistentes.add(nombreEspacio);
						}
					}
				} else if (seleccion.equals("Seleccione opción")) {
					comboBox1.removeAllItems();
				}

				ArrayList<Evento> eventosFiltrados = filtrarEventos(eventos, seleccion, seleccion2);
				actualizarVisualizacionEventos(eventosFiltrados, controller, cliente, botonesEventos);
			}
		});

		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = (String) comboBox.getSelectedItem();
				String seleccion2 = (String) comboBox1.getSelectedItem();

				ArrayList<Evento> eventosFiltrados = filtrarEventos(eventos, seleccion, seleccion2);
				actualizarVisualizacionEventos(eventosFiltrados, controller, cliente, botonesEventos);
			}
		});

	}

	public void visualizarEventos(ArrayList<Evento> eventos, Controller controller, Cliente cliente,
			ArrayList<JButton> botonesEventos) {
		int altura = 150;
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
			botonesEventos.add(btnNewButto);
			altura = altura + 70;
		}
	}

	public ArrayList<Evento> filtrarEventos(ArrayList<Evento> eventos, String seleccion, String seleccion2) {
		ArrayList<Evento> eventosFiltrados = new ArrayList<>();
		if (seleccion != null && seleccion2 != null) {
			if (seleccion.equals("Filtrar por Artista") && !seleccion2.equals("---")) {
				for (int b = 0; b < eventos.size(); b++) {
					ArrayList<Artista> artistas = eventos.get(b).getArtistas();
					for (int c = 0; c < artistas.size(); c++) {
						if (seleccion2.equals(artistas.get(c).getNombre())) {
							eventosFiltrados.add(eventos.get(b));
							break;
						}
					}
				}
			} else if (seleccion.equals("Filtrar por Espacio") && !seleccion2.equals("---")) {
				for (int z = 0; z < eventos.size(); z++) {
					Espacio espacio = eventos.get(z).getEspacio();
					if (seleccion2.equals(espacio.getNombre())) {
						eventosFiltrados.add(eventos.get(z));
					}
				}
			} else if (seleccion.equals("Seleccione opcion")) {
				for (int z = 0; z < eventos.size(); z++) {
					eventosFiltrados.add(eventos.get(z));
				}

			}
		}
		return eventosFiltrados;
	}

	public void actualizarVisualizacionEventos(ArrayList<Evento> eventos, Controller controller, Cliente cliente,
			ArrayList<JButton> botonesEventos) {
		for (JButton boton : botonesEventos) {
			contentPane.remove(boton);
		}
		botonesEventos.clear();
		contentPane.revalidate();
		contentPane.repaint();
		visualizarEventos(eventos, controller, cliente, botonesEventos);
	}
}
