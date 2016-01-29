import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;


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
	setBounds(300, 12, 900, 700);
	contentPane = new JPanel();
	contentPane.setForeground(new Color(25, 25, 112));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	//FONDO
			setIconImage(new ImageIcon(getClass().getResource("/imagen/logoass.png")).getImage());
			((JPanel)getContentPane()).setOpaque(false);
			ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagen/bio.jpg")); 
			JLabel fondo= new JLabel(); 
			fondo.setIcon(uno); 
			getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
			fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
			Dimension tam=getSize();
			setSize(tam.width,tam.height);
			setVisible(true);
		
		JLabel lblGames = new JLabel("");
		lblGames.setIcon(new ImageIcon(VentanaGame.class.getResource("/imagen/games.png")));
		lblGames.setForeground(new Color(72, 61, 139));
		lblGames.setFont(new Font("Bernard MT Condensed", Font.BOLD, 36));
		lblGames.setBounds(199, -13, 490, 223);
		getContentPane().add(lblGames);
		
		JLabel lblNombre = new JLabel("Name");
		lblNombre.setForeground(new Color(25, 25, 112));
		lblNombre.setFont(new Font("Bernard MT Condensed", Font.BOLD, 18));
		lblNombre.setBounds(70, 186, 54, 29);
		getContentPane().add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.BOLD, 18));
		lblNewLabel.setBounds(751, 196, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Punctuation ");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.BOLD, 18));
		lblNewLabel_1.setBounds(740, 297, 102, 17);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(25, 25, 112));
		lblAge.setFont(new Font("Bernard MT Condensed", Font.BOLD, 18));
		lblAge.setBounds(766, 431, 46, 29);
		getContentPane().add(lblAge);
		
		textFieldNameGame = new JTextField();
		textFieldNameGame.setForeground(new Color(0, 0, 102));
		textFieldNameGame.setFont(new Font("Rockwell Condensed", Font.BOLD, 16));
		textFieldNameGame.setBounds(49, 226, 112, 29);
		getContentPane().add(textFieldNameGame);
		textFieldNameGame.setColumns(10);
		
		 textFieldPriceGame = new JTextField();
		 textFieldPriceGame.setForeground(new Color(0, 0, 102));
		 textFieldPriceGame.setFont(new Font("Rockwell Condensed", Font.BOLD, 16));
		textFieldPriceGame.setBounds(751, 226, 61, 29);
		getContentPane().add(textFieldPriceGame);
		textFieldPriceGame.setColumns(10);
		
		textFieldPunGame = new JTextField();
		textFieldPunGame.setForeground(new Color(0, 0, 102));
		textFieldPunGame.setFont(new Font("Rockwell Condensed", Font.BOLD, 16));
		textFieldPunGame.setBounds(766, 344, 46, 29);
		getContentPane().add(textFieldPunGame);
		textFieldPunGame.setColumns(10);
		
		textField_Age = new JTextField();
		textField_Age.setForeground(new Color(0, 0, 102));
		textField_Age.setFont(new Font("Rockwell Condensed", Font.BOLD, 16));
		textField_Age.setBounds(766, 471, 46, 34);
		getContentPane().add(textField_Age);
		textField_Age.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Company");
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setFont(new Font("Bernard MT Condensed", Font.BOLD, 18));
		lblNewLabel_2.setBounds(49, 295, 86, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_3.setFont(new Font("Bernard MT Condensed", Font.BOLD, 18));
		lblNewLabel_3.setBounds(62, 434, 73, 14);
		getContentPane().add(lblNewLabel_3);
		
		textFieldCompany = new JTextField();
		textFieldCompany.setForeground(new Color(0, 0, 102));
		textFieldCompany.setFont(new Font("Rockwell Condensed", Font.BOLD, 16));
		textFieldCompany.setBounds(49, 334, 112, 29);
		getContentPane().add(textFieldCompany);
		textFieldCompany.setColumns(10);
		
		textFieldGender = new JTextField();
		textFieldGender.setForeground(new Color(0, 0, 102));
		textFieldGender.setFont(new Font("Rockwell Condensed", Font.BOLD, 16));
		textFieldGender.setBounds(49, 471, 112, 34);
		getContentPane().add(textFieldGender);
		textFieldGender.setColumns(10);
		
		JButton ButtonGuardar = new JButton("SAVE");
		ButtonGuardar.setForeground(new Color(0, 0, 51));
		ButtonGuardar.setBackground(new Color(51, 51, 204));
		ButtonGuardar.setFont(new Font("Stencil", Font.BOLD, 18));
		ButtonGuardar.setBounds(371, 572, 196, 34);
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
	