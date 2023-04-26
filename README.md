# Biblioteca

## Índice

- [Introducción](#introducción)

- [Manual](#manual)
    - [Requisitos](#requisitos)
    - [Instalación](#instalación)

- [Diseño](#diseño)
    - [Métodos de las clases](#métodos-de-las-clases)
        - [Libro](#libro)
        - [Persona](#persona)
        - [Usuario](#usuario)
        - [Bibliotecario](#bibliotecario)
        - [Biblioteca](#biblioteca-1)
        - [Material](#material)
        - [Reserva](#reserva)
        - [Menú](#menu)
        - [ClearTerminal](#clearterminal)
        - [Sleep](#sleep)
        - [Repositorio](#repositorio)
        - [App](#app)

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

#### Métodos de las clases

##### Libro

- **`añadirLibro()`:** Permite agregar un nuevo libro a una lista de libros en Java. Se solicita al usuario que ingrese información sobre el libro, como su título, autor, ISBN, editorial y número de copias disponibles. También se le pregunta al usuario si el libro está disponible o no. Luego se crea un objeto Libro con la información proporcionada por el usuario y se agrega a la lista de libros. Finalmente, se muestra un mensaje de confirmación al usuario.

- **`eliminarLibro()`:** Permite eliminar un libro de una lista de libros en Java. Se solicita al usuario que ingrese el ISBN del libro que desea eliminar. Si el ISBN del libro coincide con el ingresado por el usuario, se elimina el libro de la lista utilizando el método "remove" del iterador. Se muestra un mensaje de confirmación al usuario indicando que el libro ha sido eliminado con éxito.

- **`buscarLibroISBN()`:** Busca un libro en una lista de libros de Java utilizando su número de ISBN. El usuario ingresa el ISBN del libro que desea buscar. Se crea un iterador para la lista de libros y se recorre cada elemento de la lista. Si el ISBN del libro coincide con el ingresado por el usuario, se obtiene el índice del libro en la lista utilizando el método "indexOf". Si se encuentra el libro, se muestra un mensaje indicando la posición del libro en la lista. Si no se encuentra el libro, se muestra un mensaje indicando que no se ha encontrado ningún libro con ese ISBN.

- **`buscarLibroTitutlo()`:** Busca un libro en una lista de libros según el título introducido por el usuario. Para ello, recorre la lista mediante un iterador y compara el título de cada libro con el título introducido, ignorando mayúsculas y minúsculas. Si encuentra un libro con el mismo título, devuelve ese libro y lo muestra por pantalla. Si no encuentra ningún libro con el título introducido, devuelve null y muestra un mensaje indicándolo.

- **`modificarDatos()`:**  Permite al usuario modificar los atributos de un objeto Libro. Primero, solicita al usuario que introduzca el nombre del atributo que desea modificar ("ISBN", "título", "autor", "editorial", "nCopias" o "nCopiasDisponibles"). Después, si el usuario ha introducido un nombre de atributo válido, solicita al usuario que introduzca el nuevo valor para ese atributo. Luego, actualiza el valor del atributo del objeto Libro con el nuevo valor proporcionado por el usuario. Si el usuario introduce un nombre de atributo no válido, el método simplemente indica que no se ha encontrado ningún dato con ese nombre.

- **`añadirLibroCopia()`:**  Permite añadir una copia de un libro ya existente a una lista de libros. Primero busca el libro original llamando al método "buscarLibroTitulo" y luego crea una copia de ese libro usando el constructor de copia de la clase Libro. Luego se llama al método "modificarDatos" para que el usuario pueda modificar los datos de la copia si lo desea. Finalmente, la copia se agrega a la lista de libros y se muestra un mensaje de éxito, o un mensaje de error si no se encuentra el libro original.

---

##### Persona

- **`solicitarDatos()`:** Es un método que se utiliza para solicitar al usuario información sobre una persona, como su nombre, apellidos y edad. Los datos se leen desde la entrada estándar y se almacenan en variables de la clase.

- **`cambiarContraseña()`:** Es una función abstracta que se utiliza para cambiar la contraseña de una persona. El método es abstracto porque no tiene implementación en la clase actual y debe ser implementado en las subclases.

---

##### Usuario

- **`solicitarDatosPersona()`:** Este es un método que sobrescribe el método solicitarDatosPersona() de la clase padre Persona. Primero llama al método de la clase padre para solicitar los datos básicos de una persona. Luego, solicita información adicional como número de teléfono, dirección, código postal y correo electrónico. Además, crea una nueva lista de reservas para esta persona.

- **`añadirUsuario()`:** Crea un nuevo objeto de tipo Usuario, solicita los datos de la persona (nombre, apellidos, edad, teléfono, dirección, código postal y correo electrónico) mediante el método `solicitarDatosPersona()`, lo añade a la lista de personas y muestra un mensaje indicando que el usuario ha sido añadido con éxito.

- **`mostrarUsuario()`:** Recorre una lista de personas e imprime por pantalla los datos de aquellos que sean usuarios (instancias de la clase Usuario). Para ello, se utiliza el bucle for-each para iterar sobre cada elemento de la lista y se comprueba si el elemento es una instancia de la clase Usuario utilizando el operador instanceof. Si es así, se imprime la información de la persona utilizando el método toString().

- **`eliminarUsuario()`:** Recibe como parámetro un ArrayList de objetos Persona y permite eliminar un Usuario específico de la lista, buscándolo por su número de teléfono.

- **`iniciarSesion()`:** Permite que un usuario inicie sesión en el sistema a través de la introducción de su número de teléfono y correo electrónico. El método verifica la existencia de un usuario con esos datos y si se encuentran correctamente, muestra un mensaje de bienvenida y devuelve el usuario. Si los datos introducidos son incorrectos, se muestra un mensaje de error y se devuelve un valor nulo.

- **`añadirLibroReservado()`:** Permite añadir una reserva a la lista de reservas de un usuario. Toma como parámetro una reserva y la agrega a la lista de reservas del usuario.

- **`eliminarLibroReservado()`:** Este método elimina una reserva de la lista de reservas de un usuario en particular. Recibe como parámetro un objeto de tipo Reserva. Si el objeto no es nulo, entonces se elimina de la lista de reservas del usuario. De lo contrario, se imprime un mensaje indicando que no hay ninguna reserva con ese ISBN.

- **`buscarReservasPorISBN()`:** Recibe un parámetro "isbn" y busca en la lista de reservas del usuario una reserva que tenga un libro con ese ISBN. Si encuentra una reserva que cumple con ese criterio, devuelve esa reserva. Si no se encuentra ninguna reserva, devuelve una nueva reserva vacía.

- **`mostrarLibrosReservados()`:** Este método muestra los libros reservados por el usuario actual. Primero comprueba si hay alguna reserva en la lista. Si no hay ninguna, imprime un mensaje indicando que no hay reservas. Si hay alguna reserva, itera sobre la lista de reservas e imprime los detalles de cada reserva. Luego, llama al método "obtenerFechaDevolucion" de cada reserva para obtener la fecha de devolución del libro.

- **`saludar()`:**  Muestra por consola un mensaje de saludo, que incluye el nombre de la persona a la que pertenece el objeto que lo llama.

- **`cambiarContraseña()`:** Este método es una implementación de un método abstracto de la clase Persona, llamado `cambiarContraseña()`. Utiliza la anotación @Override para indicar que está sobrescribiendo la implementación por defecto del método. Dentro del método, se solicita al usuario que introduzca una nueva contraseña a través del teclado y se utiliza el método `setEmail()` para establecer la nueva contraseña. Luego, se imprime un mensaje de confirmación.

---

##### Bibliotecario

- **`solicitarDatosPersona()`:** Este es un método que sobrescribe el método solicitarDatosPersona() de la clase padre Persona. Primero llama al método de la clase padre para solicitar los datos básicos de una persona. Luego, solicita información adicional como el puesto de trabajo, NIF, contraseña.

- **`añadirBibliotecario()`:** Este método estático añade un nuevo bibliotecario a una lista de personas en la biblioteca. Crea un objeto Bibliotecario, solicita los datos del Bibliotecario al usuario y agrega el Bibliotecario a la lista. Finalmente, muestra un mensaje de éxito.

- **`mostrarBibliotecario()`:** Este método recibe una lista de personas como parámetro y se encarga de mostrar por pantalla solo aquellas que sean bibliotecarios. Utiliza un bucle for-each para recorrer la lista de personas y un operador instanceof para identificar si cada persona es una instancia de la clase Bibliotecario. Si es así, se muestra la información de la persona por pantalla.

- **`eliminarBibliotecario()`:** Este método recibe una lista de personas, solicita al usuario que introduzca el NIF de un bibliotecario que desea eliminar y busca en la lista si existe un bibliotecario con ese NIF. Si lo encuentra, elimina al bibliotecario de la lista y muestra un mensaje de éxito. Si no lo encuentra, muestra un mensaje de error.

- **`iniciarSesion()`:** Permite que un bibliotecario inicie sesión en el sistema a través de la introducción de su NIF y contraseña. El método verifica la existencia de un bibliotecario con esos datos y si se encuentran correctamente, muestra un mensaje de bienvenida y devuelve el usuario. Si los datos introducidos son incorrectos, se muestra un mensaje de error y se devuelve un valor nulo.

- **`reservarLibro()`:** El método solicita datos de un usuario, busca si el usuario existe en la lista de usuarios y si es así, verifica si ya ha reservado 5 libros o no. Luego solicita el ISBN del libro a reservar y verifica si el libro ya está prestado o no. Si el libro está disponible, lo reserva y lo agrega a la lista de libros reservados del usuario.

- **`devolverLibro()`:** Busca al usuario que quiere devolver un libro mediante su teléfono y correo electrónico, luego solicita el ISBN del libro a devolver y verifica si el libro ha sido prestado, en caso afirmativo lo marca como no prestado y lo elimina de la lista de libros reservados del usuario. En caso contrario, muestra un mensaje de error.

- **`cambiarContraseña()`:** Este método es una implementación de un método abstracto de la clase Persona, llamado `cambiarContraseña()`. Utiliza la anotación @Override para indicar que está sobrescribiendo la implementación por defecto del método. Dentro del método, se solicita al usuario que introduzca una nueva contraseña a través del teclado y se utiliza el método `setEmail()` para establecer la nueva contraseña. Luego, se imprime un mensaje de confirmación.

---

##### Biblioteca

- **`mostrarLibros()`:** Este método muestra los datos de los libros en una lista de libros. Si no hay libros en la lista, muestra un mensaje indicando que no hay libros y sugiere agregar algunos. Utiliza un iterador para recorrer la lista de libros y mostrar los datos de cada libro.

- **`mostrarLibrosDisponibles()`:** Este método muestra los libros disponibles en la biblioteca, es decir, aquellos que no están prestados en ese momento. Si la lista de libros está vacía, se mostrará un mensaje indicando que no hay libros en la biblioteca. Se utiliza un iterador para recorrer la lista de libros y se comprueba si cada libro está prestado o no. Si no está prestado, se muestra la información del libro.

---

##### Material

- **`obtenerFechaDevolucion()`:**  Toma un objeto "Reserva" y devuelve la fecha de devolución de los libros.

- **`mostrarInfoChula()`:**  No devuelve nada y es utilizado para mostrar información general de las reservas.

##### Reserva

- **`crearReserva()`:** Este método está diseñado para crear una nueva reserva de un libro en la biblioteca. Toma un objeto de libro como parámetro, crea un nuevo objeto de reserva, establece el libro y la fecha y hora de reserva, y luego devuelve el objeto de reserva creado.

- **`obtenerFechaDevolucion()`:** Este método calcula y muestra la fecha de devolución de un libro en préstamo, que es un mes después de la fecha de préstamo. Recibe una reserva como parámetro, obtiene su fecha y hora de préstamo, agrega un mes a esta fecha y muestra la fecha resultante de devolución.

- **`mostrarInfoChula()`:** 

---

##### Menu

- **`menu()`:** Implementa todas lós métodos anteriores en un menú construido mediante varios switches y whiles anidados.

---

##### ClearTerminal

- **`clearTerminal()`:** Se utiliza para limpiar la terminal de la consola. En resumen, esta función utiliza la secuencia de escape \033[H\033[2J para mover el cursor a la esquina superior izquierda de la terminal y limpiar la pantalla mediante la eliminación de todo el contenido actualmente mostrado. Luego, System.out.flush() vacía el búfer de salida de la consola, asegurando que cualquier salida anterior se haya eliminado completamente antes de continuar con la ejecución del programa. 

---

##### Sleep

- **`pause()`:** Este método define una pausa en la ejecución del programa durante una cantidad de tiempo dada en milisegundos. Utiliza la excepción InterruptedException para manejar errores.

---

##### Repositorio

- **`abrirRepositorio()`:** Utiliza la biblioteca Desktop de Java para abrir una URL en un navegador web predeterminado. En este caso, la URL es el repositorio de GitHub del proyecto BibliotecaV2. Si hay algún error al abrir la URL, se imprime el error.

---

##### App

- Ejecuta el programa llamando al método `menu`.

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

