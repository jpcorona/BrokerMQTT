# BrokerMQTT
Este proyecto es una aplicación Java que se conecta a un broker MQTT para publicar y suscribirse a mensajes en topics específicos. Es ideal para la integración con sistemas de IoT, permitiendo el control y monitoreo de dispositivos de forma remota.


# Características
Conexión segura a brokers MQTT como HiveMQ.
Publicación de mensajes a topics específicos.
Suscripción a topics y manejo de mensajes recibidos.
Ejemplo de integración con dispositivos IoT para control remoto.
Requisitos Previos

# Para ejecutar este proyecto, necesitarás:
Java JDK 8 o superior.
Maven para la gestión de dependencias y la construcción del proyecto.
Acceso a un broker MQTT (este ejemplo utiliza HiveMQ).

# Configuración
Clona este repositorio en tu máquina local usando git clone <URL-del-repositorio>.
Navega al directorio del proyecto y construye el proyecto con Maven ejecutando mvn clean install.
Asegúrate de modificar el archivo src/main/java/MqttHiveMQApp.java con la URL de tu broker MQTT, nombre de usuario y contraseña si es necesario.
Uso

# Para ejecutar la aplicación, usa el siguiente comando en el directorio del proyecto:

java -jar target/nombre-del-artifacto-generado.jar
Reemplaza nombre-del-artifacto-generado.jar con el nombre del archivo JAR que Maven ha generado en el directorio target/.
