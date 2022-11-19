package com.moasseo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class JoinLogin extends Activity {

    //인철 커밋용 주석

    ImageButton back;
    ImageView personal, customer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinlogin);

        back = findViewById(R.id.joinlogin_back);
        personal = findViewById(R.id.joinlogin_personal);
        customer = findViewById(R.id.joinlogin_customer);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinLogin.this, MainLogin.class);
                startActivity(intent);
            }
        });

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinLogin.this, MainJoinLogin1.class);
                startActivity(intent);
                //왜 튕김?
            }
        });
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //사업자 회원가입 페이지로 넘어가기
            }
        });

    }
}
