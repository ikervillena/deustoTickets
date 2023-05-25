package presentation.gui;

import business.clases.Evento;
import business.clases.Staff;
import business.controller.Controller;

import javax.swing.JOptionPane;
import java.util.Date;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import business.clases.dto.*;

public class InfoEventoStaff extends JFrame {

	private JPanel contentPane;

	public InfoEventoStaff(Controller controller, Evento evento, Staff staff) {
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoStaff ventana = new InfoStaff(controller, staff);
				ventana.setVisible(true);
				InfoEventoStaff.this.dispose();
			}
		});
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

		JLabel lblDireccin = new JLabel("Aforo del evento");
		lblDireccin.setForeground(new Color(255, 215, 0));
		lblDireccin.setFont(new Font("Stencil", Font.BOLD, 22));
		lblDireccin.setBackground(new Color(248, 248, 255));
		lblDireccin.setBounds(462, 172, 271, 30);
		contentPane.add(lblDireccin);

		ArrayList<EntradaDTO> entradas = evento.getEntradas();
		int numero = 0;
		int poracceder = 0;
		if (entradas == null) {
		} else {
			for (int i = 0; i < entradas.size(); i++) {
				numero = numero + 1;
				poracceder = numero;
			}
			for (int i = 0; i < entradas.size(); i++) {
				if (entradas.get(i).isUtilizada() == true) {
					poracceder = poracceder - 1;
				}
			}
		}
		int num = poracceder;

		JLabel lblDireccinDelEvento = new JLabel("" + evento.getAforo() + " personas");
		lblDireccinDelEvento.setBounds(462, 200, 150, 15);
		contentPane.add(lblDireccinDelEvento);

		JButton btnMostrarHora = new JButton("Mostrar Informacion");
		btnMostrarHora.setBounds(600, 200, 170, 15);
		contentPane.add(btnMostrarHora);

		btnMostrarHora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarInfor(entradas, num);
			}
		});

		JLabel lblLugar = new JLabel("Lugar del evento");
		lblLugar.setForeground(new Color(255, 215, 0));
		lblLugar.setFont(new Font("Stencil", Font.BOLD, 22));
		lblLugar.setBackground(new Color(248, 248, 255));
		lblLugar.setBounds(462, 225, 271, 30);
		contentPane.add(lblLugar);

		JLabel lblsisito = new JLabel("" + evento.getEspacio().getNombre());
		lblsisito.setBounds(462, 255, 332, 15);
		contentPane.add(lblsisito);

		JTextArea textArea = new JTextArea(evento.getDescripcion());
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

		textArea.append("\n \n FECHA :" + evento.getFecha());

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(400, 200));

		scrollPane.setBounds(37, 200, 344, 200);
		contentPane.add(scrollPane);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\workspace\\imagenes\\Ubicacion.png"));
		lblNewLabel_3.setBounds(444, 280, 326, 176);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("SCANEAR ENTRADAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanear ventana = new Scanear(controller, staff, evento);
				ventana.setVisible(true);
				InfoEventoStaff.this.dispose();
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
				MenuStaff ventana = new MenuStaff(controller, staff);
				ventana.setVisible(true);
				InfoEventoStaff.this.dispose();
			}
		});
		btnBack.setBackground(new Color(178, 34, 34));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Stencil", Font.BOLD, 20));
		btnBack.setBounds(655, 464, 115, 29);
		contentPane.add(btnBack);

	}

	private void mostrarInfor(ArrayList<EntradaDTO> entradas, int poracceder) {
		Date fechaHoraActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
		String horaActual = formato.format(fechaHoraActual);

		StringBuilder mensaje = new StringBuilder();
		mensaje.append("Hora del clic: ").append(horaActual).append("\n");
		mensaje.append("Personas ingresadas: ").append(entradas.size() - poracceder).append("\n");
		mensaje.append("Personas por ingresar: ").append(poracceder);

		JOptionPane.showMessageDialog(InfoEventoStaff.this, mensaje.toString(), "Informacion del evento",
				JOptionPane.PLAIN_MESSAGE);
	}

}