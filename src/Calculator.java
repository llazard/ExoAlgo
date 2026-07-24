
class Calculator {
    void main(String[] args) {

        // On réccupère les args pour les transformer en double
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);

        // on appelle la méthode faisant l'addition pour réccupère le résultat
        double addition = addition(a, b);
        // On affiche le résultat
        System.out.println("le resultat de l'addition est " + addition);
        System.out.println("le resultat de la soustraction est " + subtraction(a, b));
        System.out.println("le resultat de la division est " + division(a, b));
        System.out.println("le resultat de la somme des chiffre de a a b est " + sumAtoB(a, b));
    }

    static double addition(double a, double b) {
        return a + b;
    }

    static double subtraction(double a, double b) {
        return a - b;
    }

    static double division(double a, double b) {
        return a / b;
    }

    static double sumAtoB(double a, double b) {
        double sum = 0;
        double begin = Math.min(a, b);
        double end = Math.max(a, b);

        for (double i = begin; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}
