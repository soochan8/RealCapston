package com.moasseo;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

//POST 방식으로 웹 요청할 클래스

public class MainFindPwdResultRequest extends StringRequest {
    //서버 URL 설정 (PHP 파일 연동)
    final static private String URL = "http://moasseo.com/capstone/MainFindPwdResult.php";
    private Map<String, String> map;

    public MainFindPwdResultRequest(String User_id, String User_pwd, Response.Listener<String> listener) {
        //public MainLoginRequest(String User_id, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("id", User_id);
        map.put("pwd", User_pwd);

    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError{
        return map;
    }
}

