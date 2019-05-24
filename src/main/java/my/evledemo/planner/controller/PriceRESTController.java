package my.evledemo.planner.controller;


import my.evledemo.planner.service.price.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceRESTController {

	@Autowired
	private PriceService priceService;

	@PostMapping("/price/rest/save")
	public void savePrice(@RequestBody String data) {
		priceService.save(data);
	}

}