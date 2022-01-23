package tpTamagotchiV2;

import java.util.Scanner;


public class RepertTamagotchiV2 {
	
	//affectation et initialisation de variable
		String nomTama = "";
		String sexe = "";
		String couleur = "";	
		double taille;

		static int energie = 10; //Pour acceder energie donc static
		static int poids = 1;
		static int etatSante = 20;
		
		static Scanner saisir = new Scanner(System.in);
		

		/*
		 * Saisie au clavier des caracteristiques du Tama par l'utilisateur
		 * */
		public void saisieChoixTamagotchiV2() {
			TamagotchiV2 nouveauTama = new TamagotchiV2 (nomTama, sexe, couleur, taille, 10, 1, 20);
			System.out.println("Veuillez saisir le nom de votre Tamagotchi: ");
			String choixNom = saisir.nextLine();
			nouveauTama.setNomTama(choixNom);
			
			System.out.println("Veuillez saisir le sexe de votre Tamagotchi: (M/F) ");
			String choixSexe = saisir.nextLine();
			nouveauTama.setSexe(choixSexe);
			
			System.out.println("Veuillez saisir la couleur de votre Tamagotchi: ");
			String choixCouleur = saisir.nextLine();
			nouveauTama.setCouleur(choixCouleur);
			
			System.out.println("Veuillez donner une taille a votre Tamagotchi: (chiffre) ");
			double choixTaille = saisir.nextDouble();
			nouveauTama.setTaille(choixTaille);
			saisir.nextLine();
			
			etatDeBase(nouveauTama, energie, poids, etatSante);
			activiteTama(nouveauTama);
		}
		
		
		//Affichage du Tamagotchi cree / choisi
		public static void etatDeBase(TamagotchiV2 tamagotchiV2, int energie, int poids, int etatSante) {
			System.out.println("Les caracteristiques de votre tamagagotchi sont suivantes"+"\n\tVotre tamagotchi est nommé "+tamagotchiV2.getNomTama()+ 
					".\n\tSon sexe est "+tamagotchiV2.getSexe()+ 
					".\n\tSa couleur est de "+tamagotchiV2.getCouleur()+
					".\n\tVous lui avez donné une taille de " +tamagotchiV2.getTaille()+ " m.\n" +
					"\tIl a une energie de base de "+tamagotchiV2.getEnergie()+ ", de poids de "+tamagotchiV2.getPoids()+ ", et a son sommet de sante de "+tamagotchiV2.getEtatSante()+".");		
		}
		
		
		//Choix des activites a faire
		public static void activiteTama(TamagotchiV2 tamagotchiV2) {

			boolean vie = false;
			
			do {	
					vie = true;
					System.out.println("Voulez-vous faire un peu d'activités ? (oui / non)");
					String reponse = saisir.nextLine();
				
					if (reponse.equals("oui")) {
					//	vie = true;	
					System.out.println("On va faire des activites qui sont : dormir ou jouer ou manger ou fumer ou sport");
					System.out.println("Veuillez choisir entre une de ces 5 propositions");
					
					String choixActivite = saisir.nextLine();
			
						if(choixActivite.equals("dormir")) {
							
							if (tamagotchiV2.getEnergie() >= 10) {
								System.out.println(tamagotchiV2.getNomTama()+ "  est a son maximum d'energies. Faites autres choses");
							} 
							else {
								choixDormir(tamagotchiV2);
							}
						
						} else if (choixActivite.equals("jouer")) {
							choixJouer(tamagotchiV2);
							if (tamagotchiV2.getEnergie() <= 0) {
								vie = false;
								System.out.println(tamagotchiV2.getNomTama()+ " n'a plus de force pour jouer");
								break;
							} 
							
						} else if (choixActivite.equals("manger")) {
							choixManger(tamagotchiV2);
							if (tamagotchiV2.getPoids() > 15) {
								System.out.println(tamagotchiV2.getNomTama()+ " a succombe a son poids. RIP");
								break;
							}
						}
						
						else if (choixActivite.equals("fumer")) {
							choixFumer(tamagotchiV2);
							if (tamagotchiV2.getEtatSante() <= 0 && tamagotchiV2.getEnergie() <= 0) {
								System.out.println(tamagotchiV2.getNomTama()+ " est dans le coma suite a son cancer.");
								break;
							}
						}
						else if (choixActivite.equals("sport")) {
							
							if (tamagotchiV2.getEtatSante() >= 20 && tamagotchiV2.getEnergie()>=10) {
								System.out.println("Wow " +tamagotchiV2.getNomTama()+ " est au top de sa forme. \nIl ne pourra plus aller au dela. Faites autres choses");
							}else if (tamagotchiV2.getEtatSante() >= 20 && tamagotchiV2.getEnergie() <10) {
								System.out.println(tamagotchiV2.getNomTama()+ " est en bonne sante. \nCependant, il est fatigué, energie baisse a "+tamagotchiV2.getEnergie()+".");
							}
							else {
								choixFaireSport(tamagotchiV2);
							}
						}
						else {
							System.out.println("Votre reponse n'est pas valide, on recommence");

						}
						
					} 
					else if (reponse.equals("non")) {
	//					vie = false;
						break;
					}
					else {
						
						System.out.println("Votre reponse n'est pas valide, on recommence");
						vie = false;
					}
				
			} while (!vie || tamagotchiV2.getEnergie() > 0 || tamagotchiV2.getPoids() <= 15 || tamagotchiV2.getEtatSante() > 0);
			
			System.out.println("Merci et à bientot !");
		}
		
		
		//Methode Jouer
		public static void choixJouer(TamagotchiV2 tamagotchiV2) {
			calculEnergiePerdue(tamagotchiV2);
			
			System.out.println("L'energie de votre tamagotchi "+tamagotchiV2.getNomTama()+ " est tombé à " +tamagotchiV2.getEnergie());
			
			String rep = "";
			do {
				System.out.println("Voulez-vous rejouer ? (oui/non)");
				rep = saisir.nextLine();
				
				if (rep.equals("oui") && energie > 0) {
				System.out.println("Veuillez taper : jouer");
				saisir.nextLine();
				
				calculEnergiePerdue(tamagotchiV2);
				System.out.println("L'energie de votre tamagotchi "+tamagotchiV2.getNomTama()+ " est tombé à " +tamagotchiV2.getEnergie());		
					
				} 
			
				else {
					break;
				}
			} while (rep.equals("oui"));
			

		}
		
		
		//Methode Manger
		public static void choixManger(TamagotchiV2 tamagotchiV2) {
			calculPoids(tamagotchiV2);
			System.out.println("Le tamagotchi " +tamagotchiV2.getNomTama()+ " a pris du poids. Il pese desormais " +tamagotchiV2.getPoids()+ ".");
			
			String rep = "";
			do {
				
				System.out.println("Voulez-vous continuer a manger ? (oui/non)");
				rep = saisir.nextLine();
				
				if (rep.equals("oui") && tamagotchiV2.getPoids() <= 15) {
					System.out.println("Veuillez taper : manger");
					saisir.nextLine();
					
					calculPoids(tamagotchiV2);
					System.out.println("Le tamagotchi " +tamagotchiV2.getNomTama()+ " a repris du poids. Il pese " +tamagotchiV2.getPoids()+ ".");				
				} 

				else {	
					break;
				}
			
			} while (rep.equals("oui"));

		}
		
		//Methode Dormir
		public static void choixDormir(TamagotchiV2 tamagotchiV2) {

			tamagotchiV2.setEnergie(energie);
			System.out.println("Votre tamagotchi "+tamagotchiV2.getNomTama()+ " a un niveau d'energie de "+tamagotchiV2.getEnergie());

			String rep = "";
			do {
				
				System.out.println("Voulez-vous continuer a dormir ? (oui/non)");
				rep = saisir.nextLine();
				
				if (rep.equals("oui") && tamagotchiV2.getEnergie() < 10) {
					System.out.println("Veuillez taper : dormir");
					saisir.nextLine();
					
					energie = tamagotchiV2.getEnergie() +1;
					tamagotchiV2.setEnergie(energie);
					System.out.println("Votre tamagotchi "+tamagotchiV2.getNomTama()+ " est entrain de dormir et il aura un taux d'energie de "+tamagotchiV2.getEnergie()+" à son reveil");				
				} 
				
				else if (tamagotchiV2.getEnergie() >= 10) {
					System.out.println("L'energie de " +tamagotchiV2.getNomTama()+ " ne pourra pas changer car elle est a son niveau maximum");
				}

				else {	
					break;
				}
			
			} while (rep.equals("oui"));
		}
		
		
		//Methode Fumer
		public static void choixFumer(TamagotchiV2 tamagotchiV2) {
			
//			tamagotchiV2.setEtatSante(etatSante);
//			
//			tamagotchiV2.setEnergie(energie);
			
			calculSantePerdue(tamagotchiV2);
			
			calculEnergiePerdue(tamagotchiV2);
			
			System.out.println(tamagotchiV2.getNomTama()+ " vient de fumer une cigarette et donc sa sante se degrade. \nLe niveau est desormais à " +tamagotchiV2.getEtatSante()+
					".\nEt son energie est egalement affectee, elle est a "+tamagotchiV2.getEnergie());
			
			String rep = "";
			do {
				System.out.println("Voulez-vous continuer a fumer ? (oui/non)");
				rep = saisir.nextLine();
				
				if (rep.equals("oui") && etatSante > 0 && energie > 0) {
				System.out.println("Veuillez taper : fumer");
				saisir.nextLine();
				
				calculSantePerdue(tamagotchiV2);
				
				calculEnergiePerdue(tamagotchiV2);
			
				System.out.println("La sante de votre tamagotchi "+tamagotchiV2.getNomTama()+ " est tombé à " +tamagotchiV2.getEtatSante()+
						".\nEt son energie est egalement affectee, elle est a "+tamagotchiV2.getEnergie());		
					
				} 
			
				else {

					break;
				}
			} while (rep.equals("oui"));

		}
		
		//Methode Faire du sport
		public static void choixFaireSport(TamagotchiV2 tamagotchiV2) {
			
			tamagotchiV2.setEtatSante(etatSante);
			System.out.println("Votre tamagotchi "+tamagotchiV2.getNomTama()+ " est en tres bonne sante. Son niveau est a son maximum "+tamagotchiV2.getEtatSante());

			String rep = "";
			do {
				
				System.out.println("Voulez-vous continuer a faire du velo ? (oui/non)");
				rep = saisir.nextLine();
				
				if (rep.equals("oui") && tamagotchiV2.getEtatSante() < 20) {
					System.out.println("Veuillez taper : sport");
					saisir.nextLine();
					
					calculSanteGagnee(tamagotchiV2);
					System.out.println("Votre tamagotchi "+tamagotchiV2.getNomTama()+ " vient de faire du velo. \nSa sante va s'ameliorer de "+tamagotchiV2.getEtatSante()+".");				
				} 
				
				else if (tamagotchiV2.getEtatSante() >= 20) {
					System.out.println("Wow ! " +tamagotchiV2.getNomTama()+ " est au top de sa forme. \nIl ne pourra plus aller au dela car elle est a son niveau maximum");
				}

				else {	
					break;
				}
			
			}  while (rep.equals("oui"));
		}
		
		
		//calcul energie perdue
		public static void calculEnergiePerdue(TamagotchiV2 tamagotchiV2) {
			energie = tamagotchiV2.getEnergie() -5;
			tamagotchiV2.setEnergie(energie);
		}
		
		//calcul energie gagnee
		public static void calculEnergieGagnee(TamagotchiV2 tamagotchiV2) {
			energie = tamagotchiV2.getEnergie() +5;
			tamagotchiV2.setEnergie(energie);
		}
		
		//calcul degradation etat de sante
		public static void calculSantePerdue(TamagotchiV2 tamagotchiV2) {
			etatSante = tamagotchiV2.getEtatSante() -10;
			tamagotchiV2.setEtatSante(etatSante);
		}
		
		//calcul amelioration etat sante grace au sport
		public static void calculSanteGagnee(TamagotchiV2 tamagotchiV2) {
			etatSante = tamagotchiV2.getEtatSante() +10;
			tamagotchiV2.setEtatSante(etatSante);
		}
		
		//Augmentation du poids en mangeant
		public static void calculPoids(TamagotchiV2 tamagotchiV2) {
			poids = tamagotchiV2.getPoids() + 5;
			tamagotchiV2.setPoids(poids);
		}
				
				//Perte du poids en faisant du sport
		public static void calculPertePoids(TamagotchiV2 tamagotchiV2) {
			poids = tamagotchiV2.getPoids() -5;
			tamagotchiV2.setPoids(poids);
		}
		

}
