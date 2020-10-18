package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.TextClassifierEvent;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Button b1;
    public Button b2;
    public Button b3;
    public Button b4;
    public Button b5;
    public Button b6;
    public Button b7;
    public Button b8;
    public Button b9;
    public Button b0;
    public Button ba;public Button bs;
    public Button bdi;
    public Button bm;public Button bde;public Button ans;public Button dot;public Button bc;public Button br;public Button bp;
    public TextView res;
    public TextView exp;
    public double total;
    public int l=0;
    public ArrayList<Double> val=new ArrayList<>();
    public ArrayList<Character> s=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  setup();

            b0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"0");
                }
            });
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"1");
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"2");
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"3");
                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"4");
                }
            });
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"5");
                }
            });
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"6");
                }
            });
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"7");
                }
            });
            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"8");
                }
            });
            b9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"9");
                }
            });
            dot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+".");
                }
            });
            ba.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString() + "+");
                }
            });
            bs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"-");
                }
            });
            bm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString() + "X");
                }
            });
            bdi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"÷");
                }
            });
            bp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString()+"^");
                }
            });
            br.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(exp.getText().toString() + "√");
                }
            });
            bc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exp.setText(null);
                    res.setText(null);
                    l=0;
                    val.clear();
                    s.clear();
                    total=0;
                }
            });
            bde.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(exp.getText().toString().length()!=0&&exp.getText().toString()!="Error")
                        exp.setText(exp.getText().toString().substring(0,exp.getText().toString().length()-1));
                    else {
                        res.setText(null);
                        l=0;
                        val.clear();
                        s.clear();
                        total=0;
                    }

                }
            });
            ans.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    givingValue();
                    if (exp.getText()!="Error") {
                        calculate();
                        exp.setText(String.valueOf(val.get(0)));
                        res.setText("=" + String.valueOf(val.get(0)));
                    }
                }
            });

    }
    public void setup(){

        b0=(Button)findViewById(R.id.b0);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        ba=(Button)findViewById(R.id.ba);
        bs=(Button)findViewById(R.id.bs);
        bm=(Button)findViewById(R.id.bm);
        bc=(Button)findViewById(R.id.bc);
        br=(Button)findViewById(R.id.br);
        bp=(Button)findViewById(R.id.bp);
        bdi=(Button)findViewById(R.id.bdi);
        bde=(Button)findViewById(R.id.bde);
        ans=(Button)findViewById(R.id.ans);
        dot=(Button)findViewById(R.id.dot);
        res=(TextView)findViewById(R.id.res);
        exp=(TextView)findViewById(R.id.exp);
        }
    public void givingValue(){
        byte i;
        for (i=1;i<exp.getText().toString().length();i++){

            if (total==1&&(exp.getText().toString().charAt(i)=='X'||exp.getText().toString().charAt(i)=='+'
                    ||exp.getText().toString().charAt(i)=='-'||exp.getText().toString().charAt(i)=='^'
                    ||exp.getText().toString().charAt(i)=='÷'||exp.getText().toString().length()==i+1)){
                root(i);
                if (exp.getText().toString().length()!=i+1)
                    s.add(exp.getText().toString().charAt(i));
                total=0;
            }
            else if ((exp.getText().toString().charAt(i)=='-'||exp.getText().toString().charAt(i)=='+')
                    &&(exp.getText().toString().charAt(i-1)=='X'
                    ||exp.getText().toString().charAt(i-1)=='+'
                    ||exp.getText().toString().charAt(i-1)=='-'||exp.getText().toString().charAt(i-1)=='^'
                    ||exp.getText().toString().charAt(i-1)=='÷')){
                continue;
            }
            else if (exp.getText().toString().charAt(i)=='X'||exp.getText().toString().charAt(i)=='+'
                    ||exp.getText().toString().charAt(i)=='-'||exp.getText().toString().charAt(i)=='^'
                    ||exp.getText().toString().charAt(i)=='÷'){
                if (l!=i){

                    val.add(Double.parseDouble(exp.getText().toString().substring(l,i)));
                    s.add(exp.getText().toString().charAt(i));
                }
                else{
                    exp.setText("Error");
                }

                l=i+1;
            }
            else if (exp.getText().toString().charAt(i)=='√'){
                total=1;
                l=i+1;
            }

        }
        //For last input    ....,.....,,,,,,,...........V
        try {

            val.add(Double.parseDouble(exp.getText().toString().substring(l,i)));
        }
        catch (NumberFormatException e){
            exp.setText("Error");
        }
        // ends................... ................,,,,,,,
    }
    public void  root(byte x){
        if (exp.getText().toString().length()==x+1)
            x= (byte) (x+1);
        try {

            total=Math.sqrt(Double.parseDouble(exp.getText().toString().substring(l,x)));
            val.add(total);
        }
        catch (Exception e){
            exp.setText("Error");
        }

    }
    public void calculate(){
        for (int i=1;i<=3;i++){
            for (int j=0;j<s.size();j++){
                if (i==1){
                    if (s.get(j)=='^') {
                        total = Math.pow(val.get(j), val.get(j + 1));
                        j = replaceremove(j, total);
                    }
                }
                else if (i==2){
                    if (s.get(j)=='X'){
                        total=val.get(j)*val.get(j+1);
                        j=replaceremove(j,total);
                    }
                    else if (s.get(j)=='÷'){
                        total=val.get(j)/val.get(j+1);
                        j=replaceremove(j,total);
                    }
                }
                else{
                    if (s.get(j)=='+'){
                        total=val.get(j)+val.get(j+1);

                        j=replaceremove(j,total);
                    }
                    else if (s.get(j)=='-'){
                        total=val.get(j)-val.get(j+1);
                        j=replaceremove(j,total);
                    }
                }
            }
        }
    }
    public int  replaceremove(int x,double t){
        val.remove(x+1);
        val.remove(x);
        val.add(x,t);
        s.remove(x);
        x= (x-1);
        return x;
    }

}

