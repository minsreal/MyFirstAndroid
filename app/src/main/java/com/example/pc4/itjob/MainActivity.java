package com.example.pc4.itjob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{

    private TextView titleText;
    private Button listBotton;
    private Button recyclerButton;
    private Button frameButton;
    private Button relativeButton;
    private Button imageButton;
    private Button moreButton;

    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        initView();

        initData();

        initEvent();
    }

    public void initView(){
        titleText = (TextView) findViewById(R.id.toolbar_title);
        listBotton = (Button) findViewById(R.id.main_bt1);
        recyclerButton = (Button) findViewById(R.id.main_bt2);
        frameButton = (Button) findViewById(R.id.main_bt3);
        relativeButton = (Button) findViewById(R.id.main_bt4);
        imageButton = (Button) findViewById(R.id.main_bt5);
        moreButton = (Button) findViewById(R.id.main_bt6);
    }

    public void initData(){
        titleText.setText("Demo");
    }

    protected void initEvent(){
        listBotton.setOnClickListener(this);
        frameButton.setOnClickListener(this);
        recyclerButton.setOnClickListener(this);
        relativeButton.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        moreButton.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if(System.currentTimeMillis() - exitTime > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }else{
                finish();
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if(v == moreButton){
            Toast.makeText(getApplicationContext(), "敬请期待哦~~", Toast.LENGTH_SHORT).show();
            return;
        }else if(v == listBotton){
            intent = new Intent(MainActivity.this, ListViewDemoActivity.class);
        }else if(v == recyclerButton){
            intent = new Intent(MainActivity.this, RecyclerViewDemoActivity.class);
        }else if(v == frameButton){
            intent = new Intent(MainActivity.this, FrameDemoActivity.class);
        }else if(v == relativeButton){
            intent = new Intent(MainActivity.this, RelativeDmoActivity.class);
        }else if(v == imageButton){
            intent = new Intent(MainActivity.this, ImageButtonDemoActivity.class);
        }else
            return;
        startActivity(intent);
    }
}
