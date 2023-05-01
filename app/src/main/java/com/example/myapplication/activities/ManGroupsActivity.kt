package com.example.myapplication.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.myapplication.R

class ManGroupsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man_groups)

        val imageView = findViewById<ImageView>(R.id.test_img)

        val btnn = findViewById<Button>(R.id.reset_btn)
        val tv = findViewById<TextView>(R.id.author_tv)

        val btn1 = findViewById<Button>(R.id.first_btn)
        val btn2 = findViewById<Button>(R.id.sec_btn)
        val btn3 = findViewById<Button>(R.id.third_btn)
        val btn4 = findViewById<Button>(R.id.fourth_btn)


        val imageList = arrayOf(
            R.drawable.mx_heinvon_ready,
            R.drawable.mx_im_ready,
            R.drawable.mx_juhoni_ready,
            R.drawable.mx_kihein_ready,
            R.drawable.mx_minheik_ready
        )
        val imageAnswers = arrayOf(
            "Hyungwon",
            "I.M",
            "Joohoney",
            "Minhyuk",
            "Kihyun"
        )
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


        btnn.setOnClickListener {
//            Изображение из базы
            val image = imageList.random()
//            Ответ на вопрос
            val imgID = imageList.indexOf(image)
//            Номер кнопки правильного ответа
            val rightAnswerId = (1..4).random()
            var userAnswer = ""
            var myCount1 = false
            correctAnswerLottie.visibility = View.INVISIBLE

            imageView.setImageResource(image)
            tv.text = rightCounter.toString()
            tempMap.remove(getKey(tempMap, imgID))
            for (btn in btnArray) {
                btn.isEnabled = true
            }

            when(rightAnswerId) {
                1 -> {
                    btn1.text = imageAnswers[imgID]

                    for (btn in btnArray) {
                        if (btn != btn1) {
                            val randomName = (0 until tempMap.size).random()
                            btn.text = getKey(tempMap, randomName)
                            tempMap.remove(getKey(tempMap, randomName))
                        }
                    }
                    btn1.setOnClickListener {
                        userAnswer = btn1.text as String
                        myCount1 = isUserChoiceRight(userAnswer, imageAnswers[imgID])
                        if (myCount1){
                            rightCounter++
                            correctAnswerLottie.visibility = View.VISIBLE
                        }
                        for (btn in btnArray) {
                            btn.isEnabled = false
                        }
                    }

                    tempMap = imgMap.toMutableMap()

                }
                2 -> {
                    btn2.text = imageAnswers[imgID]

                    for (btn in btnArray) {
                        if (btn != btn2) {
                            val randomName = (0 until tempMap.size).random()
                            btn.text = getKey(tempMap, randomName)
                            tempMap.remove(getKey(tempMap, randomName))
                        }
                    }
                    btn2.setOnClickListener {
                        userAnswer = btn2.text as String
                        myCount1 = isUserChoiceRight(userAnswer, imageAnswers[imgID])
                        if (myCount1){
                            rightCounter++
                            correctAnswerLottie.visibility = View.VISIBLE
                        }
                        for (btn in btnArray) {
                            btn.isEnabled = false
                        }
                    }

                    tempMap = imgMap.toMutableMap()

                }
                3 -> {
                    btn3.text = imageAnswers[imgID]
                    for (btn in btnArray) {
                        if (btn != btn3) {
                            val randomName = (0 until tempMap.size).random()
                            btn.text = getKey(tempMap, randomName)
                            tempMap.remove(getKey(tempMap, randomName))
                        }
                    }
                    btn3.setOnClickListener {
                        userAnswer = btn3.text as String
                        myCount1 = isUserChoiceRight(userAnswer, imageAnswers[imgID])
                        if (myCount1){
                            rightCounter++
                            correctAnswerLottie.visibility = View.VISIBLE
                        }
                        for (btn in btnArray) {
                            btn.isEnabled = false
                        }
                    }

                    tempMap = imgMap.toMutableMap()

                }
                4 -> {
                    btn4.text = imageAnswers[imgID]

                    for (btn in btnArray) {
                        if (btn != btn4) {
                            val randomName = (0 until tempMap.size).random()
                            btn.text = getKey(tempMap, randomName)
                            tempMap.remove(getKey(tempMap, randomName))
                        }
                    }
                    btn4.setOnClickListener {
                        userAnswer = btn4.text as String
                        myCount1 = isUserChoiceRight(userAnswer, imageAnswers[imgID])
                        if (myCount1){
                            rightCounter++
                            correctAnswerLottie.visibility = View.VISIBLE
                        }
                        for (btn in btnArray) {
                            btn.isEnabled = false
                        }
                    }

                    tempMap = imgMap.toMutableMap()

                }
            }

        }


    }


private fun isUserChoiceRight(userAnswer: String, rightAnswer: String):Boolean {
        return userAnswer == rightAnswer
    }

    private fun getKey(array: Map<String, Int>, index: Int): String {
        return array.keys.toList().get(index)
    }
}