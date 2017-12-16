package bhavesh.app3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.SystemClock.sleep;

public class LoginActivity extends AppCompatActivity {

    final DBHandler dbHelper = new DBHandler(LoginActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b1 = (Button) findViewById(R.id.bsign);
        final EditText em = (EditText)findViewById(R.id.editText1);
        final EditText ps = (EditText)findViewById(R.id.editText2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!em.getText().toString().equals("") && !ps.getText().toString().equals("") && dbHelper.isCorrect(em.getText().toString(),ps.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Success.....",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials. Try again.....",Toast.LENGTH_SHORT).show();
            }
            }
        });
    }


    /*public static boolean CheckIsDataAlreadyInDBorNot(String TableName,
                                                      String dbfield, String fieldValue) {
        SQLiteDatabase sqldb = this.getReadableDatabase();
        String Query = "Select pwsd from " + TableName + " where " + dbfield + " = " + fieldValue;
        Cursor cursor = sqldb.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }*/

    public void goToregister (View view){
        Intent intent = new Intent (LoginActivity.this,Register.class);
        startActivity(intent);
    }

    /*public static boolean CheckIsDataAlreadyInDBorNot(String TableName,
                                                      String dbfield, String fieldValue) {
        SQLiteDatabase sqldb = ;
        String Query = "Select * from " + TableName + " where " + dbfield + " = " + fieldValue;
        Cursor cursor = sqldb.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }*/

}


