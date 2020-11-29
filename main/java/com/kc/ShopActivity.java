package com.kc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kc.util.Stats;

public class ShopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        final Button back = findViewById(R.id.back_to_main);

        ImageView shop_icon1 = findViewById(R.id.icon1);
        ImageView shop_icon2 = findViewById(R.id.icon2);
        ImageView shop_icon3 = findViewById(R.id.icon3);

        update_data();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        shop_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Stats.COOKIES>Stats.PRICE_WELLHOlZ) {
                    Stats.COOKIES -= Stats.PRICE_WELLHOlZ;
                    Stats.LEVEL_WELLHOLZ++;
                    Stats.COOKIES_PLUS += 1;
                    Stats.PRICE_WELLHOlZ = (int) (Stats.PRICE_WELLHOlZ*1.15);
                }
                update_data();
            }
        });

        shop_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Stats.COOKIES>Stats.PRICE_BACKMISCHUNG) {
                    Stats.COOKIES -= Stats.PRICE_BACKMISCHUNG;
                    Stats.LEVEL_BACKMISCHUNG++;
                    Stats.COOKIES_PLUS += 3;
                    Stats.PRICE_BACKMISCHUNG = (int) (Stats.PRICE_BACKMISCHUNG*1.15);
                }
                update_data();
            }
        });

    }

    private void update_data() {
        TextView shopinfo1 = findViewById(R.id.shopinfo1);
        TextView shopinfo2 = findViewById(R.id.shopinfo2);
        TextView shopinfo3 = findViewById(R.id.shopinfo3);
        TextView price1 = findViewById(R.id.price1);
        TextView price2 = findViewById(R.id.price2);
        TextView price3 = findViewById(R.id.price3);

        shopinfo1.setText("Wellholz, +1 Keks/Click\nLevel "+Stats.LEVEL_WELLHOLZ);
        shopinfo2.setText("Backmischung, +3 Keks/Click\nLevel "+Stats.LEVEL_BACKMISCHUNG);

        price1.setText(Stats.PRICE_WELLHOlZ + " K");
        price2.setText(Stats.PRICE_BACKMISCHUNG + " K");
    }
}
