package bhavesh.app3;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import static java.sql.Types.INTEGER;

public class DBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LatestUser.db";
    public static final String TABLE_NAME = "TABLE_PERSON";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_NUM = "NUM";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_PSWD = "PSWD";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_NAME + " VARCHAR," + COLUMN_NUM + " INTEGER, " + COLUMN_EMAIL + " VARCHAR, " + COLUMN_PSWD + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }

    private SQLiteDatabase database;

    public void insertRecord(TABLE_PERSON contact) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, contact.getName());
        contentValues.put(COLUMN_NUM, contact.getNum());
        contentValues.put(COLUMN_EMAIL, contact.getEmail());
        contentValues.put(COLUMN_PSWD, contact.getPswd());
        database.insert(TABLE_NAME, null, contentValues);
        //Toast.makeText(getApplicationContext(), "Data Inserted.....",Toast.LENGTH_SHORT).show();
        database.close();
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public boolean isCorrect(String email_id, String pswd1) {
        /*String query = "SELECT " + COLUMN_PSWD + "FROM " + TABLE_NAME + " WHERE " +COLUMN_EMAIL + "='" + email_id + "');";
        Cursor cursor = database.rawQuery(query, null);
        String a = "";
        if (cursor != null) {
            a = cursor.getString(0);
            cursor.moveToFirst();
        }
        return a;*/

        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + " = '" + email_id + "' AND " + COLUMN_PSWD + " = '" + pswd1 + "';", null);
        if (cursor != null) {
            cursor.moveToFirst();
            return true;
        }
        return false;
        /*boolean exist = (cur.getCount() > 0);
        cur.close();
        database.close();
        //Toast.makeText(getApplicationContext(), "Checked.....",Toast.LENGTH_SHORT).show();
        return exist;*/
    }

    /*public Cursor getallrows(){
        Cursor cursor = database.rawQuery(DATABASE_NAME,new String[] {COLUMN_NAME,COLUMN_NUM, COLUMN_EMAIL, COLUMN_PSWD},null,null,null,null,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    }*/

    /*public void checkAndCopyDatabasse(){
        if(database!=null){
            Log.d("TAG","Database exists");
        }else{
            this.getReadableDatabase();
            try{
                database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
            }catch(Exception e){
                Log.d("TAG","Error");
            }
        }
    }*/
}


/*
public class DBHandler extends SQLiteOpenHelper{

    private static final String TAG = "";
    String query = "CREATE TABLE " + TABLE_PERSON +
            "(" +
            NAME + " TEXT," +
            NUM + " INTEGER," +
            EMAIL + " TEXT," +
            PSWD + " TEXT," +
            ")";;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TABLE_PERSON";
    public static final String TABLE_PERSON = "TABLE_PERSON";
    public static final String NAME = "Name";
    public static final String NUM = "Num";
    public static final String EMAIL = "Email";
    public static final String PSWD = "Pswd";

    private DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db=getWritableDatabase();
        db.execSQL(query);
    }

    private static DBHandler mDbHelper;

    public static synchronized DBHandler getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.

        if (mDbHelper == null) {
            mDbHelper = new DBHandler(context.getApplicationContext());
        }
        return mDbHelper;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_PERSON + "'");
        onCreate(db);
    }

    public void insertUserDetail(TABLE_PERSON userData) {

        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();

        try {
            ContentValues values = new ContentValues();
            values.put(NAME, userData.NAME);
            values.put(NUM, userData.NUM);
            values.put(EMAIL, userData.EMAIL);
            values.put(PSWD, userData.PSWD);

            db.insertOrThrow(TABLE_PERSON, null, values);
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d(TAG, "Error while trying to add post to database");
        } finally {

            db.endTransaction();
        }


    }

    /*
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    public void addDetail(String a1, String a2, String a3, String a4){
        SQLiteDatabase db = getWritableDatabase();
        //final String Insert_Data="INSERT INTO TABLE_PERSON (Name,Num,Email,Pswd) VALUES('"+a1+"', '"+a2+"', '"+a3+"', '"+a4+"');";
        db.execSQL(Insert_Data);
        /*ContentValues values = new ContentValues();
        values.put(Name,a1);
        values.put(Num,a2);
        values.put(Email,a3);
        values.put(Pswd,a4);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PERSON, null, values);
        db.close();
    }*/

    /*public ArrayList<Rows> getRows(){
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = getWritableDatabase();
        cursor = db.rawQuery(query,null);
        ArrayList<Rows> list=new ArrayList<Rows>();

        while(cursor.moveToNext()){
            Rows row=new Rows();
            row.setcol1(cursor.getString(0));
            row.setcol2(cursor.getString(1));
            row.setcol3(cursor.getString(2));
            list.add(row);
        }

        cursor.close();
        db.close();
        return list;
    }

*/
