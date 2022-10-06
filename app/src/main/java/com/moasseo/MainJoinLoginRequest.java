package com.moasseo;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

//POST 방식으로 웹 요청할 클래스

public class MainJoinLoginRequest extends StringRequest {
    //서버 URL 설정 (PHP 파일 연동)
    //10.0.2.2 애뮬 로컬 주소
    final static private String URL = "http://10.0.2.2/capstone/MainJoinLogin.php";
    //final static private String URL = "http://172.111.106.2/inphp/MainLogin.php";
    private Map<String, String> map;

    public MainJoinLoginRequest(String User_id, String User_pwd, String User_name, String User_email, String User_NickName, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("id", User_id);
        map.put("pwd", User_pwd);
        map.put("u_nm", User_name);
        map.put("em", User_email);
        map.put("nnm", User_NickName);

        //Log.d("test1","User_id >>>>> " + User_id);
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError{
        return map;
    }
}

