package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainIntroLogin extends MainActivity{

    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intrologin);

        LoginButton = (Button)findViewById(R.id.LoginButton);

        /*Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainIntroLogin.this, MainLogin.class); //화면 전환
                startActivity(intent);

            }
        }, 4000); //딜레이 타임 조절*/

        LoginButton.setOnClickListener(new View.OnClickListener() {  //모아써 로그인 버튼 클릭
            public void onClick(View v) {
                Intent intent = new Intent(MainIntroLogin.this, MainLogin.class);
                startActivity(intent);
            }
        });
    }
}
