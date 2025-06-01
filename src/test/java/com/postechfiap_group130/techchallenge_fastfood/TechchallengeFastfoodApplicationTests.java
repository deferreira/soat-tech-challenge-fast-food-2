package com.postechfiap_group130.techchallenge_fastfood;

import com.postechfiap_group130.techchallenge_fastfood.config.TestConfig;
import com.postechfiap_group130.techchallenge_fastfood.config.TestRepositoryConfig;
import com.postechfiap_group130.techchallenge_fastfood.config.TestServiceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Import({TestConfig.class, TestRepositoryConfig.class, TestServiceConfig.class})
@ActiveProfiles("test")
class TechchallengeFastfoodApplicationTests {

	@Test
	void contextLoads() {
	}

}
