package com.example.gestorincidencies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mainVisualizar extends AppCompatActivity {

    public GestorBD bd = new GestorBD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_visualizar);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        Cursor c = bd.selectAll();
        int userNameColumn = c.getColumnIndex("userName");
        int objectColumn = c.getColumnIndex("object");
        int objectTypeColumn = c.getColumnIndex("objectType");
        int locationColumn = c.getColumnIndex("location");
        int descriptionColumn = c.getColumnIndex("description");
        int dateColumn = c.getColumnIndex("date");
        if (c.getCount() > 0)
        {
            c.moveToFirst();
            do {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("listViewUserName", "Nombre de usuario: " + c.getString(userNameColumn).toString());
                hm.put("listViewObject", "Objeto: " + c.getString(objectColumn).toString());
                hm.put("listViewObjectType", "Tipo de incidencia: " + c.getString(objectTypeColumn).toString());
                hm.put("listViewLocation", "Localización: " + c.getString(locationColumn).toString());
                hm.put("listViewDescription", "Descripción: " + c.getString(descriptionColumn).toString());
                hm.put("listViewDate", "Fecha: " + c.getString(dateColumn).toString());
                aList.add(hm);
                c.moveToNext();
            } while (c.moveToNext());
            c.close();
        }

        String[] from = {"listViewUserName", "listViewObject", "listViewTypeObject", "listViewLocation", "listViewDescription", "listViewDate"};
        int[] to = {R.id.listViewUserName, R.id.listViewIncidencia, R.id.listViewTipo, R.id.listViewLocalizacion, R.id.listViewDescripcion, R.id.listViewFecha};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
    }
    public void btnAtras2 (View view){
        Intent atras = new Intent(this, MainActivity.class);
        startActivity(atras);
    }
}