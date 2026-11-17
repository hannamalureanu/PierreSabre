package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}

	public int seFaireExtorquer() {
		int somme = argent;
		argent = 0;
		parler("J’ai tout perdu! Le monde est trop injuste...");
		return somme;
	}

	public void recevoir(int somme) {
		argent += somme;
		parler(somme + " sous ! Je te remercie généreux donateur!");
	}
}
