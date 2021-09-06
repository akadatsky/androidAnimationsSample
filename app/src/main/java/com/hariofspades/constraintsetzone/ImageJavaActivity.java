package com.hariofspades.constraintsetzone;

import android.annotation.TargetApi;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class ImageJavaActivity extends AppCompatActivity {

    ConstraintLayout parentConstraint;
    boolean set = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_java);
        initViews();
        performAnimations();
    }

    private void initViews() {
        parentConstraint = findViewById(R.id.root);
    }

    private void performAnimations() {
        final ConstraintSet constraintOne = new ConstraintSet();
        constraintOne.clone(parentConstraint);
        final ConstraintSet constraintTwo = new ConstraintSet();
        constraintTwo.load(this, R.layout.activity_image_java_alt);
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TransitionManager();
                TransitionManager.beginDelayedTransition(parentConstraint);
                if (set)
                    constraintOne.applyTo(parentConstraint);
                else
                    constraintTwo.applyTo(parentConstraint);
                set = !set;
            }
        });
    }
}
