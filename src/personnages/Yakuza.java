package personnages;

public class Yakuza extends Humain {

	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}

	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");

		int somme = victime.seFaireExtorquer();
		gagnerArgent(somme);
		reputation++;

		parler("J’ai piqué les " + somme + " sous de " + victime.getNom() + ", ce qui me fait " + argent
				+ " sous dans ma poche. Hi ! Hi !");
	}

	public int perdre() {
		int somme = argent;
		argent = 0;
		reputation--;
		parler("J’ai perdu mon duel et mes " + somme + " sous, snif... J’ai déshonoré le clan de " + clan + ".");
		return somme;
	}

	public void gagner(int gain) {
		argent += gain;
		reputation++;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + " ? Je l'ai dépouillé de ses "
				+ gain + " sous.");
	}
}