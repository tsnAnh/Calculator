package com.tsnanh.calculator


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_material_calculator.view.*
import net.objecthunter.exp4j.ExpressionBuilder

class MaterialCalculatorFragment : Fragment(), View.OnClickListener {

    private lateinit var lblMain: TextView
    private lateinit var lblResult: TextView

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("main", lblMain.text.toString())
        outState.putString("result", lblResult.text.toString())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_material_calculator, container, false)

        lblMain = view.lblMain
        lblResult = view.lblResult

        view.lblMain.text = savedInstanceState?.get("main") as String?
        view.lblResult.text = savedInstanceState?.get("result") as String?

        val listButton = listOf(view.btnZero, view.btnOne, view.btnTwo, view.btnThree,
                view.btnFour, view.btnFive, view.btnSix, view.btnSeven, view.btnEight, view.btnAdd,
                view.btnSub, view.btnMul, view.btnDiv, view.btnResult, view.btnDot, view.btnNine)

        for (button in listButton) {
            button.setOnClickListener(this)
        }
        return view
    }

    private fun checkEachNumber(): Boolean {
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
                if (checkEachNumber()) {
                    lblMain.append("0")
                    calculate()
                }
            }
            R.id.btnOne -> {
                if (checkEachNumber()) {
                    lblMain.append("1")
                    calculate()
                }
            }
            R.id.btnTwo -> {
                if (checkEachNumber()) {
                    lblMain.append("2")
                    calculate()
                }
            }
            R.id.btnThree -> {
                if (checkEachNumber()) {
                    lblMain.append("3")
                    calculate()
                }
            }
            R.id.btnFour -> {
                if (checkEachNumber()) {
                    lblMain.append("4")
                    calculate()
                }
            }
            R.id.btnFive -> {
                if (checkEachNumber()) {
                    lblMain.append("5")
                    calculate()
                }
            }
            R.id.btnSix -> {
                if (checkEachNumber()) {
                    lblMain.append("6")
                    calculate()
                }
            }
            R.id.btnSeven -> {
                if (checkEachNumber()) {
                    lblMain.append("7")
                    calculate()
                }
            }
            R.id.btnEight -> {
                if (checkEachNumber()) {
                    lblMain.append("8")
                    calculate()
                }
            }
            R.id.btnNine -> {
                if (checkEachNumber()) {
                    lblMain.append("9")
                    calculate()
                }
            }
            R.id.btnAdd -> {
                addOperator("+")
            }
            R.id.btnSub -> {
                addOperator("-")
            }
            R.id.btnMul -> {
                addOperator("*")
            }
            R.id.btnDiv -> {
                addOperator("/")
            }
        }
    }

    private fun calculate() {
        val builder = ExpressionBuilder(lblMain.text.toString())
        val expression = builder.build()
        lblResult.text = expression.evaluate().toString()
    }

    private fun addOperator(operator: String) {
        if (lblMain.text.isEmpty()) return
        if (lblMain.text[lblMain.text.length - 1] == '+' ||
                lblMain.text[lblMain.text.length - 1] == '-' ||
                lblMain.text[lblMain.text.length - 1] == '*' ||
                lblMain.text[lblMain.text.length - 1] == '/') {
            lblMain.text = lblMain.text.substring(0, lblMain.text.length - 1)
        }
        lblMain.append(operator)
    }

}