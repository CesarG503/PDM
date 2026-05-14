# ARCore

## Introduction

Se usa para identificar planos horizantales y verticales, para traking de movimeinto.

### ARCore permite que una aplicación:
Detecte superficies reales (mesas, pisos, paredes)
Reconozca movimiento y posición del teléfono
Detecte profundidad y distancia
Reconozca rostros o imágenes
Coloque modelos 3D en el entorno
Mantenga objetos virtuales “pegados” al mundo real

## Configuración

1. Agregar el plugin de ARCore a tu proyecto.
2. Configurar el proyecto para usar ARCore.
3. Agregar permisos necesarios en el AndroidManifest.xml.
4. Configurar la escena de AR en tu aplicación.

## Uso básico
1. Inicializar ARCore en tu actividad.
2. Configurar la sesión de ARCore.
3. Manejar el ciclo de vida de la sesión (onResume, onPause).
4. Detectar planos y colocar objetos virtuales en el entorno.
5. Manejar interacciones del usuario con los objetos virtuales.

## Recursos adicionales

- [Documentación oficial de ARCore](https://developers.google.com/ar)

ARCore
Sceneform o OpenGL/Filament para render 3D
Cámara del dispositivo
Modelos 3D (.glb, .gltf)

## reconocimineto
Puede detectar:
- ojos
- nariz
- boca
- expresiones

# Relación con IA y visión computacional

ARCore también se mezcla con:

- Machine Learning
- reconocimiento de objetos
- detección de personas
- segmentación
- tracking corporal

Esto ya entra en:
- Computer Vision

# Lo que probablemente verás en clases

Seguramente te enseñarán:

Configurar ARCore
Permisos de cámara
Detectar superficies
Colocar objetos 3D
Cargar modelos
Movimiento y tracking
Reconocimiento de imágenes
Posicionamiento en el mundo real



# Computer Vision

- Usar modelos ya entrenados
- Entrenar tus propios modelos

### Un modelo de IA es básicamente:

un archivo entrenado que aprendió patrones para reconocer algo

Ejemplos:

- caras
- perros
- armas
- objetos
- manos
- poses humanas
- texto
- emociones

El modelo recibe:

-una imagen o frame de cámara

devuelve:
“esto es un rostro”
“esto es una botella”
“hay una persona aquí”


Las 3 grandes áreas que usarías

| Área | Qué hace |
| --- | --- |
| Object Detection | Detecta objetos |
| Image Classification | Clasifica imágenes |
| Face/Pose Tracking | Detecta rostro/cuerpo |

Usas modelos entrenados por:

- Google
- Meta
comunidades open source

# Herramientas 

Herramientas principales en Android

1. TensorFlow Lite

La más usada en Android.

Permite correr IA directamente en el teléfono.

Se usa para:

-   reconocimiento de objetos
-   clasificación
-   OCR
-   detección facial
-   segmentación


2. ML Kit

Más fácil que TensorFlow Lite.

Tiene funciones ya listas:

- reconocimiento facial
- texto
- códigos QR
- traducción
- poses humanas

Ideal para empezar.

3. OpenCV

Muy usado en visión computacional clásica.

Sirve para:

- procesamiento de imágenes
- filtros
- tracking
- detección de bordes
- colores
- movimiento

Menos IA moderna y más visión matemática.

Paso 3 — Entrenar el modelo
Usas:
- Python
- GPUs
- TensorFlow
- PyTorch

Modelos populares para reconocimiento facial:

| Modelo         | Precisión               | Velocidad  | Android             | Dificultad |
| -------------- | ----------------------- | ---------- | ------------------- | ---------- |
| FaceNet        | Muy buena               | Buena      | Sí                  | Media      |
| ArcFace        | Excelente               | Media      | Sí                  | Media/Alta |
| MobileFaceNet  | Buena                   | Muy rápida | PERFECTO para móvil | Fácil      |
| InsightFace    | Excelente               | Media      | Sí                  | Media      |
| MediaPipe Face | Solo detección/tracking | Muy rápida | Excelente           | Fácil      |

✅ MobileFaceNet