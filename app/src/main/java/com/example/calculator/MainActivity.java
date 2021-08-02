package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button element = (Button)v;
            String text = element.getText().toString();
            String s=low.getText().toString(),operation="";


//            if(s.equalsIgnoreCase("-.") && !(text.charAt(0)-'0'>=0 && text.charAt(0)-'0'<=9)){
//                low.setText("");
//            }

            if(text.equals("CE")){
                low.setText("");
            }
            else if(text.equals("C")){
                low.setText("");
                up.setText("");
            }
            else if(text.equalsIgnoreCase("esc")){
                s = low.getText().toString();
                if(s.length()!=0){
                    if(s.length()==1){
                        low.setText("");
                    }
                    else{
                        low.setText(s.substring(0,s.length()-1));
                    }
                }
            }
            else if(s.length()<16)
                if(text.equals("/")){
                s = low.getText().toString();

                if(s.length()!=0) {
                    int neg = 1;
                    if (s.charAt(0) == '-') {
                        if(s.length()!=1){
                            s = s.substring(1);
                            neg = -1;
                        }
                        else{
                            low.setText("");
                            s="";
                        }
                    }
                    if (s.length()!=0 && !(s.charAt(s.length() - 1) - '0' <= 9 && s.charAt(s.length() - 1) - '0' >= 0)) {
                        if(s.contains("mod")) s = s.substring(0, s.length()-3);
                        else s = s.substring(0,s.length()-1);
                        s = ""+(neg==-1?"-":"")+s;

                    }
                    else{
                        if(s.indexOf('/')!=-1){
                            String s1[] = s.split("/",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a/b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.indexOf('*')!=-1){
                            String s1[] = s.split("\\*",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a*b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.indexOf('+')!=-1){
                            String s1[] = s.split("\\+",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a+b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;

                        }
                        else if(s.indexOf('-')!=-1){
                            String s1[] = s.split("-",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a-b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.contains("mod")){
                            String[] s1 = s.split("mod",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a%b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.length()!=0){
                            double b = Double.parseDouble(s);
                            b = b * 100;
                            b = Math.round(b);
                            b /= 100;
                            b *= neg;
                            s = "" + b;
                        }

                    }
                    operation = "/";
                    String[] s1 = s.split("\\.",2);
                    if(s.indexOf('.')!=-1 && s1[1].equals("0")) s = s1[0];

                    if(s.length()!=0)
                    low.setText(s+operation);
                }
            }
            else if(text.equals("*")){
                s = low.getText().toString();
                if(s.length()!=0) {
                    int neg = 1;
                    if (s.charAt(0) == '-') {
                        if(s.length()!=1){
                            s = s.substring(1);
                            neg = -1;
                        }
                        else{
                            low.setText("");
                            s="";
                        }
                    }
                    if (s.length()!=0 && !(s.charAt(s.length() - 1) - '0' <= 9 && s.charAt(s.length() - 1) - '0' >= 0)) {
                        if(s.contains("mod")) s = s.substring(0, s.length()-3);
                        else s = s.substring(0,s.length()-1);
                        s = ""+(neg==-1?"-":"")+s;
                    }
                    else{
                        if(s.indexOf('/')!=-1){
                            String s1[] = s.split("/",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a/b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.indexOf('*')!=-1){
                            String s1[] = s.split("\\*",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a*b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.indexOf('+')!=-1){
                            String s1[] = s.split("\\+",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a+b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;

                        }
                        else if(s.indexOf('-')!=-1){
                            String s1[] = s.split("-",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a-b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.contains("mod")){
                            String[] s1 = s.split("mod",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a%b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.length()!=0){
                            double b = Double.parseDouble(s);
                            b = b * 100;
                            b = Math.round(b);
                            b /= 100;
                            b *= neg;
                            s = "" + b;
                        }
                    }
                    operation = "*";
                    String[] s1 = s.split("\\.",2);
                    if(s.indexOf('.')!=-1 && s1[1].equals("0")) s = s1[0];
                    if(s.length()!=0)
                    low.setText(s+operation);
                }
            }
            else if(text.equals("-")){
                s = low.getText().toString();
                if(s.length()!=0) {
                    int neg = 1;
                    if (s.charAt(0) == '-') {
                        if(s.length()!=1){
                            s = s.substring(1);
                            neg = -1;
                        }
                        else{
                            low.setText("");
                            s="";
                        }
                    }
                    if (s.length()!=0 && !(s.charAt(s.length()-1) - '0' <= 9 && s.charAt(s.length()-1) - '0' >= 0)) {
                        if(s.contains("mod")) s = s.substring(0, s.length()-3);
                        else s = s.substring(0,s.length()-1);
                        s = ""+(neg==-1?"-":"")+s;
                    }
                    else{
                        if(s.indexOf('/')!=-1){
                            String s1[] = s.split("/",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a/b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.indexOf('*')!=-1){
                            String s1[] = s.split("\\*",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a*b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.indexOf('+')!=-1){
                            String s1[] = s.split("\\+",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a+b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;

                        }
                        else if(s.indexOf('-')!=-1){
                            String s1[] = s.split("-",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a-b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.contains("mod")){
                            String[] s1 = s.split("mod",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a%b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.length()!=0){
                            double b = Double.parseDouble(s);
                            b = b * 100;
                            b = Math.round(b);
                            b /= 100;
                            b *= neg;
                            s = "" + b;
                        }
                    }
                    operation = "-";
                    String[] s1 = s.split("\\.",2);
                    if(s.indexOf('.')!=-1 && s1[1].equals("0")) s = s1[0];

                    if(s.length()!=0)
                    low.setText(s+operation);
                }
            }
            else if(text.equals("+")){
                s = low.getText().toString();
                if(s.length()!=0) {
                    int neg = 1;
                    if (s.charAt(0) == '-') {
                        if(s.length()!=1){
                            s = s.substring(1);
                            neg = -1;
                        }
                        else{
                            low.setText("");
                            s="";
                        }
                    }
                    if (s.length()!=0 && !(s.charAt(s.length() - 1) - '0' <= 9 && s.charAt(s.length() - 1) - '0' >= 0)) {
                        if(s.contains("mod")) s = s.substring(0, s.length()-3);
                        else s = s.substring(0,s.length()-1);
                        s = ""+(neg==-1?"-":"")+s;                    }
                    else{
                        if(s.indexOf('/')!=-1){
                            String s1[] = s.split("/",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a/b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.indexOf('*')!=-1){
                            String s1[] = s.split("\\*",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a*b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.indexOf('+')!=-1){
                            String s1[] = s.split("\\+",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a+b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;

                        }
                        else if(s.indexOf('-')!=-1){
                            String s1[] = s.split("-",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a-b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.contains("mod")){
                            String[] s1 = s.split("mod",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a%b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.length()!=0){
                            double b = Double.parseDouble(s);
                            b = b * 100;
                            b = Math.round(b);
                            b /= 100;
                            b *= neg;
                            s = "" + b;
                        }
                    }
                    operation = "+";
                    String[] s1 = s.split("\\.",2);
                    if(s.indexOf('.')!=-1 && s1[1].equals("0")) s = s1[0];

                    if(s.length()!=0)
                    low.setText(s+operation);
                }
            }
            else if(text.equalsIgnoreCase("mod")){
                s = low.getText().toString();
                if(s.length()!=0) {
                    int neg = 1;
                    if (s.charAt(0) == '-') {
                        if(s.length()!=1){
                            s = s.substring(1);
                            neg = -1;
                        }
                        else{
                            low.setText("");
                            s="";
                        }
                    }
                    if (s.length()!=0 && !(s.charAt(s.length() - 1) - '0' <= 9 && s.charAt(s.length() - 1) - '0' >= 0)) {
                        if(s.contains("mod")) s = s.substring(0, s.length()-3);
                        else s = s.substring(0,s.length()-1);
                        s = ""+(neg==-1?"-":"")+s;                    }
                    else{
                        if(s.indexOf('/')!=-1){
                            String s1[] = s.split("/",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a/b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.indexOf('*')!=-1){
                            String s1[] = s.split("\\*",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a*b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.indexOf('+')!=-1){
                            String s1[] = s.split("\\+",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a+b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;

                        }
                        else if(s.indexOf('-')!=-1){
                            String s1[] = s.split("-",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a-b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.contains("mod")){
                            String[] s1 = s.split("mod",2);
                            double a = Double.parseDouble(s1[0]),
                                    b = Double.parseDouble(s1[1]);
                            b = ((neg*a%b)*100);
                            b = Math.round(b);
                            b /= 100;
                            s = ""+b;
                        }
                        else if(s.length()!=0){
                            double b = Double.parseDouble(s);
                            b = b * 100;
                            b = Math.round(b);
                            b /= 100;
                            b *= neg;
                            s = "" + b;
                        }
                    }
                    operation = "mod";
                    String[] s1 = s.split("\\.",2);
                    if(s.indexOf('.')!=-1 && s1[1].equals("0")) s = s1[0];

                    if(s.length()!=0)
                        low.setText(s+operation);
                }
            }
            else if(text.equals("=")){
                s = low.getText().toString();
                if(s.length()!=0) {
                    int neg = 1;
                    if (s.charAt(0) == '-') {
                        if(s.length()!=1){
                            s = s.substring(1);
                            neg = -1;
                        }
                        else{
                            low.setText("");
                            s="";
                        }
                    }
                    if(s.length()!=0 && !((s.charAt(s.length()-1)-'0'>=0) && (s.charAt(s.length()-1)-'0'<=9))){
                        s = s.substring(0,s.length()-1);
                        Log.d("msg",s);

                    }

                    if (s.indexOf('/') != -1) {
                        String s1[] = s.split("/", 2);
                        double a = Double.parseDouble(s1[0]),
                                b = Double.parseDouble(s1[1]);
                        b = ((neg*a / b) * 100);
                        b = Math.round(b);
                        b /= 100;
                        s = "" + b;
                    } else if (s.indexOf('*') != -1) {
                        String s1[] = s.split("\\*", 2);
                        double a = Double.parseDouble(s1[0]),
                                b = Double.parseDouble(s1[1]);
                        b = ((neg*a * b) * 100);
                        b = Math.round(b);
                        b /= 100;
                        s = "" + b;
                    } else if (s.indexOf('+') != -1) {
                        String s1[] = s.split("\\+", 2);
                        double a = Double.parseDouble(s1[0]),
                                b = Double.parseDouble(s1[1]);
                        b = ((neg*a + b) * 100);
                        b = Math.round(b);
                        b /= 100;
                        s = "" + b;

                    } else if (s.indexOf('-') != -1) {
                        String s1[] = s.split("-", 2);
                        double a = Double.parseDouble(s1[0]),
                                b = Double.parseDouble(s1[1]);
                        b = ((neg*a - b) * 100);
                        b = Math.round(b);
                        b /= 100;
                        s = "" + b;
                    } else if(s.contains("mod")){
                        String[] s1 = s.split("mod",2);
                        double a = Double.parseDouble(s1[0]),
                                b = Double.parseDouble(s1[1]);
                        b = ((neg*a%b)*100);
                        b = Math.round(b);
                        b /= 100;
                        s = ""+b;
                    } else if(s.length()!=0){
                        double b = Double.parseDouble(s);
                        b = b * 100;
                        b = Math.round(b);
                        b /= 100;
                        b *= neg;
                        s = "" + b;
                    }

                    String[] s1 = s.split("\\.", 2);
                    if (s.indexOf('.') != -1 && s1[1].equals("0")) s = s1[0];
                    low.setText(s);
                    up.setText(s);
                }
            }
            else if(text.charAt(0)-'0'>=0 && text.charAt(0)-'0'<=9 && text.length()==1){
                s = low.getText().toString();
                low.setText(s+text);
            }
            else if(text.equals(".")){
                s = low.getText().toString();

                if(s.lastIndexOf('.')<=s.lastIndexOf('/') || s.lastIndexOf('.')<=s.lastIndexOf('*') ||
                        s.lastIndexOf('.')<=s.lastIndexOf('-') || s.lastIndexOf('.')<=s.lastIndexOf('+')){
                    low.setText(s+".");
                }
            }
            else if(text.equals("+/-")){
                s = low.getText().toString();
                if(s.length()!=0){
                    if(s.lastIndexOf('-')>0){
                        int pos = s.lastIndexOf('-');
                        s = s.substring(0,pos) + "+" + s.substring(pos+1);
                    }
                    else if(s.lastIndexOf('+')!=-1){
                        int pos = s.lastIndexOf('+');
                        s = s.substring(0,pos) + "-" + s.substring(pos+1);
                    }
                    else if(s.charAt(0)=='-'){
                        s = s.substring(1);
                    }
                    else{
                        s = "-"+s;
                    }
                }
                else{
                    s = "-";
                }
                low.setText(s);
            }
            else if(text.equals("%")){
                s = low.getText().toString();
                if(s.length()==1 && s.charAt(0)=='.');
                else if(s.length()!=0){
                    int neg=1;
                    if(s.charAt(0)=='-'){
                        s = s.substring(1);
                        neg=-1;
                    }
                    int pos = s.length() - 1;
                    while (pos >= 0 && (((s.charAt(pos)) - '0' >= 0 && s.charAt(pos) - '0' <= 9) || s.charAt(pos) == '.')) {
                        pos--;
                    }

                    pos++;
                    if(s.length()!=0)
                    if (pos == 0) {
                        double b = Double.parseDouble(s);
                        b /= 100;
                        b *= neg*100;
                        b = Math.round(b);
                        b /= 100;
                        s = "" + b;
                        low.setText(s);
                    }
                    else {
                        String x = s.substring(pos), y = s.substring(0,pos-1);
                        double a = Double.parseDouble(y), b = Double.parseDouble(x);
                        b = (b*a)/100;
                        if(s.charAt(pos-1)=='+') a += b;
                        if(s.charAt(pos-1)=='-') a -= b;
                        if(s.charAt(pos-1)=='*') a *= b;
                        if(s.charAt(pos-1)=='/') a /= b;
                        a *= neg*100;
                        a = Math.round(a);
                        a /= 100;
                        s = ""+a;
                        low.setText(s);
                    }
                }
            }
            else if(text.equalsIgnoreCase("x^2")){
                s = low.getText().toString();
                if(s.length()==1 && s.charAt(0)=='.');
                else if(s.length()!=0){
                    int neg=1;
                    if(s.charAt(0)=='-'){
                        s = s.substring(1);
                    }
                    int pos = s.length() - 1;
                    while (pos >= 0 && (((s.charAt(pos)) - '0' >= 0 && s.charAt(pos) - '0' <= 9) || s.charAt(pos) == '.')) {
                        pos--;
                    }

                    pos++;
                    if(s.length()!=0){
                        if (pos == 0) {
                            double b = Double.parseDouble(s);
                            b *= b;
                            b *= neg * 100;
                            b = Math.round(b);
                            b /= 100;
                            s = "" + b;
                            low.setText(s);
                        } else {
                            String x = s.substring(pos), y = s.substring(0, pos - 1);
                            double a = Double.parseDouble(y), b = Double.parseDouble(x);
                            b = (b * b);
                            if (s.charAt(pos - 1) == '+') a += b;
                            if (s.charAt(pos - 1) == '-') a -= b;
                            if (s.charAt(pos - 1) == '*') a *= b;
                            if (s.charAt(pos - 1) == '/') a /= b;
                            a *= neg * 100;
                            a = Math.round(a);
                            a /= 100;
                            s = "" + a;
                            low.setText(s);
                        }
                    }
                }
            }
            else if(text.equalsIgnoreCase("1/x")){
                s = low.getText().toString();
                if(s.length()==1 && s.charAt(0)=='.');
                else if(s.length()!=0) {
                    int neg=1;
                    if(s.charAt(0)=='-'){
                        s = s.substring(1);
                        neg=-1;
                    }
                    int pos = s.length() - 1;
                    while (pos >= 0 && (((s.charAt(pos)) - '0' >= 0 && s.charAt(pos) - '0' <= 9) || s.charAt(pos) == '.')) {
                        pos--;
                    }

                    pos++;
                    if(s.length()!=0)
                    if (pos == 0) {
                        double b = Double.parseDouble(s);
                        b = 1 / b;
                        b *= neg*100;
                        b = Math.round(b);
                        b /= 100;
                        s = "" + b;
                        low.setText(s);
                    } else {
                        String x = s.substring(pos), y = s.substring(0, pos - 1);
                        double a = Double.parseDouble(y), b = Double.parseDouble(x);
                        b = 1 / b;
                        if (s.charAt(pos - 1) == '+') a += b;
                        if (s.charAt(pos - 1) == '-') a -= b;
                        if (s.charAt(pos - 1) == '*') a *= b;
                        if (s.charAt(pos - 1) == '/') a /= b;
                        a *= neg*100;
                        a = Math.round(a);
                        a /= 100;
                        s = "" + a;
                        low.setText(s);
                    }
                }
            }
        }
    };

    Button[] buttons = new Button[25];
    TextView up,low;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for(int i = 1; i < 25; i++){
            String s = "button";
            s+=i;

            int resID = getResources().getIdentifier(s,"id",getPackageName());
            buttons[i] = findViewById(resID);
        }

        up = findViewById(R.id.upDisplay);
        low = findViewById(R.id.lowerDisplay);


        up.setText("");
        low.setText("");


        for (int i = 1; i < 25; i++){
            buttons[i].setOnClickListener(listener);
        }
    }

    @Override
    protected void onPause() {

        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        String dis1 = low.getText().toString();
        String dis2 = up.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key dis1",dis1);
        editor.putString("key dis2",dis2);
        editor.commit();
        super.onPause();
    }

    @Override
    protected void onResume() {
        sharedPreferences = getSharedPreferences("saveData",Context.MODE_PRIVATE);
        String dis1 = sharedPreferences.getString("key dis1","");
        String dis2 = sharedPreferences.getString("key dis2","");

        low.setText(dis1);
        up.setText(dis2);

        super.onResume();
    }
}