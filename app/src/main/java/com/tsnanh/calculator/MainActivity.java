package com.tsnanh.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean b = false;
    private Float var1, var2, varResult;
    private TextView twMonitor, twMonitor2, twVar;
    private Button btnClear, btnCT, btnDel, btnDiv, btnNine, btnEight, btnSeven, btnMul, btnSix, btnFive, btnFour, btnThree, btnTwo, btnOne, btnZero, btnSub, btnAdd, btnDot, btnPercent, btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twMonitor = (TextView) this.findViewById(R.id.tw_monitor);
        twMonitor2 = (TextView) this.findViewById(R.id.tw_monitor2);
        twVar = (TextView) this.findViewById(R.id.tw_v);
        btnClear = (Button) this.findViewById(R.id.btn_clear);
        btnCT = (Button) this.findViewById(R.id.btn_ct);
        btnDel = (Button) this.findViewById(R.id.btn_del);
        btnDiv = (Button) this.findViewById(R.id.btn_div);
        btnNine = (Button) this.findViewById(R.id.btn_nine);
        btnEight = (Button) this.findViewById(R.id.btn_eight);
        btnSeven = (Button) this.findViewById(R.id.btn_seven);
        btnSix = (Button) this.findViewById(R.id.btn_six);
        btnFive = (Button) this.findViewById(R.id.btn_five);
        btnFour = (Button) this.findViewById(R.id.btn_four);
        btnThree = (Button) this.findViewById(R.id.btn_three);
        btnTwo = (Button) this.findViewById(R.id.btn_two);
        btnOne = (Button) this.findViewById(R.id.btn_one);
        btnMul = (Button) this.findViewById(R.id.btn_mul);
        btnZero = (Button) this.findViewById(R.id.btn_zero);
        btnSub = (Button) this.findViewById(R.id.btn_sub);
        btnAdd = (Button) this.findViewById(R.id.btn_add);
        btnDot = (Button) this.findViewById(R.id.btn_dot);
        btnPercent = (Button) this.findViewById(R.id.btn_percent);
        btnResult = (Button) this.findViewById(R.id.btn_result);

        btnClear.setOnClickListener(this);
        btnCT.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    public void setVar1(Float var1) {
        this.var1 = var1;
    }

    public void setVar2(Float var2) {
        this.var2 = var2;
    }

    public void setVarResult(Float varTemp) {
        this.varResult = varTemp;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_zero) {
            if (b) {
                twMonitor.setText("");
            }
            twMonitor.setText(twMonitor.getText() + "0");
            b = false;
        }
        if (id == R.id.btn_one) {
            if (b) {
                twMonitor.setText("");
            }
            twMonitor.setText(twMonitor.getText() + "1");
            b = false;
        }
        if (id == R.id.btn_two) {
            if (b) {
                twMonitor.setText("");
            }
            twMonitor.setText(twMonitor.getText() + "2");
            b = false;
        }
        if (id == R.id.btn_three) {
            if (b) {
                twMonitor.setText("");
            }
            twMonitor.setText(twMonitor.getText() + "3");
            b = false;
        }
        if (id == R.id.btn_four) {
            if (b) {
                twMonitor.setText("");
            }
            twMonitor.setText(twMonitor.getText() + "4");
            b = false;
        }
        if (id == R.id.btn_five) {
            if (b) {
                twMonitor.setText("");
            }
            twMonitor.setText(twMonitor.getText() + "5");
            b = false;
        }
        if (id == R.id.btn_six) {
            if (b) {
                twMonitor.setText("");
            }
            twMonitor.setText(twMonitor.getText() + "6");
            b = false;
        }
        if (id == R.id.btn_seven) {
            if (b) {
                twMonitor.setText("");
            }
            twMonitor.setText(twMonitor.getText() + "7");
            b = false;
        }
        if (id == R.id.btn_eight) {
            if (b) {
                twMonitor.setText("");
            }
            twMonitor.setText(twMonitor.getText() + "8");
            b = false;
        }
        if (id == R.id.btn_nine) {
            if (b) {
                twMonitor.setText("");
            }
            twMonitor.setText(twMonitor.getText() + "9");
            b = false;
        }
        if (id == R.id.btn_add) {
            if (!twMonitor.getText().toString().isEmpty()) {
                if (!twMonitor.getText().toString().isEmpty() && !twMonitor2.getText().toString().isEmpty()) {
                    result(1);
                    twVar.setText("+");
                    setVar1(varResult);
                } else if (var1 == null) {
                    String monitorVal = twMonitor.getText().toString();
                    Log.i("", monitorVal);
                    setVar1(Float.parseFloat(monitorVal));
                    twMonitor2.setText(monitorVal);
                    twMonitor.setText("");
                    twVar.setText("+");
                } else if (var2==null) {
                    setVar2(Float.parseFloat(twMonitor.getText().toString()));
                    varResult = var1 + var2;
                    twMonitor2.setText(String.valueOf(format(varResult)));
                    twMonitor.setText("");
                    setVar1(varResult);
                    twVar.setText("+");
                }
            } else {
                twMonitor.append("");
                twVar.setText("+");
            }
            b = false;
        }
        if (id == R.id.btn_sub) {
            if (!twMonitor.getText().toString().isEmpty()) {
                if (!twMonitor.getText().toString().isEmpty() && !twMonitor2.getText().toString().isEmpty()) {
                    result(1);
                    twVar.setText("-");
                    setVar1(varResult);
                } else if (var1 == null) {
                    String monitorVal = twMonitor.getText().toString();
                    Log.i("", monitorVal);
                    setVar1(Float.parseFloat(monitorVal));
                    twMonitor2.setText(monitorVal);
                    twMonitor.setText("");
                    twVar.setText("-");
                } else if (var2==null) {
                    setVar2(Float.parseFloat(twMonitor.getText().toString()));
                    varResult = var1 - var2;
                    twMonitor2.setText(String.valueOf(format(varResult)));
                    twMonitor.setText("");
                    setVar1(varResult);
                    twVar.setText("-");
                }
            } else {
                twMonitor.append("");
                twVar.setText("-");
            }
            b = false;
        }
        if (id == R.id.btn_mul) {
            if (!twMonitor.getText().toString().isEmpty()) {
                if (!twMonitor.getText().toString().isEmpty() && !twMonitor2.getText().toString().isEmpty()) {
                    result(1);
                    twVar.setText("*");
                    setVar1(varResult);
                } else if (var1 == null) {
                    String monitorVal = twMonitor.getText().toString();
                    Log.i("", monitorVal);
                    setVar1(Float.parseFloat(monitorVal));
                    twMonitor2.setText(monitorVal);
                    twMonitor.setText("");
                    twVar.setText("*");
                } else if (var2==null) {
                    setVar2(Float.parseFloat(twMonitor.getText().toString()));
                    varResult = var1 * var2;
                    twMonitor2.setText(String.valueOf(format(varResult)));
                    twMonitor.setText("");
                    setVar1(varResult);
                    twVar.setText("*");
                }
            } else {
                twMonitor.append("");
                twVar.setText("*");
            }
            b = false;
        }
        if (id == R.id.btn_div) {
            if (!twMonitor.getText().toString().isEmpty()) {
                if (!twMonitor.getText().toString().isEmpty() && !twMonitor2.getText().toString().isEmpty()) {
                    result(1);
                    twVar.setText("/");
                    setVar1(varResult);
                } else if (var1 == null) {
                    String monitorVal = twMonitor.getText().toString();
                    Log.i("", monitorVal);
                    setVar1(Float.parseFloat(monitorVal));
                    twMonitor2.setText(monitorVal);
                    twMonitor.setText("");
                    twVar.setText("/");
                } else if (var2==null) {
                    setVar2(Float.parseFloat(twMonitor.getText().toString()));
                    varResult = var1 / var2;
                    twMonitor2.setText(String.valueOf(format(varResult)));
                    twMonitor.setText("");
                    setVar1(varResult);
                    twVar.setText("/");
                }
            } else {
                twMonitor.append("");
                twVar.setText("/");
            }
            b = false;
        }
        if (id == R.id.btn_result) {
            result(0);
            setVar1(null);
            b = true;
        }
        if (id == R.id.btn_clear) {
            setVar1(null);
            setVar2(null);
            twVar.setText("");
            twMonitor2.setText("");
            twMonitor.setText("");
            b = false;
        }
        if (id == R.id.btn_del) {
            if (!twMonitor.getText().toString().isEmpty()) {
                twMonitor.setText(twMonitor.getText().toString().substring(0, twMonitor.getText().length() - 1));
            }
        }
    }

    public static String format(float d)
    {
        if(d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }

    public void result(int i) {
        if (i == 0) {
            String pt = twVar.getText().toString();
            if (twMonitor.getText().toString().isEmpty()) {
                twMonitor.setText(twMonitor2.getText().toString());
                twVar.setText("");
                twMonitor2.setText("");
            } else if (twMonitor2.getText().toString().isEmpty()) {
                twVar.setText("");
            } else {
                setVar1(Float.parseFloat(twMonitor2.getText().toString()));
                setVar2(Float.parseFloat(twMonitor.getText().toString()));
                if (pt == "+") {
                    varResult = var1 + var2;
                    twMonitor.setText(String.valueOf(format(varResult)));
                    twVar.setText("");
                    twMonitor2.setText("");
                } else if (pt == "-") {
                    varResult = var1 - var2;
                    twMonitor.setText(String.valueOf(format(varResult)));
                    twVar.setText("");
                    twMonitor2.setText("");
                } else if (pt == "*") {
                    varResult = var1 * var2;
                    twMonitor.setText(String.valueOf(format(varResult)));
                    twVar.setText("");
                    twMonitor2.setText("");
                } else if (pt == "/") {
                    varResult = var1 / var2;
                    twMonitor.setText(String.valueOf(format(varResult)));
                    twVar.setText("");
                    twMonitor2.setText("");
                }
            }
        } else if (i == 1) {
            String pt = twVar.getText().toString();
            if (twMonitor.getText().toString().isEmpty()) {
                twMonitor.setText(twMonitor2.getText().toString());
                twVar.setText("");
                twMonitor2.setText("");
            } else if (twMonitor2.getText().toString().isEmpty()) {
                twVar.setText("");
            } else {
                setVar1(Float.parseFloat(twMonitor2.getText().toString()));
                setVar2(Float.parseFloat(twMonitor.getText().toString()));
                if (pt == "+") {
                    varResult = var1 + var2;
                    twMonitor2.setText(String.valueOf(format(varResult)));
                    twVar.setText("");
                    twMonitor.setText("");
                } else if (pt == "-") {
                    varResult = var1 - var2;
                    twMonitor2.setText(String.valueOf(format(varResult)));
                    twVar.setText("");
                    twMonitor.setText("");
                } else if (pt == "*") {
                    varResult = var1 * var2;
                    twMonitor2.setText(String.valueOf(format(varResult)));
                    twVar.setText("");
                    twMonitor.setText("");
                } else if (pt == "/") {
                    varResult = var1 / var2;
                    twMonitor2.setText(String.valueOf(format(varResult)));
                    twVar.setText("");
                    twMonitor.setText("");
                }
            }
        }
    }
}
