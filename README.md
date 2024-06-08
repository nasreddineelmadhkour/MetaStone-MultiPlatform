# Application de Jeu de Cartes Multiplateforme MetaStone

Cette application de jeu de cartes est développée pour être multiplateforme en utilisant JavaFX pour l'interface graphique sur desktop, Symfony pour le backend web, et CodeNameOne pour les applications mobiles. La base de données est gérée avec MySQL.

## Fonctionnalités

- **Jeu de Cartes** : Jouez à différents jeux de cartes, tels que le Poker, le Blackjack, etc.
- **Multijoueur** : Jouez en ligne avec d'autres joueurs.
- **Personnalisation** : Personnalisez votre expérience de jeu avec des paramètres tels que les thèmes, les avatars, etc.
- **Suivi des Scores** : Gardez une trace de vos scores et de vos statistiques de jeu.

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) pour JavaFX et CodeNameOne.
- [Symfony](https://symfony.com/download) pour le backend web.
- [MySQL](https://www.mysql.com/downloads/) pour la base de données.
- [Composer](https://getcomposer.org/download/) pour gérer les dépendances Symfony.

## Installation

1. Clonez le dépôt :

    ```bash
    git clone https://github.com/nasreddineelmadhkour/MetaStone-MultiPlatform.git
    cd MetaStone-MultiPlatform
    ```

2. Configuration de la base de données MySQL :

    - Créez une base de données MySQL nommée `jeu_de_cartes`.
    - Importez le fichier SQL de création de la base de données situé dans le dossier `sql-scripts`.

3. Configuration Symfony :

    - Copiez le fichier `.env.example` en `.env` et configurez la connexion à votre base de données MySQL.

4. Installation des dépendances Symfony :

    ```bash
    composer install
    ```

5. Compilation et exécution de l'application JavaFX :

    ```bash
    cd javafx-app
    ./gradlew run
    ```

6. Compilation et déploiement de l'application CodeNameOne :

    Utilisez les outils de développement CodeNameOne pour compiler et déployer l'application sur les plateformes mobiles cibles.

## Structure du Projet

Le projet est structuré comme suit :

- `javafx-app` : Contient le code source et les ressources de l'application JavaFX.
- `symfony-backend` : Contient le code source du backend Symfony.
- `codenameone-app` : Contient le code source et les ressources de l'application CodeNameOne.
- `sql-scripts` : Contient les scripts SQL pour la création de la base de données.

## Utilisation

- L'application JavaFX peut être exécutée sur n'importe quelle plateforme de bureau prenant en charge Java.
- Le backend Symfony est accessible via l'adresse `http://localhost:8000`.
- L'application CodeNameOne doit être déployée sur des appareils mobiles compatibles.

## Contribution

Les contributions sont les bienvenues ! Si vous avez des suggestions ou des améliorations, n'hésitez pas à ouvrir une issue ou une pull request.

## Licence

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.

## Remerciements

- [JavaFX](https://openjfx.io/)
- [Symfony](https://symfony.com/)
- [CodeNameOne](https://www.codenameone.com/)
- [MySQL](https://www.mysql.com/)
