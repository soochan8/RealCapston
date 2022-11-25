package com.moasseo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MainMap extends MainActivity{

    ConstraintLayout constraintLayout11;
    ConstraintLayout constraintLayout10;  //지역 선택
    ConstraintLayout pullLayout, pullLayout1;  //전체 화면
    ConstraintLayout constraintLayout9;  //젤 위
    ImageView imageView19;
    ImageButton back;
    ImageView home, map, mypage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        Intent intent1 = getIntent();
        String nnm = intent1.getStringExtra("nnm");

        constraintLayout11 = (ConstraintLayout) findViewById(R.id.constraintLayout11);  //가려진 레이아웃
        constraintLayout10 = (ConstraintLayout) findViewById(R.id.constraintLayout10);  //지역 선택
        pullLayout = (ConstraintLayout) findViewById(R.id.pullLayout);  //전체 화면
        pullLayout1 = (ConstraintLayout) findViewById(R.id.pullLayout1);  //전체 화면
        constraintLayout9 = (ConstraintLayout) findViewById(R.id.constraintLayout9); //젤 위
        imageView19 = (ImageView) findViewById(R.id.imageView19);  //지도
        back = findViewById(R.id.map_back);  //뒤로가기 버튼
        home = findViewById(R.id.map_home);
        map = findViewById(R.id.map_map);
        mypage = findViewById(R.id.map_my);

        constraintLayout11.bringToFront();  //레이아웃 앞으로 보내기

        constraintLayout10.setOnClickListener(new View.OnClickListener() {  //지역 선택
            @Override
            public void onClick(View v) {
                pullLayout1.setVisibility(View.GONE);
                back.setBackgroundColor(Color.parseColor("#4c000000"));
                pullLayout.setBackgroundColor(Color.parseColor("#4c000000"));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {  //뒤로가기 버튼
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
            }
        });

//        map.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MainMap.class);
//                intent.putExtra("nnm", nnm);
//                startActivity(intent);
//            }
//        }); 굳이 맵에서 맵으로 이동할 필요가 있나? 뭐 새로고침?

        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
            }
        });

    }
}
