package com.lxs.animationtest;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 实现功能：
 * <p>
 * Created by lxs on 2016/9/27 15:37.
 * 修 改 者：修改日期：修改内容：
 */
public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    Button property_anim_performer, btnTranslationY, btnBackgroundColor, btnPropertyAnimSet;
    private ValueAnimator animator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_property);
        property_anim_performer = (Button) findViewById(R.id.property_anim_performer);
        btnTranslationY = (Button) findViewById(R.id.btn_translationY);
        btnBackgroundColor = (Button) findViewById(R.id.btn_background_color);
        btnPropertyAnimSet = (Button) findViewById(R.id.btn_property_anim_set);
        btnTranslationY.setOnClickListener(this);
        btnBackgroundColor.setOnClickListener(this);
        btnPropertyAnimSet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_translationY:
                animator = ObjectAnimator.ofFloat(property_anim_performer, "translationY", btnTranslationY.getHeight());
                animator.start();
                break;

            case R.id.btn_background_color:
                propertyAnimBgcolor();
                break;
            case R.id.btn_property_anim_set:
                propertyAnimSet();
                break;
        }

    }


    private void propertyAnimBgcolor() {
        animator = ObjectAnimator.ofInt(property_anim_performer, "backgroundColor", 0xFFFF0000, 0xFF0000FF);
        animator.setDuration(3000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();

    }

    private void propertyAnimSet() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(property_anim_performer, "rotationX", 0, 360),
                ObjectAnimator.ofFloat(property_anim_performer, "rotationY", 0, 180),
                ObjectAnimator.ofFloat(property_anim_performer, "rotation", 0, -90),
                ObjectAnimator.ofFloat(property_anim_performer, "translationX", 0, 90),
                ObjectAnimator.ofFloat(property_anim_performer, "translationY", 0, 90),
                ObjectAnimator.ofFloat(property_anim_performer, "scaleX", 1, 1.5f),
                ObjectAnimator.ofFloat(property_anim_performer, "scaleY", 1, 0.5f),
                ObjectAnimator.ofFloat(property_anim_performer, "alpha", 1, 0.25f, 1)
        );
        set.setDuration(5000).start();
    }

}
