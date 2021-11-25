package fr.younup.crudnocode.librairie.adapter.out.persistence;

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
