# Biblioteca

## Índice

- [Introducción](#introducción)

- [Manual](#manual)
    - [Requisitos](#requisitos)
    - [Instalación](#instalación)

- [Diseño](#diseño)


### Introducción

Bienvenido/a al proyecto de la Biblioteca del Centro Borja Moll. Este trabajo ha sido llevado a cabo por Antonio Maroto durante el primer curso de DAW con el propósito de trabajar con la programación orientada a objetos en Java.

El objetivo de este desafio era crear una biblioteca que tuviese usuarios y bibliotecarios y que cada uno de ellos pudiera realizar diferentes tareas. En el caso de los usuarios reservar libros y cambiar de contraseña y en el caso de los bibliotecarios buscar libros por título o ISBN, dar de alta nuevos usuarios y trabajadores, reservar y devolver libros para los usuarios y muchas cosas más.

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

Meter imagen diseño proyecto

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

### Librerias usadas

