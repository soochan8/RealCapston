/*
package com.moasseo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ChangeInfomation extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeinfomation);
    }
}
*/
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
        name = findViewById(R.id.changeInfomationTextview03);  //이름
        nickname = findViewById(R.id.changeInfomationTexview05);  //닉네임
        email = findViewById(R.id.changeInfomationTexview09);  //이메일
        pwd = findViewById(R.id.changeInfomationTexview07);  //비밀번호
        logout = findViewById(R.id.changeInfomationTexview10);  //로그아웃
        user_drop = findViewById(R.id.changeInfomationTexview11);  //회원탈퇴

        name.setText(u_nm);
        nickname.setText(nnm);
        email.setText(em);

        back.setOnClickListener(new View.OnClickListener() {  //뒤로가기 클릭
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {  //로그아웃 클릭
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, MainLogin.class);
                startActivity(intent);
                finish();
            }
        });

        user_drop.setOnClickListener(new View.OnClickListener() {  //회원탈퇴 클릭
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, UserDrop.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });

        nickname.setOnClickListener(new View.OnClickListener() { //닉네임 클릭
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, Nickname_Change.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });
        pwd.setOnClickListener(new View.OnClickListener() {  //비밀번호 클릭
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeInfomation.this, ChangePassword.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });
        //낄

    }
}