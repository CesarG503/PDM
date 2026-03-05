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
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Formulario extends AppCompatActivity {

    private Button boton;

    private EditText letras;

    private EditText ingresar;
    private TextView texto;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //definir las instancias

        boton = findViewById(R.id.click);

        texto = findViewById(R.id.texto);

        ingresar = findViewById(R.id.entrada);

        letras = findViewById(R.id.letras);

        letras.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        letras.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        letras.setInputType(InputType.TYPE_CLASS_NUMBER);

        letras.setFilters( new InputFilter[]{
                new InputFilter.AllCaps(),
                new InputFilter.LengthFilter(10)
        });


        //boton.setOnClickListener(v ->
        //{
            //texto.setText("Hola mundo loco ");

        //});

        ingresar.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);


        Patterns.EMAIL_ADDRESS.matcher(ingresar.getText().toString()).matches(); //devuelve un true O false
        ingresar.getText().toString().matches("[A-Za-z+]");
        
        ingresar.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                if (s.toString().length() <5 )
                {
                    ingresar.setError("Muy corto");
                    Toast.makeText(Formulario.this, "loco", Toast.LENGTH_SHORT).show();
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

    public void ejecutar(View view) {
        count++;
        texto.setText("NOOOOO");
        boton.setHeight(200 + count);

        boton.setVisibility(View.GONE);
    }
}