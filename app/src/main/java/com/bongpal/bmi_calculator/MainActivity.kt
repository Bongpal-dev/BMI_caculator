package com.bongpal.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText = findViewById<EditText>(R.id.et_height)
        val weightEditText = findViewById<EditText>(R.id.et_weight)
        val summitButton = findViewById<TextView>(R.id.btn_calculate)
        val maleButton = findViewById<RadioButton>(R.id.btn_male)
        val femaleButton = findViewById<RadioButton>(R.id.btn_female)

        var genderCheck: Boolean? = null

        maleButton.setOnClickListener {
            genderCheck = true
            println(genderCheck)
        }

        femaleButton.setOnClickListener {
            genderCheck = false
            println(genderCheck)
        }

        summitButton.setOnClickListener {

            when{
                heightEditText.text.isEmpty() && weightEditText.text.isEmpty() && genderCheck == null -> {toastMsg("모든 항목이 비었습니다"); return@setOnClickListener}
                weightEditText.text.isEmpty() && genderCheck == null -> {toastMsg("체중과 성별을 입력하세요"); return@setOnClickListener}
                heightEditText.text.isEmpty() && weightEditText.text.isEmpty() -> {toastMsg("키와 체중을 입력하세요"); return@setOnClickListener}
                heightEditText.text.isEmpty() && genderCheck == null -> {toastMsg("키와 성별을 입력하세요"); return@setOnClickListener}
                heightEditText.text.isEmpty() -> {toastMsg("키를 입력하세요"); return@setOnClickListener}
                weightEditText.text.isEmpty() -> {toastMsg("체중을 입력하세요"); return@setOnClickListener}
                genderCheck == null -> {toastMsg("성별을 입력하세요"); return@setOnClickListener}


            }




            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()
            val gender: Boolean = genderCheck!!

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            intent.putExtra("gender", gender)
            startActivity(intent)
        }
    }

    fun toastMsg(msg: String) {
        Toast.makeText(this, "$msg", Toast.LENGTH_SHORT).show()
    }
}