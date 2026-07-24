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
