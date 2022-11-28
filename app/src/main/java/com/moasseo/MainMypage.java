package com.moasseo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainMypage extends MainActivity {

    TextView grade_info, mypage_nn;  //등급안내 Text
    ConstraintLayout grade_pop;  //팝업 레이아웃
    ConstraintLayout mypage_point, mypage_mark, mypage_personal, mypage_setting;  //시장 별 포인트
    ImageView home, map, mypage;  //하단 네비게이션 바
    View view18;  //불투명 뷰
    ImageView BackButton;  //뒤로가기 버튼

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        mypage_nn = (TextView) findViewById(R.id.textView37);
        mypage_point = (ConstraintLayout) findViewById(R.id.constraintLayout5);  //내 정보 - 시장 별 포인트
        BackButton = (ImageView) findViewById(R.id.event_back);  //뒤로가기 버튼
        mypage_mark = (ConstraintLayout) findViewById(R.id.constraintLayout6); //시장 마크 모음집
        mypage_personal = (ConstraintLayout) findViewById(R.id.constraintLayout7); //개인 정보 변경
        mypage_setting = (ConstraintLayout) findViewById(R.id.constraintLayout8); //환경 설정
        home = (ImageView) findViewById(R.id.map_home);  //홈
        map = (ImageView) findViewById(R.id.map_map);  //지도
        mypage = (ImageView) findViewById(R.id.map_my);  //마이페이지

        Intent intent1 = getIntent();
        String nnm = intent1.getStringExtra("nnm");
        String intent_result = intent1.getStringExtra("intent_result");
        mypage_nn.setText(nnm);
        //닉네임 표기

        BackButton.setOnClickListener(new View.OnClickListener() {  //뒤로가기 버튼 클릭 시
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMypage.this, Main.class);  //메인 클래스로 이동
                intent.putExtra("nnm", nnm);  //닉네임을 같이 보냄 (메인_서브메뉴에서 닉네임을 보여주기 위해)
                startActivity(intent);
                //overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
                //ㅁㄴㅇ
            }
        });

        mypage_mark.setOnClickListener(new View.OnClickListener() {  //시장 마크 모음집
            @Override
            public void onClick(View v) {

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("test","try는 들어감 ㅇㅇ");
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean("success");

                            if (success) {  //로그인 성공시
                                Log.d("test","로그인 성공");
                                String id = jsonObject.getString("id");  //DB에 있는 닉네임을 받아옴, 서브메뉴에 넘겨줄 값
                                Intent intent = new Intent(MainMypage.this, market_list.class);  //메인 클래스로 이동
                                intent.putExtra("nnm", nnm);
                                intent.putExtra("id", id);
                                startActivity(intent);
                            }
                            else { //로그인 실패시
                                Log.d("test","더 노력해라 이상민!");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                Get_idRequest get_idRequest = new Get_idRequest(nnm, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainMypage.this);
                queue.add(get_idRequest);
            }
        });

        mypage_point.setOnClickListener(new View.OnClickListener() {  //시장 별 포인트 레이아웃을 클릭하면
            @Override
            public void onClick(View v) {
                //시장별 포인트로 넘어가기
                Intent intent = new Intent(MainMypage.this, MainMypagePoint.class);  //시장 별 포인트 화면으로 이동
                intent.putExtra("nnm", nnm);
                intent.putExtra("intent_result", intent_result);
                startActivity(intent);
                overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
            }
        });

        mypage_personal.setOnClickListener(new View.OnClickListener() {  //개인 정보 변경 클릭
            @Override
            public void onClick(View v) {
                //개인 정보 변경으로 넘어가기
                Intent intent = new Intent(MainMypage.this, Pass_check.class);  //개인 정보 변경 화면으로 이동
                intent.putExtra("nnm", nnm);
                startActivity(intent);
                overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
            }
        });

        mypage_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //환경 설정으로 넘어가기
                Intent intent = new Intent(MainMypage.this, MainSetting.class);  //환경 설정 화면으로 이동
                intent.putExtra("nnm", nnm);
                startActivity(intent);
                overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //홈으로 넘어가기
                Intent intent = new Intent(MainMypage.this, Main.class);  //메인 화면으로 이동
                intent.putExtra("nnm", nnm);
                startActivity(intent);
                overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //지도로 넘어가기
                Intent intent = new Intent(MainMypage.this, KakaoMap.class);  //지도 화면으로 이동
                startActivity(intent);
                overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
            }
        });
        //하단 네비게이션 바의 내 정보를 누르면 새로고침
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //새로고침
                Intent intent = new Intent(MainMypage.this, MainMypage.class);  //새로고침
                intent.putExtra("nnm", nnm);
                startActivity(intent);
                overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
            }
        });
    }
}