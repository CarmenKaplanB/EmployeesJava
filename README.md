# Examen de Java.
 
> Java & Spring  :leaves:
 
Para poner en marcha este proyecto, siga las siguientes instrucciones:
 
* **Paso 1.** *Clonar el proyecto*.
En consola, escriba el siguiente comando.
 
~~~
git clone https://github.com/CarmenKaplanB/EmployeesJava.git
~~~

O simplemente, descargue el archivo zip que se adjunta en este repositorio.

* **Paso 2.** *Conexión H2*.
Al ser una conexión H2 con la base de datos, no necesitará modificar o crear una base de datos en algún gestor externo. 
(Contemple reemplazar sus datos como usuario y contraseña para una conexión exitosa).

Si su intención es ejecutar esta aplicación en MySQL por ejemplo; deberá modificar dos archivos; application properties y POM, ambos que se encuentra dentro del proyecto.
Si su elección es MySQL agregue la dependencia de ´mysql´ en el archivo POM como se muestra a continuación. 
~~~
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
~~~

Por lo tanto, el archivo application properties deberá ser modificado a algo como esto:

~~~
spring.datasource.url=jdbc:mysql://localhost/NombreBasedeDatos?serverTimezone=America/Mexico_City&useSSL=false
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
~~~

´Nota´
Podrá encontrar el archivo en esta ruta ´spring-security-jwt\src\main\resources    y seleccionar el archivo llamado "application"´. 
Considere sustituir los datos requeridos por los suyos, para establecer una conexión exitosa.

* **Paso 3.** *Ejecución de la aplicación*.
Dentro de su editor preferido, despligue la aplicación. Si hace uso de un IDE como IntellijIdea, bastará con pulsar el botón de ejecución como se muestra en la imagen.

![Example](https://raw.githubusercontent.com/CarmenKaplanB/EmployeesJava/main/Screens/MuestraEjecucion.PNG "Example")

* **Paso 4.** *Verifique la salida en consola*.
Cuando ejecutamos la aplicación, deberá visualizarse el logo de Spring en un inicio y posterior a ello una salida exitosa como la que se muestra en la siguiente imagen.

![Example](https://raw.githubusercontent.com/CarmenKaplanB/EmployeesJava/main/Screens/MuestraEjecucionConsola.PNG "Example")

* **Paso 5.** *Continue con el proceso e implemente Python*.
La aplicación esta lista para ser utilizada, podrá ser capaz de ingresar datos desde Postman usando una ruta como la siguiente:

~~~
http://localhost:8080/employee/apiv1/clientes/add
~~~

Asegúrese que el método sea POST, como se muestra en la imagen.
 
![Example](https://raw.githubusercontent.com/CarmenKaplanB/EmployeesPython/main/Screens/MuestraEjecucionPostman.PNG "Example")

O desde la aplicación de Python que se adjunta a continuación. En este enlace, podrá encontrar la guía para su compilación y ejecución.

Enlace: [Repositorio de Python.](https://github.com/CarmenKaplanB/EmployeesPython)

`Nota:`
 
Para implementar completamente el proyecto necesita al menos:
* Un IDE de Java o IntelliJ IDEA.
* Git.
* Spring 5.
* Java 8 o 11.
* Postman.

### ¡Listo! Hemos terminado con éxito.
