package Eco3DPrint.BackendEco3DPrint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class BackendEco3DPrintApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendEco3DPrintApplication.class, args);
	}

}
