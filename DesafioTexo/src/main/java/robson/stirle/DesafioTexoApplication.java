package robson.stirle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages = {"robson.stirle.model"})
@ComponentScan(basePackages = {"robson.stirle"})
@EnableJpaRepositories(basePackages = {"robson.stirle.repository"})
@EnableTransactionManagement
@RestController
@EnableAutoConfiguration
public class DesafioTexoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTexoApplication.class, args);
	}

}
