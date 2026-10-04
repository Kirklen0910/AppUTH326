package com.uth.apputh326.Views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uth.apputh326.Controllers.PersonasController;
import com.uth.apputh326.Models.Personas;
import com.uth.apputh326.R;

public class ActivityPersonas extends AppCompatActivity {

    EditText nombre, apellido, fechaNac, direccion, telefono, correo;
    Button agregarPersona;

    PersonasController personasController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);

        InitControls();
        personasController = new PersonasController(this);

        agregarPersona.setOnClickListener(v -> {
            Personas persona = new Personas();
            persona.setNombre(nombre.getText().toString());
            persona.setApellido(apellido.getText().toString());
            persona.setFechaNac(fechaNac.getText().toString());
            persona.setDireccion(direccion.getText().toString());
            persona.setTelefono(telefono.getText().toString());
            persona.setCorreo(correo.getText().toString());

            long resultado = personasController.insertarPersona(persona);

            if (resultado > 0) {
                Toast.makeText(this, "Persona agregada correctamente", Toast.LENGTH_SHORT).show();
                limpiarCampos();
            } else {
                Toast.makeText(this, "Error al agregar persona", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void InitControls() {
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        fechaNac = findViewById(R.id.fechaNac);
        direccion = findViewById(R.id.direccion);
        telefono = findViewById(R.id.telefono);
        correo = findViewById(R.id.correo);
        agregarPersona = findViewById(R.id.agregarPersona);
    }

    private void limpiarCampos() {
        nombre.setText("");
        apellido.setText("");
        fechaNac.setText("");
        direccion.setText("");
        telefono.setText("");
        correo.setText("");
    }
}
