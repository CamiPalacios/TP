package com.example.tp_07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MainActivity extends AppCompatActivity {

    ListView UsuariosLista;
    ArrayList<String> ArrayUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsuariosLista =findViewById(R.id.listaUsuarios);
    }
    /*private class tareaAsincronica extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... parametros) {
            try {
                URL miRuta = new URL("https://jsonplaceholder.typicode.com/todos/" + );
                Log.d("Conexion", "Me voy a conectar");

                HttpURLConnection miConexion = (HttpURLConnection) miRuta.openConnection();
                Log.d("Conexion", "Ya estableci la conexion");

                if (miConexion.getResponseCode() == 200) {
                    Log.d("Conexion", "Conexion OK");
                    InputStream lector = miConexion.getInputStream();
                    InputStreamReader lectorJSon = new InputStreamReader(lector, "UTF-8");

                    JsonParser ProcesadorDeJSon = new JsonParser();
                    JsonObject objetoJSon = ProcesadorDeJSon.parse(lectorJSon).getAsJsonObject();

                    peliculas = objetoJSon.get("peliculas").getAsJsonArray();
                    Log.d("Conexion", "El array tiene " + peliculas.size() + " elementos");

                    for (int i = 0; i < peliculas.size(); i++) {
                        JsonObject pelis = peliculas.get(i).getAsJsonObject();
                        String nombre = pelis.get("nombre").getAsString();
                        listaPeliculas.add(nombre);
                    }
                } else {
                    Log.d("Conexion", "Error en la conexion");
                }

            } catch (Exception Error) {
                Log.d("Conexion", "Ocurrio un error al procesar : " + Error.getMessage());
            }
            return null;
        }*/
}