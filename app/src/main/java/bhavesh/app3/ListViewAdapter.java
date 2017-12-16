package bhavesh.app3;

/**
 * Created by User on 01-Feb-17.
 */

import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static bhavesh.app3.frag4.flag;
import static bhavesh.app3.frag4.title_desc;
import static bhavesh.app3.frag4.title_list;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    String[] title_list1;
    String[] title_desc1;
    int[] flag1;
    private static LayoutInflater inflater=null;

    public ListViewAdapter(Context fragment, String[] title_list, String[] title_desc, int[] flag) {
        context = fragment;
        title_list1 = title_list;
        title_desc1 = title_desc;
        flag1 = flag;
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return title_list1.length;
    }


    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder{
        TextView text1;
        TextView text2;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.row,null);
        holder.text1=(TextView)rowView.findViewById(R.id.tv1);
        holder.text2=(TextView)rowView.findViewById(R.id.tv2);
        holder.img=(ImageView)rowView.findViewById(R.id.iv1);
        return rowView;
    }
}
