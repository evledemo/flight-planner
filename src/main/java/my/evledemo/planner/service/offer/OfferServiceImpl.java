package my.evledemo.planner.service.offer;

import com.googlecode.jmapper.JMapper;
import my.evledemo.planner.entety.Price;
import my.evledemo.planner.repository.PriceRepository;
import my.evledemo.planner.transport.dto.OfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public List<OfferDTO> list() {
		ArrayList<OfferDTO> offers = new ArrayList<>();
		JMapper<OfferDTO, Price> userMapper = new JMapper<>(OfferDTO.class,
				Price.class);

		priceRepository.findAll().forEach(e -> {
			OfferDTO offerDTO = userMapper.getDestination(e);
			offers.add(offerDTO);
		});

		return offers;
	}

}
