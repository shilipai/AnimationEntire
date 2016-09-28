package com.lxs.animationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

/**
 * 实现功能：
 * <p>
 * Created by lxs on 2016/9/28 15:49.
 */
public class LayoutAnimationJavaActivity extends AppCompatActivity {

    private LinearLayout ll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_layout);
        ll = (LinearLayout) findViewById(R.id.ll);
        Animation annotation = AnimationUtils.loadAnimation(this, R.anim.anim_item);
        LayoutAnimationController controller = new LayoutAnimationController(annotation);
        controller.setDelay(0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        ll.setLayoutAnimation(controller);

    }
}
