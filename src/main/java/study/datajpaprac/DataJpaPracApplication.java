package study.datajpaprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * @EnableJpaRepositories(basePackages = "study.datajpaprac")
 * SpringBoot가 자동으로 끌어온다.
 */

public class DataJpaPracApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaPracApplication.class, args);
	}

}
