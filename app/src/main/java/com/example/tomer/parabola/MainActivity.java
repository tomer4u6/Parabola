package com.example.tomer.parabola;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView wv;
    EditText et1;
    EditText et2;
    EditText et3;
    Button btn;
    String st1, st2, st3, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = (WebView) findViewById(R.id.wv);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        btn = (Button) findViewById(R.id.btn);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new MyWebViewClient());
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    public void getnumbers(View view) {
        st1 = et1.getText().toString();
        st2 = et2.getText().toString();
        st3 = et3.getText().toString();
        if ((st1.isEmpty()) || (st2.isEmpty()) || (st3.isEmpty())) {
            Toast.makeText(this, "Missing parameters", Toast.LENGTH_SHORT).show();
        } else if (Double.parseDouble(st1) == 0) {
            Toast.makeText(this, "A cannot be zero", Toast.LENGTH_SHORT).show();
        } else if((Double.parseDouble(st2) == 0)&&(Double.parseDouble(st3) == 0)) {
            url = "https://www.google.co.il/search?q=";
            url = url + st1 + "x%5E2";
            wv.loadUrl(url);
        }
        else if(Double.parseDouble(st3) == 0){
            url = "https://www.google.co.il/search?q=";
            url = url + st1 + "x%5E2%2B" + st2 + "x";
            wv.loadUrl(url);
        }
        else if(Double.parseDouble(st2) == 0){
            url = "https://www.google.co.il/search?q=";
            url = url + st1 + "x%5E2%2B" + st3;
            wv.loadUrl(url);
        }
        else{
            url = "https://www.google.co.il/search?q=";
            url = url + st1 + "x%5E2%2B" + st2 + "x%2B" + st3;
            wv.loadUrl(url);
        }
    }
}

