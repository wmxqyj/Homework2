package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void Register(View v){
        //判断姓名、密码是否为空
        EditText nameedt = findViewById( R.id.name );
        EditText pwdedt = findViewById( R.id.pwd );
        ProgressBar probar = findViewById( R.id.pro_bar );

        String name = nameedt.getText().toString();
        String pwd = pwdedt.getText().toString();
        if(name.equals( "" ) || pwd.equals( "" )) {
            //为空则提示输入

            Toast.makeText(this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
        }else {
            //都不为空，则加载进度条
            probar.setVisibility(View.VISIBLE );
            new Thread(){
                @Override
                public void run() {
                    for (int i= 0;i <= 100;i++){
                        probar.setProgress( i );
                        try {
                            Thread.sleep( 30 );
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
            startActivity( new Intent(this,UserActivity.class) );
        }
    }
}