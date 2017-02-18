package com.apphunters.bconvo;

import android.os.Handler;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * Created by sean on 1/19/17.
 */

public class Checker {
    Handler hand;
    EditText uI;
    StringBuilder build;



    public Checker(Handler h,EditText e)
    {
        hand = h;
        uI = e;
        build = new StringBuilder();
    }


    public void putText(String num, Spinner spin) {

        String a = spin.getSelectedItem().toString();
        if (a.equals("Binary")) {

            try
            {
                int numI = Integer.parseInt(num);
                if (numI == 1 || numI == 0) {
                    DisplayText(num);
                }
            }catch(NumberFormatException e)
            {

            }
        }

        if (a.equals("Octal")) {
            try
            {
                int numI = Integer.parseInt(num);
                if (numI > -1 && numI < 8) {
                    DisplayText(num);
                }
            }catch(NumberFormatException e)
            {

            }
        }

        if (a.equals("Decimal")) {
            try
            {
                int numI = Integer.parseInt(num);
                if (numI > -1 && numI < 10) {
                    DisplayText(num);
                }
            }catch(NumberFormatException e)
            {

            }
        }

        if (a.equals("Hexa"))
        {
            DisplayText(num);
        }

        if(num.equals("."))
        {

            Displaydot(".");
        }

        if(num.equals("BackSpace"))
        {
            BackText();
        }






    }

    public void DisplayText(String num)
    {
        final String number = num;
        hand.post(new Runnable() {
            @Override
            public void run() {

                build = null;
                build = new StringBuilder();
                build.append(uI.getText().toString());
                String temp = build.toString();
                if(temp.contains("P"))
                {

                    build.delete(0,build.length());
                }
                build.append(number);
                uI.setText(build.toString());

            }
        });

    }

    public void Displaydot(String num)
    {
        final String number = num;
        hand.post(new Runnable() {
            @Override
            public void run() {
                build = null;
                build = new StringBuilder();
                build.append(uI.getText().toString());
                String temp = build.toString();
                if(temp.contains("P"))
                {

                    build.delete(0,build.length());
                }
                if(temp.contains("."))
                {

                }else {
                    build.append(number);
                    uI.setText(build.toString());
                }

            }
        });

    }

    public void BackText()
    {

        hand.post(new Runnable() {
            @Override
            public void run() {
                build = null;
                build = new StringBuilder();

                String temp = uI.getText().toString();
                if(temp.indexOf('S')!=-1)
                {
                    temp = temp.substring(0,temp.length()-9);
                }
                //java.lang.System.out.println( temp+"  "+temp.length());
                build.append(temp);
                if(temp.contains("P"))
                {



                }else if(temp.isEmpty())
                {

                }else
                {

                        build.deleteCharAt(build.length()-1);

                        if(build.toString().isEmpty())
                        {
                            uI.setText("Please use key pad");
                        }else{

                        uI.setText(build.toString());
                        }

                }


            }
        });

    }


}
