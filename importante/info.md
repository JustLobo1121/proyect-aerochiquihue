# clases del modelo
- Las clases `AssistantData`, `EncomiendaData` y `ViajeData`, contienen atributos que representan la información de los asistentes y los detalles de los viajes y encomiendas
- la clase `avion` son los datos de los 3 tipos de avion junto con su distribucion 
- la clase `TotalCost` es la que genera y retorna un costo dependiendo del destino, peso o cantidad de asientos
# clases del controller
- La clase `assistantController`. Esta clase contiene métodos que gestionan las acciones del usuario, como la confirmación de selección de asientos y el manejo de pagos
- la clase `managerController`. esta clase se encarga de la visualizacion de los datos, utilizando la base de datos dependiendo de cual boton se visualizan los datos de la tabla de viajes o encomienda
# cosas de la base de datos
- La clase `DataSaver` contiene métodos para guardar datos en la Base de Datos, como "saveViajeToDb" y "saveEncomiendaToDb", que almacenan la información de los viajes y encomiendas respectivamente
- la clase `DataReader` se encarga de leer datos de la Base de Datos, como en el método readData, que obtiene la información de los asistentes