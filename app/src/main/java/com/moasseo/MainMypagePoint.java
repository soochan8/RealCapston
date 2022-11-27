package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MainMypagePoint extends MainActivity {

    ImageButton point_back;
    ImageView home, map, mypage;

    protected void onCreate(Bundle savedInstanceState) {

        //ImageButton back = (ImageButton) findViewById(R.id.point_back);

        ConstraintLayout marketLayout;  //시장이 들어있는 레이아웃
        ConstraintLayout mangwon_market;  //망원시장
        ConstraintLayout tongin_market;  //통인시장
        ConstraintLayout kwangjang_market;  //광장시장

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_point);

        marketLayout = (ConstraintLayout) findViewById(R.id.marketLayout);  //시장이 들어있는 레이아웃
        mangwon_market = (ConstraintLayout) findViewById(R.id.constraintLayout14);  //망원 시장
        tongin_market = (ConstraintLayout) findViewById(R.id.constraintLayout15);  //통인 시장
        kwangjang_market = (ConstraintLayout) findViewById(R.id.constraintLayout100);  //광장 시장
        point_back = findViewById(R.id.point_back);
        home = findViewById(R.id.bottom_home);
        map = findViewById(R.id.bottom_map);
        mypage = findViewById(R.id.bottom_my);

        Intent intent1 = getIntent();
        String nnm = intent1.getStringExtra("nnm");
        String intent_result = intent1.getStringExtra("intent_result");

        point_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMypagePoint.this, MainMypage.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
            }
        });

        mangwon_market.setOnClickListener(new View.OnClickListener() {  //망원시장 클릭 시
            @Override
            public void onClick(View v) {
                //망원시장 바코드 및 사용 내역으로 이동
                Intent intent = new Intent(MainMypagePoint.this, MainMypagePoint1.class);
                intent.putExtra("nnm", nnm);
                String intent_result = "point";
                intent.putExtra("intent_result", intent_result);
                startActivity(intent);
            }
        });
        tongin_market.setOnClickListener(new View.OnClickListener() {  //통인시장 클릭 시
            @Override
            public void onClick(View v) {
                //통인시장 바코드 및 사용 내역으로 이동
                Intent intent = new Intent(MainMypagePoint.this, MainMypagePoint2.class);
                intent.putExtra("nnm", nnm);
                String intent_result = "point";
                intent.putExtra("intent_result", intent_result);
                startActivity(intent);
            }
        });
        kwangjang_market.setOnClickListener(new View.OnClickListener() {  //광장시장 클릭 시
            @Override
            public void onClick(View v) {
                //광장시장 바코드 및 사용 내역으로 이동
                Intent intent = new Intent(MainMypagePoint.this, MainMypagePoint3.class);
                intent.putExtra("nnm", nnm);
                String intent_result = "point";
                intent.putExtra("intent_result", intent_result);
                startActivity(intent);
            }
        });
        //나머지도 추가해야됨
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMypagePoint.this, Main.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMypagePoint.this, KakaoMap.class);
                startActivity(intent);
            }
        });
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMypagePoint.this, MainMypage.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
            }
        });

    }
}