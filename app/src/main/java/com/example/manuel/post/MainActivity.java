package com.example.manuel.post;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.example.manuel.post.Adaptars.MyAdapter;
import com.example.manuel.post.Interface.ServicesTutorial;
import com.example.manuel.post.Model.ResponseService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    public MyAdapter adapter;

    ResponseService responseService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ui();
        cargar();
        //new Peticion().execute();
    }

    public  void Ui(){
        gridView=(GridView)findViewById(R.id.gridView);
        this.setTitle("Consumir Usuarios");
    }

    public  void cargar(){
        final  String url="https://androidtutorials.herokuapp.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//Indicamos la url del servicio
                .addConverterFactory(GsonConverterFactory.create())//Agregue la fábrica del convertidor para la serialización y la deserialización de objetos.
                .build();//Cree la instancia de Retrofit utilizando los valores configurados.
        //https://square.github.io/retrofit/2.x/retrofit/retrofit2/Retrofit.Builder.html
        ServicesTutorial servicesTutorial=retrofit.create(ServicesTutorial.class);
        Call<List<ResponseService>> response=servicesTutorial.getUserGet();

        response.enqueue(new Callback<List<ResponseService>>() {
            @Override
            public void onResponse(Call<List<ResponseService>> call, Response<List<ResponseService>> response) {
                List<ResponseService> peopleData = response.body();
                if (peopleData==null){
                    Toast.makeText(MainActivity.this,"Vacio",Toast.LENGTH_SHORT).show();
                }
                else{
                    adapter=new MyAdapter(R.layout.item,peopleData,MainActivity.this);
                    gridView.setAdapter(adapter);



                }
            }

            @Override
            public void onFailure(Call<List<ResponseService>> call, Throwable t) {

            }
        });

    }

    private List<String> getAllFruits(final String nombre) {
        List<String> list = new ArrayList<String>() {{
            add(nombre);

        }};
        return list;
    }

}
