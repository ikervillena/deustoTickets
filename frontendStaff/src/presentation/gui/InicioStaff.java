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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;


public class InicioStaff extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InicioStaff(Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 820, 513);
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\fotofiesta.jpg");
		Image image = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		
		JButton btnNewButton = new JButton("Inicio Sesion");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioSesionStaff ventana = new InicioSesionStaff(controller);
				ventana.setVisible(true);
				InicioStaff.this.dispose();;
			}
		});
		btnNewButton.setBounds(192, 374, 423, 43);
		contentPane.add(btnNewButton);
		
		
		JLabel lblDeustoTickets = new JLabel("Deusto Tickets");
		lblDeustoTickets.setBackground(new Color(255, 255, 0));
		lblDeustoTickets.setBorder(UIManager.getBorder("Button.border"));
		lblDeustoTickets.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDeustoTickets.setFont(new Font("Stencil", Font.PLAIN, 94));
		lblDeustoTickets.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeustoTickets.setForeground(new Color(255, 200, 0));
		lblDeustoTickets.setBounds(-12, 102, 836, 228);
		contentPane.add(lblDeustoTickets);
		label.setIcon(new ImageIcon(image));
		contentPane.add(label);
	}

}
