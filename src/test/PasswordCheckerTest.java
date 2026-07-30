package test;

import main.PasswordChecker;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {

    @Test
    void validatePassword_validPassword_returnsEmptyList() {
        // Given
        String password = "Azerty123!xyz";

        // When
        List<String> errors = PasswordChecker.validatePassword(password);

        // Then
        assertTrue(errors.isEmpty());
    }

    @Test
    void validatePassword_tooShort_returnsLengthError() {
        // Given
        String password = "Azerty1!";

        // When
        List<String> errors = PasswordChecker.validatePassword(password);

        // Then
        assertTrue(errors.contains("Le mot de passe doit contenir au moins 12 caractères"));
    }

    @Test
    void validatePassword_noLetter_returnsLetterError() {
        // Given
        String password = "123456789012!";

        // When
        List<String> errors = PasswordChecker.validatePassword(password);

        // Then
        assertTrue(errors.contains("Le mot de passe doit contenir au moins une lettre"));
    }

    @Test
    void validatePassword_noDigit_returnsDigitError() {
        // Given
        String password = "Azertyuiopqs!";

        // When
        List<String> errors = PasswordChecker.validatePassword(password);

        // Then
        assertTrue(errors.contains("Le mot de passe doit contenir au moins un chiffre"));
    }

    @Test
    void validatePassword_noSpecialChar_returnsSpecialCharError() {
        // Given
        String password = "Azerty123xyz";

        // When
        List<String> errors = PasswordChecker.validatePassword(password);

        // Then
        assertTrue(errors.contains("Le mot de passe doit contenir au moins un caractère spécial"));
    }

    @Test
    void validatePassword_containsSpace_returnsSpaceError() {
        // Given
        String password = "Azerty 123!xyz";

        // When
        List<String> errors = PasswordChecker.validatePassword(password);

        // Then
        assertTrue(errors.contains("Le mot de passe ne doit pas contenir d'espace"));
    }

    @Test
    void validatePassword_multipleViolations_returnsAllErrors() {
        // Given : "abc" cumule trois manquements : trop court, pas de
        // chiffre, pas de caractère spécial.
        String password = "abc";

        // When
        List<String> errors = PasswordChecker.validatePassword(password);

        // Then
        assertEquals(3, errors.size());
        assertTrue(errors.contains("Le mot de passe doit contenir au moins 12 caractères"));
        assertTrue(errors.contains("Le mot de passe doit contenir au moins un chiffre"));
        assertTrue(errors.contains("Le mot de passe doit contenir au moins un caractère spécial"));
    }
}
