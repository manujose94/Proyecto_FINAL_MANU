import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;


public class VentanaPlataforma extends JFrame{
	private Plataforma myPlataforma;
	private JPanel contentPane;
	private Games myGames;
	private DATA myData;
	private JTextField textField_Plataforma;
	private JTextField textField_NumGames;
	private JComboBox<Games> ComboBoxGames;
	private JComboBox<Plataforma> ComboPlataformas;
	
	private ArrayList<Games> myGamesPlat;
	
	public VentanaPlataforma( final Plataforma myPlataforma,final DATA myData, JComboBox<Plataforma> ComboBoxPlataforma) {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				refrescarData();
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		this.myPlataforma = myPlataforma;
		this.myData = myData;
		ComboPlataformas = ComboBoxPlataforma;
		
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 620, 530);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(139, 0, 0));
		contentPane.setBackground(new Color(255, 245, 238));
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblPlataforma = new JLabel("Platform");
		lblPlataforma.setForeground(new Color(128, 0, 0));
		lblPlataforma.setBackground(new Color(128, 0, 0));
		lblPlataforma.setFont(new Font("Old English Text MT", Font.BOLD, 29));
		lblPlataforma.setBounds(224, 0, 132, 34);
		getContentPane().add(lblPlataforma);
		
		JLabel lblNGames = new JLabel("N\u00BA Games");
		lblNGames.setForeground(Color.RED);
		lblNGames.setBackground(Color.RED);
		lblNGames.setFont(new Font("Old English Text MT", Font.BOLD, 22));
		lblNGames.setBounds(224, 247, 107, 26);
		getContentPane().add(lblNGames);
		
		textField_Plataforma = new JTextField();
		textField_Plataforma.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_Plataforma.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Plataforma.setForeground(new Color(220, 20, 60));
		textField_Plataforma.setBackground(Color.WHITE);
		textField_Plataforma.setBounds(212, 34, 166, 34);
		getContentPane().add(textField_Plataforma);
		textField_Plataforma.setColumns(10);
		
		textField_NumGames = new JTextField();
		textField_NumGames.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_NumGames.setHorizontalAlignment(SwingConstants.CENTER);
		textField_NumGames.setForeground(new Color(139, 0, 0));
		textField_NumGames.setBackground(new Color(230, 230, 250));
		textField_NumGames.setBounds(246, 273, 73, 33);
		getContentPane().add(textField_NumGames);
		textField_NumGames.setColumns(10);
		
		ComboBoxGames = new JComboBox<Games>();
		ComboBoxGames.setForeground(new Color(128, 0, 0));
		ComboBoxGames.setBackground(new Color(178, 34, 34));
		ComboBoxGames.setFont(new Font("Tahoma", Font.BOLD, 12));
		ComboBoxGames.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println(ComboBoxGames.getSelectedIndex());
		}
	});
		ComboBoxGames.setBounds(146, 419, 314, 33);
	getContentPane().add(ComboBoxGames);
	
		JButton btnModGame = new JButton("Mod. Game");
		btnModGame.setBackground(new Color(47, 79, 79));
		btnModGame.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModGame.setForeground(new Color(220, 20, 60));
		btnModGame.setBounds(234, 333, 97, 23);
		getContentPane().add(btnModGame);
		btnModGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				myGames = myGamesPlat.get(ComboBoxGames.getSelectedIndex());
				System.out.println(myGames.toString() + " mod " );
				VentanaGame frame = new VentanaGame(myGames,myData,myPlataforma,ComboBoxGames);
				frame.setVisible(true);
				
			}
			
		});
	
		JButton btnAddGame = new JButton("Add Game");
		btnAddGame.setBackground(new Color(47, 79, 79));
		btnAddGame.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddGame.setForeground(new Color(220, 20, 60));
		btnAddGame.setBounds(28, 333, 104, 23);
		getContentPane().add(btnAddGame);
		 btnAddGame.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			myPlataforma.setnombrePlataforma(textField_Plataforma.getText());
			myGames = new Games(myPlataforma.getIdPlataforma());
			//System.out.println(myGamesPlat.size());
			VentanaGame frame = new VentanaGame(myGames,myData,myPlataforma,ComboBoxGames);
			frame.setVisible(true);
			refrescarData();
		}
		
	});

		JButton btnDeleteGame = new JButton("Delete Game");
		btnDeleteGame.setBackground(new Color(47, 79, 79));
		btnDeleteGame.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteGame.setForeground(new Color(220, 20, 60));
		btnDeleteGame.setBounds(457, 333, 117, 23);
		getContentPane().add(btnDeleteGame);
		btnDeleteGame.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			myGames = myGamesPlat.get(ComboBoxGames.getSelectedIndex());
			System.out.println(ComboBoxGames.getSelectedItem());
			myPlataforma.rmGame(ComboBoxGames.getSelectedIndex(), myGames);
			
			refrescarData();
		}
		
	});
		
		
		//JButton buttRef = new JButton("Ref");
		//buttRef.setBounds(205, 302, 55, 23);
		//contentPane.add(buttRef);
		//buttRef.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
			
			 //myData.readGames(myPlataforma.getIdPlataforma());
			// ComboBoxGames.removeAllItems();
		//	refrescarDatos2();
			 
			
		//	}
	//	});
	// OJIIIITTOOOOO MIRAR -..>
		
	/**
		JButton btnsavePlataforma = new JButton("saveplata");
		btnsavePlataforma.setBackground(new Color(47, 79, 79));
		btnsavePlataforma.setForeground(new Color(128, 0, 0));
		btnsavePlataforma.setBounds(254, 153, 89, 34);
		contentPane.add(btnsavePlataforma);
		btnsavePlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPlataforma.setnombrePlataforma(textField_Plataforma.getText());
				myPlataforma.setnumGames(Integer.valueOf(textField_NumGames.getText()));
				//pasamo a la calse Platador al metodo savePlataforma pasadole la platfora y el combobox
					//Luego este metodo llama el metodo savePlatafor en BBDD  en Data
				myPlataforma.savePlataforma(myPlataforma, ComboPlataformas);
				
			}
		});
		refrescarData();
	**/
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPlataforma.class.getResource("/imagen/wit.png")));
		lblNewLabel.setBounds(87, 0, 432, 496);
		contentPane.add(lblNewLabel);
		
	}
	
		private void refrescarData(){
		
			ComboBoxGames.removeAllItems();
			//para que que recarga cada uno de los equipos del arayliat gamePlataforma
			myGamesPlat = myPlataforma.getgamePlataforma();
			textField_Plataforma.setText(myPlataforma.toString());
			textField_NumGames.setText(String.valueOf(myGamesPlat.size()));
			//Volvemos a rellenar el array 
			for(int i=0;i<myGamesPlat.size();i++){
				ComboBoxGames.addItem(myGamesPlat.get(i));
			}
		
	}
}


