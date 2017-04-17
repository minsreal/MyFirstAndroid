package com.example.pc4.itjob;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.pc4.itjob.R.id.login_name;

/**
 * Created by PC4 on 2017/4/13.
 */

public class LoginActivity extends Activity{

    private EditText login_edit;
    private Button  login_button;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);

        initView();

        initEvent();
    }

    protected void initView(){
        login_button = (Button) findViewById(R.id.login_btn);
        login_edit = (EditText) findViewById(login_name);
    }

    protected void initEvent(){
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        login_edit.setImeOptions(EditorInfo.IME_ACTION_DONE);
        login_edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_UNSPECIFIED || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)){
                    login();
                }

                return false;
            }
        });
    }

    protected void login(){
        String name = login_edit.getText().toString().trim();
        if(name == null || name.equals("")){
            Dialog dialog = new AlertDialog.Builder(LoginActivity.this)
                    .setTitle("提示").setMessage("请输入任意字符再登录")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create();
            dialog.show();
        }else{
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            LoginActivity.this.finish();
        }
    }
}
