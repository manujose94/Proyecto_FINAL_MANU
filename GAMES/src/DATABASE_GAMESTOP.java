

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;


public class DATABASE_GAMESTOP extends JFrame {
	
	private JComboBox<Plataforma> ComboPlataformas;
	private DATA myData = new DATA();
	private ArrayList<Plataforma> myPlataformas;
	private Plataforma myPlataforma;
	
	public DATABASE_GAMESTOP() {
		CerrarVentana();
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				refrescar();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 100, 850, 560);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//FONDO
		setIconImage(new ImageIcon(getClass().getResource("/imagen/logoass.png")).getImage());
		((JPanel)getContentPane()).setOpaque(false);
		ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagen/asse.jpg")); 
		JLabel fondo= new JLabel(); 
		fondo.setIcon(uno); 
		getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
		fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		Dimension tam=getSize();
		setSize(tam.width,tam.height);
		setVisible(true);
		
		
		ComboPlataformas = new  JComboBox<Plataforma>();
		ComboPlataformas.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
		ComboPlataformas.setBackground(new Color(0, 102, 255));
		ComboPlataformas.setBounds(146, 177, 332, 30);
		getContentPane().add(ComboPlataformas);
		
		JButton btnMODPALT = new JButton("");
		btnMODPALT.setSelectedIcon(new ImageIcon(DATABASE_GAMESTOP.class.getResource("/imagen/3b.png")));
		btnMODPALT.setIcon(new ImageIcon(DATABASE_GAMESTOP.class.getResource("/imagen/3.png")));
		//Boton transparente
		btnMODPALT.setOpaque(false);
		btnMODPALT.setContentAreaFilled(false);
		btnMODPALT.setBorderPainted(false);
		btnMODPALT.setBorderPainted(false);
		btnMODPALT.setBackground(new Color(173, 216, 230));
		btnMODPALT.setFont(new Font("Vijaya", Font.BOLD, 20));
		btnMODPALT.setBounds(123, 328, 423, 182);
		getContentPane().add(btnMODPALT);
		btnMODPALT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//Indicamos  Myplatoforma contega lo seccionado del combobox obtinido (get) del ArralyList Plataforma
			myPlataforma = myPlataformas.get(ComboPlataformas.getSelectedIndex());
			VentanaPlataforma frame = new VentanaPlataforma(myPlataforma, myData,ComboPlataformas);
			frame.setVisible(true);
		}
	});
		
		
	
		
		
		
		
		
		
		JButton btnADDPLAT = new JButton("");
		btnADDPLAT.setSelectedIcon(new ImageIcon(DATABASE_GAMESTOP.class.getResource("/imagen/2.b.png")));
		btnADDPLAT.setIcon(new ImageIcon(DATABASE_GAMESTOP.class.getResource("/imagen/2.png")));
		btnADDPLAT.setBackground(new Color(135, 206, 235));
		btnADDPLAT.setFont(new Font("Vijaya", Font.BOLD, 20));
		btnADDPLAT.setBounds(123, 0, 386, 176);
		getContentPane().add(btnADDPLAT);
		//Boton transparente
		btnADDPLAT.setOpaque(false);
		btnADDPLAT.setContentAreaFilled(false);
		btnADDPLAT.setBorderPainted(false);
		btnADDPLAT.setBorderPainted(false);

		btnADDPLAT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			myPlataforma = new Plataforma();
			VentanaPlataformaADD frame = new VentanaPlataformaADD(myPlataforma, myData,ComboPlataformas);
			frame.setVisible(true);
		}
	});
		
		
	}	
		
		
		public void refrescar(){
			ComboPlataformas.removeAllItems();
			myPlataformas = myData.readPlataforma();
			if(myPlataformas.size()==0){
				System.out.println("No hay Plataformas dispoinibles");
			}else {
				for(int i=0;i<myPlataformas.size();i++){
					ComboPlataformas.addItem(myPlataformas.get(i));
				}
			}
	
	}
		 public void CerrarVentana(){


				try {
					this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					
				
				 addWindowListener(new WindowAdapter() {
				   public void windowClosing(WindowEvent e) {
					  confirmarSalida();
				    
				   } 
				 });
				 this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				 //frameGameStop = new DATABASE_GAMESTOP();
				// frameGameStop.setVisible(true);
				 //frameGameStop.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			public void confirmarSalida(){
				int valor=JOptionPane.showConfirmDialog(this, "Deseas Deslogarte como ADMINISTRADOR(LIDER)" );
				
				if(valor==JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(this, " NARARNARNANRNARN LIDER !!");
					
					
				}
				if(valor==JOptionPane.NO_OPTION)
	            {
					new DATABASE_GAMESTOP().setVisible(true);
					JOptionPane.showMessageDialog(this, " ADORO AL LIDER!");
					
	            }
			}
}

