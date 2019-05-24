package my.evledemo.planner.transport.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CustomDoubleDeserializer extends JsonDeserializer<Double> {

	public Double deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
		String date = jsonparser.getText();
		if(date.contains(","))
			date = date.replace(",","");
		return Double.parseDouble(date.substring(1,date.length()));
	}
}