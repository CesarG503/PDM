# validar muchos campos de texto en android studio

```java
    private boolean validarCampos(EditText... campos) {
        boolean todosValidos = true;
        for (EditText campo : campos) {
            if (campo.getText().toString().trim().isEmpty()) {
                campo.setError("Este campo es obligatorio");
                todosValidos = false;
            }
        }
        return todosValidos;
    }
```

# Enable o disable o esconder visibilidad de un objeto

```java
    // para habilitar o deshabilitar un objeto
    miBoton.setEnabled(false); // deshabilita el botón
    miBoton.setEnabled(true); // habilita el botón

    // para esconder o mostrar un objeto
    miBoton.setVisibility(View.GONE); // esconde el botón completamente
    miBoton.setVisibility(View.INVISIBLE); // esconde el botón pero mantiene su espacio
    miBoton.setVisibility(View.VISIBLE); // muestra el botón
```

```java

 Integer position = getAdapterPosition();

    if (position != RecyclerView.NO_POSITION && listener != null)
    {
        listener.OnClick(recetaData.get(position));
    }
```