package presentation.gui;

import business.controller.Controller;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import business.clases.*;
import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;

import javax.swing.JOptionPane;

public class DescargaEntrada extends JFrame {

    private JPanel contentPane;

    public DescargaEntrada(Controller controller, ClienteDTO cliente, Evento evento, ArrayList<EntradaDTO> entradas) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 831, 569);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 248, 220));
        contentPane.setForeground(new Color(255, 248, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("");
        label.setBounds(0, 0, 820, 513);
        ImageIcon imageIcon = new ImageIcon(
                "C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\fotofiesta.jpg");
        Image image = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);

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
        lblNewLabel_1.setBounds(117, 108, 633, 63);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton_2 = new JButton("TELEGRAM");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mensaje = "Necesitamos tu chatID, sigue los pasos a continuación para obtenerlo:\n" +
                        "1. Abre la aplicación de Telegram en tu dispositivo.\n" +
                        "2. Busca el bot llamado @DeustoTickets y ábrelo.\n" +
                        "3. Inicia una conversación con el bot si no hay una existente.\n" +
                        "4. Busca el bot llamado @UserInfoBot e inicia una conversación.\n" +
                        "5. Copia el número que aparece en la parte inferior como 'ChatID'.\n" +
                        "6. Vuelve a esta ventana, pega el ChatID en el cuadro de diálogo y haz clic en 'Aceptar'.";

                String chatID = JOptionPane.showInputDialog(DescargaEntrada.this, mensaje);
                boolean respuesta = controller.enviarEntradas(entradas, chatID, false);
                if (!respuesta) {
                    JOptionPane.showMessageDialog(DescargaEntrada.this,
                            "Las entradas han sido enviadas a tu telegram.");
                } else {
                    JOptionPane.showMessageDialog(DescargaEntrada.this,
                            "Las entradas no han podido ser enviadas.");
                }

            }
        });
        btnNewButton_2.setBackground(new Color(255, 215, 0));
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.setFont(new Font("Stencil", Font.BOLD, 20));
        btnNewButton_2.setBounds(117, 293, 619, 63);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("ENVIAR POR CORREO");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean respuesta = controller.enviarEntradas(entradas, cliente.getEmail(), true);
                if (!respuesta) {
                    JOptionPane.showMessageDialog(DescargaEntrada.this,
                            "Las entradas han sido enviadas a tu direccion de email.");
                } else {
                    JOptionPane.showMessageDialog(DescargaEntrada.this,
                            "Las entradas no han podido ser enviadas.");
                }

            }
        });
        btnNewButton_3.setBackground(new Color(255, 215, 0));
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.setFont(new Font("Stencil", Font.BOLD, 20));
        btnNewButton_3.setBounds(117, 198, 619, 63);
        contentPane.add(btnNewButton_3);
        label.setIcon(new ImageIcon(image));
        contentPane.add(label);

        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuCliente ventana = new MenuCliente(controller, cliente);
                ventana.setVisible(true);
                DescargaEntrada.this.dispose();
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
