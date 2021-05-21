package tr.com.vodafone.yunusemre.carFactory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import tr.com.vodafone.yunusemre.carFactory.controller.CarFactoryController;

@SpringBootTest
class CarFactoryApplicationTests {
	@Autowired
	private CarFactoryController controller;

	@Test
	void testCabrioProduce() {
		String carType = "cabrio";
		ResponseEntity<String> response = controller.getProduced(carType);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Cabrio Car has Produced.");
	}

	@Test
	void testSedanProduce() {
		String carType = "sedan";
		ResponseEntity<String> response = controller.getProduced(carType);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Sedan Car has produced.");
	}

	@Test
	void testHatchbackProduce() {
		String carType = "hatchback";
		ResponseEntity<String> response = controller.getProduced(carType);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Hatchback Car has produced.");
	}

	@Test
	void testInvalidProduce() {
		String carType = "invalid";
		ResponseEntity<String> response = controller.getProduced(carType);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	void testEmptyCarTypeProduce() {
		String carType = "";
		ResponseEntity<String> response = controller.getProduced(carType);

		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
}
