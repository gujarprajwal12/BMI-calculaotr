package gujarprawjal12gmail.com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;
    

   TextView mbimidisplay , mbmicateogory,mgender;
   Intent intent;
   ImageView mimageview;
   String  mbmi;
   float intbmi;

   String height;
   String weight;
   float intheight,intweight;
   RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>" ));
        getSupportActionBar().setTitle("Your BMI Result");
        // we can use drewable for the get the color

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D" ) );
        getSupportActionBar().setBackgroundDrawable(colorDrawable);



        intent = getIntent();
        mbimidisplay = findViewById(R.id.BMIDisplay);
        mbmicateogory = findViewById(R.id.BmiCalculation);
        mgender = findViewById(R.id.GenderDisplay);
        mbackground = findViewById(R.id.contantlayout);
        mimageview = findViewById( R.id.imageview);
        mrecalculatebmi = findViewById(R.id.REcalculatebmi);

        // to get the data form user

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");


        //to get result into the flot we need to convert the sting into float

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight / 100;

        intbmi = intweight / (intheight*intheight);

        mbmi = Float.toString(intbmi);

        if( intbmi < 16) {
           mbmicateogory.setText("Severe Thinness");
           mbackground.setBackgroundColor(Color.RED);
           mimageview.setImageResource(R.drawable.cross);
        }
        else if ( intbmi <16.9 && intbmi >16) {
            mbmicateogory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if ( intbmi <18.4 && intbmi >17) {
            mbmicateogory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
         else if ( intbmi <25 && intbmi >18.4){
            mbmicateogory.setText("Normal");
            mbackground.setBackgroundColor(Color.BLUE);
            mimageview.setImageResource(R.drawable.ok_sign);
        }
        else if ( intbmi <29.4 && intbmi >25){
            mbmicateogory.setText("OverWeight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else {
            mbmicateogory.setText("Obse class");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }


        mgender.setText(intent.getStringExtra("gender"));
        mbimidisplay.setText(mbmi);


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