package com.hariofspades.constraintsetzone

import android.annotation.TargetApi
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_nested.*

class NestedActivity : AppCompatActivity() {

    private lateinit var parentConstraint: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested)
        parentConstraint = findViewById(R.id.nestShoppingRoot)
        setupAnimations()
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private fun setupAnimations() {
        val firstConstraint = ConstraintSet()
        firstConstraint.clone(parentConstraint)

        val secConstraint = ConstraintSet()
        secConstraint.clone(this, R.layout.activity_nested_alt)

        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()

        askSize.setOnClickListener {
            secConstraint.applyTo(parentConstraint)
            askSize.text = "ADD TO CART - 1234 INR"
            TransitionManager.beginDelayedTransition(parentConstraint, transition)
        }

        close.setOnClickListener {
            firstConstraint.applyTo(parentConstraint)
            askSize.text = "SELECT SIZE"
            TransitionManager.beginDelayedTransition(parentConstraint, transition)
        }
    }
}
