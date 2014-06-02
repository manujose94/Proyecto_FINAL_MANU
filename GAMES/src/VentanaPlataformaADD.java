import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPlataformaADD extends JFrame{
	private Plataforma myPlataforma;
	private JPanel contentPane;
	private JTextField textField_Plataforma;
	private JTextField textField_NumGames;	
	private JComboBox<Plataforma> ComboPlataformas;
	
	
	public VentanaPlataformaADD( final Plataforma myPlataforma,final DATA myData, JComboBox<Plataforma> ComboBoxPlataforma) {
		
		
		this.myPlataforma = myPlataforma;
		ComboPlataformas = ComboBoxPlataforma;
		
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 456, 320);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblPlataforma = new JLabel("Platform");
		lblPlataforma.setBounds(180, 11, 62, 14);
		getContentPane().add(lblPlataforma);
		
		JLabel lblNGames = new JLabel("N\u00BA Games");
		lblNGames.setBounds(193, 122, 49, 14);
		getContentPane().add(lblNGames);
		
		textField_Plataforma = new JTextField();
		textField_Plataforma.setBounds(113, 36, 203, 20);
		getContentPane().add(textField_Plataforma);
		textField_Plataforma.setColumns(10);
		
		textField_NumGames = new JTextField();
		textField_NumGames.setBounds(180, 147, 73, 20);
		getContentPane().add(textField_NumGames);
		textField_NumGames.setColumns(10);
		
		JButton btnADDPlataforma = new JButton("ADD");
		btnADDPlataforma.setBounds(164, 214, 89, 23);
		contentPane.add(btnADDPlataforma);
		
		btnADDPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPlataforma.setnombrePlataforma(textField_Plataforma.getText());
				myPlataforma.setnumGames(Integer.valueOf(textField_NumGames.getText()));
				myPlataforma.savePlataforma(myPlataforma,ComboPlataformas);
				
			}
		});
}
}
