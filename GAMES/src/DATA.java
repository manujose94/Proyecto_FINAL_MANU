import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class DATA {
	
	private ArrayList<Plataforma> myPlataforma = new ArrayList<Plataforma>();
	private ArrayList<Games> myGames = new ArrayList<Games>();	
	private Games myGame;
	//BBDD
	private Statement instruccion = null;
	public Connection conexion = null; // Conexión a la base de datos
	private ResultSet misResultadosPlataforma = null;
	private ResultSet misResultadosGame= null;
	private JComboBox<Games> ComboBoxGames;
	private ResultSet conjuntoResultado = null ;
	private JComboBox ComboBox;
	private ResultSet misResultadosUsers = null;
	
	public DATA() {
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

	}
	//---------------------------------------------
	/**public void acceder(String usuario, String pass)
    {
        String cap="";
       String sql="SELECT * FROM usuario WHERE nick='"+usuario+"' && password='"+pass+"'";
        try {
        	instruccion = (Statement) conexion.createStatement();
        	misResultadosUsers  = instruccion.executeQuery(sql);
 
            while(misResultadosUsers.next())
            {
                cap=misResultadosUsers.getString("tipousuario");
            }
            if(cap.equals("Administrador"))
            {
                  
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    System.out.println("Administrador");
                
            }
            if(cap.equals("Invitado"))
            {
            
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    System.out.println("Invitado");
            }
            if((!cap.equals("Administrador"))&& (!cap.equals("Invitado")))
            {
            	System.out.println("No existe user ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DATA.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }**/
	//-----------------------------------------
	
	
	public void rellenarCombobox(){
		try{
		instruccion = (Statement) conexion.createStatement();
		conjuntoResultado = instruccion.executeQuery ("SELECT * FROM gamaes");
		// Bucle While para iniciar la consulta
		while (conjuntoResultado.next())
		{
			myGame = new Games();
		//Rellenamos combobox a partir de la consulta
			myGame.setnombreGame((String) conjuntoResultado.getObject("nombreGame"));
			myGame.setCompañia((String) conjuntoResultado.getObject("Genero"));
			myGame.setGenero((String) conjuntoResultado.getObject("Compañia"));
			myGame.setIdGame(conjuntoResultado.getInt("IdGame"));
			myGame.setPrecio(conjuntoResultado.getInt("Precio"));
			myGame.setPuntuacion(conjuntoResultado.getInt("golesFavor"));
			myGame.setEdadRecomendada(conjuntoResultado.getInt("Puntuacion"));
		
			
		}
		//Cerramos conexion
		// conexion.close();
		} catch(SQLException e){
		JOptionPane.showMessageDialog(null,"No se pudieron leerr datos de nuestra BBDD");
		}
		}
	
	public void readingGames(JComboBox ComboBox){
		try{
			instruccion = (Statement) conexion.createStatement();
			misResultadosGame = instruccion.executeQuery("SELECT * FROM games ");
			
			//System.out.println("Estoy en leerEquipos");		
			
				while(misResultadosGame.next()){
					myGame = new Games (misResultadosGame.getString("nombreGame"),misResultadosGame.getString("Genero"),misResultadosGame.getString("Compañia"), misResultadosGame.getInt("EdadRecomendada"), misResultadosGame.getInt("Precio"),
							misResultadosGame.getInt("Puntuacion"), misResultadosGame.getInt("IdGame"));
					ComboBox.addItem(myGame);
						}
		}catch( SQLException excepcionSql ){
				excepcionSql.printStackTrace();
				}
		
	}
	
	
	
	
	public ArrayList<Plataforma> readPlataforma() {
		myPlataforma.removeAll(myPlataforma);
		System.out.println("read myPlataforma");
		try{
			instruccion = (Statement) conexion.createStatement();
			misResultadosPlataforma = instruccion.executeQuery("SELECT * FROM plataforma");
			while(misResultadosPlataforma.next()){
				Plataforma newPlata = new Plataforma (misResultadosPlataforma.getString("nombrePlataforma"),misResultadosPlataforma.getInt("numGames"), misResultadosPlataforma.getInt("IdPlataforma"));
				myPlataforma.add(newPlata);
				System.out.println("pLATAFORMA Añadida: "+newPlata);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return myPlataforma;
	}
	
	public void rmPlataforma(Plataforma myPlataforma){
		try{
			
			instruccion = (Statement) conexion.createStatement();
			String sql_Strng1 = "DELETE FROM `games`.`games` WHERE `games`.`IdPlataforma` ="+myGame.getIdPlataforma();
			String sql_Strng2 = "DELETE FROM `games`.`plataforma` WHERE `plataforma`.`IdPlataforma` ="+myPlataforma.getIdPlataforma();
			
			System.out.println(sql_Strng1);
			System.out.println(sql_Strng2);
			//instruccion.executeUpdate(sql_Strng);
			
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void savePlataforma(Plataforma myPlataforma,JComboBox<Plataforma> comboBoxPlataforma){
		if(myPlataforma.getIdPlataforma()>0){
			try{
				instruccion = (Statement) conexion.createStatement();
				String sql_Strng = "UPDATE `plataforma` SET `nombrePlataforma`=\""+myPlataforma.toString()+"\", `numGames`="+myPlataforma.getnumGames()+" WHERE `IdPlataforma`="+myPlataforma.getIdPlataforma();
				instruccion.executeUpdate(sql_Strng);
				System.out.println(sql_Strng);
				instruccion.executeUpdate(sql_Strng);
				
			}catch (SQLException e){
				e.printStackTrace();
			}
		}else{
			try{
				instruccion = (Statement) conexion.createStatement();
				String sql_Strng="INSERT INTO  `games`.`plataforma` (`nombrePlataforma` ,`numGames`)";
				sql_Strng = sql_Strng+"VALUES ('"+myPlataforma.getnombrePlataforma()+"',  '"+myPlataforma.getnumGames()+"');";
				System.out.println(sql_Strng);
				instruccion.executeUpdate(sql_Strng);
				comboBoxPlataforma.addItem(myPlataforma);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	
	
	public ArrayList<Games> readGames(int idPlataforma){
		myGames.removeAll(myGames);
		System.out.println("++ Game");
		try{
			instruccion = (Statement) conexion.createStatement();
			misResultadosGame = instruccion.executeQuery("SELECT * FROM games WHERE `IdPlataforma`="+idPlataforma);
			while(misResultadosGame.next()){
				Games newGame = new Games (misResultadosGame.getString("nombreGame"),misResultadosGame.getString("Genero"),misResultadosGame.getString("Compañia"), misResultadosGame.getInt("EdadRecomendada"), misResultadosGame.getInt("Precio"),
						misResultadosGame.getInt("Puntuacion"), misResultadosGame.getInt("IdGame"));
				myGames.add(newGame);
				System.out.println(" Equipo:" +newGame);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return myGames;
	}
	
	public void rmGame(Games myGame){
		try{
			
			instruccion = (Statement) conexion.createStatement();
			String sql_Strng = "DELETE FROM `games`.`games` WHERE `games`.`IdGame` ="+myGame.getIdGame();
			System.out.println(sql_Strng);
			instruccion.executeUpdate(sql_Strng);
			
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void saveGame(Games gameModificado){
		System.out.println(gameModificado.getIdGame());
		if(gameModificado.getIdGame()>0){
			try{
				System.out.println("Update game Inicio ");
				instruccion = (Statement) conexion.createStatement();
				String sql = "UPDATE `games` SET `nombreGame`=\""+gameModificado.toString()+"\", `Genero`=\""+gameModificado.toStringGenero()+
						"\", `Compañia`=\""+gameModificado.toStringCompañia()+"\", `EdadRecomendada`="+gameModificado.getEdadRecomendada()+", `Precio`="+gameModificado.getPrecio()+",`Puntuacion`="+gameModificado.getPuntuacion()+" WHERE `IdGame`="+gameModificado.getIdGame();
				System.out.println(sql);
				instruccion.executeUpdate(sql);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}else{
			try{
				instruccion = (Statement) conexion.createStatement();
				String sql_Strng="INSERT INTO  `games`.`games` (`IdGame` ,`IdPlataforma` ,`nombreGame` ,`Genero` ,`Compañia` ,`EdadRecomendada` ,`Precio`,`Puntuacion`)";
				sql_Strng = sql_Strng+"VALUES ('"+gameModificado.getIdGame()+"',  '"+gameModificado.getIdPlataforma()+"',  '"+gameModificado.toString()+"',  '"+gameModificado.toStringGenero()+"',  '"+gameModificado.toStringCompañia()+"', '"+gameModificado.getEdadRecomendada()+"', '"+gameModificado.getPrecio()+"' ,  '"+gameModificado.getPuntuacion()+"' );";
				System.out.println(sql_Strng);
				instruccion.executeUpdate(sql_Strng);
			}catch (SQLException e){
				e.printStackTrace();
			}
		
		}
	}
	
}
