package test;

import main.StringExplore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringExploreTest {

    @Test
    void countOccurrences_letterPresentSeveralTimes() {
        // Given
        String word = "mississippi";
        char letter = 's';

        // When
        int result = StringExplore.countOccurrences(word, letter);

        // Then
        assertEquals(4, result);
    }

    @Test
    void countOccurrences_letterAbsentFromWord() {
        // Given : cas limite - la lettre n'apparaît pas dans le mot
        String word = "mississippi";
        char letter = 'z';

        // When
        int result = StringExplore.countOccurrences(word, letter);

        // Then
        assertEquals(0, result);
    }

    @Test
    void countOccurrences_emptyWord() {
        // Given : cas limite - le mot est vide
        String word = "";
        char letter = 'a';

        // When
        int result = StringExplore.countOccurrences(word, letter);

        // Then
        assertEquals(0, result);
    }

    @Test
    void isPalindrome_wordIsPalindrome() {
        // Given
        String word = "radar";

        // When
        boolean result = StringExplore.isPalindrome(word);

        // Then
        assertTrue(result);
    }

    @Test
    void isPalindrome_wordIsNotPalindrome() {
        // Given
        String word = "mississippi";

        // When
        boolean result = StringExplore.isPalindrome(word);

        // Then
        assertFalse(result);
    }

    @Test
    void isPalindrome_singleLetterWord() {
        // Given : cas limite - un mot d'une seule lettre est toujours un palindrome
        String word = "a";

        // When
        boolean result = StringExplore.isPalindrome(word);

        // Then
        assertTrue(result);
    }

    @Test
    void isPalindrome_emptyWord() {
        // Given : cas limite - un mot vide est considéré comme un palindrome
        String word = "";

        // When
        boolean result = StringExplore.isPalindrome(word);

        // Then
        assertTrue(result);
    }
}
