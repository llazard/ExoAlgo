package main;

import java.util.ArrayList;
import java.util.List;

public class PasswordChecker {
    void main(String[] args) {
        String password = args[0];
        List<String> errors = validatePassword(password);

        if (errors.isEmpty()) {
            System.out.println(true);
        } else {
            for (String error : errors) {
                System.out.println(error);
            }
            System.out.println(false);
        }
    }

    // Renvoie la liste des règles non respectées : liste vide = mot de passe
    // valide. Contrainte de l'exercice : pas de regex, on inspecte donc la
    // chaîne caractère par caractère et on met à jour des drapeaux booléens
    // au fur et à mesure. On ne s'arrête jamais à la première erreur trouvée :
    // on collecte toutes les règles violées avant de renvoyer le résultat.
    public static List<String> validatePassword(String password) {
        List<String> errors = new ArrayList<>();

        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        boolean hasSpace = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isWhitespace(c)) {
                hasSpace = true;
            } else {
                hasSpecialChar = true;
            }
        }

        if (password.length() < 12) {
            errors.add("Le mot de passe doit contenir au moins 12 caractères");
        }
        if (!hasLetter) {
            errors.add("Le mot de passe doit contenir au moins une lettre");
        }
        if (!hasDigit) {
            errors.add("Le mot de passe doit contenir au moins un chiffre");
        }
        if (!hasSpecialChar) {
            errors.add("Le mot de passe doit contenir au moins un caractère spécial");
        }
        if (hasSpace) {
            errors.add("Le mot de passe ne doit pas contenir d'espace");
        }

        return errors;
    }
}
