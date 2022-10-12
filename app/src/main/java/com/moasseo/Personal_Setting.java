package com.moasseo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;

public class Personal_Setting extends MainMypage {

    ImageButton back;
    Switch auto, gps, push, alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        back = (ImageButton) findViewById(R.id.BackButton);
        auto = (Switch) findViewById(R.id.switch1);
        gps = (Switch) findViewById(R.id.switch2);
        push = (Switch) findViewById(R.id.switch3);
        alarm = (Switch) findViewById(R.id.switch4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (auto.isChecked()) {
                    //자동로그인
                } else {
                    //자동로그인 해제
                }
            }
        });

        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gps.isChecked()) {
                    //gps
                } else {
                    //gps 해제
                }
            }
        });
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (push.isChecked()) {
                    //푸시
                } else {
                    //푸시 해제
                }
            }
        });
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alarm.isChecked()) {
                    //알람
                } else {
                    //알람 해제
                }
            }
        });


    }
}
