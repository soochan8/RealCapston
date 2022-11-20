package com.moasseo;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

public class MainMypage extends MainActivity {

    TextView grade_info, mypage_nn;  //등급안내 Text
    ConstraintLayout grade_pop;  //팝업 레이아웃
    ConstraintLayout mypage_point, mypage_mark, mypage_personal, mypage_setting;  //시장 별 포인트
    //View close;  //하단 닫기 뷰
    View view18;  //불투명 뷰
    ImageView BackButton;  //뒤로가기 버튼

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        mypage_nn = (TextView) findViewById(R.id.textView37);
        //grade_info = (TextView) findViewById(R.id.textView36);  //등급안내 Text
        // grade_pop = (ConstraintLayout) findViewById(R.id.constraintlayout10);  //팝업 레이아웃
        mypage_point = (ConstraintLayout) findViewById(R.id.constraintLayout5);  //내 정보 - 시장 별 포인트
        // close = (View) findViewById(R.id.view3);  //하단 닫기 뷰
        // view18 = (View) findViewById(R.id.view18);  //불투명 뷰
        BackButton = (ImageView) findViewById(R.id.BackButton);  //뒤로가기 버튼
        mypage_mark = (ConstraintLayout) findViewById(R.id.constraintLayout6); //시장 마크 모음집
        mypage_personal = (ConstraintLayout) findViewById(R.id.constraintLayout7); //개인 정보 변경
        mypage_setting = (ConstraintLayout) findViewById(R.id.constraintLayout8); //환경 설정

        Intent intent = getIntent();
        String nnm = intent.getStringExtra("nnm").toString();
        mypage_nn.setText(nnm);
        //닉네임 표기

        BackButton.setOnClickListener(new View.OnClickListener() {  //뒤로가기 버튼 클릭 시
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMypage.this, Main.class);  //메인 클래스로 이동
                intent.putExtra("nnm", nnm);  //닉네임을 같이 보냄 (메인_서브메뉴에서 닉네임을 보여주기 위해)
                startActivity(intent);
                //overridePendingTransition(0, 0);  //화면 바로 넘김 스무스하게
            }
        });

        mypage_point.setOnClickListener(new View.OnClickListener() {  //시장 별 포인트 레이아웃을 클릭하면
            @Override
            public void onClick(View v) {
                //시장별 포인트로 넘어가기
                Intent intent = new Intent(MainMypage.this, MainMypagePoint.class);  //시장 별 포인트 화면으로 이동
                intent.putExtra("nnm", nnm);
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


    }
}