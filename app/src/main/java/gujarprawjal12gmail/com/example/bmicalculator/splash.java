package gujarprawjal12gmail.com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // USE TO REMOVE THE TITLE BAR
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // TO HIDE THE ACTION BAR
        getSupportActionBar().hide();

        // to create the splash effect

        new Handler(  ).postDelayed(new Runnable( ) {
            @Override
            public void run() {
                Intent intent = new Intent( splash.this,MainActivity.class );
               startActivity(intent);
               finish();

            }
        }, 1500);


    }
}