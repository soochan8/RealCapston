package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainEvent extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);

        ImageView event1 = (ImageView) findViewById(R.id.event_banner1);
        ImageView event2 = (ImageView) findViewById(R.id.event_banner2);
        ImageView event3 = (ImageView) findViewById(R.id.event_banner3);

        ImageButton back = (ImageButton) findViewById(R.id.event_back);
        back.setOnClickListener(v -> {
            finish();
        });

        event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("event1", "event1");
                Intent intent = new Intent(MainEvent.this, Event_Sub1.class);
                startActivity(intent);
            }
        });

        event2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainEvent.this, Event_Sub2.class);
                startActivity(intent);
            }
        });

        event3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainEvent.this, Event_Sub3.class);
                startActivity(intent);
            }
        });


    }
}
