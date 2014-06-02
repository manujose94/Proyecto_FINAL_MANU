public class Games {
	private String nombreGame,Genero,Compañia ;
	private int EdadRecomendada, Precio, Puntuacion, IdGame,IdPlataforma ;

	public Games(String nombreGame, String Genero ,String Compañia, int EdadRecomendada, int Precio , int Puntuacion , int IdGame   ){
		
		this.nombreGame = nombreGame;
		this.Genero = Genero;
		this.Compañia = Compañia;
		this.EdadRecomendada = EdadRecomendada;
		this.Precio = Precio;
		this.Puntuacion = Puntuacion;	
		this.IdGame = IdGame;
	}
	
	public Games(int IdPlataforma){
		this.nombreGame = null;
		this.Genero = null;
		this.Compañia = null;
		this.EdadRecomendada = 0;
		this.Precio = 0;
		this.Puntuacion = 0;
		this.IdPlataforma = IdPlataforma;
	}
	
	public Games(){
		this.nombreGame = null;
		this.Genero = null;
		this.Compañia = null;
		this.EdadRecomendada = 0;
		this.Precio = 0;
		this.Puntuacion = 0;
	}

	
	public String toString() {
		return nombreGame;
	}
	public String toStringGenero() {
		return Genero;
	}

	public String toStringCompañia() {
		return Compañia;
	}
	public void setnombreGame(String nombreGame){
		this.nombreGame = nombreGame;
	}
	public void setGenero(String Genero){
		this.Genero = Genero;
	}
	public void setCompañia(String Compañia){
		this.Compañia = Compañia;
	}
	
	
	public int getEdadRecomendada() {
		return EdadRecomendada;
	}

	public void setEdadRecomendada(int EdadRecomendada) {
		this.EdadRecomendada = EdadRecomendada;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int Precio) {
		this.Precio = Precio;
	}

	public int getPuntuacion() {
		return Puntuacion;
	}

	public void setPuntuacion(int Puntuacion) {
		this.Puntuacion = Puntuacion;
	}

	
	public void  setIdGame(int IdGame ){
		this.IdGame = IdGame;
	}
	
	public int getIdGame(){
		return this.IdGame;
	}
	
	public int getIdPlataforma(){
		return this.IdPlataforma;
	}

	
}
