package com.example.multiple;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IMC extends AppCompatActivity {

    private TextView IMC;
    private TextView categoria;
    private RadioButton btn_metrico;
    private RadioButton btn_imperial;

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

        peso = findViewById(R.id.peso);
        altura = findViewById(R.id.altura);

        //peso.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        altura.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        peso.setFilters( new InputFilter[]{
                new InputFilter.LengthFilter(10)
        });

        altura.setFilters( new InputFilter[]{
                new InputFilter.LengthFilter(10)
        });




    }

    public void calcular(View view) {

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


        String Speso = peso.getText().toString();
        String Saltura = altura.getText().toString();

        if (btn_metrico.isChecked())
        {
            double pesoD = Double.parseDouble(peso.getText().toString());
            double alturaD = Double.parseDouble(altura.getText().toString());

            double IMCD = calcularIMC(alturaD,pesoD);

        }else if (btn_imperial.isChecked())
        {

        }


    }

    public double calcularIMC(double alturaD, double pesoD)
    {
        double IMCD = pesoD / alturaD;
        return IMCD;
    }


}