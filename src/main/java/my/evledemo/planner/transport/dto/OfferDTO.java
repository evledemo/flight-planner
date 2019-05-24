package my.evledemo.planner.transport.dto;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OfferDTO {
	private Long id;
	@JMap("connection.cityTo.iata")
	private String from;
	@JMap("connection.cityFrom.iata")
	private String to;
	private Double price;
}
