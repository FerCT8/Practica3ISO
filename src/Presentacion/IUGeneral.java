package Presentacion;

import Dominio.Administrador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class IUGeneral extends JFrame{
        private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
        private JTextField textFieldDNI;
        private JTextField textFieldNombre;
        private JTextField textFieldPermiso;
        
	private JTextPane textPane;

	public IUGeneral() {
		setTitle("Bienvenido a la interfaz General del programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label_1 = new JLabel("Lista");
		label_1.setForeground(Color.RED);
		label_1.setBounds(6, 130, 61, 16);
		contentPane.add(label_1);
                
		textPane = new JTextPane();
		textPane.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
		textPane.setEditable(false);
		textPane.setBounds(6, 154, 407, 102);
		contentPane.add(textPane);
		
		JButton btnAltaUsuario = new JButton("Mostrar Lista");
		btnAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					textPane.setText("Aqui va la lista");	
					label_1.setForeground(Color.GREEN);
					
				} catch (Exception e) {
					
						textPane.setText("No se ha podido insertar el usuario "+e);	
						label_1.setForeground(Color.RED);
				}
			}
		});
		btnAltaUsuario.setBounds(253, 76, 117, 29);
		contentPane.add(btnAltaUsuario);
		
	}
}