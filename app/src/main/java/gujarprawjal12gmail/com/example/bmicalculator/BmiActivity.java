package gujarprawjal12gmail.com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BmiActivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        getSupportActionBar().hide();
        mrecalculatebmi = findViewById(R.id.REcalculatebmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( BmiActivity.this,MainActivity.class );
                startActivity(intent);
                finish();
            }
        });
    }
}