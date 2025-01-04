# Paradigmas de la Programación - FaMAF

## Informe - Laboratorio 03: Parte 2

#### Grupo número 31: "StackOverFlowers" 🌻

### Estudiantes:
* Adragna Javier Martín
* Gonzalía Alvaro Tomás
* Gomez Vera Eleonora Constanza

## Contenido

- [Programación asistida para Frameworks sobre Cálculo Distribuido](#programación-asistida-para-frameworks-sobre-cálculo-distribuido)
 - [Funcionamiento del proyecto](#funcionamiento-del-proyecto)
  - [Flags](#flags)
- [Evaluación y selección de proyectos previos](#evaluaci%C3%B3n-y-selecci%C3%B3n-de-proyectos-previos)
- [Incorporación de nuevas funcionalidades](#incorporaci%C3%B3n-de-nuevas-funcionalidades)
 - [Recuperación de documentos por palabras clave](#recuperación-de-documentos-por-palabras-clave)
- [Conclusiones](#conclusiones)

## Programación asistida para Frameworks sobre Cálculo Distribuido - Parte 2

El proyecto presentado es una **re-implementación** del [Laboratorio 02](https://bitbucket.org/paradigmas-programacion-famaf/grupo31_lab02_2023/src/master/) parte 1 (individual) de la misma materia, manteniendo a [Java](https://www.oracle.com/java/) como lenguaje de programación, y [Apache Spark](https://spark.apache.org/faq.html) como framework de análisis de datos.
A la presentación de la parte 1, se le suma una nueva funcionalidad; el poder recuperar documentos por palabras clave, imprimiendolos en forma ordenada por frecuencia de aparición de las mismas.

### Funcionamiento del proyecto

Para ejecutar la aplicación, se debe instalar [JDK 8](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html) en su version 8.372 o superior, y [Apache Maven](https://maven.apache.org/download.cgi) en su version 3.8.1

```bash
sudo apt update
sudo apt install openjdk-8-jdk
sudo apt install maven
```

Configurar e instalar dependencias 
    
```bash
export JAVA_HOME=path_to_java_home
export MAVEN_OPTS="-Xss64m -Xmx2g -XX:ReservedCodeCacheSize=1g"
mvn clean install
```
desde el directorio raíz del proyecto, y reemplazando _path_to_java_home_ por la ruta al directorio de instalación de Java.

Luego, el programa puede ejecutarse con los siguientes comandos

```bash
mvn compile
java FeedReaderMain
```
#### Flags

Agregando opcionalmente la flag `-ne` al final del segundo comando para activar el análisis de entidades nombradas, o la flag `-search` para realizar una recuperar los documentos que contengan una determinada palabra.

## Evaluación y selección de proyectos previos
   Se realizó una comparación entre los laboratorios presentados y se llegó a las siguientes conclusiones:

   1. Laboratorio 1: Realizado por Adragna Javier Martín - Herramienta utilizada: Guanaco 33B.

      * Ventajas:
        * Modularización.
        * Nombre de variables más representativos.
      * Desventajas: 
        * Estructura map-reduce más abstracta.
   

   2. Laboratorio 2: Realizado por Gómez Vera Eleonora Constanza - Herramienta utilizada: GPT-3.5 en inglés
      * Ventajas:
        * Código más claro de leer.
   
      * Desventajas:
        * Uso no explícito de la función reduce.
   
   3. Laboratorio 3: Realizado por Gonzalia Alvaro Tomas - Herramienta utilizada: GPT-3.5 en español

      * Ventajas:
        * Código claro.
        * Código en español (Ventaja para quien no tenga nivel en inglés).
        
      * Desventajas:
        * Poca modularización.
        * Código más verboso.

  En base a este análisis, se decidió continuar el proyecto tomando como base el laboratorio 1, ya que se consideró que la modularización del mismo podría llegar a facilitar la incorporación de nuevas funcionalidades.
   
## Incorporación de nuevas funcionalidades

Usando como base la parte 1 del laboratorio implementamos un nuevo método para crear el índice invertido y luego imprimir los artículos que contengan la palabra a buscar, en el orden correcto.

### Recuperación de documentos por palabras clave
Utilizamos GPT3 en español para adaptar las funcionalidades a spark. En primer lugar creamos el índice invertido de documentos de manera manual y sin utilizar Spark, y luego lo pasamos por GPT3 para mejorarlo y adaptarlo.
Notamos que GPT3 se confunde mucho a la hora de mostrarnos código en un proyecto como el nuestro, ya que en varias ocasiones nos proporcionó métodos con errores graves a la hora de compilarlo. Luego de varias iteraciones pudimos lograr adaptar el código.

### Conclusiones
Este proyecto nos sirvió para terminar de comprender cómo funciona Map y Reduce, seguir aprendiendo sobre Java y herramientas de IA, además de empezar a usar tecnologías como IntelliJ y Maven, pues nos tuvo que forzar a manejar las dependencias de una manera más organizada y clara, para lo cual el IDE nos proporcionó muchísimas facilidades; a la hora de ejecutar la aplicación, hacer la build y la implementación de las librerías agregadas previamente con Maven.
