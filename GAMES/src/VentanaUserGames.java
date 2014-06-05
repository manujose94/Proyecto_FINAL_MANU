import javax.swing.JFrame;






import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
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
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


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
	
	
	public VentanaUserGames( final Plataforma myPlataforma,final DATA myData, final JComboBox<Plataforma> ComboBoxPlataforma) {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				;
				lblnomPlataforma.setText(myPlataforma.toString());
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		IdPlataforma=myPlataforma.getIdPlataforma();

		this.myPlataforma = myPlataforma;
		this.myData = myData;
		ComboPlataformas = ComboBoxPlataforma;

		//PARTE GRÁFICA SWING
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		//JTABLE
        //1.- Definimos el modelo de JTable, en nuestro caso DefaultModel
		//2.- Definimos los títulos de las columnas
		//3.- REllenamos las filas a partir de la consulta a la base de datos
		//3.- Creamos el JTable y le asignamosel modelo rellenado
		//4,. Ponemos el JTable dentro de un JScrollPane para poder hacer scroll
		//5.- Damos visivilidad al JTable con setViewportView
        dtmEjemplo = new DefaultTableModel(null,rellenarTitColumnas());
        
		//CONEXION A BASE DE DATOS
		conexionDB();       

        table = new JTable();
		table.setModel(dtmEjemplo);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 414, 186);
		scrollPane.add(table);
		//REvisar la documentación para ver que significa el JScrollPane
		//http://docs.oracle.com/javase/7/docs/api/javax/swing/JScrollPane.html
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
	
		
		lblnomPlataforma = new JLabel();
		lblnomPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
		lblnomPlataforma.setForeground(Color.RED);
		lblnomPlataforma.setFont(new Font("Forte", Font.BOLD, 15));
		lblnomPlataforma.setBounds(150, 11, 136, 27);
		contentPane.add(lblnomPlataforma);


	}

    //Encabezados de la tabla
    private String[] rellenarTitColumnas()
    {
          String columna[]=new String[]{"ID","TITULO","PUNTUACION"};
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
			String sql_Strng="SELECT IdGame,nombreGame,Puntuacion FROM games WHERE `IdPlataforma`="+IdPlataforma;
			conjuntoResultados = instruccion.executeQuery(sql_Strng);
			//Añadir datos al modelo
	        Object datos[]=new Object[3]; //Numero de columnas de la tabla
	        while (conjuntoResultados.next()) {
	        	for (int i = 0; i < 3; i++) {
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
