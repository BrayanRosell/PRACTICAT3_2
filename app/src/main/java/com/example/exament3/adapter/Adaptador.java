package com.example.exament3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exament3.R;
import com.example.exament3.personaje.Personaje;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.AdaptadorViewHolder>{
    private List<Personaje> listaPersonajes;

    public Adaptador(List<Personaje> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override
    public Adaptador.AdaptadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_personaje, parent, false);
        AdaptadorViewHolder vh = new AdaptadorViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.AdaptadorViewHolder holder, int position) {

        TextView nombre = holder.itemView.findViewById(R.id.nombre);
        TextView descripcion = holder.itemView.findViewById(R.id.descripcion);
        ImageView imagen = holder.itemView.findViewById(R.id.imagen);

        Personaje personaje = listaPersonajes.get(position);

        nombre.setText(personaje.getNombre());
        descripcion.setText(personaje.getDescripcion());
        String urlImage = personaje.getImagen();
        Picasso.get().load(urlImage).into(imagen);
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public class AdaptadorViewHolder extends RecyclerView.ViewHolder {

        public AdaptadorViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
