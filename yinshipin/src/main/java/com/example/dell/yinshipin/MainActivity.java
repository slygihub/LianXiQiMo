package com.example.dell.yinshipin;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt1;
    private Button bt2;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                               try {
                                   mediaPlayer.setDataSource("http://sc1.111ttt.cn/2016/5/07/23/200230031351.mp3");
                                   mediaPlayer.prepare();
                                   mediaPlayer.start();
                               } catch (IOException e) {
                                   e.printStackTrace();
                               }
                break;
            case R.id.bt2:
                mediaPlayer.stop();
                break;
            case R.id.bt3:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
