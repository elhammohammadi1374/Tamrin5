package com.example.mohammad.tamrin6;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener{

    private int loc=0;
    private TextView hours , minutes;
    private Button btn;
    private RadioButton RB1 , RB2 ;
    private RadioGroup RG1;
    SharedPreferences sp;
    private int n=12;

    int[] sounds={R.raw.s1,R.raw.s2,R.raw.s3,R.raw.s4,R.raw.s5,R.raw.s6,R.raw.s7,R.raw.s8,R.raw.s9,R.raw.s10,R.raw.s11,R.raw.s12,R.raw.s13,
            R.raw.s14,R.raw.s15,R.raw.s16,R.raw.s17,R.raw.s18,R.raw.s19,R.raw.s20,
            R.raw.s1o,R.raw.s2o,R.raw.s3o,R.raw.s4o,R.raw.s5o,R.raw.s6o,R.raw.s7o,R.raw.s8o,R.raw.s9o,R.raw.s10o,R.raw.s11o,R.raw.s12o,R.raw.s13o,
            R.raw.s14o,R.raw.s15o,R.raw.s16o,R.raw.s17o,R.raw.s18o,R.raw.s19o,R.raw.s20o,
            R.raw.s10,R.raw.s20,R.raw.s30,R.raw.s40,R.raw.s50,
            R.raw.s10o,R.raw.s20o,R.raw.s30o,R.raw.s40o,R.raw.s50o,0
    };
    int[] sounds1={0,R.raw.s1,R.raw.s2,R.raw.s3,R.raw.s4,R.raw.s5,R.raw.s6,R.raw.s7,R.raw.s8,R.raw.s9,R.raw.s10,R.raw.s11,R.raw.s12,R.raw.s13,
            R.raw.s14,R.raw.s15,R.raw.s16,R.raw.s17,R.raw.s18,R.raw.s19,R.raw.s20};
    int[] sounds1o={0,R.raw.s1o,R.raw.s2o,R.raw.s3o,R.raw.s4o,R.raw.s5o,R.raw.s6o,R.raw.s7o,R.raw.s8o,R.raw.s9o,R.raw.s10o,R.raw.s11o,R.raw.s12o,R.raw.s13o,
            R.raw.s14o,R.raw.s15o,R.raw.s16o,R.raw.s17o,R.raw.s18o,R.raw.s19o,R.raw.s20o};
    int[] sounds10={0,R.raw.s10,R.raw.s20,R.raw.s30,R.raw.s40,R.raw.s50};
    int[] sounds10o={0,R.raw.s10o,R.raw.s20o,R.raw.s30o,R.raw.s40o,R.raw.s50o};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hours=(TextView)findViewById(R.id.hours);
        minutes=(TextView)findViewById(R.id.minute);
        btn=(Button) findViewById(R.id.btn);
        RG1=(RadioGroup) findViewById(R.id.RG1);
        sp = getSharedPreferences("Mypref" , Context.MODE_PRIVATE);

        Typeface seg=Typeface.createFromAsset(getAssets(),"fonts/digital7.otf");
        hours.setTypeface(seg);
        minutes.setTypeface(seg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date d = new Date();
                int h = d.getHours();
                int m = d.getMinutes();
                String hs = String.format("%2d" , h);
                String ms = String.format("%2d" , m);
                hours.setText(hs);
                minutes.setText(ms);
                if(n==12) {
                    if (h == 0)
                        h = 12;
                    else if (h > 12)
                        h -= 12;
                    n = 24;

                }

                int i=0;
                sounds[i++]= m==0 ? sounds1[h] : sounds1o[h];
                if(m<20)
                    sounds[i++]=sounds1[m];
                else {
                    int m10 = m/10;
                    int m1=m%10;
                    sounds[i++]= m1==0 ? sounds10[m10] : sounds10o[m10];
                }
                if(m !=0)
                    sounds[i++]=R.raw.daghigheh;
                sounds[i++]=0;
                MediaPlayer mp = MediaPlayer.create( MainActivity.this ,R.raw.saat);
                mp.setOnCompletionListener(MainActivity.this);
                mp.start();
            }
        });

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        if(sounds[loc] != 0){
            MediaPlayer m = MediaPlayer.create(MainActivity.this , sounds[loc]);
            loc++;
            m.setOnCompletionListener(this);
            mp.start();
        }


        RG1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(v.getId()== R.id.RB1){
                    sp.edit().putInt("count" , n).commit();
                    sp.getInt("count" ,0);
                }
                else if(v.getId() == R.id.RB2){
                    sp.edit().putInt("count" , n).commit();
                    sp.getInt("count" , 0);
                }
            }
        });
    }

}

