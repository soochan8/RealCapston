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
    ConstraintLayout list_1, list_2, list_3;
    String mnm[] = {"망원시장", "통인시장", "광장시장", "영천시장", "연서시장","동대문종합시장","방학동도깨비시장","수유재래시장","신원시장","용문전통시장"};
    boolean flag = false;
    ImageView point1 ,point2, point3;


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

        list_1 = findViewById(R.id.list_1);
        list_2 = findViewById(R.id.list_2);
        list_3 = findViewById(R.id.list_3);

        point1 = findViewById(R.id.imageView21);  //망원시장
        point2 = findViewById(R.id.imageView22);  //통인
        //point3 = findViewById(R.id.imageView21);  //광장시장



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
                            Log.d("sdad", " sdfsdf ");
                            JSONArray jsonArray = new JSONArray(response);
                            String [] arr = new String[jsonArray.length()];
                            for(int i =0;i<jsonArray.length();i++){
                                arr[i] = jsonArray.getString(i);
                                //jsonArray.getString(i)의 값은 {"m_nm":"통인시장"}이런식으로 나오는데,
                                //이걸 {"통인시장"} 이런식으로 나오게 변경
                                arr[i] = arr[i].substring(9,arr[i].length()-2);
                                 if(mnm[i].equals(arr[i])) {
                                     //point1이 흐리게 보이게 설정

                                    //point1.setBackgroundColor(Color.parseColor("#000000"));
                                    //point2.setBackgroundColor(Color.parseColor("#000000"));
                                }
                                else {
                                    Log.d("sdad", " false>> " + arr[i]);

                                }
                            }
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
