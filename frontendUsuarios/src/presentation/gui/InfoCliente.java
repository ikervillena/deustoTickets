package presentation.gui;

import business.controller.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import business.clases.*;
import java.util.Date;

public class InfoCliente extends JFrame {

	private JPanel contentPane;

	public InfoCliente(Controller controller, Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setForeground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nombre usuario");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 215, 0));
		ImageIcon icon = new ImageIcon(
				"C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\usuario.png");
		Image img = icon.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(153, 34, 493, 67);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Informacion personal");
		lblNewLabel_2.setBackground(new Color(248, 248, 255));
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setFont(new Font("Stencil", Font.BOLD, 22));
		lblNewLabel_2.setBounds(61, 134, 312, 33);
		contentPane.add(lblNewLabel_2);

		JLabel lblUsuario = new JLabel("NOMBRE");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(new Color(210, 180, 140));
		lblUsuario.setFont(new Font("Stencil", Font.BOLD, 20));
		lblUsuario.setBackground(new Color(255, 215, 0));
		lblUsuario.setBounds(22, 213, 129, 40);
		contentPane.add(lblUsuario);

		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setForeground(new Color(210, 180, 140));
		lblApellidos.setFont(new Font("Stencil", Font.BOLD, 20));
		lblApellidos.setBackground(new Color(255, 215, 0));
		lblApellidos.setBounds(22, 257, 122, 40);
		contentPane.add(lblApellidos);

		JLabel label_2 = new JLabel("FECHA NAC");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(210, 180, 140));
		label_2.setFont(new Font("Stencil", Font.BOLD, 20));
		label_2.setBackground(new Color(255, 215, 0));
		label_2.setBounds(15, 300, 136, 40);
		contentPane.add(label_2);

		JLabel label_1 = new JLabel("Usuario");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(210, 180, 140));
		label_1.setFont(new Font("Stencil", Font.BOLD, 20));
		label_1.setBackground(new Color(255, 215, 0));
		label_1.setBounds(15, 173, 136, 40);
		contentPane.add(label_1);

		JLabel InfoUsuario = new JLabel(cliente.getUsuario());
		InfoUsuario.setBounds(186, 183, 69, 20);
		contentPane.add(InfoUsuario);

		JLabel InfoNombre = new JLabel(cliente.getNombre());
		InfoNombre.setBounds(186, 222, 69, 20);
		contentPane.add(InfoNombre);

		JLabel InfoApellido = new JLabel(cliente.getApellido());
		InfoApellido.setBounds(186, 266, 69, 20);
		contentPane.add(InfoApellido);

		Date fecha = cliente.getFecNac();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // se crea un objeto SimpleDateFormat
		String fechaString = formatter.format(fecha);
		char[] caracteres = fechaString.toCharArray();

		JLabel InfoFechaNac = new JLabel("" + caracteres[0] + caracteres[1] + caracteres[2] + caracteres[3]
				+ caracteres[4] + caracteres[5] + caracteres[6] + caracteres[7] + caracteres[8] + caracteres[9]);
		InfoFechaNac.setBounds(186, 309, 69, 20);
		contentPane.add(InfoFechaNac);

		JButton btnNewButton = new JButton("Cambiar Info");
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Stencil", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambioInfor ventana = new CambioInfor(controller, cliente);
				ventana.setVisible(true);
				InfoCliente.this.dispose();
			}
		});
		btnNewButton.setBounds(25, 366, 348, 29);
		contentPane.add(btnNewButton);

		JLabel lblMisEntradas = new JLabel("Mis entradas");
		lblMisEntradas.setForeground(new Color(255, 215, 0));
		lblMisEntradas.setFont(new Font("Stencil", Font.BOLD, 22));
		lblMisEntradas.setBackground(new Color(248, 248, 255));
		lblMisEntradas.setBounds(532, 134, 190, 33);
		contentPane.add(lblMisEntradas);

		/*
		 * For para que aparezcan todas las entradas, modificar el set bounds para que
		 * no se solapen
		 * y el boton deber�a dirigir al evento
		 */

		JButton btnNewButton_1 = new JButton("Entrada 1");
		btnNewButton_1.setBackground(new Color(255, 228, 181));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Stencil", Font.BOLD, 25));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(480, 183, 281, 40);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCliente ventana = new MenuCliente(controller, cliente);
				ventana.setVisible(true);
				InfoCliente.this.dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Stencil", Font.BOLD, 22));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(658, 453, 136, 29);
		contentPane.add(btnNewButton_2);

	}
}