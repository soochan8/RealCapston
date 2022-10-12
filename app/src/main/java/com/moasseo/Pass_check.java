package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Pass_check extends MainMypage{

    ImageButton back;
    ImageView eye;
    EditText pass;
    Button check;
    TextView find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pass_check);

        back = (ImageButton) findViewById(R.id.pass_check_back);
        eye = (ImageView) findViewById(R.id.pass_check_eye);
        pass = (EditText) findViewById(R.id.pass_check_edit);
        check = (Button) findViewById(R.id.pass_check_login);
        find = (TextView) findViewById(R.id.pass_check_find);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //비밀번호 찾기

            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pwd = pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            Log.d("test", "try는 들어옴");
                            if (success) {
                                Log.d("test", "success는 들어옴");
                                //여기서 개인정보를 가지고 개인정보 변경 페이지로 넘어가는거임
                                String id = jsonObject.getString("id");  //아이디
                                String u_nm = jsonObject.getString("u_nm");  //이름
                                String nnm = jsonObject.getString("nnm");  //닉네임
                                String em = jsonObject.getString("em");  //이메일


                                Intent intent = new Intent(Pass_check.this, ChangeInfomation.class);
                                intent.putExtra("id", id);
                                intent.putExtra("u_nm", u_nm);
                                intent.putExtra("nnm", nnm);
                                intent.putExtra("em", em);
                                startActivity(intent);
                                finish();
                            } else {
                                //비밀번호가 일치하지 않는다는 다이얼로그 띄우기
                                Log.d("test", "실패");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                Pass_checkRequest pass_checkRequest = new Pass_checkRequest(pwd, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Pass_check.this);
                queue.add(pass_checkRequest);
            }
        });

    }
}
