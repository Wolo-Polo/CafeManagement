package cafemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cafemanage")
@SpringBootApplication
public class CafeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeManagementApplication.class, args);
	}

}
