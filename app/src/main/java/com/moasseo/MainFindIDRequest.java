package com.moasseo;

import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainFindIDRequest extends StringRequest {
    //서버 URL 설정 (PHP 파일 연동)
    final static private String URL = "http://10.0.2.2/capstone/MainFindID.php";
    //final static private String URL = "http://172.111.106.2/inphp/MainLogin.php";
    private Map<String, String> map;

    public MainFindIDRequest(String u_nm, String em, Response.Listener<String> listener) {
        //public MainLoginRequest(String User_id, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("u_nm", u_nm);  //php에 아이디를 넘김
        map.put("em", em);

    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}
