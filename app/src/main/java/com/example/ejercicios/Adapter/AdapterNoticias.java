package com.example.ejercicios.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicios.Clases.ClsNoticias;
import com.example.ejercicios.R;

import java.util.ArrayList;

public class AdapterNoticias  extends RecyclerView.Adapter<AdapterNoticias.ViewHolderDatos> implements View.OnClickListener{

    ArrayList<ClsNoticias> listaNoticias;

    public AdapterNoticias(ArrayList<ClsNoticias> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    private View.OnClickListener listener;
    public  void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    @NonNull
    @Override
    public AdapterNoticias.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noticias,parent,false);
        vista.setOnClickListener(this);
        return new  ViewHolderDatos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNoticias.ViewHolderDatos holder, int position) {

        if (holder instanceof ViewHolderDatos){
            final ViewHolderDatos items =(ViewHolderDatos)holder;

            items.txttitulo.setText(listaNoticias.get(position).getTitulo());
            items.txtdescripcion.setText(listaNoticias.get(position).getDescrpipion());
            //items.nombreclase=listaClases.get(position).getNombreclase();




        }
    }

    @Override
    public int getItemCount() {
        return listaNoticias.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView txttitulo,txtdescripcion;
        ImageView imgfotoo;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            txttitulo=(TextView)itemView.findViewById(R.id.idtitulo);
            txtdescripcion=(TextView)itemView.findViewById(R.id.idescripcion);
            imgfotoo=(ImageView)itemView.findViewById(R.id.imgfoto);
        }
    }
}
