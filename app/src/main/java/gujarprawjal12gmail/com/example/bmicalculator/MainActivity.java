package gujarprawjal12gmail.com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mcalculatebmi;

     TextView mcurrenththeight;
    TextView  mcurrentage, mcurrentweight;
    ImageView mincrementage, mincrementweight, mdecermentage, mddecremetweight;
    SeekBar mseekbarforheight;
    RelativeLayout mmale,mfemale;

    int intweight = 50;
    int intage =23;
    int currentprogress;
    String mintprogress = "180";
    String typeofuser="0";
    String weight2 = "55";
    String age2 = "25";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mcalculatebmi = findViewById(R.id.calculatebmi);
        mcurrentage = findViewById(R.id.currentAge);
        mcurrentweight = findViewById(R.id.currentweight);
        mcurrenththeight = findViewById(R.id.currentheight);
        mincrementage = findViewById(R.id.inccementAge);
        mincrementweight = findViewById(R.id.inccementweight);
        mdecermentage = findViewById(R.id.dercementAge);
        mddecremetweight = findViewById(R.id.dercementweight);
        mseekbarforheight = findViewById(R.id.SeekBarforheight);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);



     mmale.setOnClickListener(new View.OnClickListener( ) {
         @Override
         public void onClick(View v) {
             mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalfocus));
             mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalnotfocus));
             typeofuser = "Male";
         }
     });


        mfemale.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalfocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalnotfocus));
                typeofuser = "Female";
            }
        });

    //  Seekbar code in the andriod studio  whole process


        mseekbarforheight.setMax(350);
        mseekbarforheight.setProgress(180);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener( ) {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 currentprogress = progress;
                 mintprogress = String.valueOf(currentprogress);
                 mcurrenththeight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        // for incerment height  and the weight

        mincrementage.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                 intage = intage+1;
                 age2 = String.valueOf(intage);
                 mcurrentage.setText(age2);
            }
        });



        mincrementweight.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                intweight = intweight+1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });


        mdecermentage.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                intage = intage-1;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });


        mddecremetweight.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                intweight = intweight-1;
                weight2 = String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });



        mcalculatebmi.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {


                if (typeofuser.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select Your Gender First", Toast.LENGTH_SHORT).show();
                }

                else if (mintprogress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"Select Your Height First", Toast.LENGTH_SHORT).show();

                }
                else  if ( intage==0 || intage<0)
                {
                    Toast.makeText(getApplicationContext(),"Age is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else  if( intweight == 0 || intweight<0 )
                {
                    Toast.makeText(getApplicationContext(),"Weight is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else{

                    Intent intent = new Intent( MainActivity.this,BmiActivity.class );
                    intent.putExtra("gender" , typeofuser);
                    intent.putExtra("height" , mintprogress);
                    intent.putExtra("weight" , weight2);
                    intent.putExtra("age" , age2);
                    startActivity(intent);

                }

                finish();
            }
        });

    }
}