package fr.younup.crudnocode.library.application.port.in;

public interface LivreDto {
	default String getTitre(){
		return "titre projection";
	}
}
