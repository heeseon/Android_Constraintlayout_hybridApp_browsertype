package urqa.com.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.webkit.WebView;


public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    View.OnClickListener onClickListener;
    WebView webViewMain;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        if (webViewMain.canGoBack()){
            webViewMain.goBack();
        }
        else {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webViewMain = (WebView) findViewById(R.id.webViewMain);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn1 :
                        btn1Clicked();
                        break;
                    case R.id.btn2 :
                        btn2Clicked();
                        break;
                    case R.id.btn3 :
                        btn3Clicked();
                        break;
                    case R.id.btn4 :
                        btn4Clicked();
                        break;
                    default:
                        break;
                }
            }
        };

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);

        WebSettings webSettings = webViewMain.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webViewMain.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                btn1.setText("loading....");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                btn1.setText(webViewMain.getTitle());
            }
        });
        webViewMain.setWebChromeClient(new WebChromeClient());
        webViewMain.loadUrl("https://domich.wordpress.com/");

    }

    void btn1Clicked(){
    }

    void btn2Clicked(){
        webViewMain.loadUrl("https://domich.wordpress.com/");
    }

    void btn3Clicked(){
        webViewMain.loadUrl("http://www.naver.com");
    }

    void btn4Clicked(){
        webViewMain.loadUrl("http://www.google.com");
    }

}
