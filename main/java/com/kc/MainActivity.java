package com.kc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kc.util.Stats;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int displayX, displayY, wait_time=0, cookies, wait_klee=20;
    private boolean wait;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //hier was abläuft
            check_kleeblatt();
            handler.postDelayed(this,1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayX = (int) (getResources().getDisplayMetrics().widthPixels * 0.75);
        displayY = (int) (getResources().getDisplayMetrics().heightPixels * 0.75);

        ImageView cookie = findViewById(R.id.cookie);
        ImageView background = findViewById(R.id.background);
        background.setImageBitmap(create_background(R.drawable.back));

        Button shop = findViewById(R.id.shop);
        handler.post(runnable);

        cookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stats.COOKIES = Stats.COOKIES + Stats.COOKIES_PLUS;
                updateUI();
                ImageView image = findViewById(R.id.cookie);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation_cookie);
                image.startAnimation(animation);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_shop);
            }
        });

    }

    public void updateUI() {
        TextView cookiesam = findViewById(R.id.cookiesam);
        cookiesam.setText(String.valueOf(Stats.COOKIES));
    }

    public Bitmap create_background(int graphic) {
        Bitmap img = BitmapFactory.decodeResource(getResources(), graphic);
        img = Bitmap.createScaledBitmap(img, displayX, displayY, true);
        return img;
    }

    private void check_kleeblatt() {
        Random zufall = new Random();
        //IMAGE VIEW

        if(wait) {
            wait_time++;
            if(wait_time == wait_klee) {
                wait=false;
            } else {
                wait=true;
                wait_klee = zufall.nextInt(60);
                wait_time=0;
                //Image wird angezeigt!
            }
        }
    }
}