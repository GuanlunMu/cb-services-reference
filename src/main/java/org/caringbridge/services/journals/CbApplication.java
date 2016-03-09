package org.caringbridge.services.journals;

import org.caringbridge.common.services.annotations.EnableCorrelationFilter;
import org.caringbridge.common.services.annotations.EnableMongoDatasource;
import org.caringbridge.common.services.annotations.EnableTrackRequestTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main class to run the application.
 *
 * @author craig.smith
 *
 */

@SpringBootApplication
@ComponentScan("org.caringbridge.services.journals")
@EnableCorrelationFilter
@EnableTrackRequestTime
@EnableSwagger2
@EnableMongoDatasource
public class CbApplication {

	/**
	 * Main method to run the Spring Boot Application.
	 * @param args arguments used when running on command line.
	 */
	public static void main(final String[] args) {
		SpringApplication.run(CbApplication.class, args);
	}
}
