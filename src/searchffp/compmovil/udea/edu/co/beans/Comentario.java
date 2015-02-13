package searchffp.compmovil.udea.edu.co.beans;

public class Comentario {
	
	private String CN_NAME;
	private String CN_PUNTOS;
	private String CN_COMENTARIO;
	
	
	public String getCN_ID() {
		return CN_NAME;
	}
	public void setCN_ID(String cN_ID) {
		CN_NAME = cN_ID;
	}
	public String getCN_PUNTOS() {
		return CN_PUNTOS;
	}
	public void setCN_PUNTOS(String cN_PUNTOS) {
		CN_PUNTOS = cN_PUNTOS;
	}
	public String getCN_COMENTARIO() {
		return CN_COMENTARIO;
	}
	public void setCN_COMENTARIO(String cN_COMENTARIO) {
		CN_COMENTARIO = cN_COMENTARIO;
	}
	
	public String toString(){
		return CN_COMENTARIO;
	}
	

}
