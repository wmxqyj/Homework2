package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    private TextView count_down_num;
    private Handler mhandler=new Handler();
    private int  time=30;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                time--;
                count_down_num.setText( time + "" );
                if (time == 0) {
                    Intent intent = new Intent( UserActivity.this, MainActivity.class );
                    startActivity( intent );
                    finish();
                } else {
                    mhandler.postDelayed( runnable, 1000 );
                }

            }
        };


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user);
            findViewById( R.id.count_down ).setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    initView();
                }
            } );
        }


        private void initView() {
            count_down_num = (TextView) findViewById(R.id.count_down);
            mhandler.postDelayed(runnable,1000);

        }

}