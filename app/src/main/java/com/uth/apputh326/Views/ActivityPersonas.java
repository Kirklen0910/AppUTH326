package com.uth.apputh326.Views;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uth.apputh326.Controllers.PersonasController;
import com.uth.apputh326.Models.Personas;
import com.uth.apputh326.R;

import java.util.List;

public class ActivityPersonas extends AppCompatActivity {

    EditText nombre, apellido, fechaNac, direccion, telefono, correo;
    Button agregarPersona, listarPersonas;
    ListView listViewPersonas;

    PersonasController personasController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);

        personasController = new PersonasController(this);
        InitControls();

        agregarPersona.setOnClickListener(v -> {
            String nom = nombre.getText().toString().trim();
            String ape = apellido.getText().toString().trim();
            String fecha = fechaNac.getText().toString().trim();
            String dir = direccion.getText().toString().trim();
            String tel = telefono.getText().toString().trim();
            String cor = correo.getText().toString().trim();

            if (nom.isEmpty()) {
                nombre.setError("El nombre es obligatorio");
                nombre.requestFocus();
                return;
            }
            if (ape.isEmpty()) {
                apellido.setError("El apellido es obligatorio");
                apellido.requestFocus();
                return;
            }
            if (fecha.isEmpty()) {
                fechaNac.setError("La fecha de nacimiento es obligatoria");
                fechaNac.requestFocus();
                return;
            }
            if (cor.isEmpty()) {
                correo.setError("El correo es obligatorio");
                correo.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(cor).matches()) {
                correo.setError("Formato de correo inválido");
                correo.requestFocus();
                return;
            }

            Personas persona = new Personas();
            persona.setNombre(nom);
            persona.setApellido(ape);
            persona.setFechaNac(fecha);
            persona.setDireccion(dir);
            persona.setTelefono(tel);
            persona.setCorreo(cor);

            long resultado = personasController.insertarPersona(persona);

            if (resultado > 0) {
                Toast.makeText(this, "Persona registrada correctamente", Toast.LENGTH_SHORT).show();
                limpiarCampos();
            } else {
                Toast.makeText(this, "Error al registrar persona", Toast.LENGTH_SHORT).show();
            }
        });

        listarPersonas.setOnClickListener(v -> {
            List<Personas> lista = personasController.obtenerPersonas();

            if (lista.isEmpty()) {
                Toast.makeText(this, "No hay personas registradas", Toast.LENGTH_SHORT).show();
            } else {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        lista.stream()
                                .map(p -> p.getId() + " - " + p.getNombre() + " " + p.getApellido())
                                .toArray(String[]::new)
                );
                listViewPersonas.setAdapter(adapter);
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
        listarPersonas = findViewById(R.id.listarPersonas);
        listViewPersonas = findViewById(R.id.listViewPersonas);
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
