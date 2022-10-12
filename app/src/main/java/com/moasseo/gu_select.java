package com.moasseo;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class gu_select extends Activity
{
    TextView textView;
    Spinner spinner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        textView = findViewById(R.id.seoul_gu);
        spinner = findViewById(R.id.gu_spinner);

        ArrayAdapter locAdapter = ArrayAdapter.createFromResource(this, R.array.gu, android.R.layout.simple_dropdown_item_1line);

        locAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(locAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String gu = spinner.getSelectedItem().toString();
                textView.setText("서울특별시 " + gu);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("");
            }
        });


    }
}
