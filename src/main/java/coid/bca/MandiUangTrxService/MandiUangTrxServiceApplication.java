package coid.bca.MandiUangTrxService;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackageClasses = { 
		MandiUangTrxServiceApplication.class,
		Jsr310JpaConverters.class 
})
public class MandiUangTrxServiceApplication {
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+7"));
	}
	
	public static void main(String[] args) {
	
		SpringApplication.run(MandiUangTrxServiceApplication.class, args);
	}

}
