package com.moasseo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class Loading extends MainLogin {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (auto.getBoolean("auto", false)) {
                    Intent intent = new Intent(Loading.this, Main.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(Loading.this, MainIntroLogin.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                Intent intent = new Intent(Loading.this, MainIntroLogin.class); //화면 전환(로그인화면이 kakaotest임), MainIntro
//                overridePendingTransition(0, 0);
//                startActivity(intent);
//
//
//            }
//        }, 4000); //딜레이 타임 조절
    }
}
