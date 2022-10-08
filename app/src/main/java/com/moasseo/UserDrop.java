package com.moasseo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

public class UserDrop extends Activity {

    Button check;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdrop);

        check = findViewById(R.id.user_drop_btn);

        //check.setEnabled(false);
        //체크 박스 눌렀을 때, 활성화가 되게 바뀌어야 함.
        //이미 박스가 좀 흐리니까 체크 박스 눌렀을 때, 선명하게 바뀌어야 함.
        //이름 휴대폰 총 보유 포인트 넘겨받아야함


        final String id = "test";
        //이건 테스트용 아이디임
        //이름, 휴대폰, 총 보유 포인트를 가져올 방법을 생각해야함
        //메인에서 회원탈퇴 눌렀을 때, 인텐트로 가져오는 방법도 있고 뭐 다른 방법도 있을 것임.



        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            //굳이 필요한건가?!
                            Log.d("test", "try는 들어옴");
                            if (success) {
                                Log.d("test", "성공함");
                                //삭제되었을 때 삭제되었다고 다이얼로그 같은거 뜨면 좋을 듯 함.
                                //그리고 거기서 확인 누르면 바로 로그아웃되고 로딩으로 넘어가는 거임.
                            } else {
                                Log.d("test", "실패함");
                            }
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
