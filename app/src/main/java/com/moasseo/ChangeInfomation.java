package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        String id = intent.getStringExtra("id");  //아이디
        String u_nm = intent.getStringExtra("u_nm");  //이름
        String nnm = intent.getStringExtra("nnm");  //닉네임
        String em = intent.getStringExtra("em");  //이메일

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

        back.setOnClickListener(new View.OnClickListener() {  //뒤로가기 버튼 클릭시 마이페이지로 이동
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, MainMypage.class);
                intent.putExtra("nnm", nnm);  //닉네임을 같이 보냄 (메인_서브메뉴에서 닉네임을 보여주기 위해)
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {  //로그아웃
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, MainLogin.class);
                startActivity(intent);
                finish();
            }
        });

        user_drop.setOnClickListener(new View.OnClickListener() {  //회원탈퇴
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, UserDrop.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        nickname.setOnClickListener(new View.OnClickListener() {  //닉네임
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, Nickname_Change.class);
                intent.putExtra("id", id);
                intent.putExtra("u_nm", u_nm);  //이름
                intent.putExtra("nnm", nnm);  //닉네임
                intent.putExtra("em", em);  //이메일
                startActivity(intent);
            }
        });
        pwd.setOnClickListener(new View.OnClickListener() {  //비밀번호
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, ChangePassword.class);
                intent.putExtra("id", id);
                intent.putExtra("u_nm", u_nm);  //이름
                intent.putExtra("nnm", nnm);  //닉네임
                intent.putExtra("em", em);  //이메일
                startActivity(intent);
                finish();
            }
        });
        //낄

    }
}
