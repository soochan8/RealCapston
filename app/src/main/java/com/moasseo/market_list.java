package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class market_list extends MainActivity {
    Button on, off;
    ImageButton back;
    ImageView home, map, mypage; //하단 네비게이션 바

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_list);

        Intent intent1 = getIntent();
        String nnm = intent1.getStringExtra("nnm").toString();

        on = findViewById(R.id.list_on);
        off = findViewById(R.id.list_off);
        back = findViewById(R.id.list_back);
        home = findViewById(R.id.list_home);
        map = findViewById(R.id.list_map);
        mypage = findViewById(R.id.list_my);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
                finish();
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KakaoMap.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
                finish();
            }
        });

        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
                finish();
            }
        });


    }
}
