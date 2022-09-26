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

    Button btn;
    EditText et;
    TextView tv1, tv2, tv3, tv4, tv5;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        btn = findViewById(R.id.btn1);
        et = findViewById(R.id.edt1);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        img1 = findViewById(R.id.img1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String m_nm = et.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            Log.d("test", "try는 들어옴");
                            if (success) {
                                Log.d("test", "if까지도 들어옴");
                                String num = jsonObject.getString("m_n");
                                String name = jsonObject.getString("m_nm");
                                String city = jsonObject.getString("m_si");
                                String gu = jsonObject.getString("m_gu");
                                String details = jsonObject.getString("m_dong");
                                String img = jsonObject.getString("m_url");

                                tv1.setText(num);
                                tv2.setText(name);
                                tv3.setText(city);
                                tv4.setText(gu);
                                tv5.setText(details);
                                Glide.with(test.this).load(img).into(img1);

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
