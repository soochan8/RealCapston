package com.moasseo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.json.JSONObject;


public class test extends AppCompatActivity {

    ImageView test;
    public static String address_intent;
    public static String m_nm = "망원시장";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        test = findViewById(R.id.test_img);

        //그 이미지를 눌렀을 때, 어떻게 그 시장인지를 알것인가?
        //그럼 DB에 있는 시장 번호를 가지고 하면 됨
        //Ex) 어차피 스크롤뷰에 하나씩 번호대로 넣는다고 가정하면 몇 번 째 이미지를 눌렀을 때 어떤 시장의 정보를 가져올 것인가.


        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("test", "왜 안되냐고요 아저씨!!");
                //final String m_nm = et.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            Log.d("test", "try는 들어옴");
                            if (success) {
                                Log.d("test", "if까지도 들어옴");
                                String name = jsonObject.getString("m_nm");
                                String city = jsonObject.getString("m_si");
                                String gu = jsonObject.getString("m_gu");
                                String details = jsonObject.getString("m_dong");
                                String img = jsonObject.getString("m_url");
                                String home = jsonObject.getString("m_hom");
                                String call = jsonObject.getString("m_call");

                                address_intent = city + gu + details;

                                Intent intent = new Intent(test.this, marketinfo_.class);
                                intent.putExtra("name", name);
                                intent.putExtra("address", address_intent);
                                intent.putExtra("img", img);
                                intent.putExtra("home", home);
                                intent.putExtra("call", call);
                                startActivity(intent);

                                //try도 아에 안들어감

                            } else {
                                Toast.makeText(test.this, "실패", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                testRequest testRequest = new testRequest(m_nm, responseListener);
                RequestQueue queue = Volley.newRequestQueue(test.this);
                queue.add(testRequest);
            }
        });


    }
}
