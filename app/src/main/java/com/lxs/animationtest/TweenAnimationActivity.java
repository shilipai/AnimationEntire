package com.lxs.animationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * 实现功能：
 * <p>
 * Created by lxs on 2016/9/26 11:29.
 * 修 改 者：修改日期：修改内容：
 */
public class TweenAnimationActivity extends AppCompatActivity {
    private Button btnRotate;
    private Animation anim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_tween);

        anim = AnimationUtils.loadAnimation(this, R.anim.rotate);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        btnRotate = (Button) findViewById(R.id.btn_rotate);
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnRotate.startAnimation(anim);
            }
        });

    }
}
