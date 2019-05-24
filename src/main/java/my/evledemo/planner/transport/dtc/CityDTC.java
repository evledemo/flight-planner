package my.evledemo.planner.transport.dtc;

import lombok.Getter;
import lombok.Setter;
import my.evledemo.planner.transport.dto.CityDTO;

import java.util.List;

@Getter
@Setter
public class CityDTC {
	private List<CityDTO> cities;
}
