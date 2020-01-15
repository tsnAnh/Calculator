package com.tsnanh.calculator


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_material_calculator.view.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat

class MaterialCalculatorFragment : Fragment(), View.OnClickListener {

    private var isResult: Boolean = false
    private lateinit var lblMain: TextView
    private lateinit var lblResult: TextView

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("main", lblMain.text.toString())
        outState.putString("result", lblResult.text.toString())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        lblMain.text = savedInstanceState?.get("main") as String?
        lblResult.text = savedInstanceState?.get("result") as String?
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater
                .inflate(R.layout.fragment_material_calculator, container, false)

        lblMain = view.lblMain
        lblResult = view.lblResult

        val listButton = listOf(view.btnZero, view.btnOne, view.btnTwo, view.btnThree,
                view.btnFour, view.btnFive, view.btnSix, view.btnSeven, view.btnEight, view.btnAdd,
                view.btnSub, view.btnMul, view.btnDiv, view.btnResult, view.btnDot, view.btnNine,
                view.btnDelete)

        for (button in listButton) {
            button.setOnClickListener(this)
            if (button == view.btnDelete) {
                button.setOnLongClickListener {
                    lblMain.text = ""
                    lblResult.text = ""
                    true
                }
            }
        }
        return view
    }

    private fun checkEach15Number(): Boolean {
        val list = lblMain.text.split("[+*/-]".toRegex())
        val lastIndex = list.size - 1
        return if (list[lastIndex].length >= 15) {
            Toast.makeText(this.context, "Khong the nhap qua 15 chu so", Toast.LENGTH_LONG)
                    .show()
            false
        } else {
            true
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnZero -> {
                addNumber("0")
            }
            R.id.btnOne -> {
                addNumber("1")
            }
            R.id.btnTwo -> {
                addNumber("2")
            }
            R.id.btnThree -> {
                addNumber("3")
            }
            R.id.btnFour -> {
                addNumber("4")
            }
            R.id.btnFive -> {
                addNumber("5")
            }
            R.id.btnSix -> {
                addNumber("6")
            }
            R.id.btnSeven -> {
                addNumber("7")
            }
            R.id.btnEight -> {
                addNumber("8")
            }
            R.id.btnNine -> {
                addNumber("9")
            }
            R.id.btnAdd -> {
                addOperator("+")
                isResult = false
            }
            R.id.btnSub -> {
                addOperator("-")
                isResult = false
            }
            R.id.btnMul -> {
                addOperator("*")
                isResult = false
            }
            R.id.btnDiv -> {
                addOperator("/")
                isResult = false
            }
            R.id.btnDelete -> {
                lblMain.text = lblMain.text.dropLast(1)
                if (lblMain.text.isNotEmpty()) {
                    calculate()
                } else {
                    lblResult.text = ""
                }
            }
            R.id.btnDot -> {
                if (lblMain.text.isEmpty()
                        || (lblMain.text.last() == '+'
                                || lblMain.text.last() == '-'
                                || lblMain.text.last() == '*'
                                || lblMain.text.last() == '/')) lblMain.append("0.")
                else {
                    if (lblMain.text.last() != '.') {
                        lblMain.append(".")
                        calculate()
                    }
                }
            }
            R.id.btnResult -> {
                if (lblResult.text.isNotEmpty()) {
                    lblMain.text = lblResult.text
                    lblResult.text = ""
                    isResult = true
                }
            }
        }
    }

    private fun addNumber(num: String) {
        if (isResult) {
            lblMain.text = ""
            isResult = false
        }
        if (checkEach15Number()) {
            lblMain.append(num)
            calculate()
        }
    }

    private fun formatNumber(number: Double): String {
        val decimalFormat = DecimalFormat("###.##")
        return decimalFormat.format(number)
    }

    private fun calculate() {
        try {
            if (lblMain.text.last() == '+' || lblMain.text.last() == '-'
                    || lblMain.text.last() == '*'
                    || lblMain.text.last() == '/') {
                return
            }
            val builder = ExpressionBuilder(lblMain.text.toString())
            val expression = builder.build()
            lblResult.text = formatNumber(expression.evaluate())
        } catch (e: ArithmeticException) {
            lblResult.text = ""
            Toast.makeText(this.context!!, "Division by zero \"9\"", Toast.LENGTH_SHORT).show()
            Log.e("MaterialCalculator", e.message!!)
        }
    }

    private fun addOperator(operator: String) {
        if (lblMain.text.isEmpty()) return
        if (lblMain.text[lblMain.text.length - 1] == '+' ||
                lblMain.text[lblMain.text.length - 1] == '-' ||
                lblMain.text[lblMain.text.length - 1] == '*' ||
                lblMain.text[lblMain.text.length - 1] == '/' ||
                lblMain.text[lblMain.text.length - 1] == '.') {
            lblMain.text = lblMain.text.substring(0, lblMain.text.length - 1)
        }
        lblMain.append(operator)
    }

}