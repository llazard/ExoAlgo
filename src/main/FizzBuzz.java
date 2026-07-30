package main;

public class FizzBuzz {
    void main(String[] args) {
        // On convertit l'argument (une String) en int avec Integer.parseInt().
        int n = Integer.parseInt(args[0]);
        System.out.println(fizzBuzz(n));
    }

    // On construit le résultat en testant chaque règle séparément et en
    // concaténant les morceaux (Fizz, Buzz, Qix). Ça gère naturellement les
    // combinaisons (ex : 6 -> FizzQix, 30 -> FizzBuzzQix) sans avoir à écrire
    // un cas particulier pour chaque combinaison possible.
    public static String fizzBuzz(int n) {
        // L'opérateur "%" (modulo) renvoie le reste de la division entière.
        StringBuilder result = new StringBuilder();
        if (n % 3 == 0) result.append("Fizz");
        if (n % 5 == 0) result.append("Buzz");
        if (n % 2 == 0) result.append("Qix");

        // Si aucune règle ne s'est déclenchée, on renvoie le nombre lui-même.
        if (result.isEmpty()) return String.valueOf(n);
        return result.toString();
    }
}
