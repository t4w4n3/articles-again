package fr.younup.crudnocode.librairie.adapter.in.web;

import fr.younup.crudnocode.librairie.application.port.in.LivreRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneController {

	@Autowired
	private LivreRestRepository livreRestRepository;

	@Transactional(readOnly = true)
	@GetMapping("/truc")
	public String getTruc() {
		return "pouet";
	}
}
