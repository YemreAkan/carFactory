package tr.com.vodafone.yunusemre.carFactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.com.vodafone.yunusemre.carFactory.model.Car;
import tr.com.vodafone.yunusemre.carFactory.service.CarFactoryServiceImpl;

@RestController
@RequestMapping("/carService")
public class CarFactoryController {
	
	@Autowired
	private CarFactoryServiceImpl carService;

	@GetMapping("/produceCar")
	public ResponseEntity<String> getProduced(@RequestParam String carType){
		if(!StringUtils.hasLength(carType)) {
			return new ResponseEntity<String>("Car Type is required!", HttpStatus.BAD_REQUEST);
		}

		Car car = carService.buildCar(carType);
		if(car == null) {
			return new ResponseEntity<String>("Car Type does not exists.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(car.produce(), HttpStatus.OK);
	}

}
