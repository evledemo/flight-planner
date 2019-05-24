package my.evledemo.planner.transport.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import my.evledemo.planner.transport.deserializer.CustomDateDeserializer;
import my.evledemo.planner.transport.deserializer.CustomDoubleDeserializer;

import java.util.Date;

@Getter
@Setter
@ToString
public class PriceDTO {

	@JsonDeserialize(using = CustomDateDeserializer.class)
	@JsonProperty("d")
	private Date date;
	@JsonDeserialize(using = CustomDoubleDeserializer.class)
	@JsonProperty("p")
	private Double price;
}
