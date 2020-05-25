package com.javi.pizza.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javi.pizza.R;
import com.javi.pizza.entidades.Platos;

import java.util.ArrayList;


public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<Platos>model;

    //listener
    private View.OnClickListener listener;

    public  Adaptador(Context context, ArrayList<Platos>model) {
        this.inflater=LayoutInflater.from(context);
        this.model=model;
    }


    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =inflater.inflate(R.layout.items_pizza,parent);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        String titulo = model.get(position).getTitulo();
        String descripcion = model.get(position).getDescripcion();
        String precio = model.get(position).getPrecio();
        int imagen = model.get(position).getImagenid();
        holder.titulo.setText(titulo);
        holder.descripcion.setText(descripcion);
        holder.precio.setText(precio);
        holder.imagen.setImageResource(imagen);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {

        if (listener!=null){
            listener.onClick(view);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, descripcion, precio;
        ImageView imagen;

        public ViewHolder (@NonNull View itemView){
            super (itemView);
            titulo=itemView.findViewById(R.id.tvTituloItem);
            descripcion=itemView.findViewById(R.id.tvDescripcion);
            precio=itemView.findViewById(R.id.tvPrecio);
            imagen=itemView.findViewById(R.id.ivImagen);
        }
    }
}
