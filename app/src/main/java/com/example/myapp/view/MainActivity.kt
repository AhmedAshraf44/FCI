package com.example.myapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapp.R
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import  com.example.myapp.model.Sum
import  com.example.myapp.presenter.CalculateNumberPresenter
import  com.example.myapp.presenter.ICalculateNumbersPresenter

class MainActivity : AppCompatActivity(), CalculateNumberPresenter.View {

    lateinit var calculateAgePresenter: ICalculateNumbersPresenter

    lateinit var textViewInfo: TextView
    lateinit var editTextAge: EditText
    lateinit var editTextName: EditText
    lateinit var buttonCalculateAge: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateAgePresenter = CalculateNumberPresenter(this)

        textViewInfo = findViewById(R.id.textView_your_age)
        editTextName = findViewById(R.id.editText_name)
        editTextAge = findViewById(R.id.editText_age)
        buttonCalculateAge = findViewById(R.id.button_calculate_age)

        buttonCalculateAge.setOnClickListener {

            val num1 = editTextName.text.trim().toString()
            val num2 = editTextAge.text.trim().toString()

            calculateAgePresenter.calculateNumbers(num1, num2)
        }

    }

     override fun getInfo(sum: Sum) {
        textViewInfo.text = "result sum : ${sum.numberOne} + ${sum.numberSecond} = ${sum.result}"
    }
}