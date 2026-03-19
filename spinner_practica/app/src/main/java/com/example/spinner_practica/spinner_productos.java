package com.example.spinner_practica;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class spinner_productos extends AppCompatActivity {

    private EditText cantidad;
    private Spinner spinner_monedas;
    private Spinner spinner_resultdo;

    private ArrayList<String> monedasList;
    private ArrayList<String> resultadoList;

    private ArrayAdapter<String> adapter_monedas;
    private ArrayAdapter<String> adapter_resultado;




    private Spinner spinner_xml;
    private ArrayAdapter<CharSequence> adapter_xml;

    private boolean aceptar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner_productos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cantidad = findViewById(R.id.cantidad);
       // cantidad.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        cantidad.setFilters( new InputFilter[]{
                new InputFilter.LengthFilter(10)
        });

        String regex = "[0-9]{8}(-)?[0-9]{1}";
        String regexNum = "[0-9]+(.[0-9]+)?";

        cantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                if (cantidad.getText().toString().matches(regexNum))
                {
                    aceptar=true;
                }
                else
                {
                    AlertDialog.Builder alog = new AlertDialog.Builder(spinner_productos.this);
                    alog.setTitle("Error");
                    alog.setMessage("Se a equivocado");
                    alog.show();
                    aceptar = false;
                    cantidad.setError("Ingresa un numero");

                    AlertDialog.Builder log = new AlertDialog.Builder(spinner_productos.this);

                    alog.setMessage("goad");
                    alog.show();
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });


        spinner_monedas = findViewById(R.id.spinner_monedas);


        monedasList = new ArrayList<>();
        monedasList.add("Euro");
        monedasList.add("Peso Mexicano");
        monedasList.add("Quetzal");

        adapter_monedas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, monedasList);
        adapter_monedas.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner_monedas.setAdapter(adapter_monedas);
        spinner_monedas.setSelection(2);


        spinner_resultdo = findViewById(R.id.spinner_resultado);
        resultadoList = new ArrayList<>();

        adapter_resultado = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, resultadoList);
        adapter_resultado.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_resultdo.setAdapter(adapter_resultado);


        spinner_xml = findViewById(R.id.spinner_xml);
        adapter_xml = ArrayAdapter.createFromResource(this,R.array.numeros, android.R.layout.simple_spinner_item);
        spinner_xml.setAdapter(adapter_xml);

        spinner_monedas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void calcular(View view)
    {
        String cantidadS = cantidad.getText().toString();
        if (!cantidadS.isBlank() && aceptar )
        {
            Toast.makeText(this, "siu", Toast.LENGTH_SHORT).show();

            int pos = spinner_monedas.getSelectedItemPosition();
            String resultado = "";

            double total, actual;
            total = 0;
            actual = Double.parseDouble(cantidadS);

            if(pos == 0)
            {
                resultado +="Euro -> Dolar ";
                total = actual *1.08;

            }else if(pos == 1)
            {
                resultado +="Peso Mexicano-> Dolar ";
                total = actual *0.049;

            }
            else if(pos == 2)
            {
                resultado +="Quetzal -> Dolar ";
                total = actual *0.13;

            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
                resultadoList.addFirst(String.format("%s %.2f -> %.2f",resultado,actual,total) );
            }
            adapter_resultado.notifyDataSetChanged();
        }

    }
}