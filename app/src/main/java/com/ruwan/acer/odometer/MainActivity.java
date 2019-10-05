package com.ruwan.acer.odometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    EditText editTxt1,editTxt2,editTxt3,editTxt4;
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    int val = 0;
    String hexValue;
    int distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxt1 = (EditText) findViewById(R.id.editText1);
        editTxt2 = (EditText) findViewById(R.id.editText2);
        editTxt3 = (EditText) findViewById(R.id.editText3);
        editTxt4 = (EditText) findViewById(R.id.editText4);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);


        // calculate button1

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(editTxt1.getText().toString()))
                {
                    calculateDistance(editTxt1.getText().toString());
                }
                else
                {
                    Toast.makeText(MainActivity.this, "No empty number allowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Clear button1

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxt1.setText("");
                editTxt2.setText("");
                val = 0;
            }
        });


        //Delete button1

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(editTxt1.getText().toString()))
                {
                    String txt = editTxt1.getText().toString();
                    editTxt1.setText(txt.substring(0, txt.length()-1));
                    distance = 0;
                }
                else
                {
                    editTxt1.setText("");
                    distance = 0;
                }
            }
        });

    //******************************************************************************************************

        //calculate button2

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(editTxt3.getText().toString()))
                {
                    calculateHexValue(editTxt3.getText().toString());
                }
                else
                {
                    Toast.makeText(MainActivity.this, "No empty number allowed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Clear button2

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxt3.setText("");
                editTxt4.setText("");
                hexValue = "";
            }
        });



        //Delete button2

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(editTxt3.getText().toString()))
                {
                    String txt1 = editTxt3.getText().toString();
                    editTxt3.setText(txt1.substring(0, txt1.length()-1));
                    hexValue = "";
                }
                else
                {
                    editTxt3.setText("");
                    hexValue = "";
                }
            }
        });


    }

    void calculateDistance(String hex) {
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();


        for (int i=0; i < hex.length(); i++ )
        {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }

        distance = val * 16;

        editTxt2.setText(String.valueOf(distance));
    }


    void calculateHexValue(String  decimal)
    {
        int value = Integer.parseInt(decimal) / 16;
        int rem;
        String hex ="";

        char hexchars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while (value > 0)
        {
            rem = value % 16;
            hex = hexchars[rem] + hex;
            value = value / 16;
        }

         hexValue = hex;

        // Hex Lookup Table - HLT

        Hashtable<String, String> HLT = new Hashtable<String, String>();


        int k=0;
        while ( k < hex.length())
        {
            switch (hex.charAt(k))
            {
                case '0' :
                    hexValue = hexValue +  "F";
                    break;
                case '1' :
                    hexValue = hexValue +  "E";
                    break;
                case '2' :
                    hexValue = hexValue +  "D";
                    break;
                case '3' :
                    hexValue = hexValue +  "C";
                    break;
                case '4' :
                    hexValue = hexValue +  "B";
                    break;
                case '5' :
                    hexValue = hexValue +  "A";
                    break;
                case '6' :
                    hexValue = hexValue +  "9";
                    break;
                case '7' :
                    hexValue = hexValue +  "8";
                    break;
                case '8' :
                    hexValue = hexValue +  "7";
                    break;
                case '9' :
                    hexValue = hexValue +  "6";
                    break;
                case 'A' :
                    hexValue = hexValue +  "5";
                    break;
                case 'B' :
                    hexValue = hexValue +  "4";
                    break;
                case 'C' :
                    hexValue = hexValue +  "3";
                    break;
                case 'D' :
                    hexValue = hexValue +  "2";
                    break;
                case 'E' :
                    hexValue = hexValue +  "1";
                    break;
                case 'F' :
                    hexValue = hexValue +  "0";
                    break;

            }
            k++;
        }


        editTxt4.setText(String.valueOf(hexValue));


    }


}
