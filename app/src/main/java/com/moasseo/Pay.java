package com.moasseo;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Pay extends AppCompatActivity {

    TextView num1, num2, num3, num4, num5, num6, num7, num8, num9, num00, num0;
    TextView totalpay;
    ImageButton numcancel;
    Button next;  //송금 버튼
    TextView cancel;  //취소
    StringBuffer sb = new StringBuffer();

    static String total=""; //송금 금액 저장

    String nnm;  //닉네임을 저장할 String변수

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay);

        totalpay = findViewById(R.id.totalpay);  //보낼 금액
        numcancel = findViewById(R.id.numcancel);
        next = findViewById(R.id.next12);  //송금 버튼

        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        num00 = findViewById(R.id.num00);
        num0 = findViewById(R.id.num0);
        cancel = findViewById(R.id.cancel);

        Intent intent = getIntent();
        nnm = intent.getStringExtra("nnm");//닉네임

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //취소 버튼 시 메인화면으로
                Intent intent = new Intent(Pay.this, Main.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
            }
        });


        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "1";
                totalpay.setText(total);
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "2";
                totalpay.setText(total);
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "3";
                totalpay.setText(total);
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "4";
                totalpay.setText(total);
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "5";
                totalpay.setText(total);
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "6";
                totalpay.setText(total);
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "7";
                totalpay.setText(total);
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "8";
                totalpay.setText(total);
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "9";
                totalpay.setText(total);
            }
        });

        num00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "00";
                totalpay.setText(total);
            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();

                total = total + "0";
                totalpay.setText(total);
            }
        });

        numcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = totalpay.getText().toString();
                totalpay.setText(total.substring(0, total.length() - 1).toString());

            }
        });


        totalpay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                next.setBackgroundResource(R.drawable.nextgraybutton);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                total = totalpay.getText().toString();
                if(total.length() > 0) {
                    Log.d("sadf", " >> " + total.length());
                    next.setTextColor(Color.parseColor("#FFFFFF"));
                    next.setBackgroundResource(R.drawable.nextcolorbutton);

                    //버튼이 활성화 되있을 시
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("value", ">>" + totalpay.getText().toString());

                            //pay2로 전달
                            Intent intent = new Intent(getApplicationContext(), Pay2.class);
                            //닉네임과 totalpay의 가격 전달
                            intent.putExtra("nnm", nnm);
                            intent.putExtra("totalpay", totalpay.getText().toString());
                            startActivity(intent);
                        }
                    });
                }
                else {
                    next.setTextColor(Color.parseColor("#bebebe"));
                    next.setBackgroundResource(R.drawable.nextgraybutton);
                }
            }
        });

    }
}