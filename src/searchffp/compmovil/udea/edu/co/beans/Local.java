package searchffp.compmovil.udea.edu.co.beans;

public class Local {
	
	private String CN_ID;
	private String CN_TYPE;
	private String CN_NAME;
	private String CN_LATITUDE;
	private String CN_LONGITUD;
	private String CN_ADDRESS;
	
	
	public String getCN_TYPE() {
		return CN_TYPE;
	}
	public void setCN_TYPE(String cN_TYPE) {
		CN_TYPE = cN_TYPE;
	}
	public String getCN_NAME() {
		return CN_NAME;
	}
	public void setCN_NAME(String cN_NAME) {
		CN_NAME = cN_NAME;
	}
	public String getCN_LATITUDE() {
		return CN_LATITUDE;
	}
	public void setCN_LATITUDE(String cN_LATITUDE) {
		CN_LATITUDE = cN_LATITUDE;
	}
	public String getCN_LONGITUD() {
		return CN_LONGITUD;
	}
	public void setCN_LONGITUD(String cN_LONGITUD) {
		CN_LONGITUD = cN_LONGITUD;
	}
	public String getCN_ADDRESS() {
		return CN_ADDRESS;
	}
	public void setCN_ADDRESS(String cN_ADDRESS) {
		CN_ADDRESS = cN_ADDRESS;	}
	
	public String getCN_ID() {
		return CN_ID;
	}
	public void setCN_ID(String cN_ID) {
		CN_ID = cN_ID;
	}
	
	public String toString(){
		return CN_TYPE +":  "+ CN_NAME + ". ";
	}
	

}
