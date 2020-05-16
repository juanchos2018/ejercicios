package com.example.ejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    TextView tv1,tv2,tv3;
    Button btncalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        et1=(EditText)findViewById(R.id.txt1);
        et2=(EditText)findViewById(R.id.txt2);
        btncalcular=(Button)findViewById(R.id.btncalcular);
        tv1=(TextView)findViewById(R.id.cant1);
        tv2=(TextView)findViewById(R.id.can2);
        tv3=(TextView)findViewById(R.id.tvestad);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palabra1=et1.getText().toString();
                String palabra2=et2.getText().toString();
                caluclar(palabra1,palabra2);
            }
        });

    }

 //   String [] lis = new String[4];
   // int i =0;



    private void caluclar(String palabra1, String palabra2) {

        if (TextUtils.isEmpty(palabra1)){
            Toast.makeText(this, "no hay palabra 1", Toast.LENGTH_SHORT).show();
        }
        else  if (TextUtils.isEmpty(palabra2)){
            Toast.makeText(this, "no hya palbra 2", Toast.LENGTH_SHORT).show();
        }else
        {

            String vocalesacerradas="iu";
            int vocalescerradas1=0;
            int vocalescerradas2=0;

            if (palabra1.equals(palabra2)){
                tv3.setText("no son iguales");
            }
            else{
                tv3.setText("si son iguales");
            }


            for (int j = 0; j <palabra1.length(); j++) {
                for (int k = 0; k < vocalesacerradas.length(); k++) {
                    if (palabra1.charAt(j)==vocalesacerradas.charAt(k)) {
                        vocalescerradas1++;

                        tv1.setText(""+vocalescerradas1);

                    }
                }

            }

            for (int j = 0; j <palabra2.length(); j++) {
                for (int k = 0; k < vocalesacerradas.length(); k++) {
                    if (palabra2.charAt(j)==vocalesacerradas.charAt(k)) {
                        vocalescerradas2++;

                        tv2.setText(""+vocalescerradas2);

                    }
                }

            }
        }




    }


}
