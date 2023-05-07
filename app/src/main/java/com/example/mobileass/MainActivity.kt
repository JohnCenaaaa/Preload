package com.example.mobileass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.mobileass.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val changeText : TextView = binding.preloadText2
        val wordMap = mapOf(
            R.drawable.boxed_water_is_better_z6xw00fvay to "WORK LIKE \n" +
                    "THERE IS NO TOMMOROW",
            R.drawable.untitled_design to "STAY \n" +
                    "HYDRATED",
            R.drawable.untitled_design__1_ to "DON’T TELL PEOPLE YOUR PLAN, SHOW THEM WITH RESULT"
        )
        val img1: ImageView =binding.preload1Image
        val img2: ImageView =binding.preload2Image
        val img3: ImageView =binding.preload3Image
        val imageArray = intArrayOf(R.drawable.untitled_design,
            R.drawable.untitled_design__1_,
            R.drawable.boxed_water_is_better_z6xw00fvay)
        val random = Random()
        val randomIndex = random.nextInt(imageArray.size)
        val selectedImage = imageArray[randomIndex]
        fun updateViews() {
            when (selectedImage) {
                R.drawable.untitled_design -> {
                    img1.visibility = View.VISIBLE
                    img2.visibility = View.INVISIBLE
                    img3.visibility = View.INVISIBLE
                    changeText.text = wordMap[R.drawable.untitled_design]
                }
                R.drawable.untitled_design__1_ -> {
                    img1.visibility = View.INVISIBLE
                    img2.visibility = View.VISIBLE
                    img3.visibility = View.INVISIBLE
                    changeText.text = wordMap[R.drawable.untitled_design__1_]
                }
                R.drawable.boxed_water_is_better_z6xw00fvay -> {
                    img1.visibility = View.INVISIBLE
                    img2.visibility = View.INVISIBLE
                    img3.visibility = View.VISIBLE
                    changeText.text = wordMap[R.drawable.boxed_water_is_better_z6xw00fvay]
                }
            }
        }
        selectedImage?.let {
            updateViews()
        }
        Handler().postDelayed({
            val intent = Intent(this, LogReg::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}