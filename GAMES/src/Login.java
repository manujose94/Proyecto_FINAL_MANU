import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login  extends JFrame{


	private DATABASE_GAMESTOP basedato_gamestop;
	private String us;
	private String pass;
	private JTextField textFieldNICK;
	private JTextField textFieldPASS;
	private JButton 		 btnACCEDER;
	private Statement instruccion = null;
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
	
	
	
	
	
	
	public Login() {
		
getContentPane().setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(200, 300, 400, 280);
JPanel contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
		textFieldNICK = new JTextField();
		textFieldNICK.setBounds(64, 45, 86, 20);
		getContentPane().add(textFieldNICK);
		textFieldNICK.setColumns(10);
		
		textFieldPASS = new JTextField();
		textFieldPASS.setBounds(239, 45, 86, 20);
		getContentPane().add(textFieldPASS);
		textFieldPASS.setColumns(10);
		
		btnACCEDER = new JButton("Acceder");
		btnACCEDER.setBounds(172, 133, 89, 23);
		getContentPane().add(btnACCEDER);
		btnACCEDER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 us=textFieldNICK.getText();
				pass=textFieldPASS.getText();
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
            
                    
                    System.out.println("Invitado");
            }
            if((!tipo.equals("Administrador"))&& (!tipo.equals("Invitado")))
            {
            	System.out.println("No existe user ");
            	JOptionPane.showMessageDialog(this, "No existe sus datos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
	//-----------------------------------------
	
	

}
