
class FizzBuzz {
    void main(String[] args) {
        // On convertit l'argument (une String) en int avec Integer.parseInt().
        int n = Integer.parseInt(args[0]);
        System.out.println(fizzBuzz(n));
    }

    static String fizzBuzz(int n) {
        // L'opérateur "%" (modulo) renvoie le reste de la division entière.
        // n % 15 == 0 revient à tester "divisible par 3 ET par 5 en même temps",
        // donc on doit tester ce cas AVANT les cas Fizz et Buzz séparés,
        // sinon on ne rentrerait jamais dans cette condition.
        if (n % 15 == 0) return "FizzBuzz";
        if (n % 3 == 0) return "Fizz";
        if (n % 5 == 0) return "Buzz";

        // String.valueOf(n) convertit l'int en String pour que la méthode
        // renvoie toujours le même type (String) quel que soit le cas.
        return String.valueOf(n);
    }
}
