package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeInfomation extends MainMypage {

    ImageButton back;
    TextView name, nickname, email, pwd;
    TextView logout, user_drop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeinfomation);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String u_nm = intent.getStringExtra("u_nm");
        String nnm = intent.getStringExtra("nnm");
        String em = intent.getStringExtra("em");

        back = findViewById(R.id.BackButton);  //뒤로가기 버튼
        name = findViewById(R.id.changeInfomationTextview03);
        nickname = findViewById(R.id.changeInfomationTexview05);
        email = findViewById(R.id.changeInfomationTexview09);
        pwd = findViewById(R.id.changeInfomationTexview07);
        logout = findViewById(R.id.changeInfomationTexview10);
        user_drop = findViewById(R.id.changeInfomationTexview11);

        name.setText(u_nm);
        nickname.setText(nnm);
        email.setText(em);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, MainLogin.class);
                startActivity(intent);
                finish();
            }
        });

        user_drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, UserDrop.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });

        nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, Nickname_Change.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });
        pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, ChangePassword.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });

    }
}
