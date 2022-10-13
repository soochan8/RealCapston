package com.moasseo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Nickname_Change extends Activity {

    ImageButton back;
    EditText nick;
    Button submit;
    TextView error;

    private String NickNameValidation = "^[가-힣]{2,11}";  //닉네임 정규식
    public static boolean flag2 = false;  //닉네임
    String nnm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nickname_change);

        back = findViewById(R.id.nick_back);
        nick = findViewById(R.id.nick_edt);
        submit = findViewById(R.id.nick_submit);
        error = findViewById(R.id.nick_error);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nick.addTextChangedListener(new TextWatcher() {     //닉네임 EditText, 유효성 검사 아직 안함
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                nnm = nick.getText().toString();
                if(!(nnm.matches(NickNameValidation))) {
                    nick.setBackgroundResource(R.drawable.erroredit);
                    nick.setTextColor(Color.parseColor("#191919"));
                    flag2 = false;
                    error.setVisibility(View.VISIBLE);  //텍스트보이게
                    error.setText("2글자 이상 입력해 주세요.");
                    error.setTextColor(Color.parseColor("#ff3120"));
                }
                else {
                    nick.setBackgroundResource(R.drawable.login1editshape);
                    nick.setTextColor(Color.parseColor("#191919"));
                    flag2 = true;
                    error.setVisibility(View.VISIBLE);
                    error.setText("사용 가능한 이름입니다.");  //에러메시지 > 사용가능 메시지로 변경
                    error.setTextColor(Color.parseColor("#3e68ff"));
                }


                if(nnm.matches("")) {
                    flag2 = false;
                    nick.setBackgroundResource(R.drawable.login1editshape);
                    error.setVisibility(View.GONE);  //아무것도 입력안했을 시 에러메시지 들어감
                }
                else {
                    flag2 = true;
                }

                if(flag2 == true) {
                    submit.setBackgroundResource(R.drawable.nextcolorbutton);
                    submit.setTextColor(Color.parseColor("#FFFFFF"));
                }
                else {
                    submit.setBackgroundResource(R.drawable.nextgraybutton);
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "버튼 이거 맞음? 들어옴");
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            Log.d("test", "try는 들어옴");
                            if (success) {
                                AlertDialog.Builder dlg = new AlertDialog.Builder(Nickname_Change.this);
                                dlg.setTitle("닉네임 변경 완료");
                                dlg.setMessage("닉네임이 변경 되었습니다.");
                                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(Nickname_Change.this, MainMypage.class);
                                        intent.putExtra("id", id);
                                        intent.putExtra("nnm", nnm);
                                        startActivity(intent);
                                    }
                                });
                                dlg.show();
                            } else {
                                AlertDialog.Builder dlg = new AlertDialog.Builder(Nickname_Change.this);
                                dlg.setTitle("닉네임 변경 실패!");
                                dlg.setMessage("닉네임이 변경 되지 않았습니다.");
                                dlg.setPositiveButton("확인", null);
                                dlg.show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                Nickname_ChangeRequest nickname_changeRequest = new Nickname_ChangeRequest(id, nnm, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Nickname_Change.this);
                queue.add(nickname_changeRequest);
            }
        });


    }
}
