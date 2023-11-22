package com.netsystem.animation_ui

import android.animation.ObjectAnimator
import android.graphics.Path
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.View

class LineAndCircleAnimation {

    private fun leftToRightMovement(view: View) {
        val leftToRight = Path()
        leftToRight.arcTo(70f, 70f, 690f, 690f, -150f, 120f, true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val animator1 = ObjectAnimator.ofFloat(view, View.X, View.Y, leftToRight)
            animator1.duration = 3000
            animator1.repeatCount = ObjectAnimator.INFINITE
            animator1.repeatMode = ObjectAnimator.RESTART
            animator1.start()
        } else {
            // Create animator without using curved path
        }
    }

    private fun topToDownMovement(view: View) {
        val topToDown = Path()
        topToDown.arcTo(0f, 100f, 690f, 690f, -30f, 120f, true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val animator2 = ObjectAnimator.ofFloat(view, View.X, View.Y, topToDown)
            animator2.duration = 3000
            animator2.repeatCount = ObjectAnimator.INFINITE
            animator2.repeatMode = ObjectAnimator.RESTART
            animator2.start()
        } else {
            // Create animator without using curved path
        }
    }

    public fun bottomToTopMovement(view: View) {
        val bottomToUp = Path()
        bottomToUp.arcTo(65f, 10f, 690f, 690f, 90f, 120f, true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val animator3 = ObjectAnimator.ofFloat(view, View.X, View.Y, bottomToUp)
            animator3.duration = 3000
            animator3.repeatCount = ObjectAnimator.INFINITE
            animator3.repeatMode = ObjectAnimator.RESTART
            animator3.start()
        } else {
            // Create animator without using curved path
        }
    }

    public fun rightMovement(view: View) {
        val x = 110f
        val y = 0f
        val path = Path()
        path.moveTo(x + 0, y + 0)
        path.lineTo(x + 0, y + 330)
        path.moveTo(x + 0, y + 330)
        path.lineTo(x + 100, y + 330)
        path.moveTo(x + 100, y + 330)

        val objectAnimator = ObjectAnimator.ofFloat(view, View.X, View.Y, path)
        objectAnimator.duration = 3000
        objectAnimator.repeatCount = ObjectAnimator.INFINITE
        objectAnimator.repeatMode = ObjectAnimator.RESTART
        objectAnimator.start()
    }

    public fun leftMovement(view: View) {
        val x = 60f
        val y = 0f
        val path = Path()
        path.moveTo(x + 0, y + 0)
        path.lineTo(x + 0, y + 600)
        path.moveTo(x + 0, y + 600)

        val objectAnimator = ObjectAnimator.ofFloat(view, View.X, View.Y, path)
        objectAnimator.duration = 3000
        objectAnimator.repeatCount = ObjectAnimator.INFINITE
        objectAnimator.repeatMode = ObjectAnimator.RESTART
        objectAnimator.start()
    }

    fun handleLeftToRight(view: View, view2: View, view3: View, view4: View) {
        leftToRightMovement(view)

        Handler(Looper.getMainLooper()).postDelayed({
            leftToRightMovement(view2)
        }, 800);

        Handler(Looper.getMainLooper()).postDelayed({
            leftToRightMovement(view3)
        }, 1600)

        Handler(Looper.getMainLooper()).postDelayed({
            leftToRightMovement(view4)
        }, 2400)
    }

    fun handleTopToDown(view: View, view2: View, view3: View, view4: View) {
        topToDownMovement(view)

        Handler(Looper.getMainLooper()).postDelayed({
            topToDownMovement(view2)
        }, 800);

        Handler(Looper.getMainLooper()).postDelayed({
            topToDownMovement(view3)
        }, 1600)

        Handler(Looper.getMainLooper()).postDelayed({
            topToDownMovement(view4)
        }, 2400)
    }

    fun handleBottomToUp(view: View, view2: View, view3: View, view4: View) {
        bottomToTopMovement(view)

        Handler(Looper.getMainLooper()).postDelayed({
            bottomToTopMovement(view2)
        }, 800);

        Handler(Looper.getMainLooper()).postDelayed({
            bottomToTopMovement(view3)
        }, 1600)

        Handler(Looper.getMainLooper()).postDelayed({
            bottomToTopMovement(view4)
        }, 2400)
    }

    fun handleLeftMovement(view: View, view2: View, view3: View, view4: View) {
        leftMovement(view)

        Handler(Looper.getMainLooper()).postDelayed({
            leftMovement(view2)
        }, 800);

        Handler(Looper.getMainLooper()).postDelayed({
            leftMovement(view3)
        }, 1600)

        Handler(Looper.getMainLooper()).postDelayed({
            leftMovement(view4)
        }, 2400)
    }

    fun handleRightMovement(view: View, view2: View, view3: View) {
        rightMovement(view)

        Handler(Looper.getMainLooper()).postDelayed({
            rightMovement(view2)
        }, 900);

        Handler(Looper.getMainLooper()).postDelayed({
            rightMovement(view3)
        }, 1800)
    }
}