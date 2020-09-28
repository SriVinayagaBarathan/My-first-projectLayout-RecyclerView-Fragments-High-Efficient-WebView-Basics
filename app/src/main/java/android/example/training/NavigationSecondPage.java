package android.example.training;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationSecondPage extends AppCompatActivity {

    BottomNavigationView navi;


    ImageButton twitter,facebook,instagram,github;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_second_page);

        navi=findViewById(R.id.bnv);
        navi.setSelectedItemId(R.id.webid);


        twitter=findViewById(R.id.twitterbutton);
        facebook=findViewById(R.id.facebookbutton);
        instagram=findViewById(R.id.instagrambutton);
        github=findViewById(R.id.githubbutton);

        webView=findViewById(R.id.connectwebview);
        webView.setWebViewClient(new WebClass());




        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.regformid:
                        Intent intent = new Intent(NavigationSecondPage.this,NavigationFirstPage.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);

                        Toast.makeText(NavigationSecondPage.this, " Register Form!", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.webid:

                        Toast.makeText(NavigationSecondPage.this, "Already in this page,Stay connected with", Toast.LENGTH_SHORT).show();
                        return true;
                }

                return false;
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://twitter.com/Srivinayagabar1/following";
                webView.loadUrl(url);
                webAccessories();
                Toast.makeText(NavigationSecondPage.this, "Twitter launching", Toast.LENGTH_SHORT).show();
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://www.facebook.com/sri.vinayagabarathan";
                webView.loadUrl(url);
                webAccessories();
                Toast.makeText(NavigationSecondPage.this, "Facebook launching", Toast.LENGTH_SHORT).show();
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://www.instagram.com/wolf_must_be_chill_always/";
                webView.loadUrl(url);
                webAccessories();
                Toast.makeText(NavigationSecondPage.this, "Instagram launching", Toast.LENGTH_SHORT).show();
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://github.com/SriVinayagaBarathan";
                webView.loadUrl(url);
                webAccessories();
                Toast.makeText(NavigationSecondPage.this, "Github launching", Toast.LENGTH_SHORT).show();
            }
        });



    }




    void webAccessories()          //this is extra fittings,to make web View with efficient speed and compatiblity size to all mobile phones
    {
        webView.requestFocus();
        webView.getSettings().setLightTouchEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.setSoundEffectsEnabled(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        webView.getSettings().setUseWideViewPort(true);
    }
}

 // this class makes that he webView can be completed accesed without moving out of activity,(no intenting to browser)
class WebClass extends WebViewClient
{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
       view.loadUrl(url);
       return true;

    }
}
