package cn.com.norming.base.web.custom;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

import cn.com.norming.base.util.DateUtil;

public class CustomObjectMapper extends ObjectMapper {  
  
    public CustomObjectMapper(){  
        CustomSerializerFactory factory = new CustomSerializerFactory();
        
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>(){

			@Override
			public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) 
					throws IOException, JsonProcessingException {
				jgen.writeString(DateUtil.TRANS_FORMAT_DATE.format(value));
			}
        });
        
        factory.addGenericMapping(Timestamp.class, new JsonSerializer<Timestamp>() {

			@Override
			public void serialize(Timestamp value, JsonGenerator jgen,
					SerializerProvider provider) throws IOException,
					JsonProcessingException {
				jgen.writeString(DateUtil.TRANS_FORMAT_STAMP.format(value));
			}
        	
        });
        
        this.setSerializerFactory(factory);  
    }  
}  