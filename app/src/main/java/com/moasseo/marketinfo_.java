package com.moasseo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.bumptech.glide.Glide;

public class marketinfo_ extends Activity {

    ImageView market_mark, toilet_img, parking_img, facility_img, market_map;
    TextView market_name, market_address, market_url, market_call, toilet_text, parking_text, facility_text;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketinformation);

        market_mark = findViewById(R.id.imageView37);
        toilet_img = findViewById(R.id.imageView42);
        parking_img = findViewById(R.id.imageView43);
        facility_img = findViewById(R.id.imageView44);
        market_map = findViewById(R.id.imageView48);

        market_name = findViewById(R.id.info_name);
        market_address = findViewById(R.id.textView124);
        market_url = findViewById(R.id.textView126);
        market_call = findViewById(R.id.textView125);

        toilet_text = findViewById(R.id.textView129);
        parking_text = findViewById(R.id.textView130);
        facility_text = findViewById(R.id.textView131);

        back = findViewById(R.id.BackButton);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        String img = intent.getStringExtra("img");
        String home = intent.getStringExtra("home");
        String call = intent.getStringExtra("call");

        market_name.setText(name);
        market_address.setText(address);
        Glide.with(marketinfo_.this).load(img).into(market_mark);
        market_call.setText(call);
        market_url.setText(home);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
