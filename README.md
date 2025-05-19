# SameGame (Projet Java - SAE DEV2.1)

Ce projet est une implémentation du jeu **SameGame** en **Java**, développé dans le cadre de la **SAE DEV2.1** de ma formation en **BUT Informatique**, au **semestre 2**.  
Nous avons obtenu la **note de 16/20** pour ce projet.

## 🧩 Présentation

SameGame est un jeu de réflexion où le joueur doit cliquer sur des groupes de cases de même couleur pour les faire disparaître et obtenir un score.  
Le jeu utilise une interface graphique réalisée avec **Swing** et respecte une architecture **MVC (Modèle-Vue-Contrôleur)**.

## 🛠️ Technologies utilisées

- **Java SE**
- **Swing**
- **StarUML** (uniquement pour modéliser le diagramme de classes)
- **Makefile** pour la compilation

## 💡 Lancement du programme et fonctionnalités Make

Un **Makefile** est fourni à la racine du projet pour automatiser les principales actions :

| Commande | Description |
|----------|-------------|
| `make` ou `make run` | Compile le projet et lance l'application graphique |
| `make compile` | Compile uniquement les fichiers `.java` et génère les `.class` |
| `make clean` | Supprime tous les fichiers `.class` du dossier `src` (récursivement) |
| `make doc` | Génère la documentation JavaDoc (si les commentaires sont présents) dans un dossier `doc` |
| `make all` | Compile, lance le programme et génère la documentation |

## ⚠️ Ce qui aurait pu être amélioré

- **Makefile** : nous avons pris une solution simple et rapide sans exploiter tout le potentiel de `make`, notamment pour gérer les dépendances de manière plus fine.
- **Diagramme de classes** : il est trop **complet** (toutes les méthodes et attributs sont visibles), alors que le professeur attendait un niveau d’abstraction plus **fonctionnel** ou **synthétique**.
- **Documentation JavaDoc** : certaines classes ne sont **pas documentées**, ce qui nuit à la lisibilité globale du projet. Cela a été un oubli par manque de relecture.

## 👨‍💻 Auteurs

- Nathan BAUDRIER
- Lakshman MURALITHARAN

