package com.moasseo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class test01 extends MainActivity {

    EditText edit;
    TextView text;

    String key = "oNVqTKJ%2F7TkUhO7durfsD0Z7mscQ9pE4Xoy6dATYUy0vNYgBhm3ugDUl%2Bt8EnsgchkaX78NKAPulwC2VxUeSgw%3D%3D";
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test01);

        edit = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.text);
    }

    //Button을 클릭했을 때 자동으로 호출되는 callback method
    public void mOnClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        data = getXmlData();
                        //아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(data);
                                //TextView에 문자열 data 출력
                            }
                        });
                    }
                }).start();
                break;
        }

    }

    String getXmlData() {
        StringBuffer buffer = new StringBuffer();

        String str = edit.getText().toString();  //EditText에 작성된 Text얻어오기
        String location = URLEncoder.encode(str);  //한글의 경우 인식이 안되기때문에 utf-8 방식으로 encoding, 지역 검색 위한 변수

        String queryUrl = "http://apis.data.go.kr/3740000/suwonEvChrstn/getdatalist?serviceKey=" + key + "&type=xml&sortKey=chrstnType&filterKey=chrstnType&filterValues=DC콤보&numOfRows=10&pageNo=0";

        try {
            URL url = new URL(queryUrl);
            InputStream is = url.openStream();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8"));

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();

            while(eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작\n");
                        break;
                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();

                        if(tag.equals("item"));
                        else if(tag.equals("chrstnNm")) {
                            buffer.append("주소 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("useOpenTime")) {
                            buffer.append("시간 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;
                    case XmlPullParser.END_TAG:
                        tag = xpp.getName();

                        if(tag.equals("item"))
                            buffer.append("\n");

                        break;
                }
                eventType = xpp.next();
            }
        }
        catch(Exception e) {}

        buffer.append("파싱 끝");

        return buffer.toString();
    }
}
