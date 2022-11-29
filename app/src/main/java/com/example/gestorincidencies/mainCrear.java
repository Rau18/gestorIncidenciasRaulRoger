package com.example.gestorincidencies;


import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.ContentView;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class mainCrear extends AppCompatActivity {

    //Creamos variables para poder iterar con las labels.
    public EditText userName;
    public EditText object;
    public Spinner objectType;
    public EditText location;
    public EditText description;
    public EditText date;

    public String spinnerValue;

    //Instanciamos nuestra base de datos.
    public GestorBD db = new GestorBD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_crear);

        String[] spnObjectType = {(String) getResources().getText(R.string.hw), (String) getResources().getText(R.string.sw)};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spnObjectType);
        objectType = findViewById(R.id.lblSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        objectType.setAdapter(adapter);

       objectType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                spinnerValue = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerValue = parent.getItemAtPosition(0).toString();
            }
        });
    }
    public void btnAtras (View view){
        Intent atras = new Intent(this, MainActivity.class);
        startActivity(atras);
    }

    //Método para insertar registros.
    public void btnGuardar (View view) {
        userName = (EditText) findViewById(R.id.lblUserName);
        object = (EditText) findViewById(R.id.lblObject);
        location = (EditText) findViewById(R.id.lblLocation);
        description = (EditText) findViewById(R.id.lblDescricption);
        date = (EditText) findViewById(R.id.lblDate);

        //Instanciamos el objeto content values para poder hacer el insert en nuestra tabla de la BD.
        ContentValues cv = new ContentValues();

        cv.put("userName", userName.getText().toString());
        cv.put("object", object.getText().toString());
        cv.put("objectType", spinnerValue);
        Toast.makeText(getBaseContext(), spinnerValue,
                Toast.LENGTH_LONG).show();
        cv.put("location", location.getText().toString());
        cv.put("description", description.getText().toString());
        cv.put("date", date.getText().toString());

        db.insertIncidencia(cv);
    }

}