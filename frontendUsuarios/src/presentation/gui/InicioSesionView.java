package presentation.gui;

import business.controller.Controller;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;

public class InicioSesionView extends JFrame {

	private JPanel contentPane;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesionView frame = new InicioSesionView(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioSesionView(Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(0, 0, 820, 513);
		ImageIcon imageIcon = new ImageIcon("C:\\workspace\\imagenes\\fotofiesta.jpg");
		Image image = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		
		JButton btnNewButton = new JButton("Inicio Sesion");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioView ventana = new InicioView(controller);
				ventana.setVisible(true);
				InicioSesionView.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(192, 374, 423, 43);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Nuevo Usuario");
		button.setFont(new Font("Stencil", Font.PLAIN, 25));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(255, 215, 0));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroView ventana1 = new RegistroView(controller);
				ventana1.setVisible(true);
				InicioSesionView.this.setVisible(false);
			}
		});
		button.setBorder(BorderFactory.createEmptyBorder());
		
		button.setBounds(192, 433, 423, 43);
		contentPane.add(button);
		
		
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
