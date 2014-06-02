public class Games {
	private String nombreGame,Genero,Compa�ia ;
	private int EdadRecomendada, Precio, Puntuacion, IdGame,IdPlataforma ;

	public Games(String nombreGame, String Genero ,String Compa�ia, int EdadRecomendada, int Precio , int Puntuacion , int IdGame   ){
		
		this.nombreGame = nombreGame;
		this.Genero = Genero;
		this.Compa�ia = Compa�ia;
		this.EdadRecomendada = EdadRecomendada;
		this.Precio = Precio;
		this.Puntuacion = Puntuacion;	
		this.IdGame = IdGame;
	}
	
	public Games(int IdPlataforma){
		this.nombreGame = null;
		this.Genero = null;
		this.Compa�ia = null;
		this.EdadRecomendada = 0;
		this.Precio = 0;
		this.Puntuacion = 0;
		this.IdPlataforma = IdPlataforma;
	}
	
	public Games(){
		this.nombreGame = null;
		this.Genero = null;
		this.Compa�ia = null;
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

	public String toStringCompa�ia() {
		return Compa�ia;
	}
	public void setnombreGame(String nombreGame){
		this.nombreGame = nombreGame;
	}
	public void setGenero(String Genero){
		this.Genero = Genero;
	}
	public void setCompa�ia(String Compa�ia){
		this.Compa�ia = Compa�ia;
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
