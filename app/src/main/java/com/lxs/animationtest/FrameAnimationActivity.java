package com.lxs.animationtest;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 实现功能：
 * <p/>
 * Created by lxs on 2016/9/26 16:41.
 * 修 改 者：修改日期：修改内容：
 */
public class FrameAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView tvAnimationFrame;
    private Button start, stop;
    private AnimationDrawable anim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_frame);
        tvAnimationFrame = (ImageView) findViewById(R.id.tv_animation_frame);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

//        anim = (AnimationDrawable) ContextCompat.getDrawable(this, R.drawable.frame);//查看：http://stackoverflow.com/questions/29041027/android-getresources-getdrawable-deprecated-api-22
//        tvAnimationFrame.setBackgroundDrawable(anim);

        tvAnimationFrame.setBackgroundResource(R.drawable.frame);//查看：http://www.lai18.com/content/666597.html
        anim = (AnimationDrawable) tvAnimationFrame.getBackground();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                anim.start();
                break;
            case R.id.stop:
                anim.stop();
                break;
        }
    }
}
