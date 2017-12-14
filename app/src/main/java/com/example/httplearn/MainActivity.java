package com.example.httplearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/*
 *  https://www.12306.cn/mormhweb/
 */
public class MainActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webView);

        final URL url;
        try {
            url = new URL("https://developer.android.com/reference/javax/net/ssl/HttpsURLConnection.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Toast.makeText(this, "URL解析错误", Toast.LENGTH_SHORT).show();
            return;
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpsURLConnection cnn = (HttpsURLConnection) url.openConnection();
                    cnn.connect();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("bear", e.getCause() + ", " + e.getMessage());
                }
            }
        }).start();


    }
}
