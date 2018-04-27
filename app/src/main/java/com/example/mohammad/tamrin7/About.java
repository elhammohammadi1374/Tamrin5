package com.example.mohammad.tamrin7;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;

public class About extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private int loc1=0;
    private int loc2=0;
    private RadioGroup RG1;

    int[] RB12={R.id.RB1 ,R.id.RB2};
    int[] sounds={R.raw.s40,R.raw.s50,R.raw.s2,R.raw.daghigheh,0};
    int[] sounds1={0,R.raw.s1,R.raw.s2,R.raw.s3,R.raw.s4,R.raw.s5,R.raw.s6,R.raw.s7,R.raw.s8,R.raw.s9,R.raw.s10,R.raw.s11,R.raw.s12,R.raw.s13,
            R.raw.s14,R.raw.s15,R.raw.s16,R.raw.s17,R.raw.s18,R.raw.s19,R.raw.s20};
    int[] sounds1o={0,R.raw.s1o,R.raw.s2o,R.raw.s3o,R.raw.s4o,R.raw.s5o,R.raw.s6o,R.raw.s7o,R.raw.s8o,R.raw.s9o,R.raw.s10o,R.raw.s11o,R.raw.s12o,
            R.raw.s13o,R.raw.s14o,R.raw.s15o,R.raw.s16o,R.raw.s17o,R.raw.s18o,R.raw.s19o,R.raw.s20o};
    int[] sounds10={0,R.raw.s10,R.raw.s20,R.raw.s30,R.raw.s40,R.raw.s50};
    int[] sounds10o={0,R.raw.s10o,R.raw.s20o,R.raw.s30o,R.raw.s40o,R.raw.s50o};

    int[] counds={R.raw.c40,R.raw.c50,R.raw.c2,R.raw.dagh,0};
    int[] counds1={0,R.raw.c1,R.raw.c2,R.raw.c3,R.raw.c4,R.raw.c5,R.raw.c6,R.raw.c7,R.raw.c8,R.raw.c9,R.raw.c10,R.raw.c11,R.raw.c12,R.raw.c13,
            R.raw.c14,R.raw.c15,R.raw.c16,R.raw.c17,R.raw.c18,R.raw.c19,R.raw.c20};
    int[] counds1o={0,R.raw.c1o,R.raw.c2o,R.raw.c3o,R.raw.c4o,R.raw.c5o,R.raw.c6o,R.raw.c7o,R.raw.c8o,R.raw.c9o,R.raw.c10o,R.raw.c11o,R.raw.c12o,
            R.raw.c13o,R.raw.c14o,R.raw.c15o,R.raw.c16o,R.raw.c17o,R.raw.c18o,R.raw.c19o,R.raw.c20o};
    int[] counds10={0,R.raw.c10,R.raw.c20,R.raw.c30,R.raw.c40,R.raw.c50};
    int[] counds10o={0,R.raw.c10o,R.raw.c20o,R.raw.c30o,R.raw.c40o,R.raw.c50o};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        RG1=(RadioGroup) findViewById(R.id.RG1);


        Intent about_activity=getIntent();

        RG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RB12[0]== R.id.RB1) {
                    Bundle about_activity = getIntent().getExtras();
                    int h = about_activity.getInt("hours");
                    int m = about_activity.getInt("minutes");

                    if (h == 0)
                        h = 12;
                    else if (h > 12)
                        h -= 12;


                    int i = 0;
                    sounds[i++] = m == 0 ? sounds1[h] : sounds1o[h];
                    if (m < 20)
                        sounds[i++] = sounds1[m];
                    else {
                        int m10 = m / 10;
                        int m1 = m % 10;
                        sounds[i++] = m1 == 0 ? sounds10[m10] : sounds10o[m10];
                    }
                    if (m != 0)
                        sounds[i++] = R.raw.daghigheh;
                    sounds[i++] = 0;
                    MediaPlayer mp = MediaPlayer.create(About.this, R.raw.saat);
                    mp.setOnCompletionListener(About.this);
                    mp.start();
                }

                else if (RB12[1]== R.id.RB2) {
                    Bundle extras = getIntent().getExtras();
                    int h = extras.getInt("hours");
                    int m = extras.getInt("minutes");

                    if (h == 0)
                    h = 12;
                    else if (h > 12)
                    h -= 12;
                    int i = 0;
                    counds[i++] = m == 0 ? counds1[h] : counds1o[h];
                    if (m < 20)
                    counds[i++] = counds1[m];
                    else {
                    int m10 = m / 10;
                    int m1 = m % 10;
                    counds[i++] = m1 == 0 ? counds10[m10] : counds10o[m10];
                    }
                    if (m != 0)
                    counds[i++] = R.raw.dagh;
                    counds[i++] = 0;
                    MediaPlayer mp = MediaPlayer.create(About.this, R.raw.caat);
                    mp.setOnCompletionListener(About.this);
                    mp.start();
                }

            }

        });

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        if (RB12[0]== R.id.RB1) {

            if (sounds[loc1] != 0) {
                MediaPlayer m = MediaPlayer.create(About.this, sounds[loc1]);
                loc1++;
                m.setOnCompletionListener(About.this);
                mp.start();
            }
        }
        if (RB12[1]== R.id.RB2) {

            if (counds[loc2] != 0) {
                MediaPlayer m = MediaPlayer.create(About.this, counds[loc2]);
                loc2++;
                m.setOnCompletionListener(About.this);
                mp.start();
            }
        }

    }



}
