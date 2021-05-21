package tr.com.vodafone.yunusemre.carFactory.service;

import org.springframework.stereotype.Component;
import tr.com.vodafone.yunusemre.carFactory.model.Cabrio;
import tr.com.vodafone.yunusemre.carFactory.model.Car;
import tr.com.vodafone.yunusemre.carFactory.model.Hatchback;
import tr.com.vodafone.yunusemre.carFactory.model.Sedan;

@Component
public class CarFactoryServiceImpl implements ICarFactoryService {

	@Override
	public Car buildCar(String type) {
		if(type == null) {
			return null;
		}

		switch (type) {
			case "cabrio":
				return new Cabrio();
			case "sedan":
				return new Sedan();
			case "hatchback":
				return new Hatchback();
			default:
				return null;
		}
	}
}
