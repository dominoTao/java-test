package kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * 消费者示例代码
 */
public class ConsumerFastStart {
    public static final String BROKER_LIST = "192.168.176.129:9092";
    public static final String TOPIC = "topic-demo";
    public static final String GROUP_ID = "group.demo";

    public static void main(String[] args) {
        Properties properties = new Properties(  );
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", StringDeserializer.class.getName());
        properties.put("bootstrap.servers", BROKER_LIST);
        properties.put("group.id", GROUP_ID);

        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(properties);
        // 订阅主题
        consumer.subscribe(Collections.singleton(TOPIC));
        // 循环消费消息
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000 ));
            for (ConsumerRecord<String,String> record : records) {
                System.out.println(record.value() );
            }
        }
    }
}
