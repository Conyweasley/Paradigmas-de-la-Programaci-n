# Paradigmas de la Programación - FaMAF

## **Informe - Laboratorio 02**

#### Grupo número 31: "StackOverFlowers" 🌻

#### Integrantes:

- Gonzalía Alvaro Tomas
- Adragna Javier Martín
- Eleonora Constanza Gómez Vera

## Laboratorio de Programación Orientada a Objetos

En este proyecto se implementa un lector automático de **feeds** xml, como aplicación de consola, bajo el paradigma orientado a objetos. Este lector, además de permitir imprimir los datos obtenidos, cuenta con una funcionalidad (activable ejecutando con el flag `-ne`) que computa de los mismos y, mediante una **heurística**, al conjunto de **entidades nombradas** y su cantidad de ocurrencias, clasificándolas en diferentes **categorías** utilizando dos tipos de jerarquías.

### Funcionamiento del laboratorio

Para ejecutar la aplicación, se debe instalar [Java](https://www.java.com/es/) en su version 11 o superior, además se debe tener la libreria [Gson 2.8.9](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.9)


El archivo a ejecutarse debe ser

```bash
    FeedReaderMain.java
```

El programa resume los feeds analizados, dados por un archivo llamado `subscriptions.json` con el siguiente formato:

```bash
    "url": "https://rss.nytimes.com/services/xml/rss/nyt/%s.xml",
    "urlParams": ["Business", "Technology"],
    "urlType": "rss"
```

### Metodología de trabajo

La realización de todo el laboratorio se dio trabajando en conjunto, siguiendo la técnica de _**pair programming**_. Para ello, se utilizó la extensión de Vscode "_Live Share_" mientras se mantenían reuniones periódicas a través de _Discord_. Adicionalmente, los días viernes se trabajó siguiendo la misma técnica pero de manera presencial. Por tal motivo, la gran mayoría de los commits son de carácter grupal. Las reuniones fueron cada 3 o 4 dias, haciendo grandes avances en menos reuniones a comparación del proyecto anterior.

### Utilización de IAs

Si bien para este laboratorio no nos resultó tan necesaria la utilización de herramientas de inteligencia artificial al momento de comprender el código proporcionado por la cátedra (debido a la verbosidad de Java), si que fue una fuerte ayuda en otros aspectos. Por ejemplo, en la utilización de librerías con las cuales no estábamos familiarizados, o cuestiones relacionadas al **lenguaje** y al **paradigma** para quienes era nuestro primer proyecto con estas tecnologías.
La librería _Gson_ utilizada para parsear archivos _JSON_ con objetos de _Java_, fue exclusiva recomendación de **ChatGPT**, debido a que la librería recomendada por la cátedra acarreaba problemas relacionados a las distintas versiones de Java utilizadas por los integrantes del grupo.
Además, ante un problema de _complejidad algorítmica_ que llevaba a que la ejecución del programa fuera demasiado lenta, ChatGPT nos dio recomendaciones que nos permitieron optimizar determinadas funciones y eliminar tal problema. Incluso al momento de confeccionar los _diccionarios_ de cada categoría de entidad nombrada, fue de ayuda para obtener esos datos más rápidamente y ya formateados según nuestras necesidades.
Por otro lado, **GitHub Copilot** fue de fuerte ayuda para la realización de la petición GET al servidor, en la clase _httpRequest_ fue el encargado de direccionar la principal idea de cómo se desarrolló el algoritmo.

A partir de nuestras experiencias en el uso de herramientas de IA en el primer laboratorio, nos aseguramos de corroborar las respuestas dadas, no encontrando grandes problemas en ellas en esta ocasión.

### Nuestra opinión

La aplicación nos resultó muy _motivante y entretenida_ de desarrollar. Fue un proyecto distinto a los que veníamos realizando en la carrera y lo sentimos más cercano al tipo de programas que se puede realizar en una industria, principalmente por el paradigma y la tecnología usada.
Java nos resultó un lenguaje bastante _verboso_, por ello sentimos que hay muchas líneas de código que podríamos haber optimizado aún más, pero el tiempo nos jugó en contra. En cuanto a la comprensión de la consigna, debemos mencionar que tuvimos dificultades a la hora de entender el propósito de determinados paquetes, especialmente los relacionados al manejo y _clasificación de entidades nombradas_.
