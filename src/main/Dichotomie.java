package main;

public class Dichotomie {
    void main(String[] args) {
        int target = Integer.parseInt(args[0]);
        int min = Integer.parseInt(args[1]);
        int max = Integer.parseInt(args[2]);

        int tries = numberOfTry(target, min, max);
        System.out.println("Nombre d'essais : " + tries);
    }

    // Recherche dichotomique : à chaque essai, on compare le milieu de
    // l'intervalle à la cible, puis on réduit l'intervalle de moitié du bon
    // côté (à gauche ou à droite du milieu). C'est cette réduction par moitié
    // qui garantit le nombre d'essais maximum du brief (ex : 7 essais pour un
    // intervalle 1-100).
    public static int numberOfTry(int target, int min, int max) {
        int attempts = 0;

        while (min <= max) {
            attempts++;
            int mid = (min + max) / 2;

            if (mid == target) {
                System.out.println("Essai " + attempts + " : " + mid + ", trouvé !");
                return attempts;
            } else if (mid < target) {
                System.out.println("Essai " + attempts + " : " + mid + ", le chiffre est plus grand");
                min = mid + 1;
            } else {
                System.out.println("Essai " + attempts + " : " + mid + ", le chiffre est plus petit");
                max = mid - 1;
            }
        }

        return attempts;
    }
}
