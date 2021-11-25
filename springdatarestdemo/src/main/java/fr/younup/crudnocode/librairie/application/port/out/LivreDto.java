package fr.younup.crudnocode.librairie.application.port.out;

public interface LivreDto {
	default String getTitre(){
		return "titre projection";
	}
}
