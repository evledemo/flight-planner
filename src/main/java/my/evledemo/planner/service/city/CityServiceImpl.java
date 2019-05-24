package my.evledemo.planner.service.city;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.evledemo.planner.entety.City;
import my.evledemo.planner.repository.CityRepository;
import my.evledemo.planner.transport.dto.CityDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

	private ModelMapper modelMapper = new ModelMapper();
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private CityRepository cityRepository;

	private void saveCity(CityDTO cityDTO) {
		Optional<City> city = cityRepository.findByIata(cityDTO.getIata());
		if (!city.isPresent()) {
			cityRepository.save(create(cityDTO));
		}
	}

	public City create(CityDTO cityDTO) {
		Optional<City> cityOp = cityRepository.findByIata(cityDTO.getIata());
		if (!cityOp.isPresent()) {
			cityOp = Optional.of(modelMapper.map(cityDTO, City.class));
		}
		return cityOp.get();
	}

	@Override
	public void save(String data) {
		try {
			CityDTO cityDTO = mapper.readValue(data, CityDTO.class);
			saveCity(cityDTO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
