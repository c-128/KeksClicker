package com.kc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int displayX, displayY, cookies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayX = (int) (getResources().getDisplayMetrics().widthPixels * 0.75);
        displayY = (int) (getResources().getDisplayMetrics().heightPixels * 0.75);

        ImageView cookie = findViewById(R.id.cookie);
        ImageView backgorund = findViewById(R.id.background);

        cookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cookies++;
                updateUI();
            }
        });
    }

    public void updateUI() {
        TextView cookiesam = findViewById(R.id.cookiesam);
        cookiesam.setText(String.valueOf(cookies));
    }

    public Bitmap create_background(int graphic) {
        Bitmap img = BitmapFactory.decodeResource(getResources(), graphic);
        img = Bitmap.createScaledBitmap(img, displayX, displayY, true);
        return img;
    }
}