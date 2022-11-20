package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MainMypagePoint extends MainActivity {

    ImageButton point_back;
    ImageView home, map, mypage;

    Intent intent = getIntent();
    String nnm = intent.getStringExtra("nnm").toString();

    //아니 ㅅㅂ 버튼 하나 추가했다고 왜 창이 튕김? 개빡치네
    protected void onCreate(Bundle savedInstanceState) {

        //ImageButton back = (ImageButton) findViewById(R.id.point_back);

        ConstraintLayout marketLayout;  //시장이 들어있는 레이아웃
        ConstraintLayout mangwon_market;  //망원시장
        ConstraintLayout tongin_market;  //통인시장

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_point);

        marketLayout = (ConstraintLayout) findViewById(R.id.marketLayout);  //시장이 들어있는 레이아웃
        mangwon_market = (ConstraintLayout) findViewById(R.id.constraintLayout14);  //망원 시장
        tongin_market = (ConstraintLayout) findViewById(R.id.constraintLayout15);  //통인 시장
        point_back = findViewById(R.id.point_back);
        home = findViewById(R.id.bottom_home);
        map = findViewById(R.id.bottom_map);
        mypage = findViewById(R.id.bottom_my);

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