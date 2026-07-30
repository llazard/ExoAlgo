package main;

public class StringExplore {
    void main(String[] args) {
        // Ici pas besoin de parser le premier élément car c'est déjà
        // une String quand on arrive dans le code.
        String word = args[0];
        // On veut être sûr que le paramètre passé en ligne de commande
        // ne soit qu'une seule lettre : on récupère donc uniquement le
        // premier caractère (char) de la String args[1] avec charAt(0).
        char letter = args[1].charAt(0);

        int occurrenceCount = countOccurrences(word, letter);
        boolean palindrome = isPalindrome(word);
        System.out.println("Nombre d'occurences " + occurrenceCount);
        System.out.println("Est palindrome " + palindrome);
    }

    public static int countOccurrences(String word, char letter) {
        int count = 0;
        // On parcourt chaque caractère de la String avec un index i.
        // word.charAt(i) renvoie le caractère (type char) à la position i.
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) count++;
        }
        return count;
    }

    public static boolean isPalindrome(String word) {
        // Technique des deux pointeurs : on compare le caractère de gauche
        // et celui de droite, puis on les rapproche vers le centre.
        // Un mot est un palindrome si tous les couples de caractères
        // symétriques sont identiques (ex : "radar"). Un mot vide ou d'une
        // seule lettre est trivialement un palindrome (la boucle ne s'exécute
        // jamais car left >= right dès le départ).
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
