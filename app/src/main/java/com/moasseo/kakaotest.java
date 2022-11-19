package com.moasseo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.kakao.sdk.auth.LoginClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class kakaotest extends AppCompatActivity {

    private View loginButton;
    //private View logoutButton;
    //private TextView nickName;
    //private ImageView profileImage;
    String nnm;

    Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kakaotest);

        LoginButton = (Button)findViewById(R.id.LoginButton);

        loginButton = findViewById(R.id.login);
        //logoutButton = findViewById(R.id.logout);
        //nickName = findViewById(R.id.nickname);
        //profileImage = findViewById(R.id.profile);

        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken != null) {

                }
                if(throwable != null) {

                }
                updateKakaoLoginUi();
                return null;
            }
        };

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(LoginClient.getInstance().isKakaoTalkLoginAvailable(kakaotest.this)) {
                    LoginClient.getInstance().loginWithKakaoTalk(kakaotest.this, callback);
                }
                else {
                    LoginClient.getInstance().loginWithKakaoAccount(kakaotest.this, callback);
                }
            }
        });

        /*logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
                    @Override
                    public Unit invoke(Throwable throwable) {
                        updateKakaoLoginUi();
                        return null;
                    }
                });
            }
        });*/

        updateKakaoLoginUi();

        LoginButton.setOnClickListener(new View.OnClickListener() {  //모아써 로그인 버튼 클릭
            public void onClick(View v) {
                Intent intent1 = new Intent(kakaotest.this, MainLogin.class);
                startActivity(intent1);
            }
        });
    }

    private void updateKakaoLoginUi() {
        UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {
                if(user != null) {
                    Log.d("test123", "실행");
                    //nickName.setText(user.getKakaoAccount().getProfile().getNickname());
                    //Glide.with(profileImage).load(user.getKakaoAccount().getProfile().getThumbnailImageUrl()).circleCrop().into(profileImage);
                    nnm = user.getKakaoAccount().getProfile().getNickname();
                    //user.getKakaoAccount().getProfile().getThumbnailImageUrl();

                    //loginButton.setVisibility(View.VISIBLE);
                    //logoutButton.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(kakaotest.this, Main.class);
                    intent.putExtra("nnm", nnm);  //카카오톡 이름을 넘김
                    startActivity(intent);
                }
                else {
                    //nickName.setText(null);
                    //profileImage.setImageBitmap(null);
                    //loginButton.setVisibility(View.VISIBLE);
                    //logoutButton.setVisibility(View.GONE);
                }
                return null;
            }
        });
    }
}
