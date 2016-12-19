package Presentacion;

import Dominio.GestorListado;
import Dominio.GestorPiezas;
import Dominio.Listado;
import Dominio.Piezas;
import Dominio.Producto;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class IUGeneral extends JFrame {

    private JPanel contentPane;

    private JTextField textFieldCodigo;
    private JTextField textFieldNombre;
    private JTextPane textPane;

    public IUGeneral() {

        setTitle("IUVENTAS-Inserte un producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 285);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textPane = new JTextPane();
        textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
        textPane.setEditable(false);
        textPane.setBounds(6, 154, 407, 500);
        contentPane.add(textPane);

        JButton btnMostrar = new JButton("Mostrar Lista");
        btnMostrar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                   try {
                        String Codigo=Listado.Mostrar().getCodigo();
                        String Nombre=Listado.Mostrar().getNombre();
                        textPane.setText(Codigo+Nombre);
                   
                } catch (Exception e) {
                    textPane.setText("Error " + e);

                }
            }
        });
        btnMostrar.setBounds(253, 30, 117, 29);
        contentPane.add(btnMostrar);

    }
}