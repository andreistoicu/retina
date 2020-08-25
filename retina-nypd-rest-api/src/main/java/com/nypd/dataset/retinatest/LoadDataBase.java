package com.nypd.dataset.retinatest;


import java.io.BufferedReader;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.nypd.dataset.retinatest.entity.Historic;
import com.nypd.dataset.retinatest.repository.HistoricRepository;

@Configuration
public class LoadDataBase {
	
    Logger logger = LoggerFactory.getLogger(LoadDataBase.class);

	@Autowired
    private Environment env;
	
	@Bean
	CommandLineRunner initDatabase(HistoricRepository repository) {

		return args -> {
			
			String line = "";
			String file = env.getProperty("app.csvFileLocation");
			
			logger.warn("=======================================================================");
			logger.error("DB IS LOADING , PLEASE WAIT THE SUCCCESS MESSAGE ...it can take a while");
			logger.warn("=======================================================================");

			BufferedReader br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");

				int cmplntNum = Integer.parseInt(data[0]);
				int kyCd = Integer.parseInt(data[7]);

				repository.save(new Historic(cmplntNum, kyCd));
			};
			br.close();
			
			logger.warn("======================================================================");
			logger.warn("-----SUCCESSFULLY LOADED THE DB DATA , now you can access the API-----");
			logger.warn("======================================================================");

		};
	}
}
