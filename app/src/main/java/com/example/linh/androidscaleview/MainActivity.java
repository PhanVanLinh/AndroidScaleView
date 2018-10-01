package com.example.linh.androidscaleview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import vn.linh.androidscaleview.R;

public class MainActivity extends AppCompatActivity {

    ImageView imageView3;
    ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView3 = findViewById(R.id.image_3);
        imageView4 = findViewById(R.id.image_4);
        findViewById(R.id.button_animate_scale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scale(imageView3);
            }
        });

        findViewById(R.id.button_resize).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resize(imageView4, 0.5f, 0.8f);
            }
        });
    }

    private void scale(View view) {
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat("scaleX", 0.5f),
                PropertyValuesHolder.ofFloat("scaleY", 0.5f));
        scaleDown.setDuration(1000);
        scaleDown.start();
    }

    private void resize(View view, float scaleX, float scaleY) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (view.getWidth() * scaleX);
        layoutParams.height = (int) (view.getHeight() * scaleY);
        view.setLayoutParams(layoutParams);
    }
}
