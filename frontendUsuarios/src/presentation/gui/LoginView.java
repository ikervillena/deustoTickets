package presentation.gui;

import business.controller.Controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

    private JPanel contentPane;
    private JTextField txtUsuario;
    private JPasswordField pwdContrasenya;

    /**
     * Create the frame.
     */
    public LoginView(Controller loginController) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 878, 587);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblLogin.setBounds(385, 62, 75, 83);
        panel.add(lblLogin);

        txtUsuario = new JTextField();
        txtUsuario.setText("Usuario");
        txtUsuario.setBounds(350, 231, 146, 26);
        panel.add(txtUsuario);
        txtUsuario.setColumns(10);

        pwdContrasenya = new JPasswordField();
        pwdContrasenya.setText("Contrasenya");
        pwdContrasenya.setBounds(350, 317, 146, 26);
        panel.add(pwdContrasenya);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnAceptar.setBounds(365, 402, 115, 29);
        panel.add(btnAceptar);
    }

}
