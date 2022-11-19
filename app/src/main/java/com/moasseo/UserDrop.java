package com.moasseo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

public class UserDrop extends Activity {

    Button btn_drop;
    ImageButton btn_back, check;
    static boolean Dropflag = true;  //회원 탈퇴 체크, 미체크 할 때 사용

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdrop);

        btn_drop = findViewById(R.id.user_drop_btn);
        btn_back = findViewById(R.id.drop_back);
        check = findViewById(R.id.drop_check);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");


        //체크 박스 눌렀을 때, 활성화가 되게 바뀌어야 함.
        //이미 박스가 좀 흐리니까 체크 박스 눌렀을 때, 선명하게 바뀌어야 함.
        //이름 휴대폰 총 보유 포인트 넘겨받아야함
//

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //이건 테스트용 아이디임
        //이름, 휴대폰, 총 보유 포인트를 가져올 방법을 생각해야함
        //메인에서 회원탈퇴 눌렀을 때, 인텐트로 가져오는 방법도 있고 뭐 다른 방법도 있을 것임.

        check.setOnClickListener(new View.OnClickListener() {  //체크버튼 클릭 시
            @Override
            public void onClick(View view) {
                if (Dropflag == true) {  //회원탈퇴 체크버튼 클릭 시
                    check.setImageResource(R.drawable.check_colro_circle);
                    Dropflag = false;
                    btn_drop.setEnabled(true);
                    btn_drop.setBackgroundResource(R.drawable.nextcolorbutton);  //하단 탈퇴버튼 활성화
                    btn_drop.setTextColor(Color.parseColor("#FFFFFF"));  //하단 다음버튼 글씨 흰색으로 변경
                } else {
                    check.setImageResource(R.drawable.check_circle);
                    Dropflag = true;
                    btn_drop.setEnabled(false);
                    btn_drop.setBackgroundResource(R.drawable.nextgraybutton);  //하단 탈퇴버튼 비활성화
                    btn_drop.setTextColor(Color.parseColor("#bebebe"));
                }
            }
        });


        btn_drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("test1","ad >> " + Dropflag);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                                Intent intent = new Intent(UserDrop.this, kakaotest.class);  //로그인 선택 창으로 보냄
                                startActivity(intent);


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                UserDropRequest userDropRequest = new UserDropRequest(id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UserDrop.this);
                queue.add(userDropRequest);
            }
        });

    }
}
