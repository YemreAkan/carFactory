package tr.com.vodafone.yunusemre.carFactory.service;

import tr.com.vodafone.yunusemre.carFactory.model.Car;

public interface ICarFactoryService {

	public Car buildCar(String type);
}
