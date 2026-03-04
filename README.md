## Fundamentos JAVA + Android Studio    

### crear el proyecto

1. Seccion de Phone and Tablet > Empty View Activity
2. nombre del proyecto:
     Lenguaje: Java
     Minimun SDK: API 24 para Android 7.0
     Build configuration: Groovy DSL o Kotlin DSL 

## Estructura del proyecto

1. app: contiene todo
2. manifest: archivo de configuracion, sirve para configurar: 
- Cómo se llama tu app
- Qué permisos necesita
- Qué actividades tiene
- Qué versión mínima soporta
- Qué servicios usa

3. Kotlin + java: 
     Ahí se guarda todo el código fuente de tu aplicación.
     Lógica de botones
     Procesamiento de texto
     Conexión a backend
     Validaciones
     Eventos

| Arquitectura       | Significado               | Enfoque                          |
| ------------------ | ------------------------- | -------------------------------- |
| MVC                | Model – View – Controller | La Activity controla todo        |
| MVP                | Model – View – Presenter  | Se separa la lógica en Presenter |
| MVVM               | Model – View – ViewModel  | ViewModel maneja datos y estado  |
| Clean Architecture | Arquitectura limpia       | Separación fuerte por capas      |

Android Studio usa MVVM por defecto

4. res
     contiene todos los recursos de la app
     layout: archivos XML que definen la interfaz de usuario
     values: archivos XML que definen los valores de la app
     drawable: imágenes y gráficos
     mipmap: iconos de la app

## Inicio basico

Dentro de layout Activity_main.xml esta la vista de la app
constraintlayout : permite posicionar todo 

Arrastra objetos y su codigo estare en XML para posicionar los objetos 

para seleccionar los objetos en XML se usa el id 

Luego de colocar los elementos en el view 

## identificacion de elemntos backend 

para localizar un elemnto y poder editar y ver sus propiedades se usa:

```java
boton = findViewById(R.id.boton);

text = findViewById(R.id.text);
```

para hacer un evento de click en un boton se usa:

#### forma 1

crear la propiedade Onclick en el XML dale click derecho y generar funcion genera lo siguiente:

```java
public void miFuncion(View view) {
    // código que se ejecuta al hacer clic
}
```

#### forma 2

```java
boton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // código que se ejecuta al hacer clic
    }
});

boton.setOnClickListener(v -> {
    // código que se ejecuta al hacer clic
});
```

El metodo anterior sobreescribe el metodo Onclick totalmente!

# Metodos importantes de los componentes

- .setText("texto") : permite cambiar el texto de un componente
- .getText() : permite obtener el texto de un componente
- .setOnClickListener() : permite hacer un evento de click en un componente
- .setTextSize(18);
- .setEnabled(false);

#### visibilidad de los componentes
- OBJETO.setVisibility(View.GONE);      // desaparece
- OBJETO.setVisibility(View.INVISIBLE); // invisible pero ocupa espacio
- OBJETO.setVisibility(View.VISIBLE);   // visible


### Validacion de campos de texto EditText
- 1 Tipos de entrada (InputType)
- 2 Validaciones manuales
- 3 Filtros (InputFilter)
- 4 TextWatcher (validación en tiempo real)
- 5 Clases importantes para validar

#### 1
```java
editText.setInputType(InputType.TYPE_CLASS_NUMBER); //solo numeros 

InputType.TYPE_CLASS_TEXT // texto

InputType.TYPE_CLASS_PHONE // telefono

InputType.TYPE_CLASS_EMAIL // correo

InputType.TYPE_CLASS_NUMBER_PASSWORD // contraseña

InputType.TYPE_NUMBER_FLAG_DECIMAL // decimales

InputType.TYPE_NUMBER_FLAG_SIGNED // negativos

```

#### 2
```java

String texto = editText.getText().toString().trim();

if (texto.isEmpty()) {
    editText.setError("Campo obligatorio");
    return;
}

```


#### 4

```java

editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        
    }

    @Override
    public void afterTextChanged(Editable s) {
        
    }
});

```




