package com.moasseo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class Event_Sub1 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_sub1);

        ImageButton back = (ImageButton) findViewById(R.id.event_sub1_back);

        back.setOnClickListener(v -> {
            finish();
        });


    }
}
