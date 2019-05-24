package my.evledemo.planner.service.connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.evledemo.planner.entety.City;
import my.evledemo.planner.entety.Connection;
import my.evledemo.planner.repository.CityRepository;
import my.evledemo.planner.repository.ConnectionRepository;
import my.evledemo.planner.transport.dtc.CityDTC;
import my.evledemo.planner.transport.dto.CityDTO;
import my.evledemo.planner.transport.dto.ConnectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	private ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ConnectionRepository connectionRepository;

	@Override
	public void saveDirection(String data) {
		try {
			// for debug
//			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\temp.txt"));
//			writer.write(data);
			CityDTC cityDTC = mapper.readValue(data, CityDTC.class);
			saveConnection(cityDTC.getCities());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveConnection(List<CityDTO> cities) {
		for (CityDTO cityDTO : cities) {
			String iataFrom = cityDTO.getIata();
			for (ConnectionDTO connectionDTO : cityDTO.getConnections()) {
				String iataTo = connectionDTO.getIata();
				Optional<Connection> conection = connectionRepository.findByCityFromAndCityTo(null, null);
				if (!conection.isPresent()) {
					conection = Optional.of(create(connectionDTO, null, null));
				} else {
					Optional<City> cityTo = cityRepository.findByIata(connectionDTO.getIata());
					Optional<City> cityFrom = cityRepository.findByIata(connectionDTO.getIata());
					update(connectionDTO, conection.get(), cityFrom.get(), cityTo.get());
				}
				connectionRepository.save(conection.get());
			}
		}
	}

	public Connection create(ConnectionDTO connectionDTO, City cityFrom, City cityTo) {
		Connection connection = new Connection();
		connection.setCityFrom(cityFrom);
		connection.setCityTo(cityTo);
		connection.setRescueEndDate(connectionDTO.getRescueEndDate());
		connection.setOperationStartDate(connectionDTO.getOperationStartDate());
		return connection;
	}

	public void update(ConnectionDTO connectionDTO, Connection connection, City cityFrom, City cityTo){
		connection.setOperationStartDate(connectionDTO.getOperationStartDate());
		connection.setRescueEndDate(connectionDTO.getRescueEndDate());
		connection.setCityTo(cityTo);
		connection.setCityFrom(cityFrom);

	}

}
