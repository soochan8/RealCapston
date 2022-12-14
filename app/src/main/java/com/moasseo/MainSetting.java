package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainSetting extends MainActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        ImageButton btn_back = (ImageButton) findViewById(R.id.setting_back);
        ImageView home = findViewById(R.id.map_home);
        ImageView map = findViewById(R.id.map_map);
        ImageView mypage = findViewById(R.id.setting_my);

        Intent intent1 = getIntent();
        String nnm = intent1.getStringExtra("nnm").toString();

        btn_back.setOnClickListener(v -> {
            finish();
        });

        home.setOnClickListener(v -> {
            Intent intent = new Intent(MainSetting.this, Main.class);
            intent.putExtra("nnm", nnm);
            startActivity(intent);
        });
        map.setOnClickListener(v -> {
            Intent intent = new Intent(MainSetting.this, KakaoMap.class);
            intent.putExtra("nnm", nnm);
            startActivity(intent);
        });
        mypage.setOnClickListener(v -> {
            Intent intent = new Intent(MainSetting.this, MainMypage.class);
            intent.putExtra("nnm", nnm);
            startActivity(intent);
        });

    }
}