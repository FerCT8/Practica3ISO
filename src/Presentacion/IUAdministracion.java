package Presentacion;

import Dominio.Administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IUAdministracion extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldLogin;
    private JTextField textFieldPassword;
    private JTextField textFieldDNI;
    private JTextField textFieldNombre;
    private JTextField textFieldPermiso;

    private JTextPane textPane;

    public IUAdministracion() {
        setTitle("Dar de alta a un nuevo usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 285);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setBounds(6, 0, 69, 16);
        contentPane.add(lblLogin);
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(6, 30, 69, 16);
        contentPane.add(lblPassword);
        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setBounds(6, 60, 69, 16);
        contentPane.add(lblDNI);
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(6, 90, 69, 16);
        contentPane.add(lblNombre);
        JLabel lblPermiso = new JLabel("Permiso:");
        lblPermiso.setBounds(6, 120, 69, 16);
        contentPane.add(lblPermiso);

        textFieldLogin = new JTextField();
        textFieldLogin.setBounds(87, 0, 134, 28);
        contentPane.add(textFieldLogin);
        textFieldLogin.setColumns(10);

        textFieldPassword = new JTextField();
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(87, 30, 134, 28);
        contentPane.add(textFieldPassword);

        textFieldDNI = new JTextField();
        textFieldDNI.setBounds(87, 60, 134, 28);
        contentPane.add(textFieldDNI);
        textFieldDNI.setColumns(10);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(87, 90, 134, 28);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldPermiso = new JTextField();
        textFieldPermiso.setBounds(87, 120, 134, 28);
        contentPane.add(textFieldPermiso);
        textFieldPermiso.setColumns(10);

        textPane = new JTextPane();
        textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
        textPane.setEditable(false);
        textPane.setBounds(6, 154, 407, 102);
        contentPane.add(textPane);

        JButton btnAltaUsuario = new JButton("Alta usuario");
        btnAltaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
				//c—digo necesario para insertar un nuevo usuario en la base de datos.
                //Se deber‡ comprobar que el usuario se ha insertado correctamente intentando 
                //hacer el login			
                //Se deber‡ reportar en el panel de estado el resultado de la inserci—n. Tanto su exito
                //como cualquier excepci—n que pueda surgir.

                String Login = textFieldLogin.getText();
                String Password = textFieldPassword.getText();
                String DNI = textFieldDNI.getText();
                String Nombre = textFieldNombre.getText();
                String Permission = textFieldPermiso.getText();
                int Permiso = Integer.parseInt(Permission);

                try {
                    if (Login.equals("") || Password.equals("")) {

                        textPane.setText("Inserte un usuario y contraseña!");

                    } else {

                        Administrador.nuevoUsuario(Login, Password, DNI, Nombre, Permiso);
                        textPane.setText("Usuario insertado correctamente: Bienvenid@ " + Login);;
                    }

                } catch (Exception e) {

                    textPane.setText("No se ha podido insertar el usuario " + e);
                }
            }
        });
        btnAltaUsuario.setBounds(253, 76, 117, 29);
        contentPane.add(btnAltaUsuario);

    }
}
