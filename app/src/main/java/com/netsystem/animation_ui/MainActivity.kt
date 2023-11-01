package com.netsystem.animation_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        findViewById<LinearLayout>(R.id.clockwiseLeft).setBackgroundColor(resources.getColor(R.color.black))
//        findViewById<LinearLayout>(R.id.clockwiseRight).setBackgroundColor(resources.getColor(R.color.black))

        val rotate = RotateAnimation(
            0F, 180F,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )

        rotate.duration = 1000
        rotate.repeatCount = Animation.INFINITE
        findViewById<LinearLayout>(R.id.clockwiseLeft).animation = rotate
        findViewById<LinearLayout>(R.id.clockwiseRight).animation = rotate

        val rotate1 = RotateAnimation(
            0F, 180F,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )

        rotate1.duration = 1000
        rotate1.repeatCount = Animation.INFINITE
        findViewById<LinearLayout>(R.id.clockwise).animation = rotate1

    }
}