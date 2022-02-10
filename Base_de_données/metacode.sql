-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 10 fév. 2022 à 01:09
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `metacode`
--

-- --------------------------------------------------------

--
-- Structure de la table `carte`
--

CREATE TABLE `carte` (
  `Id_carte` int(11) NOT NULL,
  `Mana` int(2) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `Vie` int(2) NOT NULL,
  `Prix` int(2) NOT NULL,
  `Image` varchar(255) NOT NULL,
  `Attaque` int(2) NOT NULL,
  `Defence` int(2) NOT NULL,
  `Rareté` varchar(20) NOT NULL,
  `Nom` varchar(11) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Visibilité` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `collection`
--

CREATE TABLE `collection` (
  `Id_collection` int(11) NOT NULL,
  `Id_utilisateur` int(11) NOT NULL,
  `Id_carte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `Id_commande` int(11) NOT NULL,
  `Type_paiement` varchar(255) NOT NULL,
  `Date_commande` date NOT NULL,
  `Prix_total` float NOT NULL,
  `Adresse` varchar(255) NOT NULL,
  `Date_livraison` date NOT NULL,
  `Id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `Id_cmnt` int(11) NOT NULL,
  `Commentaire` varchar(255) NOT NULL,
  `Id_utilisateur` int(11) NOT NULL,
  `Id_poste` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE `demande` (
  `Id_demande` int(11) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `evénement`
--

CREATE TABLE `evénement` (
  `Id_evénement` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Lieu` varchar(255) NOT NULL,
  `Durée` time NOT NULL,
  `Sponsore` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE `joueur` (
  `Id_joueur` int(11) NOT NULL,
  `Emplacemment` varchar(255) NOT NULL,
  `Id_tournoi` int(11) NOT NULL,
  `Id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `merche`
--

CREATE TABLE `merche` (
  `Id_produit` int(11) NOT NULL,
  `Nom_produit` varchar(255) NOT NULL,
  `Prix_produit` int(11) NOT NULL,
  `Description_produit` varchar(255) NOT NULL,
  `Type_produit` varchar(255) NOT NULL,
  `Taille_produit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `Id_panier` int(11) NOT NULL,
  `Nbr_produit` int(11) NOT NULL,
  `Prix_total` float NOT NULL,
  `Id_produit` int(11) NOT NULL,
  `Id_commande` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `participants`
--

CREATE TABLE `participants` (
  `Id_participant` int(11) NOT NULL,
  `Id_utilisateur` int(11) NOT NULL,
  `Id_séance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `poste`
--

CREATE TABLE `poste` (
  `Id_poste` int(11) NOT NULL,
  `Titre` varchar(255) NOT NULL,
  `Date_poste` date NOT NULL,
  `Contenu` varchar(5000) NOT NULL,
  `Categorie` varchar(255) NOT NULL,
  `Id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `séance`
--

CREATE TABLE `séance` (
  `Id_séance` int(11) NOT NULL,
  `Id_coach` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Durée` time NOT NULL,
  `Nbr_participants` int(11) NOT NULL,
  `URL` varchar(255) NOT NULL,
  `Prix` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `tournoi`
--

CREATE TABLE `tournoi` (
  `Id_tournoi` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Createur` varchar(255) NOT NULL,
  `Nbr_joueur` int(11) NOT NULL,
  `Recompence` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `ID_utilisateur` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prénom` varchar(255) NOT NULL,
  `Date_naiss` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `Tel` int(14) NOT NULL,
  `Adresse` varchar(40) NOT NULL,
  `Nom_utilisateur` varchar(20) NOT NULL,
  `Mot_de_passe` varchar(50) NOT NULL,
  `Sexe` varchar(255) NOT NULL,
  `Photo_de_profil` varchar(80) NOT NULL,
  `MTC` int(11) NOT NULL,
  `Rôle` varchar(255) NOT NULL,
  `Rank` varchar(255) NOT NULL,
  `Id_consommateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_utilisateur`, `Nom`, `Prénom`, `Date_naiss`, `email`, `Tel`, `Adresse`, `Nom_utilisateur`, `Mot_de_passe`, `Sexe`, `Photo_de_profil`, `MTC`, `Rôle`, `Rank`, `Id_consommateur`) VALUES
(1, 'nasr', 'madhkour', '1998-04-12', 'nad@dd', 15545, 'daz', 'daz', 'daz', 'Homme', 'dzad', 544, 'ADMIN', 'Hero', 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `carte`
--
ALTER TABLE `carte`
  ADD PRIMARY KEY (`Id_carte`);

--
-- Index pour la table `collection`
--
ALTER TABLE `collection`
  ADD PRIMARY KEY (`Id_collection`),
  ADD KEY `etranger_collection_user` (`Id_utilisateur`),
  ADD KEY `etranger_collection_carte` (`Id_carte`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`Id_commande`),
  ADD KEY `etranger_cammande_user` (`Id_utilisateur`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`Id_cmnt`),
  ADD KEY `etranger_user_comnt` (`Id_utilisateur`),
  ADD KEY `etranger_poste_comnt` (`Id_poste`);

--
-- Index pour la table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`Id_demande`),
  ADD KEY `etranger_demande` (`Id_utilisateur`);

--
-- Index pour la table `evénement`
--
ALTER TABLE `evénement`
  ADD PRIMARY KEY (`Id_evénement`);

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`Id_joueur`),
  ADD KEY `etranger_joueur_id_User` (`Id_utilisateur`),
  ADD KEY `etranger_ID_Tournoi` (`Id_tournoi`);

--
-- Index pour la table `merche`
--
ALTER TABLE `merche`
  ADD PRIMARY KEY (`Id_produit`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`Id_panier`),
  ADD KEY `etranger_produit_id` (`Id_produit`),
  ADD KEY `etranger_cammande_id` (`Id_commande`);

--
-- Index pour la table `participants`
--
ALTER TABLE `participants`
  ADD PRIMARY KEY (`Id_participant`),
  ADD KEY `etranger_participant_idUser` (`Id_utilisateur`),
  ADD KEY `etranger_participant_idseance` (`Id_séance`);

--
-- Index pour la table `poste`
--
ALTER TABLE `poste`
  ADD PRIMARY KEY (`Id_poste`),
  ADD KEY `etranger_user_poste` (`Id_utilisateur`);

--
-- Index pour la table `séance`
--
ALTER TABLE `séance`
  ADD PRIMARY KEY (`Id_séance`),
  ADD KEY `etranger_seance_idUser` (`Id_coach`);

--
-- Index pour la table `tournoi`
--
ALTER TABLE `tournoi`
  ADD PRIMARY KEY (`Id_tournoi`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`ID_utilisateur`),
  ADD UNIQUE KEY `E_mail` (`email`),
  ADD UNIQUE KEY `Nom_utilisateur` (`Nom_utilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `carte`
--
ALTER TABLE `carte`
  MODIFY `Id_carte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `collection`
--
ALTER TABLE `collection`
  MODIFY `Id_collection` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `Id_commande` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `Id_cmnt` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `demande`
--
ALTER TABLE `demande`
  MODIFY `Id_demande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `evénement`
--
ALTER TABLE `evénement`
  MODIFY `Id_evénement` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `joueur`
--
ALTER TABLE `joueur`
  MODIFY `Id_joueur` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `merche`
--
ALTER TABLE `merche`
  MODIFY `Id_produit` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `panier`
--
ALTER TABLE `panier`
  MODIFY `Id_panier` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `participants`
--
ALTER TABLE `participants`
  MODIFY `Id_participant` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `poste`
--
ALTER TABLE `poste`
  MODIFY `Id_poste` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `séance`
--
ALTER TABLE `séance`
  MODIFY `Id_séance` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tournoi`
--
ALTER TABLE `tournoi`
  MODIFY `Id_tournoi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `ID_utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `collection`
--
ALTER TABLE `collection`
  ADD CONSTRAINT `etranger_collection_carte` FOREIGN KEY (`Id_carte`) REFERENCES `carte` (`Id_carte`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etranger_collection_user` FOREIGN KEY (`Id_utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `etranger_cammande_user` FOREIGN KEY (`Id_utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `etranger_poste_comnt` FOREIGN KEY (`Id_poste`) REFERENCES `poste` (`Id_poste`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etranger_user_comnt` FOREIGN KEY (`Id_utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `etranger_demande` FOREIGN KEY (`Id_utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD CONSTRAINT `etranger_ID_Tournoi` FOREIGN KEY (`Id_tournoi`) REFERENCES `tournoi` (`Id_tournoi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etranger_joueur_id_User` FOREIGN KEY (`Id_utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `etranger_cammande_id` FOREIGN KEY (`Id_commande`) REFERENCES `commande` (`Id_commande`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etranger_produit_id` FOREIGN KEY (`Id_produit`) REFERENCES `merche` (`Id_produit`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `participants`
--
ALTER TABLE `participants`
  ADD CONSTRAINT `etranger_participant_idUser` FOREIGN KEY (`Id_utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etranger_participant_idseance` FOREIGN KEY (`Id_séance`) REFERENCES `séance` (`Id_séance`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `poste`
--
ALTER TABLE `poste`
  ADD CONSTRAINT `etranger_user_poste` FOREIGN KEY (`Id_utilisateur`) REFERENCES `utilisateur` (`ID_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `séance`
--
ALTER TABLE `séance`
  ADD CONSTRAINT `etranger_seance_idUser` FOREIGN KEY (`Id_coach`) REFERENCES `utilisateur` (`ID_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
