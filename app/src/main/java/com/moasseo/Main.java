package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

public class Main extends MainActivity {    //MainActivity

    private DrawerLayout drawerLayout;
    NavigationView navigationView;
    static String abc;
    String grade_img;

    ImageView close;  //side_header 닫기 버튼 이미지
    ImageView imageAlarm;  //상단 우측 알람 이미지
    ImageView Qrcode;  //Qr코드 스캔
    Button button9;  //Qr코드 스캔
    ImageView home, map, mypage; //하단 네비게이션 이미지

    private IntentIntegrator qrScan;

    String nnm;

    //--------------------
    //ViewPager 변수
    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 3;
    private CircleIndicator3 mIndicator;

    //Recycler 변수
    private RecyclerView mRecyclerView;
    private ArrayList<RecyclerViewItem> mList;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        //navigationView.setItemIconTintList(null);

        close = (ImageView) findViewById(R.id.side_back);  //side_header 닫기 버튼 이미지
        imageAlarm = (ImageView) findViewById(R.id.event_banner1); //상단 우측 알람 이미지
        Qrcode = (ImageView) findViewById(R.id.imageView37);  //Qr코드 스캔

        qrScan = new IntentIntegrator(this);

        //하단 네비게이션 이미지
        home = (ImageView) findViewById(R.id.bottom_home);
        map = (ImageView) findViewById(R.id.bottom_map);
        mypage = (ImageView) findViewById(R.id.bottom_my);

        //MainLogin에서 넘긴 NickName값
        Intent intent = getIntent();
        nnm = intent.getStringExtra("nnm");//닉네임

        //메뉴바를 클릭하면...
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //하단 뒤로가기 버튼 누를 시 드로어 레이아웃 닫히게 구현할 것.


        // Qr 버튼 클릭시 카메라 켜기
        Qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //scan option
                qrScan.setPrompt("Scanning...");
                //qrScan.setOrientationLocked(false);
                qrScan.initiateScan();

            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, KakaoMap.class);
                startActivity(intent);
            }
        });

        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, MainMypage.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
            }
        });

        //메뉴바 목록 클릭 시
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.information:  //내 정보
                        Intent intent1 = new Intent(Main.this, MainMypage.class);
                        intent1.putExtra("nnm", nnm);
                        startActivity(intent1);
                        break;
                    case R.id.event:  //이벤트
                        Intent intent2 = new Intent(Main.this, MainEvent.class);
                        startActivity(intent2);
                        break;
                    case R.id.map:  //지도
                        Intent intent3 = new Intent(Main.this, KakaoMap.class);
                        startActivity(intent3);
                        break;
                    case R.id.setting:  //설정
                        Intent intent4 = new Intent(Main.this, MainSetting.class);
                        intent4.putExtra("nnm", nnm);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });

        //xml 파일에서 넣어놨던 header 선언
        View header = navigationView.getHeaderView(0);

        //side_header 닫기 버튼 이미지
        close = (ImageView) header.findViewById(R.id.side_back);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        //header에 있는 리소스 가져오기
        //로그인 시 아이디, 비밀번호에 닉네임 출력
        TextView text = (TextView) header.findViewById(R.id.tv_name);
        text.setText(nnm);  //사이드바 닉네임 표시

        imageAlarm.setOnClickListener(new View.OnClickListener() {  //알림
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, MainAlarm.class); //메인 > 알람 화면으로 이동
                intent.putExtra("nnm", nnm);  //닉네임을 같이 넘김
                startActivity(intent);
            }
        });

        //-------------------------------------------------------
        //Recycler List item 생성
        mList = new ArrayList<RecyclerViewItem>();
        mList.add(new RecyclerViewItem(R.drawable.mangwon));
        mList.add(new RecyclerViewItem(R.drawable.tongin));
        mList.add(new RecyclerViewItem(R.drawable.market_location3));

        //Recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //Recycler Adapter 추가
        mRecyclerViewAdapter = new RecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        //Recycler Layout manager 추가
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        //ViewPager2
        mPager = findViewById(R.id.viewpager1);

        pagerAdapter = new MyAdapter(this, num_page);
        mPager.setAdapter(pagerAdapter);
        //Indicator
        mIndicator = findViewById(R.id.indicator1);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(num_page, 0);
        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        mPager.setCurrentItem(1000); //시작 지점
        mPager.setOffscreenPageLimit(4); //최대 이미지 수

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position % num_page);
            }
        });


        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main.this, "눌렀음", Toast.LENGTH_LONG).show();
            }
        });
    }

    //Getting the scan resultsㅁㄴㅇ
    //qr스캔
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //qrcode 가 없으면
            if (result.getContents() == null) {
                Toast.makeText(this, "취소!", Toast.LENGTH_SHORT).show();
            } else {
                //qrcode 결과가 있으면
                Toast.makeText(this, "스캔완료!", Toast.LENGTH_SHORT).show();
                try {
                    //data를 json으로 변환
                    JSONObject obj = new JSONObject(result.getContents());

                    Intent intent3 = new Intent(Main.this, Pay.class);
                    intent3.putExtra("onm", obj.getString("name"));
                    intent3.putExtra("mnm", obj.getString("market"));
                    startActivity(intent3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
