package com.moasseo;

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
                                //개인정보 변경으로 이동
                            } else {
                                //비밀번호가 일치하지 않는다는 다이얼로그 띄우기
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
