

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
		CerrarVentana();
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				refrescar();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(200, 300, 478, 290);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ComboPlataformas = new  JComboBox<Plataforma>();
		ComboPlataformas.setBounds(63, 135, 376, 30);
		getContentPane().add(ComboPlataformas);
		
		JButton btnMODPALT = new JButton("Mod. Platform");
		btnMODPALT.setBounds(69, 54, 120, 66);
		getContentPane().add(btnMODPALT);
		btnMODPALT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//Indicamos  Myplatoforma contega lo seccionado del combobox obtinido (get) del ArralyList Plataforma
			myPlataforma = myPlataformas.get(ComboPlataformas.getSelectedIndex());
			VentanaPlataforma frame = new VentanaPlataforma(myPlataforma, myData,ComboPlataformas);
			frame.setVisible(true);
		}
	});
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(187, 76, 89, 23);
		contentPane.add(btnDelete);
		/**
		btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			myPlataforma = myPlataformas.get(ComboPlataformas.getSelectedIndex());
			System.out.println(ComboPlataformas.getSelectedItem());
			myPlataforma.rmPlataforma(ComboPlataformas.getSelectedIndex(), myPlataforma);
			
			
		
		}
	});
		**/
	
		
		
		
		
		
		
		JButton btnADDPLAT = new JButton("Add Platform");
		btnADDPLAT.setBounds(274, 54, 120, 66);
		getContentPane().add(btnADDPLAT);

		btnADDPLAT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			myPlataforma = new Plataforma();
			VentanaPlataformaADD frame = new VentanaPlataformaADD(myPlataforma, myData,ComboPlataformas);
			frame.setVisible(true);
		}
	});
		JButton btnRefs = new JButton("REFS");
		btnRefs.setBounds(187, 199, 89, 23);
		contentPane.add(btnRefs);
		
		
		btnRefs.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			refrescar();
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

