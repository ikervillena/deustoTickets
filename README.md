# deustoTickets
Este repositorio contiene el proyecto grupal para la asignatura "Diseño de Software".

## Descripción y alcance del proyecto
El proyecto consiste en diseñar y desarrollar una aplicación, DeustoTicket,  para la venta de entradas de distintos tipos de eventos. Estará dirigida al consumidor final por lo que será una aplicación B2C. La aplicación estará compuesta por dos frontends y un backend. El primer frontend lo utilizarán los clientes de los eventos, que les permitirá realizar la compra de entradas. Y el otro estará dirigido al staff de los eventos, donde podrán verificar los códigos QR de las entradas de los clientes. La conexión entre los frontends y el backend será mediante RMI.
Por otro lado, nuestra aplicación no se encargará de generar entradas, las conseguirá a través del proveedor mayorista de entradas TicketProvider. Nuestro backend mediante una API REST obtendrá información de los próximos eventos y podrá realizar la compra de entradas.
Además, nuestro servidor se encargará de generar un código QR y de enviar por correo electrónico  la entrada, con dicho QR, al cliente.

### Punto de vista del cliente
La aplicación que vamos a desarrollar te dará la posibilidad de registrarte y de iniciar sesión. Los datos de los usuarios serán almacenados en la base de datos MySQL, que está conectada con el backend.
Después la aplicación mostrará la oferta de eventos  y el usuario podrá acceder a cada evento para ver la información correspondiente. Para que el usuario pueda comprar una entrada, haremos un apartado de entradas donde podrá ver las diferentes opciones. Tanto la información de los eventos, como de las entradas se obtendrán mediante el API REST de TicketProvider. Cuando el usuario compre una entrada, la información de la compra, con los datos del usuario y el evento se almacenarán en la base de datos.

### Punto de vista del staff
El staff iniciará sesión con su nombre de usuario y contraseña, que estará guardado en MySQL, y accederá a la lista de eventos. Una vez seleccione un evento, le aparecerá la misma información que a los clientes, pero en vez de la opción de compra de entradas, verá la opción de escanear QR. Una vez accedido, aparecerá un recuadro para escanear el QR y este devolverá si el QR es válido o no.
En el diseño de la interfaz gráfica, explicamos más detalladamente que hace cada pantalla de la aplicación.

### Organizacion del software
El proyecto, tal y como hemos comentado anteriormente, consta de 3 aplicaciones diferentes: un backend y dos frontends (uno para los usuarios y otro para el staff).
Las 3 aplicaciones son independientes pero se relacionan entre sí y siguen la misma estructura. Hemos optado por utilizar una arquitectura por capas, diferenciando las 3 principales: capa de presentación (presentation), capa de negocio (business) y capa de acceso a datos (data access).
