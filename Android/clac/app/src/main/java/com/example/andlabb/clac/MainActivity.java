package com.example.andlabb.clac;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bp,bdot,bm,bmu,bdiv,be,clr;
    EditText editText;
    String num="",operator="";
    float fno=0,sno,result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        b0=findViewById(R.id.b0);
        bdot=findViewById(R.id.bdot);
        bm=findViewById(R.id.bm);
        bmu=findViewById(R.id.bmu);
        bdiv=findViewById(R.id.bdiv);
        be=findViewById(R.id.be);
        bp=findViewById(R.id.bp);
        clr=findViewById(R.id.bclear);
        editText=findViewById(R.id.editText);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bdot.setOnClickListener(this);
        bm.setOnClickListener(this);
        bmu.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        be.setOnClickListener(this);
        bp.setOnClickListener(this);
        clr.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v==bdot)
        {
            num=num+".";
            editText.setText(num);
        }
        if(v==b1)
        {
            num=num+"1";
            editText.setText(num);
        }
        if(v==b2)
        {
            num=num+"2";
            editText.setText(num);
        }
        if(v==b3)
        {
            num=num+"3";
            editText.setText(num);
        }
        if(v==b4)
        {
            num=num+"4";
            editText.setText(num);
        }
        if(v==b5)
        {
            num=num+"5";
            editText.setText(num);
        }
        if(v==b6)
        {
            num=num+"6";
            editText.setText(num);
        }
        if(v==b7)
        {
            num=num+"7";
            editText.setText(num);
        }
        if(v==b8)
        {
            num=num+"8";
            editText.setText(num);
        }
        if(v==b9)
        {
            num=num+"9";
            editText.setText(num);
        }
        if(v==b0)
        {
            num=num+"0";
            editText.setText(num);
        }
        if(v==bp)
        {
            operator="+";
            abc();



        }
        if(v==bm)
        {
            operator="-";
            abc();



        }
        if(v==bmu)
        {
            operator="*";
            abc();



        }
        if(v==bdiv)
        {
            operator="/";
            abc();



        }
        if(v==clr)
        {
            operator="";
            fno=0;
            sno=0;
            num="";
            result=0;
            editText.setText("");
        }
        if(v==be)
        {


            if(sno==0)
                sno = Float.parseFloat(num);
            switch (operator)
            {
                case "+":result=result+sno;
                        break;
                case "-":result=result-sno;
                    break;
                case "*":result=result*sno;
                    break;
                case "/":result=result/sno;
                    break;

            }
            num=result+"";
            editText.setText(result+"");
            fno=0;



        }

    }
    public void abc()
    {
        if(fno==0) {
            editText.setText("");
            fno = Float.parseFloat(num);
            result=fno;
            num="";
            sno=0;
        }
        else {
            editText.setText("");
            sno = Float.parseFloat(num);
            num="";
        }
    }
}
