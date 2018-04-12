package uk.co.smalldogltd.blackcat.rle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BlackcatRleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackcatRleApplication.class, args);
	}
}
