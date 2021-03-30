package com.endCom.PokeServicesV2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PokeServicesV2Application implements CommandLineRunner {

	@Autowired
	private JdbcTemplate template;



	@Bean
	public RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(PokeServicesV2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		template.execute("DROP TABLE POKEMON IF EXISTS");
		template.execute("CREATE TABLE c_pokemon (id_pokemon INTEGER (4) PRiMARY KEY auto_increment , " +
				"apodo VARCHAR (50) , " +
				"especie VARCHAR (50) , " +
				"ataque INTEGER (5) , " +
				"defensa INTEGER (5)  ," +
				"salud INTEGER (5)) ");

		//for (int i= 0 ; i<10; i++){
		//	template.update("insert into  c_pokemon(apodo, especie, ataque, defensa, salud)values('Pokemon000"+i+"', 'especie',1,56,8) ");

		//}

	}
}
