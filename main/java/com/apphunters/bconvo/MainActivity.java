package com.apphunters.bconvo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Handler hand;
    Spinner spin;
    EditText uI;
    Checker check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = (Spinner) findViewById(R.id.spinner);
        uI = (EditText) findViewById(R.id.UI);
        hand = new Handler();
        check = new Checker(hand,uI);
    }






    public void num1(View view)
    {
        check.putText("1",spin);
    }

    public void num2(View view)
    {
        check.putText("2",spin);
    }

    public void num3(View view)
    {
        check.putText("3",spin);
    }

    public void num4(View view)
    {
        check.putText("4",spin);
    }

    public void num5(View view)
    {
        check.putText("5",spin);
    }

    public void num6(View view)
    {
        check.putText("6",spin);
    }

    public void num7(View view)
    {
        check.putText("7",spin);
    }

    public void num8(View view)
    {
        check.putText("8",spin);
    }

    public void num9(View view)
    {
        check.putText("9",spin);
    }

    public void numA(View view)
    {
        check.putText("A",spin);
    }

    public void numB(View view)
    {
        check.putText("B",spin);
    }

    public void numC(View view)
    {
        check.putText("C",spin);
    }

    public void numD(View view)
    {
        check.putText("D",spin);
    }

    public void numE(View view)
    {
        check.putText("E",spin);
    }

    public void numF(View view)
    {
        check.putText("F",spin);
    }

    public void num0(View view)
    {
        check.putText("0",spin);
    }

    public void back(View view)
    {
        check.putText("BackSpace",spin);
    }
    public void dot(View view)
    {
        check.putText(".",spin);

    }

    public void crunch(View view)
    {

        API ap = new API(uI.getText().toString(),getType());
        ap.startConversion();
        final String ans = ap.getAnswers();
        hand.post(new Runnable() {
            @Override
            public void run() {
            String[] temp = ans.split(";");
             TextView txB = (TextView) findViewById(R.id.BText);
                TextView txO = (TextView) findViewById(R.id.OText);
                TextView txD = (TextView) findViewById(R.id.DText);
                TextView txH = (TextView) findViewById(R.id.Htext);
                txB.setText(temp[0]);
                txO.setText(temp[1]);
                txD.setText(temp[2]);
                txH.setText(temp[3]);
            }
        });
    }

    public int getType()
    {
        String a = spin.getSelectedItem().toString();
        if (a.equals("Binary")) {

            return 2;
        }else if (a.equals("Octal")) {
          return 8;
        }else if (a.equals("Decimal")) {
            return 10;
        }else
        {
            return 16;
        }
    }


}
