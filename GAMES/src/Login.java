import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ContentHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;

public class Login  extends JFrame{


	private VentanaUser VentanaUser1;
	private DATABASE_GAMESTOP basedato_gamestop;
	private String us;
	private String pass;
	private JTextField textFieldNICK;
	private JPanel contentPane;
	private JTextField textFieldPASS;
	private JButton 		 btnACCEDER;
	private Statement instruccion = null;
	private JPasswordField Password;
	public static Connection conexion = null; // Conexión a la base de datos
	private ResultSet misResultadosPlataforma = null;
	private ResultSet misResultadosGame= null;
	
	
	private ResultSet conjuntoResultado = null ;

	private ResultSet misResultadosUsers = null;
	
	 public static void main(String args[]) {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/games","root","");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		 
	        /* Set the Nimbus look and feel */
	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	         */
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {

	            public void run() {
	                new Login().setVisible(true);
	            }
	        });
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
			int valor=JOptionPane.showConfirmDialog(this, "Desea Cerrar la Aplicacion GAMESTOP");
			
			if(valor==JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(this, "Gracias por su Visita ;)");
				System.exit(0);
				
			}
			if(valor==JOptionPane.NO_OPTION)
            {
				new Login().setVisible(true);
				
            }
		}
		
	
	
	
	
	public Login() {
		CerrarVentana();
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 100, 820, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setIconImage(new ImageIcon(getClass().getResource("/imagen/rayman.jpg")).getImage());
		((JPanel)getContentPane()).setOpaque(false);
		ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagen/rayman.jpg")); 
		JLabel fondo= new JLabel(); 
		fondo.setIcon(uno); 
		getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
		fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		Dimension tam=getSize();
		setSize(tam.width,tam.height);
		setVisible(true);
		
		textFieldNICK = new JTextField();
		textFieldNICK.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldNICK.setBounds(94, 125, 136, 27);
		getContentPane().add(textFieldNICK);
		textFieldNICK.setColumns(10);
		
		Password = new JPasswordField();
		Password.setFont(new Font("Tahoma", Font.BOLD, 13));
		Password.setBounds(588, 125, 136, 27);
		getContentPane().add(Password);
		Password.setColumns(10);
		
		
		//textFieldPASS = new JTextField();
		//textFieldPASS.setBounds(588, 125, 136, 27);
		//getContentPane().add(textFieldPASS);
		//textFieldPASS.setColumns(10);
		
		btnACCEDER = new JButton("");
		btnACCEDER.setSelectedIcon(new ImageIcon("C:\\Users\\ManuelJose\\Pictures\\llaveespada2.png"));
		//btnACCEDER.setForeground(Color.BLUE);
		//btnACCEDER.setBackground(Color.WHITE);
		btnACCEDER.setOpaque(false);
		btnACCEDER.setContentAreaFilled(false);
		btnACCEDER.setBorderPainted(false);
		btnACCEDER.setBorderPainted(false);
		btnACCEDER.setIcon(new ImageIcon("C:\\Users\\ManuelJose\\Pictures\\llaveespada.png"));
		btnACCEDER.setBounds(299, 330, 263, 120);
		getContentPane().add(btnACCEDER);
		//(new ImageIcon(getClass().getResource("/imagen/GameStop_logo5.png")).getImage());
		JLabel lblAccederAGamestop = new JLabel("");
		lblAccederAGamestop.setIcon(new ImageIcon("C:\\Users\\ManuelJose\\Desktop\\GameStop_logo5.png"));
		lblAccederAGamestop.setForeground(Color.RED);
		lblAccederAGamestop.setFont(new Font("Vrinda", Font.BOLD, 13));
		lblAccederAGamestop.setBounds(310, 11, 205, 63);
		contentPane.add(lblAccederAGamestop);
		btnACCEDER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 us=textFieldNICK.getText();
				pass=Password.getText();
				acceder(us, pass);
			}
		});
	
		
	}
	
	
	
	//---------------------------------------------
	public void acceder(String usuario, String pass)
    {
        String tipo="";
       String sql="SELECT * FROM usuario WHERE nick='"+usuario+"' && password='"+pass+"'";
        try {
        	instruccion = (Statement) conexion.createStatement();
        	misResultadosUsers  = instruccion.executeQuery(sql);
 
            while(misResultadosUsers.next())
            {
            	tipo=misResultadosUsers.getString("tipousuario");
            }
            if(tipo.equals("Administrador"))
            {
                  
            
            
            	new DATABASE_GAMESTOP().setVisible(true);
                    System.out.println("Administrador");
                
            }
            if(tipo.equals("Invitado"))
            {
            	new VentanaUser().setVisible(true);
                    
                    System.out.println("Invitado");
            }
            if((!tipo.equals("Administrador"))&& (!tipo.equals("Invitado")))
            {
            	System.out.println("No existe user ");
            	JOptionPane.showMessageDialog(this, "User o pass INCORRECT");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
}
