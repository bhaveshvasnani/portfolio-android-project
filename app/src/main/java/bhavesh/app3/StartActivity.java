package bhavesh.app3;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //final ImageView zoom = (ImageView) findViewById(R.id.ImageView);
        //final Animation zoomAnimation = AnimationUtils.loadAnimation(this,R.anim.zoom);
        //zoom.startAnimation(zoomAnimation);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent (StartActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        }, 8000);

    }
/*
    public void goToactivity_login (View view){
        Intent intent = new Intent (StartActivity.this,LoginActivity.class);
        startActivity(intent);
    }

*/
}
