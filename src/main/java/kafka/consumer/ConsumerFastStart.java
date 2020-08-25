package kafka.consumer;

//import kafka.entry.Company;
//import kafka.util.CompanyDeserializer;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.Properties;

/**
 * 消费者示例代码
 */
public class ConsumerFastStart {
    public static final String BROKER_LIST = "192.168.176.129:9092";
    public static final String TOPIC = "topic-demo";
    public static final String GROUP_ID = "group.demo";

//    public static void main(String[] args) {
//        Properties properties = new Properties(  );
//        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        //TODO value 的反序列胡器需要重写
//        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CompanyDeserializer.class.getName());
//        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
//        properties.put("group.id", GROUP_ID);
//
//        KafkaConsumer<String,Company> consumer = new KafkaConsumer<>(properties);
//        // 订阅主题
//        consumer.subscribe(Collections.singleton(TOPIC));
//        // 循环消费消息
//        while(true) {
//            ConsumerRecords<String, Company> records = consumer.poll(Duration.ofMillis(1000 ));
//            for (ConsumerRecord<String, Company> record : records) {
//                Company value = record.value( );
//                System.out.println(value.toString() );
//            }
//        }
//    }
}
