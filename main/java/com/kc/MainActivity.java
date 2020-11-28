package com.kc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kc.util.Stats;

public class MainActivity extends AppCompatActivity {

    public int displayX, displayY, cookies;

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
}