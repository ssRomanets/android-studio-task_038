package com.example.task_038

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var shopViewIV: ImageView
    private lateinit var enterToShopBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()

        val animationImage = AnimationUtils.loadAnimation(applicationContext, R.anim.visibility)
        shopViewIV.startAnimation(animationImage)

        enterToShopBTN.animate().apply{
            translationX(0.0f)
        }.withEndAction{
            enterToShopBTN.animate().apply {
                duration = 5000
                translationX(365.0f)
            }.start()
        }

        enterToShopBTN.setOnClickListener{
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
        }
    }

    fun initUI() {
        shopViewIV = findViewById(R.id.shopViewIV);
        enterToShopBTN = findViewById(R.id.enterToShopBTN);
    }
}