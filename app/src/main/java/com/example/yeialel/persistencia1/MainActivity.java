package com.example.yeialel.persistencia1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText apodo, email, nombre, apellido;
    private String datoApodo, datoEmail,datoNombre, datoApellido;

    private CheckBox estado;
    private boolean datoCheckBox;

    public SharedPreferences datos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apodo = (EditText) findViewById(R.id.editTextUserName);
        email = (EditText) findViewById(R.id.editTextEmail);
        nombre = (EditText) findViewById(R.id.editTextNombre);
        apellido = (EditText) findViewById(R.id.editTextApellido);
        estado = (CheckBox) findViewById(R.id.checkBoxEstoyDeacuerdo);
    }

    @Override
    public void onPause() {
        super.onPause();
        //PASOS PARA LA PERSISTENCIA DE DATOS PARA CARGAR LAS PREFERENCIAS
        /** 1 - Crear un objeto de tipo SharedPreferences, Con esto se crea un objeto donde se guardara los datos de la pantalla
         * El parametro: 'archivoConfiguracion' es el nombre de archivo donde se guardara las preferencias   */
        datos = getSharedPreferences("archivoPreferencias", MODE_PRIVATE);

        // 2 - Hacer editable el objeto creado, con esto se hace que el objeto SharedPreferences sea editable
        SharedPreferences.Editor miEditor = datos.edit();

        // 3 - Establecer la informacion a almacenar,  Aqui se modifica el objeto para que almacene los datos que queremos
        miEditor.putString("apodo", apodo.getText().toString()); // dos parametros, 1: clave, 2: el dato a pasar
        miEditor.putString("email", email.getText().toString());
        miEditor.putString("nombre", nombre.getText().toString());
        miEditor.putString("apellido", apellido.getText().toString());
        miEditor.putBoolean("estado", estado.isChecked());  // verifica el estado en que esta el check

        // 4 - Transferir la informacion a SharedPreferences, Con esto hacemos que las preferencias sean compartidas
        miEditor.apply();  // Esto se lleva la informacion al objeto
    }

    @Override
    public void onResume() {
        super.onResume();

        // Con esto se crea un objeto donde se guardo los datos de la pantalla
        datos = getSharedPreferences("archivoPreferencias", MODE_PRIVATE);

        datoApodo = datos.getString("apodo", "");
        apodo.setText(datoApodo);

        datoEmail = datos.getString("email", "");
        email.setText(datoEmail);

        datoNombre = datos.getString("nombre", "");
        nombre.setText(datoNombre);

        datoApellido = datos.getString("apellido", "");
        apellido.setText(datoApellido);

        datoCheckBox = datos.getBoolean("checked", true);
        estado.setChecked(datoCheckBox);
    }
}
