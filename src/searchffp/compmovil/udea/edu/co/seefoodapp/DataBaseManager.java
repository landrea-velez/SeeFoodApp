package searchffp.compmovil.udea.edu.co.seefoodapp;


import android.net.Uri;

public class DataBaseManager {

    public static final String DB_NAME = "Servicios.db";
    public static final int DB_SCHEMA_VERSION = 1;
    public static final String TABLE_NAME= "local";

    //LOS CAMPOS
    public static final String CN_ID = "_id";
    public static final String CN_NAME = "nombre";
    public static final String CN_LATITUDE = "latitud";
    public static final String CN_LONGITUDE = "longitud";
    public static final String CN_ADDRESS = "direccion";


    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_NAME + " text not null,"
            + CN_LATITUDE + " text,"
            + CN_LONGITUDE + " text,"
            + CN_ADDRESS + " text not null);";

    public static final String DATA_ID = "009";
    public static final String DATA_NAME = "Restaurante";
    public static final String DATA_LATITUDE = "4006";
    public static final String DATA_LONGITUDE = "2355";
    public static final String DATA_ADDRESS = "Bloque 21";

    public static final String AUTHORITY = "searchffp.compmovil.udea.edu.co.seefoodapp.DataProvider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);
    public static final int STATUS_ITEM = 1;
    public static final int STATUS_DIR = 2;
}



