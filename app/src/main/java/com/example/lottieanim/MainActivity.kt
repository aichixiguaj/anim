package com.example.lottieanim

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lottieView = findViewById<LottieAnimationView>(R.id.lottieView)
        val maskImage = findViewById<ImageView>(R.id.imageView)
        val viewAnim = setAnim(maskImage)
        lottieView.apply {
            setAnimation("custom.zip")
            repeatCount = 0
            addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) {
                    viewAnim.let {
                        viewAnim.start()
                    }
                }

                override fun onAnimationRepeat(p0: Animator?) {
                }

                override fun onAnimationEnd(p0: Animator?) {
                    SecondActivity.jumpActivity(this@MainActivity, lottieView)
                }

                override fun onAnimationCancel(p0: Animator?) {
                }
            })
            playAnimation()
        }
    }

    private fun setAnim(view: View): ValueAnimator {
        val valueAnim = ValueAnimator.ofFloat(1f, 0f)
        valueAnim.duration = 200
        valueAnim.addUpdateListener { animation ->
            animation?.let {
                val animValue = animation.animatedValue as Float
                view.alpha = animValue
                view.scaleX = animValue
                view.scaleY = animValue
                view.requestLayout()
                if (animValue == 0f) {
                    view.visibility = View.GONE
                }
            }
        }
        return valueAnim
    }
}