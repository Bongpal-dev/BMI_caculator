package com.bongpal.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)
        val gender = intent.getBooleanExtra("gender", true)

        val btn_back = findViewById<TextView>(R.id.btn_back)


        var value = weight / (height/100.0).pow(2.0)
        value = round(value*1000)/1000

        var resultText = ""
        var resultImage = 0

        fun resultMaker(text: String, image: Int) {
            resultText = text
            resultImage = image
        }

        when {
            value < 18.5 -> {resultMaker("저체중입니다.", R.drawable.lv_1)}
            value >= 18.5 && value < 23.0 -> {resultMaker("정상체중입니다.", R.drawable.lv_2)}
            value >= 23.0 && value < 25.0 -> {resultMaker("과체중입니다.", R.drawable.lv_1)}
            value >= 25.0 && value < 30.0 -> {resultMaker("경도비만입니다.", R.drawable.lv_3)}
            value >= 30.0 && value < 35.0 -> {resultMaker("고도비만입니다.", R.drawable.lv_4)}
            else -> {resultMaker("초고도비만입니다.", R.drawable.lv_5)}
        }

        val tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        val tv_resText = findViewById<TextView>(R.id.tv_resText)
        val iv_resImage = findViewById<ImageView>(R.id.iv_resImage)

        tv_resValue.text = value.toString()
        tv_resText.text = resultText
        iv_resImage.setImageResource(resultImage)

        btn_back.setOnClickListener {
            finish()
        }

    }


}