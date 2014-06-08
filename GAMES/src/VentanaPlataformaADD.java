import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class VentanaPlataformaADD extends JFrame{
	private Plataforma myPlataforma;
	private JPanel contentPane;
	private JTextField textField_Plataforma;
	private JTextField textField_NumGames;	
	private ArrayList<Plataforma> myPlataformas;
	private JComboBox<Plataforma> ComboPlataformas;
	private DATABASE_GAMESTOP frameGameStop;
	private DATA myData = new DATA();
	
	
	
	public VentanaPlataformaADD( final Plataforma myPlataforma,final DATA myData, JComboBox<Plataforma> ComboBoxPlataforma) {
		
		//CerrarVentana();
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				System.out.println("No hay Plataformas disponibles");
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		
	
		
		this.myPlataforma = myPlataforma;
		ComboPlataformas = ComboBoxPlataforma;
		
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 780, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(SystemColor.textHighlightText);
		
		contentPane.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//FONDO
				setIconImage(new ImageIcon(getClass().getResource("/imagen/logoass.png")).getImage());
				((JPanel)getContentPane()).setOpaque(false);
				ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagen/limbo.jpg")); 
				JLabel fondo= new JLabel(); 
				fondo.setIcon(uno); 
				getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
				fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
				Dimension tam=getSize();
				setSize(tam.width,tam.height);
				setVisible(true);
		
		
		JLabel lblPlataforma = new JLabel("Platform");
		lblPlataforma.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		lblPlataforma.setBounds(234, 42, 92, 24);
		getContentPane().add(lblPlataforma);
		
		JLabel lblNGames = new JLabel("N\u00BA Games");
		lblNGames.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
		lblNGames.setBounds(234, 272, 102, 23);
		getContentPane().add(lblNGames);
		
		textField_Plataforma = new JTextField();
		textField_Plataforma.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Plataforma.setForeground(new Color(105, 105, 105));
		textField_Plataforma.setBackground(new Color(253, 245, 230));
		textField_Plataforma.setBounds(174, 77, 203, 20);
		getContentPane().add(textField_Plataforma);
		textField_Plataforma.setColumns(10);
		
		textField_NumGames = new JTextField();
		textField_NumGames.setHorizontalAlignment(SwingConstants.CENTER);
		textField_NumGames.setForeground(new Color(105, 105, 105));
		textField_NumGames.setBackground(new Color(250, 240, 230));
		textField_NumGames.setBounds(252, 318, 73, 20);
		getContentPane().add(textField_NumGames);
		textField_NumGames.setColumns(10);
		
		JButton btnADDPlataforma = new JButton("ADD");
		btnADDPlataforma.setBackground(SystemColor.window);
		btnADDPlataforma.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnADDPlataforma.setBounds(237, 367, 112, 32);
		contentPane.add(btnADDPlataforma);
		
		btnADDPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//myPlataforma.setnombrePlataforma(textField_Plataforma.getText());
				//myPlataforma.setnumGames(Integer.valueOf(textField_NumGames.getText()));
				myPlataforma.setPlataforma(textField_Plataforma.getText(),Integer.valueOf(textField_NumGames.getText()));
				myPlataforma.savePlataforma(myPlataforma,ComboPlataformas);
				
				
				
			}


		});
		
	
		
	
		
}
	
	
	private void refrescar(){
		ComboPlataformas.removeAllItems();
		myPlataformas = myData.readPlataforma();
		if(myPlataformas.size()==0){
			System.out.println("No hay Plataformas disponibles");
		}else {
			for(int i=0;i<myPlataformas.size();i++){
				ComboPlataformas.addItem(myPlataformas.get(i));
			}
		}
	}
	
}

