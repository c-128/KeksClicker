package com.kc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kc.util.Stats;

public class ShopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Button back = findViewById(R.id.back_to_main);
        Button more_cookies = findViewById(R.id.buy1);

        TextView more_cookies_price = findViewById(R.id.price1);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });

        more_cookies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price = (int) (Stats.MORE_COOKIES_PRICE * 2);
                Stats.MORE_COOKIES_PRICE++;
                Stats.COOKIES = Stats.COOKIES - price;
                more_cookies_price.setText(String.valueOf(Stats.MORE_COOKIES_PRICE));
            }
        });
    }
}
