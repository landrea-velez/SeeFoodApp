package searchffp.compmovil.udea.edu.co.seefoodapp;


import android.net.Uri;

public class DataBaseManager {

    public static final String DB_NAME = "Servicios.db";
    public static final int DB_SCHEMA_VERSION = 6;
    public static final String TABLE_NAME_LOCAL= "Local";
    public static final String TABLE_NAME_COMENTARIO= "Comenta";

    //LOS CAMPOS
    public static final String CN_ID = "id";
    public static final String CN_TYPE = "tipo";
    public static final String CN_NAME = "nombre";
    public static final String CN_LATITUDE = "latitud";
    public static final String CN_LONGITUDE = "longitud";
    public static final String CN_ADDRESS = "direccion";
    
    public static final String CN_PUNTOS = "puntos";
    public static final String CN_COMENTARIO = "comentario";


    public static final String CREATE_TABLE_LOCAL = "CREATE TABLE " + TABLE_NAME_LOCAL + " ("
            + CN_ID + " varchar(4),"
            + CN_TYPE + " varchar(20),"
            + CN_NAME + " varchar(20),"
            + CN_LATITUDE + " varchar(20),"
            + CN_LONGITUDE + " varchar(20),"
            + CN_ADDRESS + " varchar(20));";
    
    public static final String CREATE_TABLE_COMENTARIO = "CREATE TABLE " + TABLE_NAME_COMENTARIO + " ("
            + CN_NAME + " varchar(4),"
            + CN_PUNTOS + " varchar(4),"
            + CN_COMENTARIO + " varchar(200));";
    
    public static final String DB_SCHEMA = CREATE_TABLE_LOCAL;

    public static final String DATA_ID = "332";
    public static final String DATA_TYPE = "Cafeteria";
    public static final String DATA_NAME = "COESDUA";
    public static final String DATA_LATITUDE = "6.268082729";
    public static final String DATA_LONGITUDE = "-75.568285882";
    public static final String DATA_ADDRESS = "Bloque 21";
    
    public static final String DATA_ID1 = "333";
    public static final String DATA_TYPE1 = "Cafeteria";
    public static final String DATA_NAME1 = "De Lolita Restó Café";
    public static final String DATA_LATITUDE1 = "6.268301355";
    public static final String DATA_LONGITUDE1 = "-75.568414629";
    public static final String DATA_ADDRESS1 = "Zona de comidas";
    
    public static final String DATA_ID2 = "334";
    public static final String DATA_TYPE2 = "Restaurante";
    public static final String DATA_NAME2 = "Arbóreo Gourmet";
    public static final String DATA_LATITUDE2 = "6.266451027";
    public static final String DATA_LONGITUDE2 = "-75.569525063";
    public static final String DATA_ADDRESS2 = "Plazoleta Barrientos";
    
    public static final String DATA_ID3 = "335";
    public static final String DATA_TYPE3 = "Frutas y helados";
    public static final String DATA_NAME3 = "Fruticas";
    public static final String DATA_LATITUDE3 = "6.268654179";
    public static final String DATA_LONGITUDE3 = "-75.568463802";
    public static final String DATA_ADDRESS3 = "Zona de comidas";
    
    
    public static final String DATA_NAME_COMENT1 = "Arbóreo Gourmet";
    public static final String DATA_PUNTOS1 = "5";
    public static final String DATA_COMENT1 = "Excelente lugar para comer";

    public static final String DATA_NAME_COMENT2 = "Arbóreo Gourmet";
    public static final String DATA_PUNTOS2 = "5";
    public static final String DATA_COMENT2 = "100% recomendado";
    
    public static final String DATA_NAME_COMENT3 = "De Lolita Restó Café";
    public static final String DATA_PUNTOS3 = "4";
    public static final String DATA_COMENT3 = "Excelente servicio";
    
    public static final String DATA_NAME_COMENT4 = "COESDUA";
    public static final String DATA_PUNTOS4 = "5";
    public static final String DATA_COMENT4 = "Muy organizado";
    
    public static final String DATA_NAME_COMENT5 = "COESDUA";
    public static final String DATA_PUNTOS5 = "4";
    public static final String DATA_COMENT5 = "Tienen mucha variedad en productos";
    
    public static final String DATA_NAME_COMENT6 = "Arbóreo Gourmet";
    public static final String DATA_PUNTOS6 = "5";
    public static final String DATA_COMENT6 = "Tienen menu variado, saludable a buen precio";

    public static final String DATA_NAME_COMENT7 = "Arbóreo Gourmet";
    public static final String DATA_PUNTOS7 = "3";
    public static final String DATA_COMENT7 = "Agilizar el servicio";
    
    public static final String DATA_NAME_COMENT8 = "De Lolita Restó Café";
    public static final String DATA_PUNTOS8 = "4";
    public static final String DATA_COMENT8 = "Muy buena atención al cliente";
    
    public static final String DATA_NAME_COMENT9 = "De Lolita Restó Café";
    public static final String DATA_PUNTOS9 = "5";
    public static final String DATA_COMENT9 = "Muy organizado y limpio";
    
    public static final String DATA_NAME_COMENT10 = "COESDUA";
    public static final String DATA_PUNTOS10 = "4";
    public static final String DATA_COMENT10 = "Recomendado, excelente lugar";
        
}



