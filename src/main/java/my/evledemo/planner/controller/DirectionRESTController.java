package my.evledemo.planner.controller;


import my.evledemo.planner.service.connection.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectionRESTController {

	@Autowired
	private ConnectionService connectionService;

	@PostMapping("/direction/rest/save")
	public void saveDirection(@RequestBody String data) {
		connectionService.saveDirection(data);
	}

}