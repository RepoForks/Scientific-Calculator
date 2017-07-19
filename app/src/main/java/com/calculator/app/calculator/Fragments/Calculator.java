package com.calculator.app.calculator.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.calculator.app.calculator.R;

/**
 * Created by Home on 2017-07-18.
 */

public class Calculator extends Fragment implements View.OnClickListener {
    TextView result;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAdd,btnSub,btnMult,btnDiv,clear,dot,btn_result;
    public double x,y,z;
    public static String c = "";
    Fragment Calculator;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.calculator,container,false) ;


        result =   v.findViewById(R.id.result);
        clear  =   v.findViewById(R.id.clear);
        btnAdd =   v.findViewById(R.id.btnAdd);
        btnSub =   v.findViewById(R.id.btnSub);
        btnMult=   v.findViewById(R.id.btnMult);
        btnDiv =   v.findViewById(R.id.btnDiv);
        btn_result =   v.findViewById(R.id.btn_result);


        dot    =   v.findViewById(R.id.dot);
        btn0 =   v.findViewById(R.id.btn0);
        btn1 =   v.findViewById(R.id.btn1);
        btn2 =   v.findViewById(R.id.btn2);
        btn3 =   v.findViewById(R.id.btn3);
        btn4 =   v.findViewById(R.id.btn4);
        btn5 =   v.findViewById(R.id.btn5);
        btn6 =   v.findViewById(R.id.btn6);
        btn7 =   v.findViewById(R.id.btn7);
        btn8 =   v.findViewById(R.id.btn8);
        btn9 =   v.findViewById(R.id.btn9);



        btn_result.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        clear.setOnClickListener(this);

        dot.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {



        if(v.getId()== R.id.btn_result ||
                v.getId()== R.id.btnAdd||
                v.getId()== R.id.btnDiv||
                v.getId()== R.id.btnSub||
                v.getId()== R.id.btnMult||
                v.getId()== R.id.clear)
        {
            switch_case(v);
        }else{
            pop(v);
        }

    }
    public void switch_case(View v)
    {
        switch (v.getId()) {
            case  R.id.btnAdd:
                x = Double.parseDouble(result.getText().toString());
                result.setText("");
                c = "+";
                break;
            case  R.id.btnSub:
                x = Double.parseDouble(result.getText().toString());
                result.setText("");
                c = "-";
                break;
            case  R.id.btnMult:
                x = Double.parseDouble(result.getText().toString());
                result.setText("");
                c = "*";
                break;
            case  R.id.btnDiv:
                x = Double.parseDouble(result.getText().toString());
                result.setText("");
                c = "/";
                break;

            case  R.id.btn_result:
                y = Double.parseDouble(result.getText().toString());
                result.setText("");
                if(c.toString().equals("-"))
                {
                    z = x-y;
                    result.setText(String.valueOf(String.format("%d",(long)z)));
                }else if(c.toString().equals("+"))
                {
                    z = x+y;
                    result.setText(String.valueOf(String.format("%d",(long)z)));
                }else if(c.toString().equals("*"))
                {
                    z = x*y;
                    result.setText(String.valueOf(String.format("%d",(long)z)));
                }
                else if(c.toString().equals("/"))
                {
                    z = x/y;
                    result.setText(String.valueOf(String.format("%d",(long)z)));
                }

                break;

            case  R.id.clear:
                result.setText("");
                break;

            default:
                break;
        }
    }

    public void pop(View v)
    {
        if(result.getText().toString().equals("0")) {
            result.setText("");
            Button b = (Button) v;
            String buttonText = b.getText().toString();
            result.append(buttonText);
        }else {
            Button b = (Button) v;
            String buttonText = b.getText().toString();
            result.append(buttonText);
        }
    }
}
