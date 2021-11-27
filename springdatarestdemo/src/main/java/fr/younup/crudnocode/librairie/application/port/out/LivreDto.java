package fr.younup.crudnocode.librairie.application.port.out;

import fr.younup.crudnocode.librairie.adapter.out.persistence.Livre;
import org.springframework.data.rest.core.config.Projection;

@Projection(
		name = "livreDto",
		types = { Livre.class })
public interface LivreDto {
	default String getTitre(){
		return "titre projection";
	}
}
