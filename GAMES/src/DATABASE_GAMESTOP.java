

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DATABASE_GAMESTOP extends JFrame {
	
	private JComboBox<Plataforma> ComboPlataformas;
	private DATA myData = new DATA();
	private ArrayList<Plataforma> myPlataformas;
	private Plataforma myPlataforma;
/**
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DATABASE_GAMESTOP frame = new DATABASE_GAMESTOP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**/
	public DATABASE_GAMESTOP() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 300, 478, 290);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ComboPlataformas = new  JComboBox<Plataforma>();
		ComboPlataformas.setBounds(32, 151, 376, 25);
		getContentPane().add(ComboPlataformas);
		
		JButton btnMODPALT = new JButton("Mod. Platform");
		btnMODPALT.setBounds(56, 54, 120, 66);
		getContentPane().add(btnMODPALT);
		btnMODPALT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//Indicamos  Myplatoforma contega lo seccionado del combobox obtinido (get) del ArralyList Plataforma
			myPlataforma = myPlataformas.get(ComboPlataformas.getSelectedIndex());
			VentanaPlataforma frame = new VentanaPlataforma(myPlataforma, myData,ComboPlataformas);
			frame.setVisible(true);
		}
	});
		JButton btnADDPLAT = new JButton("Add Platform");
		btnADDPLAT.setBounds(245, 54, 120, 66);
		getContentPane().add(btnADDPLAT);
		btnADDPLAT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			myPlataforma = new Plataforma();
			VentanaPlataformaADD frame = new VentanaPlataformaADD(myPlataforma, myData,ComboPlataformas);
			frame.setVisible(true);
		}
	});
		refrescar();
	}	
		
		
		private void refrescar(){
			myPlataformas = myData.readPlataforma();
			if(myPlataformas.size()==0){
				System.out.println("No hay Plataformas dispoinibles");
			}else {
				for(int i=0;i<myPlataformas.size();i++){
					ComboPlataformas.addItem(myPlataformas.get(i));
				}
			}
		
		
	}

	



	/**
	 * Launch the application.
	 */

	}

