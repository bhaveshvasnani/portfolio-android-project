package bhavesh.app3;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by User on 29-Jan-17.
 */

public class registered_users extends AppCompatActivity {
    private DBHandler dbhelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Registered Users");
        setContentView(R.layout.registered_users);
        ListView listView = (ListView) findViewById(R.id.lw1);
        dbhelper = new DBHandler(this);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = dbhelper.getListContents();
        if (data.getCount() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
