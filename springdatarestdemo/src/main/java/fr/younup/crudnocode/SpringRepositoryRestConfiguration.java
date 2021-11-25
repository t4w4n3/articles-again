package fr.younup.crudnocode;

import fr.younup.crudnocode.library.adapter.out.persistence.Livre;
import fr.younup.crudnocode.library.application.port.in.LivreDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class SpringRepositoryRestConfiguration {
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return RepositoryRestConfigurer.withConfig(repositoryRestConfiguration ->
				repositoryRestConfiguration.getProjectionConfiguration()
						.addProjection(LivreDto.class, Livre.class));
	}
}
