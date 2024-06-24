package com.example.lottieanim

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var shareImage: ImageView

    companion object {
        fun jumpActivity(ctx: Activity, view: View) {
            val intent = Intent(ctx, SecondActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                ctx,
                view, "image"
            )
            ctx.startActivity(intent, options.toBundle())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        shareImage = findViewById(R.id.shareImage)
    }

}