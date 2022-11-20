package com.moasseo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class Event_Sub2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_sub2);

        ImageButton back = (ImageButton) findViewById(R.id.event_sub2_back);

        back.setOnClickListener(v -> {
            finish();
        });


    }
}
