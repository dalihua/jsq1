package com.example.yellow.jsq;

import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class jsq extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsq);

        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btnDian = (Button) findViewById(R.id.btndian);
        Button btnDenyu = (Button) findViewById(R.id.btndenyu);
        Button btnAdd = (Button) findViewById(R.id.btnjia);
        Button btnJian = (Button) findViewById(R.id.btnjian);
        Button btnCheng = (Button) findViewById(R.id.btncheng);
        Button btnChu = (Button) findViewById(R.id.btnchu);
        Button btnBaifen = (Button) findViewById(R.id.btnbaifenbi);
        Button btnDle = (Button) findViewById(R.id.btndel);
        Button btnCle = (Button) findViewById(R.id.btnC);


        onC D_btn = new onC();

        btn0.setOnClickListener(D_btn);
        btn1.setOnClickListener(D_btn);
        btn2.setOnClickListener(D_btn);
        btn3.setOnClickListener(D_btn);
        btn4.setOnClickListener(D_btn);
        btn5.setOnClickListener(D_btn);
        btn6.setOnClickListener(D_btn);
        btn7.setOnClickListener(D_btn);
        btn8.setOnClickListener(D_btn);
        btn9.setOnClickListener(D_btn);
        btnDian.setOnClickListener(D_btn);
        btnDenyu.setOnClickListener(D_btn);
        btnAdd.setOnClickListener(D_btn);
        btnJian.setOnClickListener(D_btn);
        btnCheng.setOnClickListener(D_btn);
        btnChu.setOnClickListener(D_btn);
        btnBaifen.setOnClickListener(D_btn);
        btnDle.setOnClickListener(D_btn);
        btnCle.setOnClickListener(D_btn);


    }

    class onC implements OnClickListener {
        Double showContent = null;
        LinkedList list = new LinkedList();
        LinkedList ls = new LinkedList();  //存待运算的值和符号

        TextView etInput = (TextView) findViewById(R.id.tvxiansi);

        @Override
        public void onClick(View v) {


            double Result = 0;    //计算结果
            boolean isClickEqu = false;   //判断按钮“=”是否被按


            switch (v.getId()) {

                case R.id.btndel:           //删除
                    if (list.size() == 0) {

                    } else {
                        list.removeLast();
                        xianshi();
                    }
                    break;

                case R.id.btnC:
                    //清除全部
                    if (list.size() == 0) {

                        xianshi();
                    } else {
                        remove();
                        xianshi();

                    }

                    break;

                //0---9
                case R.id.btn0:
                    list.addLast("0");
                    xianshi();
                    break;
                case R.id.btn1:
                    list.addLast("1");
                    xianshi();
                    break;
                case R.id.btn2:
                    list.addLast("2");
                    xianshi();
                    break;
                case R.id.btn3:
                    list.addLast("3");
                    xianshi();
                    break;
                case R.id.btn4:
                    list.addLast("4");
                    xianshi();
                    break;
                case R.id.btn5:
                    list.addLast("5");
                    xianshi();
                    break;
                case R.id.btn6:
                    list.addLast("6");
                    xianshi();
                    break;
                case R.id.btn7:
                    list.addLast("7");
                    xianshi();
                    break;
                case R.id.btn8:
                    list.addLast("8");
                    xianshi();
                    break;
                case R.id.btn9:
                    list.addLast("9");
                    xianshi();
                    break;

                case R.id.btndian:
                    boolean aa = false;
                    if (list.size() == 0) {
                    } else {
                        for (int i = list.size() - 1; i >= 0; i--) {
                            if (list.get(i).equals(".")) {
                                aa = true;
                                break;
                            }
                            if (list.get(i).equals("+") || list.get(i).equals("-") || list.get(i).equals("*") || list.get(i).equals("/")) {
                                break;
                            }
                        }
                        if (aa == false && !list.getLast().equals("-") && !list.getLast().equals("+") && !list.getLast().equals("*") && !list.getLast().equals("/")) {
                            list.addLast(".");

                        }
                        xianshi();
                    }
                    break;
                case R.id.btnjia:
                    if (list.size() == 0) {
                        return;
                    }
                    if (list.getLast().equals("-") || list.getLast().equals("+") || list.getLast().equals("*") || list.getLast().equals("/") || list.getLast().equals(".")) {
                        return;
                    } else {
                        list.addLast("+");
                        xianshi();
                        isClickEqu = false;
                    }
                    break;
                case R.id.btnjian:
                    if (list.size() == 0) {
                        list.addLast("-");
                        xianshi();
                    }
                    if (list.getLast().equals("-") || list.getLast().equals("+") || list.getLast().equals("*") || list.getLast().equals("/") || list.getLast().equals(".")) {
                        return;
                    }
                    list.addLast("-");
                    xianshi();
                    isClickEqu = false;
                    break;
                case R.id.btncheng:
                    if (list.size() == 0) {
                        return;
                    }
                    if (list.getLast().equals("-") || list.getLast().equals("+") || list.getLast().equals("*") || list.getLast().equals("/") || list.getLast().equals(".")) {
                        return;
                    }
                    list.addLast("*");
                    xianshi();
                    isClickEqu = false;
                    break;
                case R.id.btnchu:
                    if (list.size() == 0) {
                        return;
                    }
                    if (list.getLast().equals("-") || list.getLast().equals("+") || list.getLast().equals("*") || list.getLast().equals("/") || list.getLast().equals(".")) {
                        return;
                    }
                    list.addLast("/");
                    xianshi();
                    isClickEqu = false;
                    break;
                case R.id.btndenyu:
                   /* getlist();
                   String str6=ls.getLast().toString();
                    etInput.setText(str6);8?
                */
                    if (list.size() == 0) {
                        return;
                    }
                    if (list.getLast().equals("+") || list.getLast().equals("-") || list.getLast().equals("*") || list.getLast().equals("/")) {
                        list.removeLast();
                    } else {
                        getlist();
                        if (getResult_()) {
                            if (ls.size() > 0) {
                                ls.removeLast();
                                String str1 = String.valueOf(ls.getLast());
                                showContent = new Double(str1);
                                list.clear();
                            }
                            etInput.setText(showContent.toString());
                        }
                        isClickEqu = true;
                    }
                    break;
            }
        }

        //字符串输出
        public void xianshi() {
            String str = "";
            for (Object obj : list) {
                str += obj.toString();
            }
            etInput.setText(str);
        }

        //判断字符串内是否有点
        public boolean dian() {
            boolean dian = false;
            for (Object obj : list) {
                if (list.equals(".")) ;
                dian = true;

            }
            return dian;
        }

        //清空
        public void remove() {
            list.clear();
            xianshi();
        }

        public void getlist()  //获取值和符号
        {
            StringBuffer strBf = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("+") || list.get(i).equals("-") || list.get(i).equals("*") || list.get(i).equals("/")) {
                    ls.add(strBf);
                    ls.add(list.get(i));
                    strBf = new StringBuffer();
                } else {
                    strBf.append(list.get(i));
                }
            }
            ls.add(strBf);
        }

        public boolean getResult()  //乘除先运算
        {
            getlist();
            double temp;
            int i = 0, length = ls.size();
            while (i < length) {
                if (ls.get(i).equals("*")) {
                    String str1 = String.valueOf(ls.get(i - 1));
                    String str2 = String.valueOf(ls.get(i + 1));
                    Double d1 = new Double(Double.parseDouble(str1));
                    Double d2 = new Double(Double.parseDouble(str2));
                    temp = d1 * d2;
                    ls.remove(i - 1);
                    ls.remove(i - 1);
                    ls.remove(i - 1);
                    ls.add(i - 1, Double.valueOf(temp));
                    length -= 2;
                } else if (ls.get(i).equals("/")) {
                    String str = String.valueOf(ls.get(i + 1));
                    if (Double.parseDouble(str) == Double.parseDouble("0.00")) {
                        return false;
                    } else {
                        String str1 = String.valueOf(ls.get(i - 1));
                        String str2 = String.valueOf(ls.get(i + 1));
                        Double d1 = new Double(Double.parseDouble(str1));
                        Double d2 = new Double(Double.parseDouble(str2));
                        temp = d1 / d2;
                        ls.remove(i - 1);
                        ls.remove(i - 1);
                        ls.remove(i - 1);
                        ls.add(i - 1, Double.valueOf(temp));
                        length -= 2;
                    }
                } else {
                    i++;
                }
            }
            return true;
        }

        public boolean getResult_()     //加减运算
        {
            if (!getResult()) {
                return false;
            } else {
                double temp;
                int i = 0, length = ls.size();
                while (i < length) {
                    if (ls.get(i).equals("+")) {

                        String str1 = String.valueOf(ls.get(i - 1));
                        String str2 = String.valueOf(ls.get(i + 1));
                        Double d1 = new Double(Double.parseDouble(str1));
                        Double d2 = new Double(Double.parseDouble(str2));
                        temp = d1 + d2;
                        ls.remove(i - 1);
                        ls.remove(i - 1);
                        ls.remove(i - 1);
                        ls.add(i - 1, Double.valueOf(temp));
                        length -= 2;
                    } else if (ls.get(i).equals("-")) {
                        String str1 = String.valueOf(ls.get(i - 1));
                        String str2 = String.valueOf(ls.get(i + 1));
                        Double d1 = new Double(Double.parseDouble(str1));
                        Double d2 = new Double(Double.parseDouble(str2));
                        temp = d1 - d2;
                        ls.remove(i - 1);
                        ls.remove(i - 1);
                        ls.remove(i - 1);
                        ls.add(i - 1, Double.valueOf(temp));
                        length -= 2;
                    }
                    i++;
                }
            }
            return true;
        }
    }
}
