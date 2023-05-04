package com.example.myapplication.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.myapplication.R
import com.example.myapplication.model.ManGroupsData

class ManGroupsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man_groups)
//        Find views

        val imageView = findViewById<ImageView>(R.id.test_img)

        val resetBtn = findViewById<Button>(R.id.reset_btn)
        val tv = findViewById<TextView>(R.id.author_tv)

        val btn1 = findViewById<Button>(R.id.first_btn)
        val btn2 = findViewById<Button>(R.id.sec_btn)
        val btn3 = findViewById<Button>(R.id.third_btn)
        val btn4 = findViewById<Button>(R.id.fourth_btn)

        val btnHelp = findViewById<Button>(R.id.btn_help)

//        List of answer buttons
        val btnArray = arrayOf(btn1, btn2, btn3, btn4)
//        Counter of right answers
        var rightCounter = 0
//        temp map for filling buttons by text
        var tempMap = ManGroupsData.dataMap.toMutableMap()

//        Animation
        val correctAnswerLottie = findViewById<LottieAnimationView>(R.id.correct)
        val wrongAnswerLottie = findViewById<LottieAnimationView>(R.id.wrong)
        correctAnswerLottie.visibility = View.INVISIBLE
        wrongAnswerLottie.visibility = View.INVISIBLE

        resetBtn.setOnClickListener {
//            Define pair of image and person on it
            val pairNameAndImage = updateImage()
            val image = pairNameAndImage.second
            val rightAnswer = pairNameAndImage.first
//            Define a button's number of right answer
            val rightAnswerId = (1..4).random()

            btnHelp.setOnClickListener {
                Toast.makeText(this, rightAnswer, Toast.LENGTH_SHORT).show()
            }

            correctAnswerLottie.visibility = View.INVISIBLE
            wrongAnswerLottie.visibility = View.INVISIBLE

//            setting image resource
            imageView.setImageResource(image)
//            showing counter
            tv.text = rightCounter.toString()

            tempMap.remove(pairNameAndImage.first)
            for (btn in btnArray) {
                btn.isEnabled = true
            }

            when(rightAnswerId) {
                1 -> {
                    btn1.text = rightAnswer
                    buttonTextFiller(btnArray, btn1, tempMap)
                }
                2 -> {
                    btn2.text = rightAnswer
                    buttonTextFiller(btnArray, btn2, tempMap)
                }
                3 -> {
                    btn3.text = rightAnswer
                    buttonTextFiller(btnArray, btn3, tempMap)
                }
                4 -> {
                    btn4.text = rightAnswer
                    buttonTextFiller(btnArray, btn4, tempMap)
                }
            }
            tempMap = ManGroupsData.dataMap.toMutableMap()

//            setting onClick function to every button with variants of answer
            btn1.setOnClickListener(){
                if (btn1.text == rightAnswer) {
                    correctAnswerLottie.visibility = View.VISIBLE
                    correctAnswerLottie.playAnimation()
                    rightCounter++
                } else {
                    wrongAnswerLottie.visibility = View.VISIBLE
                    wrongAnswerLottie.playAnimation()
                }
                for (btn in btnArray) {
                    btn.isEnabled = false
                }
            }
            btn2.setOnClickListener(){
                if (btn2.text == rightAnswer) {
                    correctAnswerLottie.visibility = View.VISIBLE
                    correctAnswerLottie.playAnimation()
                    rightCounter++
                } else {
                    wrongAnswerLottie.visibility = View.VISIBLE
                    wrongAnswerLottie.playAnimation()
                }
                for (btn in btnArray) {
                    btn.isEnabled = false
                }
            }
            btn3.setOnClickListener() {
                if (btn3.text == rightAnswer) {
                    correctAnswerLottie.visibility = View.VISIBLE
                    correctAnswerLottie.playAnimation()
                    rightCounter++
                } else {
                    wrongAnswerLottie.visibility = View.VISIBLE
                    wrongAnswerLottie.playAnimation()
                }
                for (btn in btnArray) {
                    btn.isEnabled = false
                }
            }
            btn4.setOnClickListener(){
                if (btn4.text == rightAnswer) {
                    correctAnswerLottie.visibility = View.VISIBLE
                    correctAnswerLottie.playAnimation()
                    rightCounter++
                } else {
                    wrongAnswerLottie.visibility = View.VISIBLE
                    wrongAnswerLottie.playAnimation()
                }
                for (btn in btnArray) {
                    btn.isEnabled = false
                }
            }

        }
    }

    private fun buttonTextFiller(btnArray: Array<Button>, excButton: Button, data: Map<String, Int>){
        val tempMap = data.toMutableMap()
        for (btn in btnArray){
            if (btn != excButton){
                btn.text = tempMap.toList().random().first
                tempMap.remove(btn.text)
            }
        }
    }

    private fun updateImage(): Pair<String, Int> {
        return ManGroupsData.dataMap.toList().random()
    }

}