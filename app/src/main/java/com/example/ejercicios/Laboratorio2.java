package com.example.ejercicios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.util.BuddhistCalendar;
import android.os.Bundle;
import android.view.View;

import com.example.ejercicios.Adapter.AdapterNoticias;
import com.example.ejercicios.Clases.ClsNoticias;

import java.util.ArrayList;

public class Laboratorio2 extends AppCompatActivity {

    ArrayList<ClsNoticias>listaNoticias;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio2);

        listaNoticias=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        llenarLista();
        AdapterNoticias adapter  = new AdapterNoticias(listaNoticias);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("id",listaNoticias.get(recyclerView.getChildAdapterPosition(v)).getId());
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
     //  recyclerView=(RecyclerView)findViewById(R.id.)


    }
    private void llenarLista() {
        listaNoticias.add(new ClsNoticias("1","Zeballos: “El Congreso puede dar o negar la confianza o puede censurarnos, está en su derecho”","El presidente del Consejo de Ministros, Vicente Zeballos, aseguró que el pleno del Congreso podrá votar si otorga o no la confianza al gabinete ministerial, o si desea censurarlos, luego de que acuda a hablar sobre las medidas que tomó el Gobierno durante el interregno parlamentario el próximo jueves 28 de mayo.","12/12/12",R.drawable.zeballos,R.drawable.zeballos));
        listaNoticias.add(new ClsNoticias("2","Apps de reparto a domicilio no aceptarán pagos en efectivo","El Poder Ejecutivo dio a conocer este sábado el protocolo sanitario que aplicará desde este lunes para los aplicativos de reparto a domicilio (delivery) como Glovo, Rappi y Uber Eats, en el marco del proceso de reactivación económica ante el estado de emergencia nacional por el brote del nuevo coronavirus (COVID-19) en Perú.","12/12/12",R.drawable.deliver,R.drawable.deliver));
     //   listaNoticias.add(new ClsNoticias("3","Martín Vizcarra en la ONU: Confío en que lograremos el adelanto de elecciones por el bien del Perú","El presidente de la República, Martín Vizcarra, explicó ante la Asamblea General de las Naciones Unidas los motivos que le llevaron a presentar la propuesta de adelanto de elecciones ante el Congreso. Aseguró que todas las medidas de su Gobierno se dan en respeto a la Constitución y el Estado de derecho.","12/12/12",R.drawable.vizcarra));



    }
}
