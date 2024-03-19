package com.example.myapp.presenter
import com.example.myapp.model.Sum

class CalculateNumberPresenter(private val view: View): ICalculateNumbersPresenter {


    override fun calculateNumbers(numberOne: String, numberSecond: String) {
        val  num1 = numberOne.toInt();
        val  num2 = numberOne.toInt()
        val result = num1 + num2
        val sum = Sum(num1, num2,result)
        view.getInfo(sum)
    }

    interface View{
        fun getInfo(sum: Sum)
    }
}