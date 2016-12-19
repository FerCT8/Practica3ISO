package Presentacion;

import Dominio.GestorAcceso;
import Dominio.GestorListado;
import Dominio.GestorPiezas;
import Dominio.Listado;
import Dominio.Piezas;
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

public class IUMantenimiento extends JFrame {

    private JPanel contentPane;

    private JTextField textFieldCodigo;
    private JTextField textFieldNombre;
    private JTextPane textPane;

    public IUMantenimiento() {

        setTitle("IUMAN-Inserte una pieza");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 285);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ESTO ES LO DE LAS ETIQUETAS
        JLabel lblCodigo = new JLabel("CODIGO:");
        lblCodigo.setBounds(6, 0, 69, 16);
        contentPane.add(lblCodigo);

        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setBounds(6, 30, 69, 16);
        contentPane.add(lblNombre);

        JLabel label_1 = new JLabel("Estado");
        label_1.setForeground(Color.RED);
        label_1.setBounds(6, 160, 61, 16);
        contentPane.add(label_1);

        //ESTO ES LO DE LAS VENTANAS
        textFieldCodigo = new JTextField();
        textFieldCodigo.setBounds(87, 0, 134, 28);
        contentPane.add(textFieldCodigo);
        textFieldCodigo.setColumns(10);

        textFieldNombre = new JTextField();
        textFieldNombre.setColumns(10);
        textFieldNombre.setBounds(87, 30, 134, 28);
        contentPane.add(textFieldNombre);

        textPane = new JTextPane();
        textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
        textPane.setEditable(false);
        textPane.setBounds(6, 154, 407, 102);
        contentPane.add(textPane);

        JButton btnIntroducir = new JButton("Introducir");
        JButton btnComprobar = new JButton("Comprobar");
        
        btnIntroducir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                String Codigo = textFieldCodigo.getText();
                String Nombre = textFieldNombre.getText();

                try {
                    if (Codigo.equals("") || Nombre.equals("")) {

                        textPane.setText("Inserte una nueva pieza con su correspondiente codigo y nombre");
                    } else {
                        GestorPiezas.nuevoPieza(Codigo, Nombre);
                        textPane.setText("Pieza insertada con exito datos: " + Codigo + " " + Nombre);
                        label_1.setForeground(Color.GREEN);

                    }

                } catch (Exception e) {
                    textPane.setText("Error,pieza no insertada " + e);
                    label_1.setForeground(Color.RED);

                }
            }
        });

        btnComprobar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                String Codigo = textFieldCodigo.getText();
                String Nombre = textFieldNombre.getText();

                try {
                    if (GestorListado.ComprobarEnLista(Codigo, Nombre) == true) {
                        textPane.setText("Esta pieza existente en BBDD");
                        label_1.setForeground(Color.GREEN);
                    }else {
                        textPane.setText("No se ha encontrar la pieza");
                        label_1.setForeground(Color.RED);
                    }
                } catch (Exception e) {
                    textPane.setText("Error " + e);
                    label_1.setForeground(Color.RED);

                }
            }
        });

        btnIntroducir.setBounds(253, 0, 117, 29);
        contentPane.add(btnIntroducir);
        btnComprobar.setBounds(253, 30, 117, 29);
        contentPane.add(btnComprobar);

    }
}
