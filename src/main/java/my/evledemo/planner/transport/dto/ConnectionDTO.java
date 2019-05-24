package my.evledemo.planner.transport.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import my.evledemo.planner.transport.deserializer.CustomDateDeserializer;

import java.util.Date;

@Getter
@Setter
@ToString
public class ConnectionDTO {
	private String iata;
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date operationStartDate;
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date rescueEndDate;
	private Boolean isDomestic;
	private Boolean isNew;
}
