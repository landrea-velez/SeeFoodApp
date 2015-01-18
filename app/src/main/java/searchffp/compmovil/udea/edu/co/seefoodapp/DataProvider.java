package searchffp.compmovil.udea.edu.co.seefoodapp;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;


public class DataProvider extends ContentProvider {

    private static final String TAG = DataProvider.class.getSimpleName();
    private DbHelper dbHelper;
    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(DataBaseManager.AUTHORITY, DataBaseManager.TABLE_NAME, DataBaseManager.STATUS_DIR);
        sURIMatcher.addURI(DataBaseManager.AUTHORITY, DataBaseManager.TABLE_NAME + "/#", DataBaseManager.STATUS_ITEM);
    }


    @Override
    public boolean onCreate() {
        dbHelper = new DbHelper(getContext());
        Log.d(TAG, "onCreated DataProvider");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }


    @Override
    public String getType(Uri uri) {

        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri ret = null;
        Log.d(TAG, "values: " + values);
        Log.d(TAG, "uri: " + uri);

        if (sURIMatcher.match(uri) != DataBaseManager.STATUS_DIR) {
            throw new IllegalArgumentException("Illegal uri: " + uri);
        }

       SQLiteDatabase bd = dbHelper.getWritableDatabase();

        long rowId = bd.insert(DataBaseManager.TABLE_NAME, null, values);
        Log.d(TAG, "rowId: " + rowId);

// Was insert successful?
        if (rowId != -1) {
            long id = values.getAsLong(DataBaseManager.CN_ID);
            ret = ContentUris.withAppendedId(uri, id);
            Log.d(TAG, "inserted uri: " + ret);
// Notify that data for this uri has changed
            getContext().getContentResolver().notifyChange(uri, null);
        }
        Log.d(TAG, "Final inserted uri: " + ret);
        return ret;

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }


}
