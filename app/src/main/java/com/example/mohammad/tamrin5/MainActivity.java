package com.example.mohammad.tamrin5;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface seg = Typeface.createFromAsset(getAssets(), "fonts/segment7.otf");
        TextView edt = (TextView) findViewById(R.id.edt);
        edt.setTypeface(seg);

        final ArrayList<Integer> clock = new ArrayList<>(23);
        clock.set(0,R.raw.s1); clock.set(1,R.raw.s2); clock.set(2,R.raw.s3); clock.set(3,R.raw.s4);clock.set(4,R.raw.s5);clock.set(5,R.raw.s6);clock.set(6,R.raw.s7);clock.set(7,R.raw.s8);clock.set(8,R.raw.s9);
        clock.set(9,R.raw.s10);clock.set(10,R.raw.s11);clock.set(11,R.raw.s12);clock.set(12,R.raw.s13);clock.set(13,R.raw.s14);clock.set(14,R.raw.s15);clock.set(15,R.raw.s16);clock.set(16,R.raw.s17);clock.set(17,R.raw.s18);
        clock.set(18,R.raw.s19);clock.set(19,R.raw.s20);clock.set(20,R.raw.s30);clock.set(30,R.raw.s40);clock.set(40,R.raw.s50);
        final ArrayList<Integer> clocko = new ArrayList<>(23);
        clocko.set(0,R.raw.s1o); clocko.set(1,R.raw.s2o); clocko.set(2,R.raw.s3o); clocko.set(3,R.raw.s4o);clocko.set(4,R.raw.s5o);clocko.set(5,R.raw.s6o);clocko.set(6,R.raw.s7o);clocko.set(7,R.raw.s8o);clocko.set(8,R.raw.s9o);
        clocko.set(9,R.raw.s10o);clocko.set(10,R.raw.s11o);clocko.set(11,R.raw.s12o);clocko.set(12,R.raw.s13o);clocko.set(13,R.raw.s14o);clocko.set(14,R.raw.s15o);clocko.set(15,R.raw.s16o);clocko.set(16,R.raw.s17o);clocko.set(17,R.raw.s18o);
        clocko.set(18,R.raw.s19o);clocko.set(19,R.raw.s20o);clocko.set(20,R.raw.s30o);clocko.set(30,R.raw.s40o);clocko.set(40,R.raw.s50o);
        ArrayList<Integer> HMS = new ArrayList<>(2);
       HMS.set(0,R.raw.daghigheh); HMS.set(1,R.raw.daghigheho);

        Button b = (Button) findViewById(R.id.btn);
        final EditText e = (EditText) findViewById(R.id.edt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date d = new Date();
                int h = d.getHours();
                int m = d.getMinutes();
                int s = d.getSeconds();
                e.setText(h + ":" + m + ";" + s);

                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.saat);
                mp.start();

                while (h != 0 && m != 0 && s != 0) {
                    if (h > 0 && h <= 20) {
                        if (m != 0 || s != 0) {
                            mp = MediaPlayer.create(MainActivity.this, clocko.get(h - 1));
                            mp.start();
                        } else if (m == 0 && s == 0) {
                            mp = MediaPlayer.create(MainActivity.this, clock.get(h - 1));
                            mp.start();
                        }
                    } else if (h > 20) {
                        int h1 = h % 10;
                        int h2 = h - h1;
                        if (m != 0 || s != 0) {
                            mp = MediaPlayer.create(MainActivity.this, clocko.get(h2 - 1));
                            mp.start();
                            mp = MediaPlayer.create(MainActivity.this, clock.get(h1 - 1));
                            mp.start();
                        } else if (m == 0 && s == 0) {
                            mp = MediaPlayer.create(MainActivity.this, clocko.get(h2 - 1));
                            mp.start();
                            mp = MediaPlayer.create(MainActivity.this, clock.get(h1 - 1));
                            mp.start();
                        }
                    }

                    if (m > 0 && m <= 20) {

                        mp = MediaPlayer.create(MainActivity.this, clock.get(m - 1));
                        mp.start();
                    } else if (m > 20) {
                        int m1 = m % 10;
                        int m2 = m - m1;
                        if ((m % 10) == 0) {
                            mp = MediaPlayer.create(MainActivity.this, clock.get(m - 1));
                            mp.start();
                        } else {
                            mp = MediaPlayer.create(MainActivity.this, clocko.get(m2 - 1));
                            mp.start();
                            mp = MediaPlayer.create(MainActivity.this, clock.get(m1 - 1));
                            mp.start();
                        }
                        if (s != 0) {
                            mp = MediaPlayer.create(MainActivity.this, R.raw.daghigheho);
                            mp.start();
                        } else {
                            mp = MediaPlayer.create(MainActivity.this, R.raw.daghigheh);
                            mp.start();
                        }
                    }
                    if (s > 0 && s <= 20) {
                        mp = MediaPlayer.create(MainActivity.this, clock.get(s - 1));
                        mp.start();
                    } else {
                        int s1 = s % 10;
                        int s2 = s - s1;
                        if ((s % 10) == 0) {
                            mp = MediaPlayer.create(MainActivity.this, clock.get(s - 1));
                            mp.start();
                        } else {
                            mp = MediaPlayer.create(MainActivity.this, clocko.get(s2 - 1));
                            mp.start();
                            mp = MediaPlayer.create(MainActivity.this, clock.get(s1 - 1));
                            mp.start();
                        }
                    }

                    mp = MediaPlayer.create(MainActivity.this, R.raw.sanieh);
                    mp.start();

                }
            }
        });


    }
}
