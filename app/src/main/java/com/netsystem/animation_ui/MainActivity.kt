package com.netsystem.animation_ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.postDelayed
import java.util.*

class MainActivity : AppCompatActivity() {

    private val maxCount = 100
    private val targetDegree = 180
    private val random = Random()
    private val displayedNumbers = mutableListOf<Int>()
    private var isAnimationFinished = true
    private var currentDegree = 0f
    private lateinit var lineAndCircleAnimation: LineAndCircleAnimation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lineAndCircleAnimation = LineAndCircleAnimation()

        val numberTextView = findViewById<TextView>(R.id.numberTextView)
        val numberLeft = findViewById<TextView>(R.id.numberLeft)
        val numberRight = findViewById<TextView>(R.id.numberRight)
        val arrowImageView = findViewById<LinearLayout>(R.id.clockwise)
        val arrowImageLeft = findViewById<LinearLayout>(R.id.clockwiseLeft)
        val arrowImageRight = findViewById<LinearLayout>(R.id.clockwiseRight)
        val circle1 = findViewById<TextView>(R.id.circle_left_to_right)
        val circle_test = findViewById<TextView>(R.id.circle_test1)
        val circle_test2 = findViewById<TextView>(R.id.circle_test2)
        val circle_test3 = findViewById<TextView>(R.id.circle_test3)
        val circle2 = findViewById<TextView>(R.id.circle_top_to_down)
        val circle_test4 = findViewById<TextView>(R.id.circle_test4)
        val circle_test5 = findViewById<TextView>(R.id.circle_test5)
        val circle_test6 = findViewById<TextView>(R.id.circle_test6)
        val circle3 = findViewById<TextView>(R.id.circle_bottom_to_up)
        val circle_test7 = findViewById<TextView>(R.id.circle_test7)
        val circle_test8 = findViewById<TextView>(R.id.circle_test8)
        val circle_test9 = findViewById<TextView>(R.id.circle_test9)
        val circle_left1 = findViewById<ImageView>(R.id.circle_left1)
        val circle_left2 = findViewById<ImageView>(R.id.circle_left2)
        val circle_left3 = findViewById<ImageView>(R.id.circle_left3)
        val circle_left4 = findViewById<ImageView>(R.id.circle_left4)
        val circle_right5 = findViewById<ImageView>(R.id.circle_right5)
        val circle_right6 = findViewById<ImageView>(R.id.circle_right6)
        val circle_right7 = findViewById<ImageView>(R.id.circle_right7)

        val handler = Handler()

        val rotationRunnable = object : Runnable {
            override fun run() {
                if (isAnimationFinished) {

                    val randomCount = getRandomNumber()
                    numberTextView.text = randomCount.toString()
                    numberLeft.text = randomCount.toString()
                    numberRight.text = randomCount.toString()

                    val targetDegree = (randomCount / maxCount.toFloat()) * targetDegree

                    val newAnimation = createRotateAnimation(currentDegree, targetDegree)
                    newAnimation.duration = 1000
                    newAnimation.fillAfter = true
                    newAnimation.setAnimationListener(animationListener)
                    arrowImageView.startAnimation(newAnimation)

                    val newAnimationLeft = createRotateAnimation(currentDegree, targetDegree)
                    newAnimationLeft.duration = 1000
                    newAnimationLeft.fillAfter = true
                    newAnimationLeft.setAnimationListener(animationListener)
                    arrowImageLeft.startAnimation(newAnimationLeft)

                    val newAnimationRight = createRotateAnimation(currentDegree, targetDegree)
                    newAnimationRight.duration = 1000
                    newAnimationRight.fillAfter = true
                    newAnimationRight.setAnimationListener(animationListener)
                    arrowImageRight.startAnimation(newAnimationRight)

                    currentDegree = targetDegree
                }

                handler.postDelayed(this, 500)
            }
        }

        handler.post(rotationRunnable)

        //left movement
        lineAndCircleAnimation.handleLeftMovement(circle_left1, circle_left2, circle_left3, circle_left4)

        //right movement
        lineAndCircleAnimation.handleRightMovement(circle_right5, circle_right6, circle_right7)

        //move point from left to right
        lineAndCircleAnimation.handleLeftToRight(circle1, circle_test, circle_test2, circle_test3)

        //move point from top to down
        lineAndCircleAnimation.handleTopToDown(circle2, circle_test4, circle_test5, circle_test6)

        //move point from bottom to up
        lineAndCircleAnimation.handleBottomToUp(circle3, circle_test7, circle_test8, circle_test9)
    }

    private val animationListener = object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {}

        override fun onAnimationEnd(animation: Animation?) {
            isAnimationFinished = true
        }

        override fun onAnimationRepeat(animation: Animation?) {}
    }

    private fun createRotateAnimation(fromDegree: Float, toDegree: Float): RotateAnimation {
        return RotateAnimation(
            fromDegree, toDegree,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
    }

    private fun getRandomNumber(): Int {
        var randomCount: Int
        do {
            randomCount = random.nextInt(101)
        } while (displayedNumbers.contains(randomCount))
        displayedNumbers.add(randomCount)
        if (displayedNumbers.size >= maxCount) {
            displayedNumbers.clear()
        }
        isAnimationFinished = false
        return randomCount
    }
}
