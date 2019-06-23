package com.example.dell.yinshipin;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity {

    private VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        vv = (VideoView) findViewById(R.id.vv);
           //网络视频
                    String videoUrl2 = Utils.videoUrl ;
                    Uri uri = Uri.parse(videoUrl2);
                    //设置视频控制器
                    vv.setMediaController(new MediaController(this));
                    //播放完成回调
                    vv.setOnCompletionListener( new MyPlayerOnCompletionListener());
                    //设置视频路径
                    vv.setVideoURI(uri);
                    //开始播放视频
                    vv.start();
                }

                class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText( Main2Activity.this, "播放完成了", Toast.LENGTH_SHORT).show();
                    }
                }


                public class Utils {

                    public static final String videoUrl = "https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/classfile/0/PM070 中美比较（秦朔）.mp4" ;

                }
    }

