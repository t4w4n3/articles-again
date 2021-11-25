package fr.younup.crudnocode;

import fr.younup.crudnocode.librairie.adapter.in.web.LivreRestRepository;
import fr.younup.crudnocode.librairie.adapter.out.persistence.Livre;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class Bootstrap {

	private final LivreRestRepository livreRestRepository;

	public Bootstrap(LivreRestRepository livreRestRepository) {
		this.livreRestRepository = livreRestRepository;
	}

	@PostConstruct
	@Transactional
	void init() {
		Livre livre = new Livre();
		livre.titre = "Domain Driven Design";
		livreRestRepository.save(livre);
	}
}
