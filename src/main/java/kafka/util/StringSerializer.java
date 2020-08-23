package kafka.util;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.shiro.io.SerializationException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class StringSerializer implements Serializer<String> {
    private String encoding = "UTF8";


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        String propertyName = isKey ? "key.serializer.encoding" : "value.serializer.encoding";
        Object encodingValue = configs.get(propertyName);
        if(encodingValue == null) {
            encodingValue = configs.get("serializer.encoding");
        }
        if(encodingValue != null && encodingValue instanceof String) {
            encoding = (String) encodingValue;
        }
    }

    @Override
    public byte[] serialize(String topic, String data) {
        try {
            if(data == null) {
                return null;
            }else {
                return data.getBytes(encoding);
            }
        } catch (UnsupportedEncodingException e) {
            throw  new SerializationException( "Error when serializing " + "String to byte[] due to unsupported encoding " + encoding );
        }
    }

    @Override
    public byte[] serialize(String topic, Headers headers, String data) {
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
