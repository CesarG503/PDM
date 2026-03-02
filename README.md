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


