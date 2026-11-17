package personnages;

public class Ronin extends Humain {

	private int honneur = 1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}

	public void donner(Commercant beneficiaire) {
		int somme = argent / 10;
		perdreArgent(somme);
		parler(beneficiaire.getNom() + " prend ces " + somme + " sous.");
		beneficiaire.recevoir(somme);
	}

	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");

		int force = 2 * honneur;

		if (force >= adversaire.getReputation()) {
			parler("Je t’ai eu petit yakusa!");
			int gain = adversaire.perdre();
			gagnerArgent(gain);
			honneur++;
		} else {
			int perte = argent;
			perdreArgent(perte);
			honneur--;
			parler("J’ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(perte);
		}
	}
}