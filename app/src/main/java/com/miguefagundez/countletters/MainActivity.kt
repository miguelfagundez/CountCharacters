package com.miguefagundez.countletters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var tvTitle : TextView
    lateinit var etCountLetters : EditText
    lateinit var ibRefresh : ImageButton

    val textTitle = "Number of letters: "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupMembers()
        setupListener()
    }

    private fun setupMembers() {
        tvTitle = findViewById(R.id.tvTitle)
        etCountLetters = findViewById(R.id.etCountLetter)
        ibRefresh = findViewById(R.id.ibClear)
        tvTitle.setText(textTitle + "0")
    }

    private fun setupListener() {
        etCountLetters.addTextChangedListener(
            object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    var letters = etCountLetters.length().toString()
                    tvTitle.setText(textTitle + letters)
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            }
        )

        ibRefresh.setOnClickListener {
            etCountLetters.setText("")
        }
    }
}