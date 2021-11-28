package fr.younup.crudnocode.librairie.adapter.out.persistence;

import fr.younup.crudnocode.librairie.application.port.out.LivreDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class LivreMapper {

	@Mappings({
			@Mapping(target = "titre", source = "entity.titre"),
	})
	public abstract LivreDto livreToLivreDto(Livre entity);

	@Mappings({
			@Mapping(target = "titre", source = "dto.titre")
	})
	public abstract fr.younup.crudnocode.librairie.domain.Livre livreDtoToLivre(LivreDto dto);
}
