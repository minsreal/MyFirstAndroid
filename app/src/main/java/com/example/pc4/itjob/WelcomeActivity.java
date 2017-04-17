package com.example.pc4.itjob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by PC4 on 2017/4/12.
 */

public class WelcomeActivity extends Activity {
    private ImageView welImage;
    private Button welButton;
    private TextView welText;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome);
        initView();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }, 3000);
    }

    public void initView(){
        welImage = (ImageView) findViewById(R.id.welImage);
        welText = (TextView) findViewById(R.id.wel_text);
    }
}
