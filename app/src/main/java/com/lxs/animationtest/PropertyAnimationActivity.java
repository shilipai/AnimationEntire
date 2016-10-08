package com.lxs.animationtest;

import android.animation.AnimatorInflater;
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
    Button propertyAnimPerformer, btnTranslationY, btnBackgroundColor, btnPropertyAnimSet, btnPropertyAnimXml, btnWidthIncrease;
    private ValueAnimator animator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_property);
        propertyAnimPerformer = (Button) findViewById(R.id.property_anim_performer);
        btnTranslationY = (Button) findViewById(R.id.btn_translationY);
        btnBackgroundColor = (Button) findViewById(R.id.btn_background_color);
        btnPropertyAnimSet = (Button) findViewById(R.id.btn_property_anim_set);
        btnPropertyAnimXml = (Button) findViewById(R.id.btn_property_anim_xml);
        btnWidthIncrease = (Button) findViewById(R.id.btn_width_increase);
        btnTranslationY.setOnClickListener(this);
        btnBackgroundColor.setOnClickListener(this);
        btnPropertyAnimSet.setOnClickListener(this);
        btnPropertyAnimXml.setOnClickListener(this);
        btnWidthIncrease.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_translationY:
                animator = ObjectAnimator.ofFloat(propertyAnimPerformer, "translationY", btnTranslationY.getHeight());
                animator.start();
                break;

            case R.id.btn_background_color:
                propertyAnimBgColor();
                break;
            case R.id.btn_property_anim_set:
                propertyAnimSet();
                break;
            case R.id.btn_property_anim_xml:
                propertyAnimXml();
                break;
            case R.id.btn_width_increase:
                propertyAnimIncreaseWidth();
                break;
        }

    }

    private void propertyAnimIncreaseWidth() {
        ViewWrapper wrapper = new ViewWrapper(propertyAnimPerformer);
        ObjectAnimator.ofInt(wrapper, "width", 500).setDuration(5000).start();
    }


    private void propertyAnimBgColor() {
        animator = ObjectAnimator.ofInt(propertyAnimPerformer, "backgroundColor", 0xFFFF0000, 0xFF0000FF);
        animator.setDuration(3000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();

    }

    private void propertyAnimSet() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(propertyAnimPerformer, "rotationX", 0, 360),
                ObjectAnimator.ofFloat(propertyAnimPerformer, "rotationY", 0, 180),
                ObjectAnimator.ofFloat(propertyAnimPerformer, "rotation", 0, -90),
                ObjectAnimator.ofFloat(propertyAnimPerformer, "translationX", 0, 90),
                ObjectAnimator.ofFloat(propertyAnimPerformer, "translationY", 0, 90),
                ObjectAnimator.ofFloat(propertyAnimPerformer, "scaleX", 1, 1.5f),
                ObjectAnimator.ofFloat(propertyAnimPerformer, "scaleY", 1, 0.5f),
                ObjectAnimator.ofFloat(propertyAnimPerformer, "alpha", 1, 0.25f, 1)
        );
        set.setDuration(5000).start();
    }

    private void propertyAnimXml() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.property_animator);
        set.setTarget(propertyAnimPerformer);
        set.start();
    }

    private static class ViewWrapper {
        private View mTarget;

        public ViewWrapper(View target) {
            mTarget = target;
        }

        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }
    }
}
