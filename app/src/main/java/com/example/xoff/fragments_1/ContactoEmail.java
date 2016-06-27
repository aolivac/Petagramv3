package com.example.xoff.fragments_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactoEmail extends AppCompatActivity {

    private Button btnEnviar;
    private EditText nombreDe, emailTo, mensaje;

    String email;
    String nombre;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        Toolbar miToolbar = (Toolbar) findViewById(R.id.actionBarContacto);
        setSupportActionBar(miToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnEnviar = (Button) findViewById(R.id.btnSiguiente);

        nombreDe = (EditText) findViewById(R.id.etNombreCompleto);
        emailTo = (EditText) findViewById(R.id.etCorreoElectronico);
        mensaje = (EditText) findViewById(R.id.etDescripcionMensaje);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombre = nombreDe.getText().toString();
                email = emailTo.getText().toString();
                texto = mensaje.getText().toString();

                Toast.makeText(getBaseContext(), " Tu : " + nombre + " Enviaste : " + texto + " a : " + email, Toast.LENGTH_LONG).show();

                Intent sendIntent = new Intent((Intent.ACTION_SEND));
                sendIntent.setType("plain/text");
                sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                sendIntent.putExtra(Intent.EXTRA_TEXT, texto);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Mensaje enviado por " + nombre);
                startActivity(Intent.createChooser(sendIntent, "Enviar mail atraves de "));
            }
        });

    }
}
