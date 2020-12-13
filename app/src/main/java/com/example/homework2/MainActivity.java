package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

   //登录
    public void Register(View v){
        //判断姓名、密码是否为空
        EditText nameedt = findViewById( R.id.name );
        EditText pwdedt = findViewById( R.id.pwd );

        String name = nameedt.getText().toString();
        String pwd = pwdedt.getText().toString();
        if(name.equals( "" ) || pwd.equals( "" )) {
            //为空则提示输入
            Toast.makeText(this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
        }else {
            startActivity( new Intent( MainActivity.this, UserActivity.class ) );
        }
    }
}

