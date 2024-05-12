package models;

public class Employee {
	private int id;
	private String Nom;
	private String Prenom;
	private String DateEmbauche;
	private String Poste;
	
	public Employee() {
		
	}
	/*
	public Employee(int id, String nom, String prenom, String dateEmbauche, String poste) {
		super();
		this.id = id;
		Nom = nom;
		Prenom = prenom;
		DateEmbauche = dateEmbauche;
		Poste = poste;
	}
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getDateEmbauche() {
		return DateEmbauche;
	}

	public void setDateEmbauche(String dateEmbauche) {
		DateEmbauche = dateEmbauche;
	}

	public String getPoste() {
		return Poste;
	}

	public void setPoste(String poste) {
		Poste = poste;
	}
}
