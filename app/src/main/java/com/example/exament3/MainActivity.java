package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exament3.adapter.Adaptador;
import com.example.exament3.personaje.Personaje;
import com.example.exament3.service.RetrofitService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.recyclerview.widget.RecyclerView rv = findViewById(R.id.rvPersonaje);
        ImageView imagen = findViewById(R.id.imagen);
        TextView nombre = findViewById(R.id.nombre);
        TextView descripcion = findViewById(R.id.descripcion);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://nightwolf.free.beeceptor.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        service.all().enqueue(new Callback<List<Personaje>>() {
            @Override
            public void onResponse(Call<List<Personaje>> call, Response<List<Personaje>> response) {
                if (response.code()==200){
                    List<Personaje> personajes = response.body();
                    rv.setAdapter(new Adaptador(personajes));
                }else {
                    Log.i("Log" , "Intentalo nuevamente");
                }
            }

            @Override
            public void onFailure(Call<List<Personaje>> call, Throwable t) {
                Log.i("Log" , "No hay conexión con el servidor");
            }
        });
    }
}