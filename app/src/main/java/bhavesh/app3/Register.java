package bhavesh.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Register extends AppCompatActivity {

    //DBHandler dbhelper = new DBHandler(this, null, null, 1);
    //DBHandler dbHandler;
    //SQLiteDatabase db;
    //EditText e2,e3,e4,e5 ;
    //Button reg ;
    //String Name, Num, Email, Pswd ;
    //Boolean CheckEditTextEmpty ;
    //String SQLiteQuery;
    //SQLiteDatabase SQLITEDATABASE = ((Activity)getApplication(DBHandler)).db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");
        //windowSoftInputMode : Ti.UI.Android.SOFT_INPUT_ADJUST_PAN;
        //final DBHandler dbhelper = new DBHandler(this, null, null, 1);
        final EditText e2,e3,e4,e5 ;
        e2 = (EditText) findViewById(R.id.editText6);
        e3 = (EditText) findViewById(R.id.editText7);
        e4 = (EditText) findViewById(R.id.editText8);
        e5 = (EditText) findViewById(R.id.editText11);
        Button reg = (Button) findViewById(R.id.breg);

        final DBHandler sQLiteHelper = new DBHandler(Register.this);
        //final DBHandler dbHelper =  DBHandler.getInstance(getApplicationContext());;

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!e2.getText().toString().equals("") && !e3.getText().toString().equals("") && !e4.getText().toString().equals("") && !e5.getText().toString().equals("")) {
                    TABLE_PERSON userData = new TABLE_PERSON();
                    userData.setName(e2.getText().toString());
                    userData.setNum(e3.getText().toString());
                    userData.setEmail(e4.getText().toString());
                    userData.setPswd(e5.getText().toString());
                    sQLiteHelper.insertRecord(userData);
                    Toast.makeText(getApplicationContext(), "Registered. Go back to login", Toast.LENGTH_SHORT).show();
                    //dbHelper.addDetail(e2.toString(),e3.toString(),e4.toString(),e5.toString());
                    e2.getText().clear();
                    e3.getText().clear();
                    e4.getText().clear();
                    e5.getText().clear();
                } else {
                    Toast.makeText(getApplicationContext(), "All entries should be filled", Toast.LENGTH_SHORT).show();
                }
                //DBCreate();
                //Submit();
            }
        });
    }

    public void goToactivity_login1(View view) {
        Intent intent = new Intent(Register.this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToregistered_users(View view){
        Intent intent = new Intent(Register.this, registered_users.class);
        startActivity(intent);
    }


/*
    public void DBCreate(){
        db = dbhelper.getWritableDatabase();
        //SQLITEDATABASE = openOrCreateDatabase("details.db", Context.MODE_PRIVATE, null);
        //SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS TABLE_PERSON(NAME VARCHAR,NUM INTEGER, EMAIL VARCHAR, PSWD VARCHAR;");
    }

    public void Submit(){
        Name = e2.getText().toString();
        Num = e3.getText().toString();
        Email = e4.getText().toString();
        Pswd = e5.getText().toString();
        CheckEditTextIsEmptyOrNot( Name,Num, Email,Pswd);

        if(CheckEditTextEmpty == true)
        {
            dbhelper.addDetail(Name,Num,Email,Pswd);
            //SQLiteQuery = "INSERT INTO TABLE_PERSON (NAME, NUM, EMAIL, PSWD) VALUES('"+Name+"', '"+Num+"', '"+Email+"', '"+Pswd+"');";
            //SQLITEDATABASE.execSQL(SQLiteQuery);
            Toast.makeText(Register.this,"Registered Successfully", Toast.LENGTH_LONG).show();
            ClearEditTextAfterDoneTask();
        }
        else {
            Toast.makeText(Register.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String Name,String Num, String Email, String Pswd ){
        if(TextUtils.isEmpty(Name) || TextUtils.isEmpty(Num) || TextUtils.isEmpty(Email) || TextUtils.isEmpty(Pswd)){
            CheckEditTextEmpty = false ;
        }
        else {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask(){
        e2.getText().clear();
        e3.getText().clear();
        e4.getText().clear();
        e5.getText().clear();
    }

/*
    public void registerclicked(){
        //insertIntoDB(db);
    }

    protected void createDatabase(){
    db=openOrCreateDatabase("PersonDB", Context.MODE_PRIVATE, null);
    db.execSQL("CREATE TABLE IF NOT EXISTS TABLE_PERSON(NAME VARCHAR,NUM INTEGER, EMAIL VARCHAR, PSWD VARCHAR;");
}

    protected void insertIntoDB(SQLiteDatabase db){
        db = dbhelper.getWritableDatabase();
    String name = e2.getText().toString().trim();
    String num = e3.getText().toString().trim();
        String email = e3.getText().toString().trim();
        String pswd = e3.getText().toString().trim();
    if(name.equals("") || num.equals("") || email.equals("") || pswd.equals("")){
        Toast.makeText(getApplicationContext(),"Please fill all fields", Toast.LENGTH_LONG).show();
        return;
    }

    String query = "INSERT INTO TABLE_PERSON VALUES('"+name+"', '"+num+"', '\"+email+\"', '\"+pswd+\"');";
    this.db.execSQL(query);
    Toast.makeText(getApplicationContext(),"Saved Successfully", Toast.LENGTH_LONG).show();
}*/
}