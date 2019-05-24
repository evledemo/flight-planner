package my.evledemo.planner.transport.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CityDTO {
	private String iata;
	private Double longitude;
	private String currencyCode;
	private Double latitude;
	private String shortName;
	private String countryName;
	private String countryCode;
	private String isExcludedFromGeoLocation;
	private Long rank;
	private List<String> aliases;
	private List<Long> categories;
	private List<ConnectionDTO> connections;
}
