package fr.younup.crudnocode.library.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Livre {

	@Id
	@GeneratedValue
	public Long id;

	public String titre;
}
