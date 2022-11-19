package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAlarm extends Main {

    ImageButton BackButton;
    TextView textView102;  //닉네임 받아올 텍스트
    ImageView imageView24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_alarm);


        BackButton = findViewById(R.id.BackButton);

        Intent intent = getIntent();
        String nnm = intent.getStringExtra("nnm");  //닉네임

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainAlarm.this, Main.class);
                intent.putExtra("nnm", nnm);
                startActivity(intent);
            }
        });

        textView102 = (TextView) findViewById(R.id.textView102);  //닉네임 받아올 텍스트
        imageView24 = (ImageView) findViewById(R.id.imageView24);





        textView102.setText(nnm + "님, 1천원 쿠폰 받으세요.");

        /*imageView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAlarm.this, Main.class);
                startActivity(intent);
            }
        });*/

    }
}