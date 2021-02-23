package cafemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cafemanage")
@SpringBootApplication
public class CafeManagementApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CafeManagementApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CafeManagementApplication.class, args);
	}

}
