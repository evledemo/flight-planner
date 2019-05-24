package my.evledemo.planner.controller;


import my.evledemo.planner.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityRESTController {

	@Autowired
	private CityService cityService;

	@PostMapping("/city/rest/save")
	public void saveCity(@RequestBody String data) {
		cityService.save(data);
	}

}