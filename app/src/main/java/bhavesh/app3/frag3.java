package bhavesh.app3;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by User on 10-Jan-17.
 */
public class frag3 extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_frag3, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageButton fb = (ImageButton) getView().findViewById(R.id.imageButton);
        ImageButton li = (ImageButton) getView().findViewById(R.id.imageButton2);
        ImageButton sc = (ImageButton) getView().findViewById(R.id.imageButton3);
        ImageButton tw = (ImageButton) getView().findViewById(R.id.imageButton4);
        ImageButton ig = (ImageButton) getView().findViewById(R.id.imageButton5);
        ImageButton gm = (ImageButton) getView().findViewById(R.id.imageButton6);
        ImageButton cl = (ImageButton) getView().findViewById(R.id.call);

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Callintent = new Intent(Intent.ACTION_DIAL);
                Callintent.setData(Uri.parse("tel:9003673155"));
                startActivity(Callintent);
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent FacebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/bhaveshvasnani"));
                startActivity(FacebookIntent);
            }
        });

        li.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LinkedInIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in//bhavesh-vasnani-29a359137"));
                startActivity(LinkedInIntent);
            }
        });

        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SnapchatIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://snapchat.com/add/bhaveshvasnani"));
                startActivity(SnapchatIntent);
            }
        });

        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TwitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/bhaveshvasnani"));
                startActivity(TwitterIntent);
            }
        });

        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent InstagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/bhaveshvasnani"));
                startActivity(InstagramIntent);
            }
        });

        gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                        new String[] { "bhaveshvasnani197@gmail.com" });
                startActivity(emailIntent);
            }
        });

    }
}


