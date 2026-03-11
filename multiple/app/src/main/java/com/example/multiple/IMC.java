package com.example.multiple;

import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class IMC extends AppCompatActivity {

    private TextView IMC;
    private TextView categoria;
    private RadioButton btn_metrico;
    private RadioButton btn_imperial;

    private ImageView img;

    private Spinner spinner_imc;
    private ArrayList<String> imc_lista;
    private ArrayAdapter<String> adapter;

    private EditText peso;
    private EditText altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        IMC = findViewById(R.id.IMC);
        categoria = findViewById(R.id.categoria);
        btn_metrico = findViewById(R.id.btn_metrico);
        btn_imperial = findViewById(R.id.btn_imperial);
        img = findViewById(R.id.imageView);
        peso = findViewById(R.id.peso);
        altura = findViewById(R.id.altura);

        spinner_imc = findViewById(R.id.spinner_imc);
        imc_lista = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, imc_lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_imc.setAdapter(adapter);



        //peso.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        altura.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        peso.setFilters( new InputFilter[]{
                new InputFilter.LengthFilter(10)
        });

        altura.setFilters( new InputFilter[]{
                new InputFilter.LengthFilter(10)
        });

        peso.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().matches("[0-9]+"))
                {
                    peso.setError(null);
                }else
                {
                    peso.setError("Solo numeros");
                    return;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });




    }

    public void calcular(View view) {

        double IMCD = 0.00;
        String alturaS = altura.getText().toString();
        String pesoS = peso.getText().toString();

        if (btn_metrico.isChecked())
        {
            double pesoD = Double.parseDouble(peso.getText().toString());
            double alturaD = Double.parseDouble(altura.getText().toString());
            IMCD = calcularIMC(alturaD,pesoD);

        }else if (btn_imperial.isChecked())
        {
            double pesoD = Double.parseDouble(peso.getText().toString());
            double alturaD = Double.parseDouble(altura.getText().toString());
            pesoD = pesoD * 0.4536 ;
            alturaD = alturaD * 0.0254;
            IMCD = calcularIMC(alturaD,pesoD);
        }

        IMC.setText( String.valueOf(IMCD));

        if(IMCD <= 18.5)
        {
            categoria.setText("Peso Bajo");
            img.setImageResource(R.drawable.log);

        }else if(IMCD > 18.5 && IMCD <=24.9)
        {
            categoria.setText("Peso Normal");
            img.setImageResource(R.drawable.log);
        }
        else if(IMCD > 24.9 && IMCD <=29.9)
        {
            categoria.setText("Peso Mayor");
            img.setImageResource(R.drawable.log);
        }
        else if(IMCD > 29.9 )
        {
            categoria.setText("Morbido");
            img.setImageResource(R.drawable.log);
        }

        imc_lista.add( String.format(" Altura: %s Peso %s Indice de masa corporal: %.2f" ,alturaS,pesoS, IMCD));
        adapter.notifyDataSetChanged();


    }

    public double calcularIMC(double alturaD, double pesoD)
    {
        double IMCD = pesoD / alturaD;
        return IMCD;
    }


}