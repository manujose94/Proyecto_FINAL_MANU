import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;


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
				//refrescarData();
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		this.myPlataforma = myPlataforma;
		this.myData = myData;
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
		
		ComboBoxGames = new JComboBox<Games>();
		ComboBoxGames.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println(ComboBoxGames.getSelectedIndex());
		}
	});
		ComboBoxGames.setBounds(72, 203, 314, 33);
	getContentPane().add(ComboBoxGames);
	
		JButton btnModGame = new JButton("Mod. Game");
		btnModGame.setBounds(156, 178, 122, 14);
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
		btnAddGame.setBounds(21, 178, 137, 14);
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
		btnDeleteGame.setBounds(276, 178, 129, 14);
		getContentPane().add(btnDeleteGame);
		btnDeleteGame.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			myGames = myGamesPlat.get(ComboBoxGames.getSelectedIndex());
			System.out.println(ComboBoxGames.getSelectedItem());
			myPlataforma.rmGame(ComboBoxGames.getSelectedIndex(), myGames);
			
			refrescarData();
		}
		
	});
		
		
		JButton buttRef = new JButton("Ref");
		buttRef.setBounds(198, 247, 55, 23);
		contentPane.add(buttRef);
		buttRef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			 //myData.readGames(myPlataforma.getIdPlataforma());
			// ComboBoxGames.removeAllItems();
		//	refrescarDatos2();
			 
			
			}
		});
	// OJIIIITTOOOOO MIRAR -..>
		
		
		JButton btnsavePlataforma = new JButton("saveplata");
		btnsavePlataforma.setBounds(164, 67, 89, 23);
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
		/**
		public void refrescarDatos2(){
			ComboBoxGames.removeAllItems();
			myData.readingGames(ComboBoxGames);
				
			myGames = (Games) ComboBoxGames.getSelectedItem();
				System.out.println("-"+myGames);
				
			}	**/
}


