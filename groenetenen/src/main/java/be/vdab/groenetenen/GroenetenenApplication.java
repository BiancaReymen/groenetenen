package be.vdab.groenetenen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD

@SpringBootApplication
=======
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
>>>>>>> refs/remotes/origin/master
public class GroenetenenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroenetenenApplication.class, args);
	}

}

