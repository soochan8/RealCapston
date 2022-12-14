package com.moasseo;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

//POST 방식으로 웹 요청할 클래스

public class Nickname_ChangeRequest extends StringRequest {
    //서버 URL 설정 (PHP 파일 연동)
    final static private String URL = "http://moasseo.com/capstone/nick_change.php";
    //final static private String URL = "http://172.111.106.2/inphp/MainLogin.php";
    private Map<String, String> map;

    public Nickname_ChangeRequest(String nnm, String id, Response.Listener<String> listener) {
        //public MainLoginRequest(String User_id, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();

        map.put("nnm", nnm);
        map.put("id", id);

    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError{
        return map;
    }
}

