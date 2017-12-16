package bhavesh.app3;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * Created by User on 24-Jan-17.
 */


public class frag4 extends Fragment{
    public static String[] title_list;
    public static String[] title_desc;
    public static int[] flag;
    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_frag4, container,false);

        title_list = new String[]{
                "10th Board", "12th Board", "SCIPE", "SSS"
        };

        flag = new int[]{
                R.drawable.xmarksheet, R.drawable.qq, R.drawable.qq1, R.drawable.qq2
        };

        title_desc = new String[]{
                "I have successfully qualified 10th Board exam with a CGPA of 10.", "I have successfully qualified 12th Board exam with a percentage of 94%.", "I have successfully qualified SSS exam for which I was awarded a medal by Education minister.", "I have successfully qualified SCIPE in which I attended a 5 day inductive session with top professors of India."
        };

        list = (ListView)rootView.findViewById(R.id.list0);
        list.setAdapter(new ListViewAdapter(getActivity().getApplicationContext(),title_list,title_desc,flag));
        return rootView;
    }

}




























/*
public class frag4 extends Fragment {

    String[] listviewTitle = new String[]{
            "10th Board", "12th Board", "SCIPE", "SSS"
    };

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag4, container, false);
        perform(view);
        return view;
    }

    public void perform(View view) {
        ListView lv = (ListView)view.findViewById(R.id.list0);
        ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listviewTitle);

        lv.setAdapter(ListViewAdapter);
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listView = (ListView) getView().findViewById(R.id.list0);

        String[] listviewTitle = new String[]{
                "10th Board", "12th Board", "SCIPE", "SSS"
        };


        int[] listviewImage = new int[]{
                R.drawable.xmarksheet, R.drawable.qq, R.drawable.qq1, R.drawable.qq2
        };

        String[] listviewShortDescription = new String[]{
                "I have successfully qualified 10th Board exam with a CGPA of 10.", "I have successfully qualified 12th Board exam with a percentage of 94%.", "I have successfully qualified SSS exam for which I was awarded a medal by Education minister.", "I have successfully qualified SCIPE in which I attended a 5 day inductive session with top professors of India."
        };


        ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listviewTitle);

        listView.setAdapter(ListViewAdapter);



    }



/*
        String[] listviewTitle = new String[]{
                "10th Board", "12th Board", "SCIPE", "SSS"
        };


        int[] listviewImage = new int[]{
                R.drawable.xmarksheet, R.drawable.qq, R.drawable.qq1, R.drawable.qq2
        };

        String[] listviewShortDescription = new String[]{
                "I have successfully qualified 10th Board exam with a CGPA of 10.", "I have successfully qualified 12th Board exam with a percentage of 94%.", "I have successfully qualified SSS exam for which I was awarded a medal by Education minister.", "I have successfully qualified SCIPE in which I attended a 5 day inductive session with top professors of India."
        };

        ListView listView = (ListView) view.findViewById(R.id.lw1);

        ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listviewTitle);

        listView.setAdapter(ListViewAdapter);

        return view;
    }














    /*private String[] title;
    private String[] desc;
    private Integer[] imageid;
    private Activity context;



    public frag4(Activity context, String[] title, String[] desc, Integer[] imageid) {
        super();
        //super(context, R.layout.row, title);
        this.context = context;
        this.title = title;
        this.desc = desc;
        this.imageid = imageid;

    }


    String[] listviewTitle = new String[]{
            "10th Board", "12th Board", "SCIPE", "SSS"
    };


    int[] listviewImage = new int[]{
            R.drawable.xmarksheet, R.drawable.qq, R.drawable.qq1, R.drawable.qq2
    };

    String[] listviewShortDescription = new String[]{
            "I have successfully qualified 10th Board exam with a CGPA of 10.", "I have successfully qualified 12th Board exam with a percentage of 94%.", "I have successfully qualified SSS exam for which I was awarded a medal by Education minister.", "I have successfully qualified SCIPE in which I attended a 5 day inductive session with top professors of India."
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_frag4, container, false);



        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.iv1, R.id.tv1, R.id.tv2};

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }




        SimpleAdapter simpleAdapter = new SimpleAdapter(v.getContext(), aList, R.layout.fragment_frag4, from, to);
        ListView androidListView = (ListView) v.findViewById(R.id.list0);
        androidListView.setAdapter(simpleAdapter);

/*
    private List<certificates> mycertificates = new ArrayList<certificates>();
    //ListView listview = (ListView) frag4.this.getView();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_frag4, container, false);
        //ListView list = (ListView)rootView.findViewById(list);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        additemtolist();
        addlistview();

        ListView listView = (ListView) getActivity().findViewById(R.id.list);
        String[] qualifications = {"10th Board", "12th Board", "SCIPE", "SSS"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getView().getContext(),android.R.layout.simple_list_item_1,qualifications);
        listView.setAdapter(adapter);
    }

    private void addlistview() {
        ArrayAdapter<certificates> adapter = new MyListAdapter();
        ListView list = (ListView) getView().findViewById(R.id.list);
        list.setAdapter(adapter);
    }

    private void additemtolist() {
        mycertificates.add(new certificates("10th Board","I have successfully qualified 10th Board exam with a CGPA of 10.",R.drawable.xmarksheet));
        mycertificates.add(new certificates("12th Board","I have successfully qualified 12th Board exam with a percentage of 94%.",R.drawable.qq));
        mycertificates.add(new certificates("SSS","I have successfully qualified SSS exam for which I was awarded a medal by Education minister.",R.drawable.qq1));
        mycertificates.add(new certificates("SCIPE","I have successfully qualified SCIPE in which I attended a 5 day inductive session with top professors of India.",R.drawable.qq2));
    }

    private class MyListAdapter extends ArrayAdapter<certificates>
    {
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view, mycertificates);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView =  convertView;
            if (itemView==null)
                itemView = getLayoutInflater(Bundle.EMPTY).inflate(R.layout.item_view, parent, false);

            certificates currcer = mycertificates.get(position);
            ImageView imageview =(ImageView)itemView.findViewById(R.id.item_icon);
            imageview.setImageResource(currcer.getIconID());
            /*TextView currtxt = (TextView) itemView.findViewById(R.id.texttitle);
            currtxt.setText(currtxt.getTitle());
            TextView currinfo = (TextView) itemView.findViewById(R.id.textinfo);
            currinfo.setText(currinfo.getInfo());
            return itemView;
        }
    }

        return v;
    }
}
*/