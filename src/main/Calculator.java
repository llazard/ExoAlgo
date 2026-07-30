package main;

public class Calculator {
    void main(String[] args) {

        // Les arguments de la ligne de commande (args) sont toujours reçus sous forme
        // de String, même si l'utilisateur tape des nombres. Double.parseDouble()
        // convertit ("parse") une String en une valeur primitive de type double.
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);

        // On appelle la méthode addition() et on stocke le résultat dans une variable
        // pour pouvoir le réutiliser/l'afficher juste après.
        int additionResult = addition(a, b);
        // Affichage du résultat. L'opérateur "+" ici concatène une String avec un
        // double : Java convertit automatiquement le double en sa représentation String.
        System.out.println("le resultat de l'addition est " + additionResult);
        System.out.println("le resultat de la soustraction est " + subtraction(a, b));
        System.out.println("le resultat de la multiplication est " + multiplication(a, b));
        System.out.println("le resultat de la division est " + division(a, b));
        System.out.println("le resultat de la somme des chiffre de a a b est " + sumAtoB(a, b));
    }

    // "static" signifie que cette méthode appartient à la classe elle-même et n'a
    // pas besoin d'une instance de main.Calculator pour être appelée (ex : main.Calculator.addition(...)).
    public static int addition(double a, double b) {
        return (int) (a + b);
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    // Piège du typage : avec des int, 5 / 2 vaut 2 (division entière, la
    // partie décimale est tronquée). Ici a et b sont des double, donc la
    // division garde bien sa partie décimale (5.0 / 2 vaut 2.5).
    public static double division(double a, double b) {
        return a / b;
    }

    public static double sumAtoB(double a, double b) {
        double sum = 0;
        // Math.min/Math.max permettent de gérer les deux ordres d'appel,
        // ex : sumAtoB(5, 2) se comporte comme sumAtoB(2, 5).
        double begin = Math.min(a, b);
        double end = Math.max(a, b);

        // Boucle "for" classique : on part de begin et on ajoute 1 à chaque
        // tour (i++) jusqu'à dépasser end. Utiliser un double comme compteur
        // de boucle fonctionne ici car les arguments sont des nombres entiers,
        // mais en général on préfère int/long comme compteur pour éviter les
        // problèmes d'arrondi liés aux nombres à virgule flottante.
        for (double i = begin; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}
