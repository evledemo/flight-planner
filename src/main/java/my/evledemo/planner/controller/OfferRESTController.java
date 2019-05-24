package my.evledemo.planner.controller;

import my.evledemo.planner.service.offer.OfferService;
import my.evledemo.planner.transport.dto.OfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfferRESTController {

	@Autowired
	private OfferService offerService;

	@PostMapping("/offer/rest/list")
	public List<OfferDTO> saveDirection() {
		return offerService.list();
	}
}
