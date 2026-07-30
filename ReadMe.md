# Java — primitifs, objets, et où chercher

## Primitif ou objet : la distinction fondamentale

Dans l'exercice 3, vous avez écrit String.un_méthode. Mais jamais un entier sur un entier (int).

Ce n'est pas un hasard : ces deux variables n'appartiennent pas au même monde.

| | **Types primitifs** | **Objets** |
|---|---|---|
| Exemples | entier, nombre à virgule, booléen, caractère | texte, listes, et **toutes vos classes** |
| Écriture | tout en minuscules | commencent par une **majuscule** |
| Contenu | une valeur brute, rien d'autre | des données **et** des comportements |
| Manipulation | avec des opérateurs | en appelant ses méthodes, avec un point |

- Un `String` est un objet, comme en POO : il a donc des attributs et des méthodes associées, que l'on peut utiliser directement sur l'objet.
- Une variable primitive est juste la donnée : on peut la manipuler avec des opérateurs (`+`, `-`, `=`...) mais pas lui appliquer de méthodes.

## La documentation officielle

Prenez l'habitude d'y aller. C'est la source de vérité, et c'est ce que font les développeurs tous les jours — personne ne retient les centaines de méthodes disponibles.

- **String** : https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html
- **Character** : https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/Character.html

Elle est intimidante au premier abord. Allez directement à la section **Method Summary** : c'est la liste des méthodes, chacune avec une phrase de description. Le reste de la page peut être ignoré au début.

---

## Mémo des méthodes utiles

**Sur un texte** — on les appelle sur la variable, avec un point.

| Méthode | Ce qu'elle fait |
|---|---|
| `length()` | le nombre de caractères |
| `charAt(i)` | le caractère à la position `i`, en comptant depuis 0 |
| `equals(autre)` | compare le contenu de deux textes |
| `equalsIgnoreCase(autre)` | compare sans tenir compte des majuscules |
| `toLowerCase()` / `toUpperCase()` | renvoie un **nouveau** texte |
| `contains(morceau)` | ce texte contient-il ce morceau ? |
| `isEmpty()` | le texte est-il vide ? |
| `substring(debut, fin)` | extrait un morceau |
| `trim()` | enlève les espaces au début et à la fin |

**Sur la classe des caractères** — on les appelle sur la classe, jamais sur un objet.

| Méthode | Ce qu'elle fait |
|---|---|
| `isLetter(c)` | est-ce une lettre ? |
| `isDigit(c)` | est-ce un chiffre ? |
| `isWhitespace(c)` | est-ce un espace ? |
| `isUpperCase(c)` / `isLowerCase(c)` | majuscule ou minuscule ? |
| `toLowerCase(c)` / `toUpperCase(c)` | convertit un caractère |

---

## Les exercices (`src/main`)

Un fichier par exercice, chaque méthode est `static` et pure (elle reçoit ses données en paramètre et renvoie un résultat, sans dépendre d'un état extérieur) — c'est ce qui les rend testables au Jour 2. Exécution en ligne de commande, ex. `java src/main/FizzBuzz.java 15`.

| Fichier | Exercice | Méthode(s) clé(s) |
|---|---|---|
| `Calculator.java` | 1. Calculatrice | `addition`, `subtraction`, `multiplication`, `division`, `sumAtoB` |
| `FizzBuzz.java` | 2. FizzBuzz (+ règle Qix du Jour 2) | `fizzBuzz(int n)` |
| `StringExplore.java` | 3. Manipulation de chaînes | `countOccurrences`, `isPalindrome` |
| `PasswordChecker.java` | 4. Vérificateur de mot de passe | `validatePassword(String)` → `List<String>` d'erreurs |
| `Dichotomie.java` | 5. Dichotomie | `numberOfTry(cible, min, max)` |
| `RomanNumeral.java` | 6. Chiffres romains (optionnel) | `toRoman(int)` |
| `Potter.java` | 7. Kata Potter simplifié (optionnel) | `priceForCart(int[])` |


**Mot de passe :** la méthode ne s'arrête pas à la première règle violée, elle renvoie **toutes** les erreurs sous forme de `List<String>` (liste vide = mot de passe valide) — plus utile pour l'utilisateur qu'un simple `boolean`.

---

## Les tests unitaires (`src/test`) — notions clés

### GIVEN / WHEN / THEN

Chaque test suit la même structure, en commentaire au-dessus des blocs de code :

- **GIVEN** : les données de départ (les variables d'entrée).
- **WHEN** : l'appel à la méthode testée.
- **THEN** : la vérification du résultat obtenu.

```java
@Test
void addition_twoPositiveNumber() {
    // Given
    double firstNumber = 2;
    double secondNumber = 3;

    // When
    double result = Calculator.addition(firstNumber, secondNumber);

    // Then
    assertEquals(5, result);
}
```

### Les méthodes d'assertion (JUnit 5)

| Méthode | Usage |
|---|---|
| `assertEquals(attendu, obtenu)` | compare deux valeurs. **L'ordre compte** : le premier argument est toujours la valeur attendue, le second celle obtenue par le code — inversé, le message d'erreur racontera l'inverse de la réalité. |
| `assertEquals(attendu, obtenu, tolerance)` | pour les `double` : une division comme `1 / 3` ne tombe jamais juste, on ajoute une marge d'erreur (ex. `0.001`) pour éviter les pièges d'arrondi. |
| `assertTrue(condition)` / `assertFalse(condition)` | pour les résultats booléens (ex. `isPalindrome`). |

### Règles de conception d'un test

- **Un test = un cas.** Mieux vaut plusieurs petits tests bien nommés qu'un seul gros test qui vérifie tout : si un seul cas casse, on sait lequel sans avoir à déboguer.
- **Nommer pour être compris** : `subtraction_resultIsNegative()` est plus parlant que `test2()`. Convention utilisée ici : `méthode_casTesté()`.
- **Penser aux cas limites, pas seulement aux cas évidents** : mot vide, mot d'une seule lettre, lettre absente, bornes égales (`sumAtoB(4, 4)`), mot de passe qui cumule plusieurs erreurs à la fois. Ce sont ces cas-là qui révèlent le plus de bugs.
- **Vérifier qu'un test sait échouer** : casser volontairement la méthode testée et relancer le test. S'il reste vert, c'est qu'il ne teste rien.

### Régression : faire évoluer le code sans casser les tests

Exemple concret sur `FizzBuzz` : l'ajout de la règle Qix (divisible par 2) a changé le résultat attendu pour toutes les valeurs paires. Les tests existants sont passés au rouge exactement sur ces valeurs-là (`2`, `4`, `6`...), ce qui a permis de corriger précisément le code **et** les tests concernés, sans devoir tout revérifier à la main. C'est le rôle d'un test : prévenir quand quelque chose casse.
