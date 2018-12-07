package com.example.yeialel.persistencia1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText apodo, email, nombre, apellido;
    private String datoApodo, datoEmail,datoNombre, datoApellido;

    public SharedPreferences datos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Toast toast = Toast.makeText(this, "Estoy en onResume", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 600);
        toast.show();
        */


        apodo = (EditText) findViewById(R.id.editTextUserName);
        email = (EditText) findViewById(R.id.editTextEmail);
        nombre = (EditText) findViewById(R.id.editTextNombre);
        apellido = (EditText) findViewById(R.id.editTextApellido);

        //PASOS PARA LA PERSISTENCIA DE DATOS
        /**
         * 1 - Crear un objeto de tipo SharedPreferences, Con esto se crea un objeto donde se guardara los datos de la pantalla
         * El parametro: 'archivoConfiguracion' es el nombre de archivo donde se guardara las preferencias
          */
        datos = getSharedPreferences("archivoConfiguracion", MODE_PRIVATE);

        // 2 - Hacer esitable el objeto creado, con esto se hace que el objeto SharedPreferences sea editable
        SharedPreferences.Editor miEditor = datos.edit();

        // 3 - Establecer la informacion a almacenar,  Aqui se modifica el objeto para que almacene los datos que queremos
        miEditor.putString("apodo", apodo.getText().toString()); // dos parametros, 1: clave, 2: el dato a pasar
        miEditor.putString("email", email.getText().toString());
        miEditor.putString("nombre", nombre.getText().toString());
        miEditor.putString("apellido", apellido.getText().toString());

        // 4 - Transferir la informacion a SharedPreferences, Con esto hacemos que las preferencias sean compartidas
        miEditor.apply();  // Esto se lleva la informacion al objeto

    }




    @Override
    public void onStop() {
        super.onStop();

        Toast toast = Toast.makeText(this, "Estoy en onStop", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 1200);
        toast.show();

        // Con esto se crea un objeto donde se guardo los datos de la pantalla
        datos = getSharedPreferences("archivoConfiguracion", MODE_PRIVATE);

        String datoApodo = datos.getString("apodo", "nada"); // dos parametros, 1: clave, 2: el dato a recibir
        String datoEmail = datos.getString("email", "nada");
        String datoNombre = datos.getString("nombre", "nada");
        String datoApellido = datos.getString("apellido", "nada");
    }




}
