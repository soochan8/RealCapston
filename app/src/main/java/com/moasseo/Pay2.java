package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Pay2 extends AppCompatActivity {

    String total;
    TextView totalpay;
    Button next12;  //확인 버튼

    String nnm; //닉네임을 저장할 변수

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay2);

        totalpay = findViewById(R.id.totalpay);  //금액 textview
        next12 = findViewById(R.id.next12);

        Intent intent = getIntent();
        nnm = intent.getStringExtra("nnm");//닉네임
        total = intent.getStringExtra("totalpay");

        totalpay.setText(total + "원");

        //취소 버튼
        next12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pay2.this, Main.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
            }
        });
    }
}
