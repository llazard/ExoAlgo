void main(String[] args) {
    // Ici pas besoin de parser l'élément 1 car c'est
    // deja une string quand on arrive dans le code
    String word = args[0];
    // On veut être sur que le paramètre qu'on a mit en ligne
    // de commande soit qu'une seulle lettre on reccupère donc
    // uniquement le premier element de l'args
    char letter = args[1].charAt(0);

    int x = numberOccurrence(word, letter);
    boolean palindrome = isPalindrome(word);
    System.out.println("Nombre d'occurences ");
    System.out.println(x);
    System.out.println("Est palindrome");
    System.out.println(palindrome);
}



int numberOccurrence(String word, char letter) {
    int compteur = 0;
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == letter) compteur++;
    }
    return compteur;
}
static boolean isPalindrome(String word) {
    int gauche = 0;
    int droite = word.length() - 1;
    while (gauche < droite) {
        if (word.charAt(gauche) != word.charAt(droite)) return false;
        gauche++;
        droite--;
    }
    return true;
}