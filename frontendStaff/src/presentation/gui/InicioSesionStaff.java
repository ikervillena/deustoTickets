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
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import business.clases.*;

public class InicioSesionStaff extends JFrame {

	private JPanel contentPane;

	public InicioSesionStaff(Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(412, 299, 282, 43);
		contentPane.add(passwordField);

		JTextField textField = new JTextField();
		textField.setBounds(412, 234, 282, 40);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 820, 513);
		ImageIcon imageIcon = new ImageIcon(
				"C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\fotofiesta.jpg");
		Image image = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);

		JButton btnNewButton = new JButton("Inicio Sesion");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String textoUsuario = textField.getText();
				String passwordTexto = passwordField.getText();
				if (passwordTexto.equals("") || textoUsuario.equals("")) {
					JOptionPane.showMessageDialog(InicioSesionStaff.this, "No dejes ningun campo vacio");
				} else {
					Staff a = controller.iniciarSesionStaff(textoUsuario, passwordTexto);
					if (a == null) {
						JOptionPane.showMessageDialog(InicioSesionStaff.this,
								"El usuario o la contrasenya son incorrectos");
						InicioSesionStaff ventana = new InicioSesionStaff(controller);
						ventana.setVisible(true);
						InicioSesionStaff.this.dispose();
					} else {
						MenuStaff ventana = new MenuStaff(controller, a);
						ventana.setVisible(true);
						InicioSesionStaff.this.dispose();

					}
				}
			}
		});
		btnNewButton.setBounds(645, 397, 149, 33);
		contentPane.add(btnNewButton);

		JLabel lblDeustoTickets = new JLabel("Deusto Tickets");
		lblDeustoTickets.setBackground(new Color(255, 255, 0));
		lblDeustoTickets.setBorder(UIManager.getBorder("Button.border"));
		lblDeustoTickets.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDeustoTickets.setFont(new Font("Stencil", Font.PLAIN, 94));
		lblDeustoTickets.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeustoTickets.setForeground(new Color(255, 200, 0));
		lblDeustoTickets.setBounds(-16, 16, 836, 228);
		contentPane.add(lblDeustoTickets);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBackground(new Color(255, 215, 0));
		lblUsuario.setForeground(new Color(255, 215, 0));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Stencil", Font.BOLD, 30));
		lblUsuario.setBounds(133, 234, 185, 40);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(new Color(255, 215, 0));
		lblContrasea.setFont(new Font("Stencil", Font.BOLD, 30));
		lblContrasea.setBackground(new Color(255, 255, 255));
		lblContrasea.setBounds(134, 305, 209, 40);
		contentPane.add(lblContrasea);
		label.setIcon(new ImageIcon(image));
		contentPane.add(label);
	}
}