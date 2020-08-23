package kafka.util;

import kafka.entry.Company;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class ProducerInterceptorPrefixPlus implements ProducerInterceptor<String, Company> {
    private volatile long sendSuccess = 0;
    private volatile long sendFailure = 0;
    @Override
    public ProducerRecord<String, Company> onSend(ProducerRecord<String, Company> producerRecord) {
        Company company = producerRecord.value( );
        company.setName("prefix2-"+company.getName());
        return new ProducerRecord<>(producerRecord.topic(), producerRecord.partition(), producerRecord.timestamp(),
                producerRecord.key(), company, producerRecord.headers());
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if(e == null) {
            sendSuccess++;
        } else {
            sendFailure++;
        }
    }

    @Override
    public void close() {
        double v = (double) sendSuccess / (sendFailure + sendSuccess);
        System.out.println("[INFO] 发送成功率="+String.format("%f", v * 100) + "%" );
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
