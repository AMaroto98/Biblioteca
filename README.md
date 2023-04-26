# Biblioteca

## Índice

- [Introducción](#introducción)

- [Manual](#manual)
    - [Requisitos](#requisitos)
    - [Instalación](#instalación)

- [Diseño](#diseño)
- [Librerias utilizadas](#librerias-utilizadas)
- [Conclusiones]
    - [Mejoras]


---

### Introducción

Bienvenido/a al proyecto de la Biblioteca del Centro Borja Moll. Este trabajo ha sido llevado a cabo por Antonio Maroto durante el primer curso de DAW con el propósito de trabajar con la programación orientada a objetos en Java.

El objetivo de este desafio era crear una biblioteca que tuviese usuarios y bibliotecarios y que cada uno de ellos pudiera realizar diferentes tareas. En el caso de los usuarios reservar libros y cambiar de contraseña y en el caso de los bibliotecarios buscar libros por título o ISBN, dar de alta nuevos usuarios y trabajadores, reservar y devolver libros para los usuarios y muchas cosas más.

---

### Manual

#### Requisitos

Para poder comenzar a poner en funcionamiento el programa debes tener como requisitos mínimos los siguientes:

- Git
- JDK
- VS Code o algún IDE

---

#### Instalación

Crea un directorio y sitúate dentro de él. Es importante crearlo pues aquí dentro se almacenará todo el código de la aplicación.
~~~
$ mkdir BibliotecaBorjaMoll
$ cd BibliotecaBorjaMoll
~~~

Una vez dentro del directorio clonamos el repositorio de Github.
~~~
git clone https://github.com/AMaroto98/BibliotecaV2
~~~

Accedemos a la carpeta que tendremos tras clonar el proyecto y una vez dentro de la carpeta lo abrimos desde la terminal con VS Code o el IDE que más te guste.
~~~
$ cd BibliotecaV2
$ code .
~~~

---

### Diseño

![Diagrama](/images/Diagrama.jpeg)

El proyecto se encuentra situado en la carpeta `src`, dentro de ella podemos encontrar los diferentes archivos:

- `App`: Es el archivo principal desde el cual se ejecuta el programa.
- `Menu`: Es la clase donde se encuentra el menu que ejecuta todos los métodos del resto de clases, es el pilar fundamental del proyecto.
- `Biblioteca`: Es la clase a partir de la cual se crea la Biblioteca del Borja Moll y almacena los libros y empleados y usuarios de ésta.
- `Persona`: Es una clase abstracta la cual tiene dos métodos principales que heredan sus clases hijas.
- `Usuario`: Clase hija de `Persona` que estblece los métodos para los usuarios.
- `Bibliotecario`: Clase hija de `Persona` que establece los métodos para los bibliotecarios.
- `Libro`: Clase donde se definen todos los métodos para trabajar con los libros de la biblioteca.
- `Reserva`: Clase utilizada por los bibliotecarios y usuarios para guardar la información de los libros que se reservan.
- `Material`: Interfaz que aplica la clase `Reserva`.
- `ClearTerminal`: Clase que limpia la terminal cada vez que se ejecuta el programa o se usa algún método, su trabajo es meramente visual.
- `Sleep`: Clase que permite una breve pausa entre método y método para poder leer mensajes en la terminal o similares.
- `Repositorio`: Clase que contiene un método que lleva al mismo repositorio donde estás leyendo esta documentación.

---

### Librerias utilizadas

Las librerias utilizadas en el proyecto son las siguientes:

- **Java.util:**
    - ArrayList: Es una clase que implementa la interfaz List en Java y proporciona una implementación de  tamaño dinámico de una matriz. Permite agregar, eliminar y buscar elementos en la lista.
    - Iterator: Es una interfaz utilizada para recorrer elementos de una colección en Java. Proporciona métodos para verificar si hay más elementos, obtener el siguiente elemento y eliminar el elemento actual de la colección.
    - InputMismatchException: Es una excepción lanzada por la clase Scanner cuando se encuentra un token en el flujo de entrada que no coincide con el tipo de dato esperado.
    - List: Es una interfaz en Java que define un conjunto de operaciones para trabajar con listas ordenadas. Las clases ArrayList y LinkedList implementan esta interfaz.
    - Scanner: Es una clase en Java que se utiliza para analizar entradas de datos y dividirlas en tokens.

- **Java.time:**
    - LocalTime: Es una clase en Java que representa una hora del día sin una fecha asociada. Proporciona métodos para obtener la hora, los minutos y los segundos, y realizar operaciones aritméticas con ellas.

- **Java.awt:**
    - Desktop: Es una clase en Java que proporciona acceso a características del sistema operativo relacionadas con el escritorio, como abrir archivos, navegar por la web y enviar correo electrónico.

- **Java.net:**
    - URI: Es una clase en Java que representa un Identificador de Recursos Uniforme (URI), que es una cadena de caracteres que identifica un recurso en la web. Proporciona métodos para analizar y construir URIs.

---

### Conclusiones

#### Mejoras

De cara al futuro me gustaría almacenar la información de los libros, reservas, usuarios en una base de datos y poder hacer consultas más especificas.
Poder ejecutar la aplicación en una interfaz gráfica y no sólo con la terminal.

