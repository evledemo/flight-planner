package my.evledemo.planner.transport.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 2018-12-16T00:00:00
public class CustomDateDeserializer extends JsonDeserializer<Date> {
	public CustomDateDeserializer() {
	}

	public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = jsonparser.getText();
		if (date != null && date.length() != 0) {
			try {
				date = date.substring(0,date.length());
				return format.parse(date);
			} catch (ParseException var6) {
				throw new RuntimeException(var6);
			}
		} else {
			return null;
		}
	}
}
