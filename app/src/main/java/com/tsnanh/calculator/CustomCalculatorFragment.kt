package com.tsnanh.calculator


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_custom_calculator.*
import kotlinx.android.synthetic.main.fragment_custom_calculator.view.*
import net.objecthunter.exp4j.ExpressionBuilder

class CustomCalculatorFragment : Fragment(), View.OnClickListener {

    private var isResult: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater
                .inflate(R.layout.fragment_custom_calculator, container, false)

        val listButton = listOf(view.cBtnZero, view.cBtnOne, view.cBtnTwo,
                view.cBtnThree, view.cBtnFour, view.cBtnFive, view.cBtnSix, view.cBtnSeven,
                view.cBtnEight, view.cBtnNine, view.cBtnAdd, view.cBtnSub, view.cBtnMul,
                view.cBtnDiv, view.cBtnPercent, view.cBtnDot, view.cBtnResult, view.cBtnClear,
                view.cBtnNegative, view.cBtnDel)

        for (button in listButton) {
            button.setOnClickListener(this)
        }

        view.cBtnDel.setOnLongClickListener {
            cLblMain.text = ""
            cLblResult.text = ""
            true
        }

        return view
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.cBtnZero -> {
                addNumber("0")
            }
            R.id.cBtnOne -> {
                addNumber("1")
            }
            R.id.cBtnTwo -> {
                addNumber("2")
            }
            R.id.cBtnThree -> {
                addNumber("3")
            }
            R.id.cBtnFour -> {
                addNumber("4")
            }
            R.id.cBtnFive -> {
                addNumber("5")
            }
            R.id.cBtnSix -> {
                addNumber("6")
            }
            R.id.cBtnSeven -> {
                addNumber("7")
            }
            R.id.cBtnEight -> {
                addNumber("8")
            }
            R.id.cBtnNine -> {
                addNumber("9")
            }
            R.id.cBtnAdd -> {
                addOperator("+")
                isResult = false
            }
            R.id.cBtnSub -> {
                addOperator("-")
                isResult = false
            }
            R.id.cBtnMul -> {
                addOperator("*")
                isResult = false
            }
            R.id.cBtnDiv -> {
                addOperator("/")
                isResult = false
            }
            R.id.cBtnDel -> {
                cLblMain.text = cLblMain.text.dropLast(1)
                if (cLblMain.text.isNotEmpty()) {
                    calculate()
                } else {
                    cLblResult.text = ""
                }
            }
            R.id.cBtnClear -> {
                cLblMain.text = ""
                cLblResult.text = ""
            }
            R.id.cBtnDot -> {
                if (cLblMain.text.isEmpty()
                        || (cLblMain.text.last() == '+'
                                || cLblMain.text.last() == '-'
                                || cLblMain.text.last() == '*'
                                || cLblMain.text.last() == '/')) cLblMain.append("0.")
                else {
                    if (cLblMain.text.last() != '.') {
                        cLblMain.append(".")
                        calculate()
                    }
                }
            }
            R.id.cBtnResult -> {
                if (cLblResult.text.isNotEmpty()) {
                    cLblMain.text = cLblResult.text
                    cLblResult.text = ""
                    isResult = true
                }
            }
        }
    }

    private fun checkEach15Number(): Boolean {
        val list = cLblMain.text.split("[+*/-]".toRegex())
        val lastIndex = list.size - 1
        return if (list[lastIndex].length >= 15) {
            Toast.makeText(this.context, "Khong the nhap qua 15 chu so", Toast.LENGTH_LONG)
                    .show()
            false
        } else {
            true
        }
    }

    private fun addOperator(operator: String) {
        if (cLblMain.text.isEmpty()) return
        if (cLblMain.text[cLblMain.text.length - 1] == '+' ||
                cLblMain.text[cLblMain.text.length - 1] == '-' ||
                cLblMain.text[cLblMain.text.length - 1] == '*' ||
                cLblMain.text[cLblMain.text.length - 1] == '/' ||
                cLblMain.text[cLblMain.text.length - 1] == '.') {
            cLblMain.text = cLblMain.text.substring(0, cLblMain.text.length - 1)
        }
        cLblMain.append(operator)
    }

    private fun addNumber(num: String) {
        if (isResult) {
            cLblMain.text = ""
            isResult = false
        }
        if (checkEach15Number()) {
            cLblMain.append(num)
            calculate()
        }
    }

    private fun calculate() {
        try {
            if (cLblMain.text.last() == '+' || cLblMain.text.last() == '-'
                    || cLblMain.text.last() == '*'
                    || cLblMain.text.last() == '/') {
                return
            }
            val builder = ExpressionBuilder(cLblMain.text.toString())
            val expression = builder.build()
            cLblResult.text = MaterialCalculatorFragment.formatNumber(expression.evaluate())
        } catch (e: ArithmeticException) {
            cLblResult.text = ""
            Toast.makeText(this.context!!, "Division by zero \"9\"", Toast.LENGTH_SHORT).show()
            Log.e("MaterialCalculator", e.message!!)
        }
    }

}
