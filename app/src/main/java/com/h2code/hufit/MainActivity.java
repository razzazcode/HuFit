package com.h2code.hufit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titlepage, subtitlepage, btnexercise;
    ImageView imgpage;
    Animation animimgpage, bttone, bttwo, btthree, ltr;
    View bgprogress, bgprogresstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // load animation
        animimgpage = AnimationUtils.loadAnimation(this, R.anim.animimgpage);
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        ltr = AnimationUtils.loadAnimation(this, R.anim.ltr);

        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/mlight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/mmedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/daloka.ttf");

        titlepage =  findViewById(R.id.titlepage);
        subtitlepage =  findViewById(R.id.subtitlepage);
        btnexercise =  findViewById(R.id.btnexercise);
        imgpage = findViewById(R.id.imgpage);
        bgprogress =  findViewById(R.id.bgprogress);
        bgprogresstop =  findViewById(R.id.bgprogresstop);

        // customize font
        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);

        // export animate
        imgpage.startAnimation(animimgpage);
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);

        btnexercise.startAnimation(btthree);
        bgprogress.startAnimation(bttwo);
        bgprogresstop.startAnimation(ltr);

        // give an event to another page
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });



    }
}