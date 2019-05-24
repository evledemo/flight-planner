package my.evledemo.planner.service.price;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.evledemo.planner.entety.City;
import my.evledemo.planner.entety.Connection;
import my.evledemo.planner.entety.Price;
import my.evledemo.planner.repository.CityRepository;
import my.evledemo.planner.repository.ConnectionRepository;
import my.evledemo.planner.repository.PriceRepository;
import my.evledemo.planner.transport.dtc.PriceDTC;
import my.evledemo.planner.transport.dto.PriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private PriceRepository priceRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ConnectionRepository connectionRepository;

	@Override
	public void save(String data) {
		try {
			PriceDTC cityDTO = mapper.readValue(data, PriceDTC.class);
			Optional<City> cityFrom = cityRepository.findByIata(cityDTO.getItaFrom());
			Optional<City> cityTo = cityRepository.findByIata(cityDTO.getItaTo());
			Optional<Connection> connectionOutbound = connectionRepository
					.findByCityFromAndCityTo(cityFrom.get(), cityTo.get());
			Optional<Connection> connectionReturn = connectionRepository
					.findByCityFromAndCityTo(cityTo.get(), cityFrom.get());
			List<Price> byConnection = priceRepository.findByConnection(connectionOutbound.get());
			List<Price> byConnection1 = priceRepository.findByConnection(connectionReturn.get());
			priceRepository.findByConnection(connectionOutbound.get()).forEach(e -> priceRepository.delete(e));
			priceRepository.findByConnection(connectionReturn.get()).forEach(e -> priceRepository.delete(e));

			for (PriceDTO priceDTO : cityDTO.getPricesOutbound()) {
				Connection connection = connectionOutbound.get();
				savePrice(priceDTO, connectionOutbound.get(), connection.getCityFrom().getCurrencyCode());
			}

			for (PriceDTO priceDTO : cityDTO.getPricesReturn()) {
				Connection connection = connectionReturn.get();
				savePrice(priceDTO, connectionReturn.get(), connection.getCityTo().getCurrencyCode());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void savePrice(PriceDTO priceDTO, Connection connection, String currencyCode) {
		Price price = new Price();
		price.setConnection(connection);
		price.setDate(priceDTO.getDate());
		price.setPrice(priceDTO.getPrice());

		if (currencyCode.equalsIgnoreCase("EUR")) {
			price.setPriceEuro(priceDTO.getPrice());
		} else if (currencyCode.equalsIgnoreCase("RON")) {
			price.setPriceEuro(priceDTO.getPrice() * 0.21);
		} else if (currencyCode.equalsIgnoreCase("UAH")) {
			price.setPriceEuro(priceDTO.getPrice() * 0.032);
		}

		priceRepository.save(price);
	}
}
