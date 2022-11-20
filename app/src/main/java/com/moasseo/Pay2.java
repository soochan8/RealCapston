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

    String nnm, mnm, onm; //닉네임을 저장할 변수

    TextView t1, t2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay2);

        totalpay = findViewById(R.id.totalpay);  //금액 textview
        next12 = findViewById(R.id.next12);

        Intent intent = getIntent();
        mnm = intent.getStringExtra("mnm");//시장명
        onm = intent.getStringExtra("onm");//사장명
        nnm = intent.getStringExtra("nnm");//닉네임
        total = intent.getStringExtra("totalpay");

        t1 = (TextView) findViewById(R.id.textView82);
        t1.setText(mnm);  //시장명 표시

        t2 = (TextView) findViewById(R.id.textView110);
        t2.setText(onm + "에게");  //시장명 표시

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
