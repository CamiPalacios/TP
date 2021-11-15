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
    JsonArray listaObtenida;
    ArrayList<String> ArrayUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsuariosLista = findViewById(R.id.listaUsuarios);

        tareaAsincronica tarea = new tareaAsincronica();
        tarea.execute();
    }

    private class tareaAsincronica extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... parametros) {
            try {
                URL miRuta = new URL("https://jsonplaceholder.typicode.com/users/");
                Log.d("Conexion", "Me voy a conectar");

                HttpURLConnection miConexion = (HttpURLConnection) miRuta.openConnection();
                Log.d("Conexion", "Ya estableci la conexion");

                if (miConexion.getResponseCode() == 200) {
                    Log.d("Conexion", "Conexion OK");
                    InputStream lector = miConexion.getInputStream();
                    InputStreamReader lectorJSon = new InputStreamReader(lector, "UTF-8");

                    JsonParser ProcesadorDeJSon = new JsonParser();
                    JsonObject objetoJSon = ProcesadorDeJSon.parse(lectorJSon).getAsJsonObject();

                    listaObtenida = objetoJSon.get("users").getAsJsonArray();
                    Log.d("Conexion", "El array tiene " + listaObtenida.size() + " elementos");

                    for (int i = 0; i < listaObtenida.size(); i++) {
                        JsonObject pelis = listaObtenida.get(i).getAsJsonObject();
                        String nombre = pelis.get("nombre").getAsString();
                        ArrayUsuarios.add(nombre);
                    }
                } else {
                    Log.d("Conexion", "Error en la conexion");
                }

            } catch (Exception Error) {
                Log.d("Conexion", "Ocurrio un error al procesar : " + Error.getMessage());
            }
            return null;
        }
    }
}
