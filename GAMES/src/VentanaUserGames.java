import javax.swing.JFrame;









import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;


public class VentanaUserGames extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel dtmEjemplo;
	private JTable table;
	private JScrollPane scpEjemplo;

	private Plataforma myPlataforma;
	private int IdPlataforma;
	private Games myGames;
	private DATA myData;
	private JTextField textField_Plataforma;
	private JTextField textField_NumGames;
	private JComboBox<Games> ComboBoxGames;
	private JComboBox<Plataforma> ComboPlataformas;
	private ArrayList<Games> myGamesPlat;
	private JTextField textFieldnomPlataforma;
	private JLabel lblnomPlataforma;
	private JRadioButton rdbtnPrecio;
	Connection conexion = null; //maneja la conexión
	Statement instruccion = null;// instrucción de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados
	 Object datos[]=new Object[7];
	public VentanaUserGames( final Plataforma myPlataforma,final DATA myData, final JComboBox<Plataforma> ComboBoxPlataforma) {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				;
				lblnomPlataforma.setText(myPlataforma.toString());
				//PrecioMouseClicked(null);
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
				
		
		IdPlataforma=myPlataforma.getIdPlataforma();
		this.myPlataforma = myPlataforma;
		
		ComboPlataformas = ComboBoxPlataforma;

		//PARTE GRÁFICA SWING
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(90, 90, 970, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//FONDO
		setIconImage(new ImageIcon(getClass().getResource("/imagen/Placa.png")).getImage());
		((JPanel)getContentPane()).setOpaque(false);
		ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagen/rdr.jpg")); 
		JLabel fondo= new JLabel(); 
		fondo.setIcon(uno); 
		getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
		fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
		Dimension tam=getSize();
		setSize(tam.width,tam.height);
		setVisible(true);


		//JTABLE
        dtmEjemplo = new DefaultTableModel(null,rellenarTitColumnas());
        
		//CONEXION A BASE DE DATOS
		conexionDB();       

        table = new JTable();
		table.setModel(dtmEjemplo);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 137, 543, 329);
		scrollPane.add(table);
		//REvisar la documentación para ver que significa el JScrollPane
		//http://docs.oracle.com/javase/7/docs/api/javax/swing/JScrollPane.html
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
	
		
		lblnomPlataforma = new JLabel();
		lblnomPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
		lblnomPlataforma.setForeground(new Color(139, 0, 0));
		lblnomPlataforma.setFont(new Font("Footlight MT Light", Font.BOLD, 34));
		lblnomPlataforma.setBounds(102, 21, 316, 81);
		contentPane.add(lblnomPlataforma);
		
		//rdbtnPrecio = new JRadioButton("Precio");
		//rdbtnPrecio.setBounds(599, 102, 109, 23);
		//contentPane.add(rdbtnPrecio);
		
		

	}
			
    //Encabezados de la tabla
    private String[] rellenarTitColumnas()
    {
          String columna[]=new String[]{"ID","TITLE","COMPANY","GENRE","AGE","PRICE","PUNCTATION",};
          return columna;
    }

	private void conexionDB() {
		Connection conexion = null; //maneja la conexión
		Statement instruccion = null;// instrucción de consulta
		ResultSet conjuntoResultados = null;// maneja los resultados
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/games","root","");
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
			// consulta la base de datos
			String sql_Strng="SELECT IdGame,nombreGame,Compañia,Genero,EdadRecomendada,Precio,Puntuacion FROM games WHERE `IdPlataforma`="+IdPlataforma+" ORDER BY Puntuacion DESC";
			System.out.println(sql_Strng);
			conjuntoResultados = instruccion.executeQuery(sql_Strng);
			//Añadir datos al modelo
	        //Numero de columnas de la tabla
	        while (conjuntoResultados.next()) {
	        	for (int i = 0; i < 7; i++) {
	            	datos[i] = conjuntoResultados.getObject(i + 1);
	            }
	        	dtmEjemplo.addRow(datos);
	        }
			conjuntoResultados.close();
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch		
	}
}
