package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Personal_Change extends MainMypage{

    ImageButton back;
    TextView name, nickname, phone, email, pwd;
    TextView logout, user_drop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_change);

        //DB에서 가져온 값을 먼저 띄워야함

        back = (ImageButton) findViewById(R.id.change_back);
        name = (TextView) findViewById(R.id.name);
        nickname = (TextView) findViewById(R.id.nickname);
        phone = (TextView) findViewById(R.id.phone);
        email = (TextView) findViewById(R.id.email);
        pwd = (TextView) findViewById(R.id.change_pwd);
        logout = (TextView) findViewById(R.id.logout);
        user_drop = (TextView) findViewById(R.id.user_drop);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Personal_Change.this, MainLogin.class);
                startActivity(intent);
                finish();
            }
        });
        
        user_drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Personal_Change.this, UserDrop.class);
                //이름 휴대폰 총 보유 포인트 넘겨주기
                startActivity(intent);
                finish();
            }
        });


    }
}
