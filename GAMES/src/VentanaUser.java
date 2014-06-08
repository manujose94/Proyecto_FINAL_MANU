import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.net.ContentHandler;
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

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;


public class VentanaUser extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel dtmEjemplo;
	private JTable table;
	private JScrollPane scpEjemplo;
	private JComboBox<Plataforma> ComboPlataformas;
	private DATA myData = new DATA();
	private ArrayList<Plataforma> myPlataformas;
	private Plataforma myPlataforma;
	private DATABASE_GAMESTOP gamestop;


	

	public VentanaUser() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				refrescar();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		//PARTE GRÁFICA SWING
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 970, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//FONDO
				setIconImage(new ImageIcon(getClass().getResource("/imagen/Placa.png")).getImage());
				((JPanel)getContentPane()).setOpaque(false);
				ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagen/halo.jpg")); 
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
		scrollPane.setToolTipText("");
		scrollPane.setViewportBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(314, 11, 339, 145);
		scrollPane.add(table);
		//REvisar la documentación para ver que significa el JScrollPane
		//http://docs.oracle.com/javase/7/docs/api/javax/swing/JScrollPane.html
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		ComboPlataformas = new  JComboBox<Plataforma>();
		ComboPlataformas.setForeground(Color.DARK_GRAY);
		ComboPlataformas.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		ComboPlataformas.setBounds(346, 431, 279, 29);
		contentPane.add(ComboPlataformas);
		
		JButton btnSeeGames = new JButton("WATCH GAMES");
		btnSeeGames.setForeground(UIManager.getColor("Button.focus"));
		btnSeeGames.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSeeGames.setBackground(Color.DARK_GRAY);
		btnSeeGames.setBounds(408, 375, 148, 29);
		contentPane.add(btnSeeGames);
		btnSeeGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Indicamos  Myplatoforma contega lo seccionado del combobox obtinido (get) del ArralyList Plataforma
				myPlataforma = myPlataformas.get(ComboPlataformas.getSelectedIndex());
				VentanaUserGames frame = new VentanaUserGames(myPlataforma, myData,ComboPlataformas);
				frame.setVisible(true);
			}
			
		});

	}

    //Encabezados de la tabla
    private String[] rellenarTitColumnas()
    {
          String columna[]=new String[]{"ID","NAME_PLAT","NUMBER-OF-GAMES"};
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
			conjuntoResultados = instruccion.executeQuery("SELECT IdPlataforma,nombrePlataforma,numGames FROM plataforma");
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
}