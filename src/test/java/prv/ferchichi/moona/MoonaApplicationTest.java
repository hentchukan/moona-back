package prv.ferchichi.moona;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import prv.ferchichi.moona.domains.category.CategoryController;


@ActiveProfiles("test")
@SpringBootTest
class MoonaApplicationTest {

	@Autowired
	private CategoryController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
