package com.netsystem.animation_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val maxCount = 100
    private val targetDegree = 180
    private val random = Random()
    private val displayedNumbers = mutableListOf<Int>()
    private var isAnimationFinished = true
    private var currentDegree = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberTextView = findViewById<TextView>(R.id.numberTextView)
        val numberLeft = findViewById<TextView>(R.id.numberLeft)
        val numberRight = findViewById<TextView>(R.id.numberRight)
        val arrowImageView = findViewById<LinearLayout>(R.id.clockwise)
        val arrowImageLeft = findViewById<LinearLayout>(R.id.clockwiseLeft)
        val arrowImageRight = findViewById<LinearLayout>(R.id.clockwiseRight)

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
