package com.moasseo;

import android.os.Bundle;
import android.widget.ImageButton;

public class MainSetting extends MainActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        ImageButton btn_back = (ImageButton) findViewById(R.id.setting_back);

        btn_back.setOnClickListener(v -> {
            finish();
        });

    }
}
