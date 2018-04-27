package com.example.mohammad.tamrin7;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView hours , minutes;
    private Button btn ,btn_About;

    Date d = new Date();
    private int h = d.getHours();
    private int m = d.getMinutes();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hours=(TextView)findViewById(R.id.hours);
        minutes=(TextView)findViewById(R.id.minute);
        btn=(Button)findViewById(R.id.btn);
        btn_About=(Button)findViewById(R.id.btn_About);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface seg=Typeface.createFromAsset(getAssets(),"fonts/digital7.otf");
                hours.setTypeface(seg);
                minutes.setTypeface(seg);

                Date d = new Date();
                int h = d.getHours();
                int m = d.getMinutes();
                String hs = String.format("%2d" , h);
                String ms = String.format("%2d" , m);
                hours.setText(hs);
                minutes.setText(ms);
            }
        });

        btn_About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_activity = new Intent(MainActivity.this, About.class);
                about_activity.putExtra("hours",h);
                about_activity.putExtra("minutes",m);
                startActivity(about_activity);

            }
        });


    }


}
