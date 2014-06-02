import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;


public class Plataforma {
	private String nombrePlataforma;
	private int numGames;
	private Games gamePlataforma;
	private ArrayList<Games> my_gamePlataforma;
	private ArrayList<Plataforma> ArrayPlataforma;
	private ResultSet myResults_Plataforma, myResults_Games;
	private DATA my_Data= new DATA();
	private int IdPlataforma;

	public Plataforma(String nombrePlataforma, int numGames, int IdPlataforma) {
		this.IdPlataforma = IdPlataforma;
		this.nombrePlataforma = nombrePlataforma;
		this.numGames = numGames;
		//Aqui Indicamos que la lista (Arraylist) de games sea igual que la lectura de todos los juego de una determinada plataforma ( IdPlataforma )
		my_gamePlataforma = my_Data.readGames(IdPlataforma);
	}
	
	public Plataforma(){
		nombrePlataforma = null;
		numGames = 0;
		my_gamePlataforma = new ArrayList<Games>();
	}

	@Override
	public String toString() {
		return nombrePlataforma;
	}
	
	public int getIdPlataforma(){
		
		return IdPlataforma;
	}
	

	
	public ArrayList<Games> getgamePlataforma(){
		return my_gamePlataforma;
	}
	
	//Eliminar o añador Juegos de dicha plataforma
			//Pasandolo a DATA .
	public void addGame(Games myGame){
		
		my_gamePlataforma.add(myGame);
		my_Data.saveGame(myGame);
	}

	public void rmGame(int indice, Games myGame){
		my_gamePlataforma.remove(indice);
		my_Data.rmGame(myGame);
		System.out.println(myGame.getIdGame());
	}
	
	public void setnombrePlataforma(String nombrePlataforma){
		this.nombrePlataforma = nombrePlataforma;
	}
	
	public void setnumGames(int numGames){
		this.numGames = numGames;
	}
	
	public String getnombrePlataforma(){
		return nombrePlataforma;		
	}
	
	public int getnumGames(){
		return numGames;
	}
	
	//Metodo para guardar plataforma ( pasando a DATA )
	public void savePlataforma (Plataforma myPlataforma, JComboBox<Plataforma> comboBoxPlataforma){
		my_Data.savePlataforma(myPlataforma, comboBoxPlataforma);
	}
	
}
