package com.uth.apputh326.Views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.uth.apputh326.R;

import java.util.Calendar;

public class ActivityPersonas extends AppCompatActivity {

    EditText nombre, apellido, fechaNac, direccion, telefono, correo;

    Button agregarPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personas);


    }

    private void InitControls()
    {
        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        fechaNac = (android.widget.EditText) findViewById(R.id.fechaNac);
        direccion = (EditText) findViewById(R.id.direccion);
        telefono = (EditText) findViewById(R.id.telefono);
        correo = (EditText) findViewById(R.id.correo);
        agregarPersona = (Button) findViewById(R.id.agregarPersona);

    }
}