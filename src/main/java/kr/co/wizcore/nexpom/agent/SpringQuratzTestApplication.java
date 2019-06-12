package kr.co.wizcore.nexpom.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringQuratzTestApplication {

	@Autowired
	private TestScheduler scheduler;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringQuratzTestApplication.class, args);
	}

}
