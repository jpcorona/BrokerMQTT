import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttHiveMQApp {
    // Asegúrate de reemplazar esto con la URL de tu broker HiveMQ
    private static final String BROKER_URL = "tcp://tuServidorHiveMQ:1883";
    private static final String CLIENT_ID = "JavaClient";
    // Establece tu nombre de usuario y contraseña de HiveMQ aquí, si es necesario
    private static final String MQTT_USERNAME = "user";
    private static final String MQTT_PASSWORD = "pass";
    private static final String TOPIC_CONTROL_LED = "control-led";
    private static final String TOPIC_VALOR_ANALOGICO = "valor-analogico";

    public static void main(String[] args) {
        try {
            MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(MQTT_USERNAME);
            options.setPassword(MQTT_PASSWORD.toCharArray());
            
            // Opcional: Configurar opciones adicionales como reintentos, keepalive, etc.
            
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Conexión perdida: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("Mensaje recibido. Topico: " + topic + ", Mensaje: " + new String(message.getPayload()));
                    // Implementa tu lógica de manejo de mensajes aquí
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // Implementa cualquier lógica necesaria cuando se completa la entrega de un mensaje
                }
            });
            
            System.out.println("Conectando al broker: " + BROKER_URL);
            client.connect(options);
            System.out.println("Conectado");
            
            // Suscribirse a los topics
            client.subscribe(TOPIC_CONTROL_LED);
            client.subscribe(TOPIC_VALOR_ANALOGICO);

            // Aquí puedes agregar tu lógica de publicación de mensajes o cualquier otra funcionalidad
            
            // Mantén la aplicación corriendo
            // (en un ejemplo real, probablemente querrás implementar una forma más robusta de manejar esto)
            while(true) {
                Thread.sleep(1000);
            }

            // Desconectar el cliente cuando hayas terminado
            // client.disconnect();
            // System.out.println("Desconectado");
        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
