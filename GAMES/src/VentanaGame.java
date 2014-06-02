import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;


public class VentanaGame extends JFrame {
	private Plataforma myPlataforma2;
	private Games myGames2 ;
	private DATA myData2;
	
	private JPanel contentPane;
	private DATABASE_GAMESTOP gamestop;
	private JTextField textFieldPriceGame;
	private JComboBox<Games> comboBoxGames2;
	private JButton btnGuardar;
	private JTextField textFieldNameGame;
	private JTextField textFieldPunGame;
	private JTextField textField_Age;
	private JTextField textFieldCompany;
	private JTextField textFieldGender;
	
	

public VentanaGame(Games game, DATA data , Plataforma plataforma  , JComboBox<Games> comboGames) {
	myPlataforma2=plataforma;
	myGames2=game;
	myData2=data;
	comboBoxGames2=comboGames;
	
	addWindowListener(new WindowAdapter() {
		
		public void windowOpened(WindowEvent arg0) {
			textFieldNameGame.setText(myGames2.toString());
			textFieldGender.setText(myGames2.toStringGenero());
			textFieldCompany.setText(myGames2.toStringCompañia());
			textFieldPriceGame.setText(String.valueOf(myGames2.getPrecio()));
			textFieldPunGame.setText(String.valueOf(myGames2.getPuntuacion()));
			textField_Age.setText(String.valueOf(myGames2.getEdadRecomendada()));
			
			
		}
		
	});
	
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setBounds(100, 100, 447, 285);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
		
		
		JLabel lblGames = new JLabel("GAMES");
		lblGames.setBounds(179, 11, 46, 14);
		getContentPane().add(lblGames);
		
		JLabel lblNombre = new JLabel("Name");
		lblNombre.setBounds(39, 51, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(280, 51, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Punctuation ");
		lblNewLabel_1.setBounds(280, 108, 68, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(280, 152, 46, 14);
		getContentPane().add(lblAge);
		
		textFieldNameGame = new JTextField();
		textFieldNameGame.setBounds(39, 64, 86, 20);
		getContentPane().add(textFieldNameGame);
		textFieldNameGame.setColumns(10);
		
		 textFieldPriceGame = new JTextField();
		textFieldPriceGame.setBounds(262, 64, 86, 20);
		getContentPane().add(textFieldPriceGame);
		textFieldPriceGame.setColumns(10);
		
		textFieldPunGame = new JTextField();
		textFieldPunGame.setBounds(269, 121, 86, 20);
		getContentPane().add(textFieldPunGame);
		textFieldPunGame.setColumns(10);
		
		textField_Age = new JTextField();
		textField_Age.setBounds(280, 169, 86, 20);
		getContentPane().add(textField_Age);
		textField_Age.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Company");
		lblNewLabel_2.setBounds(39, 108, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBounds(39, 152, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		textFieldCompany = new JTextField();
		textFieldCompany.setBounds(39, 121, 86, 20);
		getContentPane().add(textFieldCompany);
		textFieldCompany.setColumns(10);
		
		textFieldGender = new JTextField();
		textFieldGender.setBounds(39, 169, 86, 20);
		getContentPane().add(textFieldGender);
		textFieldGender.setColumns(10);
		
		JButton ButtonGuardar = new JButton("SAVE");
		ButtonGuardar.setBounds(107, 214, 196, 23);
		getContentPane().add(ButtonGuardar);
		ButtonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myGames2.setnombreGame(textFieldNameGame.getText());
				myGames2.setCompañia(textFieldCompany.getText());
				myGames2.setGenero(textFieldGender.getText());
				myGames2.setEdadRecomendada(Integer.valueOf(textField_Age.getText()));
				myGames2.setPrecio(Integer.valueOf(textFieldPriceGame.getText()));
				myGames2.setPuntuacion(Integer.valueOf(textFieldPunGame.getText()));
				//myGames2.setPuntuacion(Puntuacion);(Integer.valueOf(textField_Punt.getText()));
				System.out.println(myGames2.getIdGame() + "<-Idhgame----save ventanagame" );
				myPlataforma2.addGame(myGames2);
				comboBoxGames2.addItem(myGames2);
				//myData2.saveGame(myGames2);
			}
		});
		
		
	}
}
	