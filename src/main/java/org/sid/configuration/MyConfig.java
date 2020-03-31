package org.sid.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.sid.service.StudentRestService;
import org.sid.service.TrainingRestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuration qui permet de déployer Jersey
 * 
 *
 */
@Configuration
public class MyConfig {
	
	@Bean
	public ResourceConfig getJersey() {
		ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(StudentRestService.class);
		resourceConfig.register(TrainingRestService.class);
		return resourceConfig;
	}

}
