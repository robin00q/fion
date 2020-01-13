package net.fion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;

import net.fion.util.JsonJacksonMapMappingUtil;
import net.fion.util.SetHttpUtil;

@SpringBootApplication
public class FionApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(FionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JsonJacksonMapMappingUtil.jsonMatchTypetoHashMap();
		JsonJacksonMapMappingUtil.jsonDivisiontoHashMap();
		SetHttpUtil.setUpHeader();
	}
	
	
}
