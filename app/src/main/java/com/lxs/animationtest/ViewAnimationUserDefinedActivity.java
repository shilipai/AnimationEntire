package com.lxs.animationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * 实现功能：
 * <p>
 * Created by lxs on 2016/9/28 17:07.
 */
public class ViewAnimationUserDefinedActivity extends AppCompatActivity {
    private Button Rotate3d;
    private RelativeLayout rLayout;
    private Animation mAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_view_user_defined);

        Rotate3d = (Button) findViewById(R.id.btn_rotate3d);
        rLayout = (RelativeLayout) findViewById(R.id.rlayout);

        Rotate3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float centerX = rLayout.getWidth() / 2f;
                float centerY = rLayout.getHeight() / 2f;

                Log.e("------", "centerX:" + centerX + ",centerY:" + centerY + ",Rotate3d.getTop()" + Rotate3d.getTop() +
                        ",Rotate3d.getHeight()" + Rotate3d.getHeight() + ",Rotate3d.getBottom():" + Rotate3d.getBottom() +
                        ",getResources().getDisplayMetrics().heightPixels:" + getResources().getDisplayMetrics().heightPixels);
                mAnimation = new Rotate3dAnimation(0, 360, centerX, centerY, 0, false);
                mAnimation.setDuration(3000);
                mAnimation.setInterpolator(new AccelerateInterpolator());

                Rotate3d.startAnimation(mAnimation);
            }
        });
    }
}
