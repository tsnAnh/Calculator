package com.tsnanh.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_ios_calculator.view.*
import java.text.DecimalFormat


class IOSCalculatorFragment : Fragment(), View.OnClickListener {

    private var b: Boolean = false
    private lateinit var twMonitor: TextView
    private lateinit var twVar: TextView
    private lateinit var twMonitor2: TextView

    private var varResult: Float? = null
    private var var1: Float? = null
    private var var2: Float? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =
                inflater.inflate(R.layout.fragment_ios_calculator, container, false)

        val listButton = listOf(view.btn_zero, view.btn_one, view.btn_two, view.btn_three,
                view.btn_four, view.btn_five, view.btn_seven, view.btn_six, view.btn_eight,
                view.btn_nine, view.btn_add, view.btn_sub, view.btn_mul, view.btn_div, view.btn_ct,
                view.btn_clear, view.btn_result, view.btn_dot, view.btn_del, view.btn_percent,
                view.btn_ct)

        twMonitor = view.tw_monitor
        twMonitor2 = view.tw_monitor2
        twVar = view.tw_v

        for (button in listButton) {
            button.setOnClickListener(this)
        }

        view.btn_del.setOnLongClickListener {
            view.tw_monitor.text = ""
            view.tw_monitor2.text = ""
            view.tw_v.text = ""
            true
        }

        return view
    }

    private fun result(i: Int) {
        if (i == 0) {
            val pt: String = twVar.text.toString()
            when {
                twMonitor.text.toString().isEmpty() -> {
                    twMonitor.text = twMonitor2.text.toString()
                    twVar.text = ""
                    twMonitor2.text = ""
                }
                twMonitor2.text.toString().isEmpty() -> {
                    twVar.text = ""
                }
                else -> {
                    var1 = twMonitor2.text.toString().toFloat()
                    var2 = twMonitor.text.toString().toFloat()
                    when {
                        pt === "+" -> {
                            varResult = var1!! + var2!!
                            twMonitor.text = java.lang.String.valueOf(format(varResult!!))
                            twVar.text = ""
                            twMonitor2.text = ""
                        }
                        pt === "-" -> {
                            varResult = var1!! - var2!!
                            twMonitor.text = java.lang.String.valueOf(format(varResult!!))
                            twVar.text = ""
                            twMonitor2.text = ""
                        }
                        pt === "*" -> {
                            varResult = var1!! * var2!!
                            twMonitor.text = java.lang.String.valueOf(format(varResult!!))
                            twVar.text = ""
                            twMonitor2.text = ""
                        }
                        pt === "/" -> {
                            if (var2 == 0F) {
                                Toast.makeText(this.activity!!, "Division by zero 9",
                                        Toast.LENGTH_SHORT)
                                        .show()
                                return
                            }
                            varResult = var1!! / var2!!
                            twMonitor.text = java.lang.String.valueOf(format(varResult!!))
                            twVar.text = ""
                            twMonitor2.text = ""
                        }
                    }
                }
            }
        } else if (i == 1) {
            val pt: String = twVar.text.toString()
            when {
                twMonitor.text.toString().isEmpty() -> {
                    twMonitor.text = twMonitor2.text.toString()
                    twVar.text = ""
                    twMonitor2.text = ""
                }
                twMonitor2.text.toString().isEmpty() -> {
                    twVar.text = ""
                }
                else -> {
                    var1 = twMonitor2.text.toString().toFloat()
                    var2 = twMonitor.text.toString().toFloat()
                    when (pt) {
                        "+" -> {
                            varResult = var1!! + var2!!
                            twMonitor2.text = java.lang.String.valueOf(format(varResult!!))
                            twVar.text = ""
                            twMonitor.text = ""
                        }
                        "-" -> {
                            varResult = var1!! - var2!!
                            twMonitor2.text = java.lang.String.valueOf(format(varResult!!))
                            twVar.text = ""
                            twMonitor.text = ""
                        }
                        "*" -> {
                            varResult = var1!!.times(var2!!)
                            twMonitor2.text = java.lang.String.valueOf(format(varResult!!))
                            twVar.text = ""
                            twMonitor.text = ""
                        }
                        "/" -> {
                            if (var2 == 0F) {
                                Toast.makeText(this.activity!!, "Division by zero 9",
                                        Toast.LENGTH_SHORT)
                                        .show()
                                return
                            }
                            varResult = var1!!.div(var2!!)
                            twMonitor2.text = java.lang.String.valueOf(format(varResult!!))
                            twVar.text = ""
                            twMonitor.text = ""
                        }
                    }
                }
            }
        }
    }

    private fun format(d: Float): String {
        val decimalFormat = DecimalFormat("###.##")
        return decimalFormat.format(d)
    }

    override fun onClick(v: View?) {
        val id = v!!.id
        if (id == R.id.btn_dot) {
            if (twMonitor.text.isEmpty()
                    || (twMonitor.text.last() == '+'
                            || twMonitor.text.last() == '-'
                            || twMonitor.text.last() == '*'
                            || twMonitor.text.last() == '/')) twMonitor.text = "0."
            else {
                if (twMonitor.text.last() != '.') {
                    twMonitor.append(".")
                }
            }
        }
        if (id == R.id.btn_percent) {
            if (twMonitor.text.isNotEmpty()) {
                if (twMonitor.text.last() == '+'
                        || twMonitor.text.last() == '-'
                        || twMonitor.text.last() == '*'
                        || twMonitor.text.last() == '/'
                        || twMonitor.text.last() == '.') {
                    Toast.makeText(this.activity!!, "Syntax Error", Toast.LENGTH_LONG).show()
                } else {
                    val result = twMonitor.text.toString().toFloat() / 100
                    twMonitor.text = result.toString()
                }
            }
        }
        if (id == R.id.btn_zero) {
            if (b) {
                twMonitor.text = ""
            }
            twMonitor.append("0")
            b = false
        }
        if (id == R.id.btn_one) {
            if (b) {
                twMonitor.text = ""
            }
            twMonitor.append("1")
            b = false
        }
        if (id == R.id.btn_two) {
            if (b) {
                twMonitor.text = ""
            }
            twMonitor.append("2")
            b = false
        }
        if (id == R.id.btn_three) {
            if (b) {
                twMonitor.text = ""
            }
            twMonitor.append("3")
            b = false
        }
        if (id == R.id.btn_four) {
            if (b) {
                twMonitor.text = ""
            }
            twMonitor.append("4")
            b = false
        }
        if (id == R.id.btn_five) {
            if (b) {
                twMonitor.text = ""
            }
            twMonitor.append("5")
            b = false
        }
        if (id == R.id.btn_six) {
            if (b) {
                twMonitor.text = ""
            }
            twMonitor.append("6")
            b = false
        }
        if (id == R.id.btn_seven) {
            if (b) {
                twMonitor.text = ""
            }
            twMonitor.append("7")
            b = false
        }
        if (id == R.id.btn_eight) {
            if (b) {
                twMonitor.text = ""
            }
            twMonitor.append("8")
            b = false
        }
        if (id == R.id.btn_nine) {
            if (b) {
                twMonitor.text = ""
            }
            twMonitor.append("9")
            b = false
        }
        if (id == R.id.btn_add) {
            if (twMonitor.text.toString().isNotEmpty()) {
                if (twMonitor.text.toString().isNotEmpty() && twMonitor2.text.toString().isNotEmpty()) {
                    result(1)
                    twVar.text = "+"
                    var1 = varResult
                } else if (var1 == null) {
                    val monitorVal = twMonitor.text.toString()
                    var1 = monitorVal.toFloat()
                    twMonitor2.text = monitorVal
                    twMonitor.text = ""
                    twVar.text = "+"
                } else if (var2 == null) {
                    var2 = twMonitor.text.toString().toFloat()
                    varResult = var1!! + var2!!
                    twMonitor2.text = format(varResult!!)
                    twMonitor.text = ""
                    var1 = varResult
                    twVar.text = "+"
                }
            } else {
                twMonitor.append("")
                twVar.text = "+"
            }
            b = false
        }
        if (id == R.id.btn_sub) {
            if (twMonitor.text.toString().isNotEmpty()) {
                if (twMonitor.text.toString().isNotEmpty()
                        && twMonitor2.text.toString().isNotEmpty()) {
                    result(1)
                    twVar.text = "-"
                    var1 = varResult
                } else if (var1 == null) {
                    val monitorVal = twMonitor.text.toString()
                    var1 = monitorVal.toFloat()
                    twMonitor2.text = monitorVal
                    twMonitor.text = ""
                    twVar.text = "-"
                } else if (var2 == null) {
                    var2 = twMonitor.text.toString().toFloat()
                    varResult = var1!! - var2!!
                    twMonitor2.text = format(varResult!!)
                    twMonitor.text = ""
                    var1 = varResult
                    twVar.text = "-"
                }
            } else {
                twMonitor.append("")
                twVar.text = "-"
            }
            b = false
        }
        if (id == R.id.btn_mul) {
            if (twMonitor.text.toString().isNotEmpty()) {
                if (twMonitor.text.toString().isNotEmpty()
                        && twMonitor2.text.toString().isNotEmpty()) {
                    result(1)
                    twVar.text = "*"
                    var1 = varResult
                } else if (var1 == null) {
                    val monitorVal = twMonitor.text.toString()
                    var1 = monitorVal.toFloat()
                    twMonitor2.text = monitorVal
                    twMonitor.text = ""
                    twVar.text = "*"
                } else if (var2 == null) {
                    var2 = twMonitor.text.toString().toFloat()
                    varResult = var1!! * var2!!
                    twMonitor2.text = format(varResult!!)
                    twMonitor.text = ""
                    var1 = varResult
                    twVar.text = "*"
                }
            } else {
                twMonitor.append("")
                twVar.text = "*"
            }
            b = false
        }
        if (id == R.id.btn_div) {
            if (twMonitor.text.toString().isNotEmpty()) {
                if (twMonitor.text.toString().isNotEmpty()
                        && twMonitor2.text.toString().isNotEmpty()) {
                    result(1)
                    twVar.text = "/"
                    var1 = varResult
                } else if (var1 == null) {
                    val monitorVal = twMonitor.text.toString()
                    var1 = monitorVal.toFloat()
                    twMonitor2.text = monitorVal
                    twMonitor.text = ""
                    twVar.text = "/"
                } else if (var2 == null) {
                    var2 = twMonitor.text.toString().toFloat()
                    varResult = var1!! / var2!!
                    twMonitor2.text = format(varResult!!)
                    twMonitor.text = ""
                    var1 = varResult
                    twVar.text = "/"
                }
            } else {
                twMonitor.append("")
                twVar.text = "/"
            }
            b = false
        }
        if (id == R.id.btn_result) {
            result(0)
            var1 = null
            b = true
        }
        if (id == R.id.btn_clear) {
            var1 = null
            var2 = null
            twVar.text = ""
            twMonitor2.text = ""
            twMonitor.text = ""
            b = false
        }
        if (id == R.id.btn_del) {
            if (twMonitor.text.toString().isNotEmpty()) {
                twMonitor.text = twMonitor.text.toString().substring(0, twMonitor.text.length - 1)
            }
        }
    }
}
