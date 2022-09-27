package com.moasseo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class ChangePassword extends Activity {

    ImageButton back;
    Button okay;
    EditText pass1, pass2;
    ImageView check1, check2;
    TextView textView120;
    TextView textView121;

    static boolean eyes = true;  //비밀번호 보이게, 안보이게 할 때 사용
    static boolean eyes1 = true;  //비밀번호 보이게, 안보이게 할 때 사용

    static boolean flag1 = false;
    static boolean flag2 = false;
    String bb, bb1, cc, cc1;

    String pwd;
    //바꿀 비밀번호 두개가 일치 하였을 때, 여기에다가 넣어줌
    String id = "test";
    //테스트용 아이디임

    private String PwdValidation = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{8,}.$";  //숫자, 영문, 특수문자 최소 8자 이상


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepassword);

        back = findViewById(R.id.pass_back);
        okay = findViewById(R.id.pass_btn1);
        pass1 = findViewById(R.id.pass_edt1);
        pass2 = findViewById(R.id.pass_edt2);
        check1 = findViewById(R.id.pass_check1);
        check2 = findViewById(R.id.pass_check2);
        textView120 = findViewById(R.id.textView120);  //유효성 검사 오류 시 나타나는 text
        textView121 = findViewById(R.id.textView121);  //비밀번호가 일치하지 않을 시 나타나는 오류text


        pass1.addTextChangedListener(new TextWatcher() {   //비밀번호 새 입력 유효성 검사
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                bb = pass1.getText().toString();  //비밀번호 입력 값 bb에 저장
                bb1 = pass1.getText().toString();  //비밀번호 입력 값 bb에 저장 (비밀번호 재입력과 비교하기 위해)

                if (!(bb.matches(PwdValidation))) { //bb가 비밀번호 유효성 검사가 일치하지 않다면
                    pass1.setBackgroundResource(R.drawable.erroredit);
                    pass1.setTextColor(Color.parseColor("#191919"));
                    flag2 = false;
                    textView120.setVisibility(View.VISIBLE);  //텍스트보이게
                    textView120.setText("숫자, 영문, 특수문자 조합 8자리 이상 입력해 주세요.");
                    textView120.setTextColor(Color.parseColor("#ff3120"));
                } else {
                    pass1.setBackgroundResource(R.drawable.login1editshape);
                    pass1.setTextColor(Color.parseColor("#191919"));
                    flag2 = true;
                    textView120.setVisibility(View.GONE);
                }


                if (bb.matches("")) {
                    flag2 = false;
                    pass1.setBackgroundResource(R.drawable.login1editshape);  //썼다가 지웠을 때 오류 사라짐
                    textView120.setVisibility(View.GONE); //아무것도 안적었을 때 오류text 사라짐
                }

                if (flag1 == true && flag2 == true) {
                    okay.setBackgroundResource(R.drawable.nextcolorbutton);
                    okay.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    okay.setBackgroundResource(R.drawable.nextgraybutton);
                }


            }
        });


        check1.setOnClickListener(new View.OnClickListener() {  //새 비밀번호 EditText 눈 표시 클릭
            @Override
            public void onClick(View v) {
                if (eyes == true) {
                    check1.setImageResource(R.drawable.eyes_on);  //클릭 시 비밀번호 보이게 이미지 변경
                    pass1.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);  //비밀번호 보이게
                    pass1.setLetterSpacing((float) -0.04);
                    eyes = false;

                } else {
                    check1.setImageResource(R.drawable.eyes_off);  //켜진 상태에서 클릭시 비밀번호 안보이게 이미지 변경
                    pass1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);  //비밀번호 안보이게
                    pass1.setLetterSpacing((float) -0.04);
                    eyes = true;
                }
            }
        });

        pass2.addTextChangedListener(new TextWatcher() {  //비밀번호 재입력
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                cc = pass2.getText().toString();
                cc1 = pass2.getText().toString();

                if (!(cc.equals(bb1))) {  //비밀번호와 비밀번호 재입력이 일치하지 않는다면
                    pass2.setBackgroundResource(R.drawable.erroredit);  //빨간색 테두리
                    pass2.setTextColor(Color.parseColor("#191919"));
                    flag1 = false;
                    textView121.setVisibility(View.VISIBLE);  //텍스트보이게
                    textView121.setText("비밀번호가 일치하지 않습니다.");
                    textView121.setTextColor(Color.parseColor("#ff3120"));
                } else {  //비밀번호와 비밀번호 재입력이 일치하다면
                    pass2.setBackgroundResource(R.drawable.login1editshape);
                    pass2.setTextColor(Color.parseColor("#191919"));
                    flag1 = true;
                    textView121.setVisibility(View.GONE);  //일치하면 사라짐ㄱ
                    pwd = pass2.getText().toString();

                }

                if (cc.matches("")) {  //아무것도 입력 안했더라면
                    flag1 = false;
                    pass2.setBackgroundResource(R.drawable.login1editshape); //흰색 배경
                    textView121.setVisibility(View.GONE);  //아무것도 안적었을 때 오류text 사라짐ㄱ
                }

                if (flag1 == true && flag2 == true) {
                    okay.setBackgroundResource(R.drawable.nextcolorbutton);
                    okay.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    okay.setBackgroundResource(R.drawable.nextgraybutton);
                }
            }
        });


        check2.setOnClickListener(new View.OnClickListener() {  //새 비밀번호 확인 EditText 눈 표시 클릭
            @Override
            public void onClick(View v) {
                if (eyes1 == true) {
                    check2.setImageResource(R.drawable.eyes_on);  //클릭 시 비밀번호 보이게 이미지 변경
                    pass2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);  //비밀번호 보이게
                    pass2.setLetterSpacing((float) -0.04);
                    eyes1 = false;

                } else {
                    check2.setImageResource(R.drawable.eyes_off);  //켜진 상태에서 클릭시 비밀번호 안보이게 이미지 변경
                    pass2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);  //비밀번호 안보이게
                    pass2.setLetterSpacing((float) -0.04);
                    eyes1 = true;
                }
            }
        });
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            Log.d("test", "try는 들어옴");
                            if (success) {
                                //비밀번호 변경됐다고 뜨는 다이얼로그
                                Log.d("test", "홀리섹스");

                            } else {
                                Toast.makeText(ChangePassword.this, "실패", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest(id, pwd, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ChangePassword.this);
                queue.add(changePasswordRequest);
            }
        });
    }
}
