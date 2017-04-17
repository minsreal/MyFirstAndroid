package com.example.pc4.itjob;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by PC4 on 2017/4/13.
 */

public class ImageButtonDemoActivity extends Activity implements View.OnClickListener{
    private ImageButton img_bt1;
    private ImageButton img_bt2;
    private ImageButton img_bt3;
    private ImageButton img_bt4;
    private ImageButton img_bt5;
    private ImageButton img_bt6;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        TitileBar.getTitleBar(this, "ImgeButton_Demo");
        setContentView(R.layout.imagebutton_demo);
        initView();

        initEvent();
    }

    protected void initView(){
        img_bt1 = (ImageButton) findViewById(R.id.img_bt1);
        img_bt2 = (ImageButton) findViewById(R.id.img_bt2);
        img_bt3 = (ImageButton) findViewById(R.id.img_bt3);
        img_bt4 = (ImageButton) findViewById(R.id.img_bt4);
        img_bt5 = (ImageButton) findViewById(R.id.img_bt5);
        img_bt6 = (ImageButton) findViewById(R.id.img_bt6);

    }

    protected void initEvent(){
        img_bt1.setOnClickListener(this);
        img_bt2.setOnClickListener(this);
        img_bt3.setOnClickListener(this);
        img_bt4.setOnClickListener(this);
        img_bt5.setOnClickListener(this);
        img_bt6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int num = 0;
        if(v == img_bt1) num = 1;
        else if(v == img_bt2) num = 2;
        else if(v == img_bt3) num = 3;
        else if(v == img_bt4) num = 4;
        else if(v == img_bt5) num = 5;
        else if(v == img_bt6) num = 6;
        Dialog dialog = new AlertDialog.Builder(ImageButtonDemoActivity.this)
                .setTitle("提示").setMessage("我是小黄人"+num+"号")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();
        dialog.show();
    }
}
