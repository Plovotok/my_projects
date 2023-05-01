package com.example.myapplication.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.myapplication.R

class ManGroupsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man_groups)

        val imageView = findViewById<ImageView>(R.id.test_img)

        val resetBtn = findViewById<Button>(R.id.reset_btn)
        val tv = findViewById<TextView>(R.id.author_tv)

        val btn1 = findViewById<Button>(R.id.first_btn)
        val btn2 = findViewById<Button>(R.id.sec_btn)
        val btn3 = findViewById<Button>(R.id.third_btn)
        val btn4 = findViewById<Button>(R.id.fourth_btn)

        val imgMap = mapOf(
            "Hyungwon" to R.drawable.mx_heinvon_ready,
            "I.M." to R.drawable.mx_im_ready,
            "Joohoney" to R.drawable.mx_juhoni_ready,
            "Minhyuk" to R.drawable.mx_minheik_ready,
            "Kihyun" to R.drawable.mx_kihein_ready)
        val btnArray = arrayOf(btn1, btn2, btn3, btn4)
//        Счетчик правильных ответов
        var rightCounter = 0
//        Массив из которого выбираются значения для всех кнопок кроме правильной
        var tempMap = imgMap.toMutableMap()

        val correctAnswerLottie = findViewById<LottieAnimationView>(R.id.correct)
        correctAnswerLottie.visibility = View.INVISIBLE

        resetBtn.setOnClickListener {
//            Изображение из базы
            val pairNameAndImage = updateImage(imgMap)
//            var image = pairNameAndImage.second
            val image = pairNameAndImage.second
//            Ответ на вопрос
            val rightAnswer = pairNameAndImage.first
//            Номер кнопки правильного ответа
            val rightAnswerId = (1..4).random()

            correctAnswerLottie.visibility = View.INVISIBLE

            imageView.setImageResource(image)
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
            tempMap = imgMap.toMutableMap()
            btn1.setOnClickListener(){
                if (btn1.text == rightAnswer) {
                    correctAnswerLottie.visibility = View.VISIBLE
                    correctAnswerLottie.playAnimation()
                    rightCounter++
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

    private fun updateImage(data: Map<String, Int>): Pair<String, Int> {
        return data.toList().random()
    }

}