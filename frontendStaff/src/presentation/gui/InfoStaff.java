package presentation.gui;

import business.controller.Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import business.clases.*;
import business.clases.dto.ClienteDTO;
import business.clases.dto.EntradaDTO;

import java.util.ArrayList;
import java.util.Date;

public class InfoStaff extends JFrame {

    private JPanel contentPane;

    public InfoStaff(Controller controller, Staff staff) {
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
        menuBar.add(btnNewButton);
        JLabel lblNewLabel_1 = new JLabel(staff.getUsuario());
        lblNewLabel_1.setBackground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 40));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(255, 215, 0));
        ImageIcon icon = new ImageIcon(
                "C:\\Users\\ALUMNO\\Desktop\\deustoTickets\\deustoTickets\\frontendUsuarios\\resources\\images\\usuario.png");
        Image img = icon.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        lblNewLabel_1.setIcon(icon);
        lblNewLabel_1.setBounds(153, 100, 493, 67);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Informacion personal");
        lblNewLabel_2.setBackground(new Color(248, 248, 255));
        lblNewLabel_2.setForeground(new Color(255, 215, 0));
        lblNewLabel_2.setFont(new Font("Stencil", Font.BOLD, 22));
        lblNewLabel_2.setBounds(61, 200, 312, 33);
        contentPane.add(lblNewLabel_2);

        JLabel lblUsuario = new JLabel("NOMBRE");
        lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsuario.setForeground(new Color(210, 180, 140));
        lblUsuario.setFont(new Font("Stencil", Font.BOLD, 20));
        lblUsuario.setBackground(new Color(255, 215, 0));
        lblUsuario.setBounds(250, 280, 129, 40);
        contentPane.add(lblUsuario);

        JLabel lblApellidos = new JLabel("APELLIDOS");
        lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
        lblApellidos.setForeground(new Color(210, 180, 140));
        lblApellidos.setFont(new Font("Stencil", Font.BOLD, 20));
        lblApellidos.setBackground(new Color(255, 215, 0));
        lblApellidos.setBounds(250, 320, 122, 40);
        contentPane.add(lblApellidos);

        JLabel label_2 = new JLabel("FECHA NAC");
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setForeground(new Color(210, 180, 140));
        label_2.setFont(new Font("Stencil", Font.BOLD, 20));
        label_2.setBackground(new Color(255, 215, 0));
        label_2.setBounds(250, 360, 136, 40);
        contentPane.add(label_2);

        JLabel label_1 = new JLabel("Email");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setForeground(new Color(210, 180, 140));
        label_1.setFont(new Font("Stencil", Font.BOLD, 20));
        label_1.setBackground(new Color(255, 215, 0));
        label_1.setBounds(250, 400, 136, 40);
        contentPane.add(label_1);

        JLabel InfoUsuario = new JLabel(staff.getEmail());
        InfoUsuario.setBounds(450, 400, 200, 20);
        contentPane.add(InfoUsuario);

        JLabel InfoNombre = new JLabel(staff.getNombre());
        InfoNombre.setBounds(450, 280, 69, 20);
        contentPane.add(InfoNombre);

        JLabel InfoApellido = new JLabel(staff.getApellido());
        InfoApellido.setBounds(450, 320, 69, 20);
        contentPane.add(InfoApellido);

        Date fecha = staff.getFecNac();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaString = formatter.format(fecha);
        char[] caracteres = fechaString.toCharArray();

        JLabel InfoFechaNac = new JLabel("" + caracteres[0] + caracteres[1] + caracteres[2] + caracteres[3]
                + caracteres[4] + caracteres[5] + caracteres[6] + caracteres[7] + caracteres[8] + caracteres[9]);
        InfoFechaNac.setBounds(450, 360, 69, 20);
        contentPane.add(InfoFechaNac);

        JButton btnNewButton_2 = new JButton("BACK");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuStaff ventana = new MenuStaff(controller, staff);
                ventana.setVisible(true);
                InfoStaff.this.dispose();
            }
        });
        btnNewButton_2.setBackground(new Color(255, 0, 0));
        btnNewButton_2.setFont(new Font("Stencil", Font.BOLD, 22));
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.setBounds(658, 453, 136, 29);
        contentPane.add(btnNewButton_2);

    }
}