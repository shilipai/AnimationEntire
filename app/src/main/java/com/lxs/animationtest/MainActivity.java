package com.lxs.animationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button animationTween, animationFrame,animationProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationTween = (Button) findViewById(R.id.animation_tween);
        animationFrame = (Button) findViewById(R.id.animation_frame);
        animationProperty = (Button) findViewById(R.id.animation_property);
        animationTween.setOnClickListener(this);
        animationFrame.setOnClickListener(this);
        animationProperty.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.animation_tween:
                startActivity(new Intent(this, TweenAnimationActivity.class));
                break;
            case R.id.animation_frame:
                startActivity(new Intent(this, FrameAnimationActivity.class));
                break;
            case R.id.animation_property:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;
        }

    }
}
