package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator3;

public class market_list extends MainActivity {
    Button button1;
    ImageButton BackButton;
    ImageView home, map, mypage; //하단 네비게이션 바

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_list);

        //Intent intent1 = getIntent();
        //String nnm = intent1.getStringExtra("nnm").toString();

        BackButton = findViewById(R.id.BackButton); // 뒤로가기 버튼
        home = (ImageView) findViewById(R.id.setting_home);  //홈
        map = (ImageView) findViewById(R.id.setting_map);  //지도
        mypage = (ImageView) findViewById(R.id.mypage_my);  //마이페이지

        /*BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("abc", "백버튼");
                Intent intent = new Intent(market_list.this, MainMypage.class);
                intent.putExtra("nnm", nnm);  //닉네임을 같이 넘김
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //홈으로 넘어가기
                Intent intent = new Intent(market_list.this, Main.class);  //메인 화면으로 이동
                //intent.putExtra("nnm", nnm);
                startActivity(intent);
                overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //지도로 넘어가기
                Intent intent = new Intent(market_list.this, KakaoMap.class);  //지도 화면으로 이동
                startActivity(intent);
                overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
            }
        });
        //하단 네비게이션 바의 내 정보를 누르면 새로고침
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //새로고침
                Intent intent = new Intent(market_list.this, MainMypage.class);  //새로고침
                //intent.putExtra("nnm", nnm);
                startActivity(intent);
                overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
            }
        });*/
    }
}
