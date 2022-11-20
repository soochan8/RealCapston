package com.moasseo;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PayRequest extends StringRequest {
    //서버 URL 설정 (PHP 파일 연동)
    //10.0.2.2 애뮬 로컬 주소
    final static private String URL = "http://moasseo.com/capstone/MainPay.php";
    //final static private String URL = "http://root/capstone/MainPay.php";

    private Map<String, String> map;

    //db로 전송할 값들
    //포인트 넘버, 마켓 넘버, 사용자 id(닉네임), 전체 포인트, 가지고 있는 포인트, 시장 넘버
    public PayRequest(String p_n, String m_n, String id, String tot_p, String hv_p, String o_n, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();

        map.put("p_n", p_n);  //포인트 넘버
        map.put("m_n", m_n);  //마켓 넘버
        map.put("id", id);  //id
        map.put("tot_p", tot_p);  //총 포인트
        map.put("hv_p", hv_p);  //가지고 있는 포인트
        map.put("o_n", o_n);  //시장 넘버

        //Log.d("test1","User_id >>>>> " + User_id);
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

