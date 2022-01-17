package tpTamagotchiV2;


public class TamagotchiV2 {
	private String nomTama;
	private String sexe;
	private String couleur;	
	private double taille;
	
	private int energie;
	private int poids;
	private int etatSante;

	
	/**
	 * Constructor TamagotchiV2 
	 * @param nom
	 * @param sexe
	 * @param couleur
	 * @param taille 
	 */
	public TamagotchiV2(String nomTama, String sexe,  String couleur, double taille) {
		this.nomTama = nomTama;
		this.sexe= sexe;
		this.taille = taille;
		this.couleur = couleur;
		this.etatSante = 20;
	}
	
	/**
	 * Getter et setter 
	 * @return param / actions
	 * */
	
	
	public String getNomTama() {
		return nomTama;
	}


	public void setNomTama(String n) {
		nomTama = n.toUpperCase();
	}


	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	
	public String getCouleur() {
		return couleur;
	}

	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public double getTaille() {
		return taille;
	}


	public void setTaille(double taille) {
		this.taille = taille;
	}


	
	public int getEnergie() {
		return energie;
	}


	public void setEnergie(int energie) {
		this.energie = energie;
	}


	public int getPoids() {
		return poids;
	}


	public void setPoids(int poids) {
		this.poids = poids;
	}


	public int getEtatSante() {
		return etatSante;
	}


	public void setEtatSante(int etatSante) {
		this.etatSante = etatSante;
	}

//Surcharge de constructeur
	public TamagotchiV2(String nomTama, String sexe, double taille, String couleur, int energie, int poids) {
		this.setNomTama(nomTama);
		this.sexe= sexe;
		this.taille = taille;
		this.couleur = couleur;
		this.etatSante = 20;
		this.setEnergie(energie);
		this.setPoids(poids);
	}


	//Fait reference etatDeBase() - Surcharge de constructeur
	public TamagotchiV2(String nomTama, String sexe, String couleur, double taille, int energie, int poids, int etatSante) {
		this.setNomTama(nomTama);
		this.setSexe(sexe);
		this.setCouleur(couleur);
		this.setTaille(taille);
		this.setEnergie(energie);
		this.setPoids(poids);
		this.setEtatSante(etatSante);
	}
	

}
