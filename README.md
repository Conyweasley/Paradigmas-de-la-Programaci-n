## Descripción de los trabajos de laboratorio:

# Laboratorio 1: Programación Funcional

Este laboratorio introduce el paradigma funcional mediante la implementación de un lenguaje específico de dominio (DSL) en Haskell para combinar figuras básicas y crear diseños complejos. Se trabaja con la separación entre datos y funciones, así como con el uso de funciones de alto orden. Las tareas incluyen:


### Implementación del DSL:
* Definir la sintaxis y semántica del lenguaje.
* Crear funciones para transformar las "palabras" del DSL en gráficos usando una biblioteca como Gloss.
* Implementar combinadores para operar sobre dibujos y funciones para manejar figuras básicas.
### Uso del DSL:
* Crear gráficos específicos como una grilla numerada, un diseño basado en Escher y una visualización de prueba.
### Escritura de Tests:
* Verificar la funcionalidad de los módulos principales mediante pruebas unitarias.
### Preguntas Teóricas:
* Responder preguntas relacionadas con la estructura modular, uso de tipos polimórficos y ventajas de fold frente al pattern-matching.

La figura generada fue la siguiente: 

![Figura](Laboratorio%201/escher.jpeg)

# Laboratorio 2: Programación Orientada a Objetos

En este trabajo, se desarrolla un lector automático de feeds RSS en Java bajo el paradigma orientado a objetos.
Los objetivos son:

### Desarrollo de Funcionalidades:
* Parsear archivos JSON y XML para extraer URLs y contenido de feeds RSS.
* Mostrar por consola atributos relevantes de los artículos.
* Implementar una funcionalidad heurística para detectar entidades nombradas (personas, lugares, organizaciones, etc.) con clases específicas para cada tipo.
### Uso de Herencia y Polimorfismo:
* Generalizar el manejo de parsers y heurísticas mediante jerarquías de clases.
### Extensibilidad:
* Diseñar el sistema para facilitar el cambio de heurísticas o la adición de nuevas funcionalidades.
### Puntos Extras:
* Parsear feeds de Reddit.
* Implementar nuevas heurísticas para entidades nombradas.


# Laboratorio 3: Frameworks sobre Cálculo Distribuido

Este laboratorio reimplementa el lector automático de feeds del Laboratorio 2 en una arquitectura distribuida utilizando *Apache Spark*. Se enfoca en:

* Adaptar el código del laboratorio previo al modelo funcional de Spark, utilizando las operaciones map y reduce para procesar datos en paralelo.
* Implementar un *índice invertido* para recuperar documentos por palabras clave.
* Comparar diferentes estrategias de desarrollo asistidas por inteligencia artificial y ejemplos de código, documentando sus ventajas y desventajas.
* Explorar funcionalidades adicionales como la creación de histogramas de frecuencias de palabras en los feeds.

***

Cada laboratorio está diseñado para fortalecer habilidades específicas, desde el pensamiento funcional y el diseño modular, hasta la orientación a objetos y la programación distribuida.
