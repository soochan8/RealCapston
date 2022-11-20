package com.moasseo;

import android.util.Log;

import org.json.JSONObject;
//import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FCMessage {


        // FCM에서 가입 후 받는 키값
        public final static String AUTH_KEY_FCM = "1129d3f5e8971913625c5707081bf87cbb127c87";

        public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

        public static void main (String[]args) throws Exception {

            //String token = tokenList.get(count).getDEVICE_ID();

            String _title = "앱 알림";
            String _body = "푸쉬메시지가 도착했습니다.";
            String _actionType = "new";
            String _code = "test";
            //String _token = "/topics/ALL"; // 전체

            // 모바일기기에서 얻음
            String _token = "cSryACIlTJu8lq4eux4gnh:APA91bHLqlkN-iib0gVLgXWQqpaCh42-LAdehV4fjRPAKXalyF5y5im8nh9K-8tvSF9lPonmLeH9z-Zw26dY06I-IXXKwXmPmdvxIzFCxAXl3LBiDEGA6HetDi2HNkZCWpN8r47Bpo3I"; // 개인


            final String apiKey = AUTH_KEY_FCM;
            URL url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "key=" + apiKey);

            conn.setDoOutput(true);


            JSONObject json = new JSONObject();
            JSONObject notification = new JSONObject();

            notification.put("title", _title);
            notification.put("body", _body);

            json.put("notification", notification);
            json.put("to", _token);

            String sendMsg = json.toString();

            OutputStream os = conn.getOutputStream();

            // 서버에서 날려서 한글 깨지는 사람은 아래처럼  UTF-8로 인코딩해서 날려주자
            //os.write(input.getBytes("UTF-8"));
            os.write(sendMsg.getBytes("UTF-8"));
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            System.out.println(response.toString());
        }
}