package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MainMypagePoint2 extends MainActivity {

    TextView barcode, barcode1;  //바코드
    TextView usemoney, usemoney1; //사용금액
    ConstraintLayout barcodeLayout, usemoneyLayout;  //바코드 화면, 사용내역 화면
    ImageButton BackButton;

    Intent intent = getIntent();
    String nnm = intent.getStringExtra("nnm").toString();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_point_2);

        barcode = (TextView) findViewById(R.id.textView80);  //바코드 Text
        barcode1 = (TextView) findViewById(R.id.textView86);  //바코드 Text

        usemoney = (TextView) findViewById(R.id.textView81);  //사용내역 Text
        usemoney1 = (TextView) findViewById(R.id.textView87);  //사용내역 Text

        barcodeLayout = (ConstraintLayout) findViewById(R.id.barcodeLayout);  //바코드 화면
        usemoneyLayout = (ConstraintLayout) findViewById(R.id.usemoneyLayout);  //사용내역 화면

        BackButton = findViewById(R.id.BackButton);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("abc", "백버튼");
                Intent intent = new Intent(MainMypagePoint2.this, MainMypagePoint.class);
                intent.putExtra("nnm", nnm);  //닉네임을 같이 넘김
                startActivity(intent);
            }
        });


        barcode.setOnClickListener(new View.OnClickListener() {  //바코드 클릭 시
            @Override
            public void onClick(View v) {
                barcodeLayout.setVisibility(View.VISIBLE);  //바코드 화면 나오기
                usemoneyLayout.setVisibility(View.GONE);  //사용 내역 가리기
                //Toast.makeText(getApplicationContext(), "바코드 클릭", Toast.LENGTH_LONG).show();
            }
        });

        barcode1.setOnClickListener(new View.OnClickListener() {  //바코드 클릭 시
            @Override
            public void onClick(View v) {
                barcodeLayout.setVisibility(View.VISIBLE);  //바코드 화면 나오기
                usemoneyLayout.setVisibility(View.GONE);  //사용 내역 가리기
                //Toast.makeText(getApplicationContext(), "바코드 클릭", Toast.LENGTH_LONG).show();
            }
        });


        usemoney.setOnClickListener(new View.OnClickListener() {  //사용내역 클릭 시
            @Override
            public void onClick(View v) {
                barcodeLayout.setVisibility(View.GONE);  //바코드 화면 가리기
                usemoneyLayout.setVisibility(View.VISIBLE);  //사용 내역 화면 나오기
            }
        });

        usemoney1.setOnClickListener(new View.OnClickListener() {  //사용내역 클릭 시
            @Override
            public void onClick(View v) {
                barcodeLayout.setVisibility(View.GONE);  //바코드 화면 가리기
                usemoneyLayout.setVisibility(View.VISIBLE);  //사용 내역 화면 나오기
            }
        });
    }
}
