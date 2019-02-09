package ca.ulaval.ima.tp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class mWebView extends Activity implements View.OnClickListener {
    private WebView mWebview;
    private String url;
    private Button Button;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        mWebview  = (WebView) findViewById(R.id.webView);
        Button = (Button) findViewById(R.id.button);
        Button.setOnClickListener(this);
        url = getIntent().getStringExtra("url");

        mWebview.getSettings().setJavaScriptEnabled(true);

        mWebview.setWebViewClient(new WebViewClient());
        mWebview .loadUrl(url);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
