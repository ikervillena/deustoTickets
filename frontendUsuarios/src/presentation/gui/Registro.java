package presentation.gui;

import javax.swing.JOptionPane;
import java.util.Date;
import business.clases.*;
import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;
import business.controller.Controller;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.util.Calendar;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textCorreo;
	private JTextField textContrasenya;
	private JTextField textoApellido;
	private JTextField textNombre;
	private JTextField textUsuario;
	private JTextField textFechaNac;
	private JTextField textDni;

	public Registro(Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(-6, 0, 820, 513);
		ImageIcon imageIcon = new ImageIcon(
				"C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\fotofiesta.jpg");
		Image image = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);

		JLabel lblUsuario = new JLabel("NOMBRE");
		lblUsuario.setBackground(new Color(255, 215, 0));
		lblUsuario.setForeground(new Color(255, 215, 0));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Stencil", Font.BOLD, 25));
		lblUsuario.setBounds(25, 288, 185, 40);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(new Color(255, 215, 0));
		lblContrasea.setFont(new Font("Stencil", Font.BOLD, 25));
		lblContrasea.setBackground(new Color(255, 255, 255));
		lblContrasea.setBounds(15, 239, 209, 40);
		contentPane.add(lblContrasea);

		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setForeground(new Color(255, 215, 0));
		lblApellidos.setFont(new Font("Stencil", Font.BOLD, 25));
		lblApellidos.setBackground(new Color(255, 215, 0));
		lblApellidos.setBounds(25, 335, 185, 40);
		contentPane.add(lblApellidos);

		JLabel tDni = new JLabel("DNI");
		tDni.setHorizontalAlignment(SwingConstants.CENTER);
		tDni.setForeground(new Color(255, 215, 0));
		tDni.setFont(new Font("Stencil", Font.BOLD, 25));
		tDni.setBackground(new Color(255, 215, 0));
		tDni.setBounds(422, 239, 185, 40);
		contentPane.add(tDni);

		JLabel label_2 = new JLabel("FECHA NAC (dia/mes/anyo)");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(255, 215, 0));
		label_2.setFont(new Font("Stencil", Font.BOLD, 25));
		label_2.setBackground(new Color(255, 215, 0));
		label_2.setBounds(422, 193, 185, 40);
		contentPane.add(label_2);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setForeground(new Color(255, 215, 0));
		lblCorreo.setFont(new Font("Stencil", Font.BOLD, 25));
		lblCorreo.setBackground(new Color(255, 215, 0));
		lblCorreo.setBounds(422, 288, 185, 40);
		contentPane.add(lblCorreo);

		JLabel lblNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setForeground(new Color(255, 255, 0));
		lblNuevoUsuario.setFont(new Font("Stencil", Font.PLAIN, 48));
		lblNuevoUsuario.setBorder(UIManager.getBorder("Button.border"));
		lblNuevoUsuario.setBackground(Color.YELLOW);
		lblNuevoUsuario.setAlignmentX(0.5f);
		lblNuevoUsuario.setBounds(181, 105, 424, 92);
		contentPane.add(lblNuevoUsuario);

		textContrasenya = new JTextField();
		textContrasenya.setBounds(223, 246, 146, 26);
		contentPane.add(textContrasenya);

		textoApellido = new JTextField();
		textoApellido.setBounds(223, 342, 146, 26);
		contentPane.add(textoApellido);

		textCorreo = new JTextField();
		textCorreo.setBounds(634, 295, 146, 26);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(225, 295, 146, 26);
		contentPane.add(textNombre);

		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(223, 204, 146, 26);
		contentPane.add(textUsuario);

		textFechaNac = new JTextField();
		textFechaNac.setColumns(10);
		textFechaNac.setBounds(634, 200, 146, 26);
		contentPane.add(textFechaNac);

		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(634, 246, 146, 26);
		contentPane.add(textDni);
		label.setIcon(new ImageIcon(image));
		contentPane.add(label);

		JLabel label_1 = new JLabel("Usuario");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(255, 215, 0));
		label_1.setFont(new Font("Stencil", Font.BOLD, 25));
		label_1.setBackground(new Color(255, 215, 0));
		label_1.setBounds(25, 193, 185, 40);
		contentPane.add(label_1);

		JLabel lblDeustoTickets = new JLabel("Deusto Tickets");
		lblDeustoTickets.setBackground(new Color(255, 255, 0));
		lblDeustoTickets.setBorder(UIManager.getBorder("Button.border"));
		lblDeustoTickets.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDeustoTickets.setFont(new Font("Stencil", Font.PLAIN, 94));
		lblDeustoTickets.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeustoTickets.setForeground(new Color(255, 200, 0));
		lblDeustoTickets.setBounds(-16, -36, 836, 228);
		contentPane.add(lblDeustoTickets);
		label.setIcon(new ImageIcon(image));
		contentPane.add(label);

		JButton button = new JButton("Nuevo Usuario");
		button.setFont(new Font("Stencil", Font.PLAIN, 25));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(255, 215, 0));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Dni = textDni.getText();
				String nombre = textNombre.getText();
				String correo = textCorreo.getText();
				String apellido = textoApellido.getText();
				String contrasenya = textContrasenya.getText();
				String usuario = textUsuario.getText();
				String fecha = textFechaNac.getText();

				if (nombre.equals("") || apellido.equals("") || usuario.equals("") || Dni.equals("")
						|| correo.equals("") || contrasenya.equals("") || fecha.equals("")) {

					JOptionPane.showMessageDialog(Registro.this, "No dejes ningun campo vacio" + nombre);
				} else {
					char[] caracteres = fecha.toCharArray();
					String day = "" + caracteres[0] + caracteres[1];
					String month = "" + caracteres[3] + caracteres[4];
					String year = "" + caracteres[6] + caracteres[7] + caracteres[8] + caracteres[9];

					int dia = Integer.parseInt(day);
					int mes = Integer.parseInt(month);
					int anyo = Integer.parseInt(year);

					Calendar calendar = Calendar.getInstance();
					calendar.set(Calendar.YEAR, anyo);
					calendar.set(Calendar.MONTH, mes - 1);
					calendar.set(Calendar.DAY_OF_MONTH, dia);
					Date date = calendar.getTime();

					ArrayList<EntradaDTO> entradas = new ArrayList<EntradaDTO>();

					ClienteDTO cliente = new ClienteDTO();

					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setUsuario(usuario);
					cliente.setDni(Dni);
					cliente.setEmail(correo);
					cliente.setContrasenya(contrasenya);
					cliente.setFecNac(date);
					cliente.setEntradas(entradas);

					Boolean respuesta = controller.Registrar(cliente);
					if (!respuesta) {
						JOptionPane.showMessageDialog(Registro.this,
								"El usuario que has introducido ya existe, por favor vuelva a realizar el registro");
						Registro ventana = new Registro(controller);
						ventana.setVisible(true);
						Registro.this.dispose();
					} else {
						JOptionPane.showMessageDialog(Registro.this, "Te has registrado correctamente");
						MenuCliente ventana = new MenuCliente(controller, cliente);
						ventana.setVisible(true);
						Registro.this.dispose();
					}
				}
			}
		});
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.setOpaque(true);
		button.setBounds(518, 436, 276, 40);
		contentPane.add(button);
	}

}
