package com.example.jabroni

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

            private var questions = listOf(" 1 Сколько стоит fisting?? \n\n " +
            "A) 2000 баксов \n\n " +
            "B) 300 bucks \n\n " +
            "C) 3000 рублей",
        "2 Кого не стало 3 марта 2018 года \n\n " +
                "A) Билли Херрингтона \n\n " +
                "B) Вана Даркхолма \n\n " +
                "C) Рикардо Милоса",
        "3 Кому из персонажей Гачимучи принадлежит фраза: \"Oh shit, I'm sorry\"? \n\n " +
                "A) Стив Рэмбо \n\n " +
                "B) Билли Херрингтон \n\n " +
                "C) Don't know",
        "4 Кто главный флексер на планете? \n\n " +
                "A) Рикардо Милос \n\n " +
                "B) Евгений Понасенков \n\n " +
                "C) Денни Ли",
        "5 Кто из них сейчас (в 2021) ведёт стримы на Твиче? \n\n " +
                "A) Рикардо Милос \n\n " +
                "B) Ван Даркхолм \n\n " +
                "C) Стив Рэмбо",
        "6 Продолжите фразу 'Let's celebrate and...? \n\n " +
                "A) ... suck some dick \n\n " +
                "B) ... gang it up \n\n " +
                "C) ... my victory",
        "7 Кого из этих исполнителей обрел большую популярность именно благодаря Гачимиксам? \n\n " +
                "A) Нурминский \n\n " +
                "B) Газманов \n\n " +
                "C) Виктор Цой",
        "8 Денис Ашкудило это ? \n\n " +
                "A) Чмо \n\n " +
                "B) Обоссыш \n\n " +
                "C) НЕ человек",
                "9 Главный девиз Гачимучи \n\n " +
                        "A) Ass we can \n\n " +
                        "B) Let's give it a go\n\n " +
                        "C) It's so fucking deep",
                "10 Кто стал победителем в битве за GYM \n\n " +
                        "A) Билли Херрингтон \n\n " +
                        "B) Ван Даркхолм \n\n " +
                        "C) Денни Ли",
                "11 В скольких фильмах Вэн Даркхолм и Билли Херрингтон снялись вместе?\n" +
                        "А) 2\n" +
                        "B) 7\n" +
                        "C) 10\n",
            "12")
    var rightAnswers = listOf(2, 1, 1, 1, 2, 1, 1, 3, 1, 2, 1, 1)
    var questionNo:Int = 0
    var results = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start()
    }
private fun start() {
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val restart = findViewById<TextView>(R.id.textView4)
        val result = findViewById<TextView>(R.id.textView3)

    textView.text = questions[questionNo]
        button.setOnClickListener { showToast(1) }
        button2.setOnClickListener { showToast(2) }
        button3.setOnClickListener { showToast(3) }
        restart.setOnClickListener { restart() }
        result.text = "$results/${questions.size - 1}"
        }

    private fun restart() {
        setContentView(R.layout.activity_main)
        questionNo = 0
        results = 0
        start()
    }

    fun showToast(answer: Int) {
        if (answer == rightAnswers[questionNo]) {
            val textView = findViewById<TextView>(R.id.textView3)
            Toast.makeText(applicationContext, "♂Right♂", Toast.LENGTH_SHORT).show()
            results += 1
            textView.text = "$results/${questions.size - 1}"
            updateQuestion()
        } else {
            Toast.makeText(applicationContext, "Jabroni", Toast.LENGTH_SHORT).show()
            updateQuestion()
        }
        if (questionNo == questions.size - 1) {
            end()
        }
    }
        fun end() {
            setContentView(R.layout.activity_end)

            val textView = findViewById<TextView>(R.id.textView3)
            val YouAre = findViewById<TextView>(R.id.textView)
            val restart = findViewById<TextView>(R.id.textView4)

            restart.setOnClickListener { restart() }

            textView.text = "$results/${questions.size-1}"

            if ((results.toDouble()/(questions.size-1).toDouble()).toDouble() in 0.5..0.85 ) {
                YouAre.text = "Ты любишь lube it up, но до dungeon master еще не дорос"
            }
            if (results.toDouble()/(questions.size-1.toDouble()).toDouble() < 0.5) {
                YouAre.text = "Ты jabroni и fucking slave"
            }
            if (results.toDouble()/(questions.size-1.toDouble()).toDouble() >= 0.85) {
                YouAre.text = "Ты настоящий Master"
            }
        }

    fun updateQuestion() {
            val textView = findViewById<TextView>(R.id.textView)
            questionNo += 1
            textView.text = questions[questionNo]

        }
    }




