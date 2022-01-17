package tpTamagotchiV2;

import tpTamagotchi.RepertoireTamagotchi;

public class PetitTama extends RepertTamagotchiV2 {
	private String nomPetitTama;
	private String couleurPetitTama;
	private String sexePetitTama;

		
	public String getSexePetitTama() {
		return sexePetitTama;
	}


	public void setSexePetitTama(String sexePetitTama) {
		this.sexePetitTama = sexePetitTama;
	}

	
	public String getNomPetitTama() {
		return nomPetitTama;
	}


	public void setNomPetitTama(String nomPetitTama) {
		this.nomPetitTama = nomPetitTama;
	}


	public String getCouleurPetitTama() {
		return couleurPetitTama;
	}


	public void setCouleurPetitTama(String couleurPetitTama) {
		this.couleurPetitTama = couleurPetitTama;
	}

	
	public PetitTama(String nomTama, String couleur, String sexe) {
		super(nomTama, couleur, sexe);

//		this.setPoids(getPoids());
//		this.setEnergie(getEnergie());
		
	}
	

	public void saisieChoixPetitTama() {
		super.saisieChoixTamagotchiV2();
	}


	public PetitTama() {
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public void choixJouer() {
//		
//		// TODO Auto-generated method stub
//		super.choixJouer(petitTama);
//	}
//	
//	@Override
//	public void choixDormir() {
//		
//		// TODO Auto-generated method stub
//		super.choixDormir(petitTama);
//	}
	
	
}
