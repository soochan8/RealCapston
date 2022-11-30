package com.moasseo;

import android.content.Intent;
import android.graphics.Color;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator3;

public class market_list extends MainActivity {
    Button on, off;
    ImageButton back;
    ImageView home, map, mypage; //하단 네비게이션 바
    TextView[] tv = new TextView[9];
    ImageView[] img = new ImageView[9];
    boolean flag = false;
    ImageView point1 ,point2, point3;
    String mnm[] = {"망원시장", "통인시장", "광장시장", "영천시장", "연서시장","동대문시장","도깨비시장","수유시장","신원시장","용문전통시장"};

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_list);

        Intent intent1 = getIntent();
        String nnm = intent1.getStringExtra("nnm").toString();
        String id = intent1.getStringExtra("id").toString();

        on = findViewById(R.id.list_on);
        off = findViewById(R.id.list_off);
        back = findViewById(R.id.list_back);
        home = findViewById(R.id.list_home);
        map = findViewById(R.id.list_map);
        mypage = findViewById(R.id.list_my);

    for(int i=0; i<9; i++) {
        img[i] = findViewById(getResources().getIdentifier("list_img" + (i), "id", "com.moasseo"));
        tv[i] = findViewById(getResources().getIdentifier("list_tv" + (i), "id", "com.moasseo"));
    }

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

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            String [] arr = new String[jsonArray.length()];
                            for(int i =0;i<jsonArray.length();i++){
                                arr[i] = jsonArray.getString(i);
                                arr[i] = arr[i].substring(9,arr[i].length()-2);
                            }
                            //진짜 모르겠네 ㅋㅋ
                            img[0].setAlpha(0.3f);
                            img[1].setAlpha(0.3f);
                            img[3].setAlpha(0.3f);
                            img[6].setAlpha(0.3f);
                            img[8].setAlpha(0.3f);

                            tv[0].setAlpha(0.3f);
                            tv[1].setAlpha(0.3f);
                            tv[3].setAlpha(0.3f);
                            tv[6].setAlpha(0.3f);
                            tv[8].setAlpha(0.3f);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                phptestRequest phptestRequest = new phptestRequest(id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(market_list.this);
                queue.add(phptestRequest);
            }
        });



    }
}
