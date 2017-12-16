package bhavesh.app3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 31-Jan-17.
 */

public class row extends Activity {
    ImageView imgflag;
    TextView txttitle;
    TextView txtdesc;
    String[] title_list;
    String[] title_desc;
    int[] flag;
    int position;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row);
        Intent i = getIntent();
        position = i.getExtras().getInt("position");
        title_list = i.getStringArrayExtra("title_list");
        title_desc = i.getStringArrayExtra("title_desc");
        flag = i.getIntArrayExtra("flag");
        txttitle = (TextView) findViewById(R.id.tv1);
        txtdesc = (TextView) findViewById(R.id.tv2);
        imgflag.setImageResource(flag[position]);
    }

}
/*
    public row(int imgflag, String txttitle, String txtdesc) {
        this.imgflag = imgflag;
        this.txttitle = txttitle;
        this.txtdesc = txtdesc;
    }
    public int getimgflag() {
        return imgflag;
    }
    public void setimgflag(int imgflag) {
        this.imgflag = imgflag;
    }
    public String gettxtdesc() {
        return txtdesc;
    }
    public void settxtdesc(String txtdesc) {
        this.txtdesc = txtdesc;
    }
    public String gettxttitle() {
        return txttitle;
    }
    public void settxttitle(String txttitle) {
        this.txttitle = txttitle;
    }
    @Override
    public String toString() {
        return txttitle + "\n" + txtdesc;
    }
}
*/