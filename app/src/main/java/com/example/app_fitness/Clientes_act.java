package com.example.app_fitness;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import clase.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner spinner1, spinner2;
    private EditText editText;
    private TextView textView;
    private Button boton1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        spinner1 = (Spinner)findViewById(R.id.spnr1);
        spinner2 = (Spinner)findViewById(R.id.spnr2);
        editText = (EditText)findViewById(R.id.edtx);
        textView = (TextView)findViewById(R.id.txtv);
        boton1 = (Button)findViewById(R.id.boton1);

        //Recibir datos

        ArrayList<String> ListaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaclientes");
        ArrayList<String> ListaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaplanes");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListaPlanes);
        spinner1.setAdapter(adapt);
        spinner2.setAdapter(adapts);
    }

    public void boton1(View v)
    {
        String cliente = spinner1.getSelectedItem().toString();
        String planes = spinner2.getSelectedItem().toString();

        Planes plan = new Planes();

        int monto = Integer.parseInt(editText.getText().toString());
        int resulxtreme = monto-plan.getXtreme();
        int resultmindFullness = monto-plan.getMindFullness();

        if(cliente.equals("Roberto") && planes.equals("xtreme"))
        {


            textView.setText("El precio del plan es: " + resulxtreme);//Precio del plan


        }

        if(cliente.equals("Roberto") && planes.equals("mindFullness"))
        {
            textView.setText("El precio del plan es: " + resultmindFullness);

        }

        if(cliente.equals("Ivan") && planes.equals("xtreme"))
        {
            textView.setText("El precio del plan es: " + resulxtreme);

        }

        if(cliente.equals("Ivan") && planes.equals("mindFullness"))
        {
            textView.setText("El precio del plan es: " + resultmindFullness);
        }



    }
}
