package com.moasseo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    ImageButton btn_back;
    CheckBox check;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdrop);

        btn_drop = findViewById(R.id.user_drop_btn);
        btn_back = findViewById(R.id.drop_back);
        check = findViewById(R.id.drop_check);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        btn_drop.setEnabled(false);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check.isChecked()){
                    btn_drop.setEnabled(true);
                    btn_drop.setBackgroundResource(R.drawable.nextcolorbutton);
                    btn_drop.setTextColor(getResources().getColor(R.color.white));
                }else{
                    btn_drop.setEnabled(false);
                    btn_drop.setBackgroundResource(R.drawable.nextgraybutton);
                    btn_drop.setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        //체크 박스 눌렀을 때, 활성화가 되게 바뀌어야 함.
        //이미 박스가 좀 흐리니까 체크 박스 눌렀을 때, 선명하게 바뀌어야 함.
        //이름 휴대폰 총 보유 포인트 넘겨받아야함


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //이건 테스트용 아이디임
        //이름, 휴대폰, 총 보유 포인트를 가져올 방법을 생각해야함
        //메인에서 회원탈퇴 눌렀을 때, 인텐트로 가져오는 방법도 있고 뭐 다른 방법도 있을 것임.



        btn_drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("test", "try는 들어옴");
                            //삭제되었을 때 삭제되었다고 다이얼로그 같은거 뜨면 좋을 듯 함.
                            //그리고 거기서 확인 누르면 바로 로그아웃되고 로딩으로 넘어가는 거임.
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
