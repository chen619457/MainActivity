package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var SaveA = 0
    var SaveB = 0
    val KEY_SAVE_A = "key_saveA"
    val KEY_SAVE_B = "key_saveB"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        read()

        button_a_add1.setOnClickListener {
            addA(1)
        }
        button_a_add2.setOnClickListener {
            addA(2)
        }
        button_a_add3.setOnClickListener {
            addA(3)
        }

        button_b_add1.setOnClickListener {
            addB(1)
        }
        button_b_add2.setOnClickListener {
            addB(2)
        }
        button_b_add3.setOnClickListener {
            addB(3)
        }

        image_button_revoke.setOnClickListener {
            revoke()
        }

        image_button_reset.setOnClickListener {
            reset()
        }
    }


    fun save() {//保存比分
        SaveA = text_score_a.text.toString().toInt()
        SaveB = text_score_b.text.toString().toInt()
        val sp = getSharedPreferences("my_sp", MODE_PRIVATE)
        sp.edit().putInt(KEY_SAVE_A, SaveA).apply()
        sp.edit().putInt(KEY_SAVE_B, SaveB).apply()
    }

    private fun read() {//读取比分
        val sp = getSharedPreferences("my_sp", MODE_PRIVATE)
        SaveA = sp.getInt(KEY_SAVE_A, 0)
        SaveB = sp.getInt(KEY_SAVE_B, 0)
        text_score_a.text = SaveA.toString()
        text_score_b.text = SaveB.toString()
    }

    fun addA(i: Int) {
        save()
        text_score_a.text = (SaveA + i).toString()
    }

    fun addB(i: Int) {
        save()
        text_score_b.text = (SaveB + i).toString()
    }

    fun revoke() {
        text_score_a.text = SaveA.toString()
        text_score_b.text = SaveB.toString()
    }

    fun reset() {
        save()
        text_score_a.text = "0"
        text_score_b.text = "0"
    }

    override fun onPause() {
        super.onPause()

    }
}