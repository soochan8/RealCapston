package com.moasseo;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class test123 extends Activity {
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.fcm_test);

        Button button = (Button) findViewById(R.id.fcm_btn);
        TextView textView = (TextView) findViewById(R.id.fcm_tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FCMessage fcMessage = new FCMessage();
                FirebaseMessaging.getInstance().getToken()
                        .addOnCompleteListener(new OnCompleteListener<String>() {
                            @Override
                            public void onComplete(@NonNull Task<String> task) {
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "Fetching FCM registration token failed", task.getException());

                                    return;
                                }

                                // Get new FCM registration token
                                String token = task.getResult();
                                Toast.makeText(test123.this, token, Toast.LENGTH_SHORT).show();
                                Log.d("FCM", token);
                                textView.setText(token);
                            }
                        });
            }
        });
    }
}
