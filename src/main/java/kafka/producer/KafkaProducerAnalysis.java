package kafka.producer;

import com.threadDemo.Producer;
import kafka.entry.Company;
import kafka.util.CompanySerializer;
import kafka.util.DemoPartitioner;
import kafka.util.ProducerInterceptorPrefix;
import kafka.util.ProducerInterceptorPrefixPlus;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * 生产者生产消息，经过拦截器，序列化器， 分区器后  才进入消息累加器
 */
public class KafkaProducerAnalysis {
    public static final String BROKER_LIST = "192.168.176.129:9092";
    public static final String TOPIC = "topic-demo";

    public static Properties initConfig(){
        Properties properties = new Properties(  );
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);// 指定生产之客户端连接Kafka集群所需的broker地址清单
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafka.util.StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CompanySerializer.class.getName());
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "producer.client.id.demo");
        // 重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);
        // 配合分区器
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, DemoPartitioner.class.getName());
        // 拦截器
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, ProducerInterceptorPrefix.class.getName()+","+ ProducerInterceptorPrefixPlus.class.getName());
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = initConfig();
        KafkaProducer<String,Company> producer = new KafkaProducer<>(properties);
        Company company = Company.builder().companyName("王元鹅").companyAddress("北京").build();
        try {

            int i = 0;
            while (i < 5) {
                ProducerRecord<String,Company> record = new ProducerRecord<>(TOPIC, company);
                RecordMetadata recordMetadata = producer.send(record).get( );
                System.out.println(recordMetadata.topic()+"-"+recordMetadata.partition()+":"+recordMetadata.offset() +i++);
                // 同步发送
//                producer.send(record).get();
                // 异步
//            Future<RecordMetadata> futher = producer.send(record);
//            RecordMetadata recordMetadata = futher.get( );
//            System.out.println(recordMetadata.topic()+"\t"+recordMetadata.offset() );
                // 异步
//                producer.send(record, new Callback( ) {
//                    @Override
//                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {// 要么成功  要么异常
//                        if (e != null) {
//                            e.printStackTrace( );
//                        } else {
//                            System.out.println(recordMetadata.topic( ) + "-" + recordMetadata.partition( ) + ":" + recordMetadata.offset( ));
//                        }
//                    }
//                });
            }
        } catch (Exception e) {
            e.printStackTrace( );
        }
    }
}
