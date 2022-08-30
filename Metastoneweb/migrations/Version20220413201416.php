<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220413201416 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE collection DROP FOREIGN KEY etranger_collection_carte');
        $this->addSql('ALTER TABLE panier DROP FOREIGN KEY etranger_cammande_id');
        $this->addSql('ALTER TABLE commande DROP FOREIGN KEY etrprod');
        $this->addSql('ALTER TABLE panier DROP FOREIGN KEY etranger_produit_id');
        $this->addSql('ALTER TABLE commentaire DROP FOREIGN KEY etranger_poste_comnt');
        $this->addSql('ALTER TABLE rating DROP FOREIGN KEY ddz');
        $this->addSql('ALTER TABLE participants DROP FOREIGN KEY etranger_seance');
        $this->addSql('ALTER TABLE joueur DROP FOREIGN KEY etranger_ID_Tournoi');
        $this->addSql('ALTER TABLE collection DROP FOREIGN KEY etranger_collection_user');
        $this->addSql('ALTER TABLE commande DROP FOREIGN KEY etranger_cammande_user');
        $this->addSql('ALTER TABLE commentaire DROP FOREIGN KEY etranger_user_comnt');
        $this->addSql('ALTER TABLE demande DROP FOREIGN KEY etranger_demande');
        $this->addSql('ALTER TABLE joueur DROP FOREIGN KEY etranger_joueur_id_User');
        $this->addSql('ALTER TABLE participants DROP FOREIGN KEY etranger_participant_idUser');
        $this->addSql('ALTER TABLE poste DROP FOREIGN KEY etranger_user_poste');
        $this->addSql('ALTER TABLE seance DROP FOREIGN KEY seance_id_coach');
        $this->addSql('DROP TABLE abonnemerche');
        $this->addSql('DROP TABLE carte');
        $this->addSql('DROP TABLE collection');
        $this->addSql('DROP TABLE commande');
        $this->addSql('DROP TABLE commentaire');
        $this->addSql('DROP TABLE demande');
        $this->addSql('DROP TABLE evenement');
        $this->addSql('DROP TABLE merche');
        $this->addSql('DROP TABLE panier');
        $this->addSql('DROP TABLE participants');
        $this->addSql('DROP TABLE poste');
        $this->addSql('DROP TABLE rating');
        $this->addSql('DROP TABLE seance');
        $this->addSql('DROP TABLE tournoi');
        $this->addSql('DROP TABLE utilisateur');
        $this->addSql('DROP INDEX etranger_ID_Tournoi ON joueur');
        $this->addSql('DROP INDEX etranger_joueur_id_User ON joueur');
        $this->addSql('ALTER TABLE joueur DROP PRIMARY KEY');
        $this->addSql('ALTER TABLE joueur DROP Emplacemment, DROP Id_tournoi, DROP Id_utilisateur, CHANGE Id_joueur id INT AUTO_INCREMENT NOT NULL');
        $this->addSql('ALTER TABLE joueur ADD PRIMARY KEY (id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE abonnemerche (id_abo INT AUTO_INCREMENT NOT NULL, PRIMARY KEY(id_abo)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE carte (Id_carte INT AUTO_INCREMENT NOT NULL, Mana INT NOT NULL, Type VARCHAR(20) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Vie INT NOT NULL, Prix INT NOT NULL, Image VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Attaque INT NOT NULL, Defence INT NOT NULL, Rarete VARCHAR(20) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Nom VARCHAR(11) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Description VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Visibilite TINYINT(1) NOT NULL, PRIMARY KEY(Id_carte)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE collection (Id_collection INT AUTO_INCREMENT NOT NULL, Id_utilisateur INT NOT NULL, Id_carte INT NOT NULL, INDEX etranger_collection_carte (Id_carte), INDEX etranger_collection_user (Id_utilisateur), PRIMARY KEY(Id_collection)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE commande (Id_commande INT AUTO_INCREMENT NOT NULL, Type_paiement VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Date_commande DATE NOT NULL, Prix_total DOUBLE PRECISION NOT NULL, Adresse VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Date_livraison DATE NOT NULL, Id_utilisateur INT NOT NULL, Id_produit INT NOT NULL, Quantite_acheter INT NOT NULL, INDEX etrprod (Id_produit), INDEX etranger_cammande_user (Id_utilisateur), PRIMARY KEY(Id_commande)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE commentaire (Id_cmnt INT AUTO_INCREMENT NOT NULL, Commentaire VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Id_utilisateur INT NOT NULL, Id_poste INT NOT NULL, INDEX etranger_poste_comnt (Id_poste), INDEX etranger_user_comnt (Id_utilisateur), PRIMARY KEY(Id_cmnt)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE demande (Id_demande INT AUTO_INCREMENT NOT NULL, Type VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Description VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Id_utilisateur INT NOT NULL, INDEX etranger_demande (Id_utilisateur), PRIMARY KEY(Id_demande)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE evenement (id_evenement INT AUTO_INCREMENT NOT NULL, Date DATE NOT NULL, Lieu VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Duree INT NOT NULL, Sponsore VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, PRIMARY KEY(id_evenement)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE merche (Id_produit INT AUTO_INCREMENT NOT NULL, Nom_produit VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Prix_produit INT NOT NULL, Description_produit VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Type_produit VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Taille_produit INT NOT NULL, Quantite_produit INT NOT NULL, PRIMARY KEY(Id_produit)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE panier (Id_panier INT AUTO_INCREMENT NOT NULL, Nbr_produit INT NOT NULL, Prix_total DOUBLE PRECISION NOT NULL, Id_produit INT NOT NULL, Id_commande INT NOT NULL, INDEX etranger_cammande_id (Id_commande), INDEX etranger_produit_id (Id_produit), PRIMARY KEY(Id_panier)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE participants (Id_participant INT AUTO_INCREMENT NOT NULL, Id_utilisateur INT NOT NULL, Id_seance INT NOT NULL, INDEX etranger_seance (Id_seance), INDEX etranger_participant_idUser (Id_utilisateur), PRIMARY KEY(Id_participant)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE poste (Id_poste INT AUTO_INCREMENT NOT NULL, Titre VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Date_poste DATE NOT NULL, Contenu VARCHAR(5000) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Categorie VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Id_utilisateur INT NOT NULL, INDEX etranger_user_poste (Id_utilisateur), PRIMARY KEY(Id_poste)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE rating (id INT AUTO_INCREMENT NOT NULL, id_post INT NOT NULL, rate DOUBLE PRECISION NOT NULL, INDEX ddz (id_post), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE seance (id_coach INT NOT NULL, Id_seance INT AUTO_INCREMENT NOT NULL, Date DATE NOT NULL, Duree TIME NOT NULL, Nbr_participants INT NOT NULL, URL VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Prix DOUBLE PRECISION NOT NULL, INDEX seance_id_coach (id_coach), PRIMARY KEY(Id_seance)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE tournoi (Id_tournoi INT AUTO_INCREMENT NOT NULL, Date DATE NOT NULL, Description VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Createur VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Nbr_joueur INT NOT NULL, Recompence DOUBLE PRECISION NOT NULL, PRIMARY KEY(Id_tournoi)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE utilisateur (ID_utilisateur INT AUTO_INCREMENT NOT NULL, Nom VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Prenom VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, age VARCHAR(22) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, email VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Tel INT NOT NULL, Adresse VARCHAR(40) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Nom_utilisateur VARCHAR(20) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Mot_de_passe VARCHAR(50) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Sexe VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Photo_de_profil VARCHAR(80) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, MTC INT NOT NULL, Role VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Rank VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, Id_consommateur VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, code INT DEFAULT NULL, etat VARCHAR(255) CHARACTER SET utf8mb4 DEFAULT \'activer\' NOT NULL COLLATE `utf8mb4_general_ci`, UNIQUE INDEX E_mail (email), UNIQUE INDEX Nom_utilisateur (Nom_utilisateur), PRIMARY KEY(ID_utilisateur)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('ALTER TABLE collection ADD CONSTRAINT etranger_collection_user FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE collection ADD CONSTRAINT etranger_collection_carte FOREIGN KEY (Id_carte) REFERENCES carte (Id_carte) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE commande ADD CONSTRAINT etrprod FOREIGN KEY (Id_produit) REFERENCES merche (Id_produit) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE commande ADD CONSTRAINT etranger_cammande_user FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE commentaire ADD CONSTRAINT etranger_user_comnt FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE commentaire ADD CONSTRAINT etranger_poste_comnt FOREIGN KEY (Id_poste) REFERENCES poste (Id_poste) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE demande ADD CONSTRAINT etranger_demande FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE panier ADD CONSTRAINT etranger_produit_id FOREIGN KEY (Id_produit) REFERENCES merche (Id_produit) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE panier ADD CONSTRAINT etranger_cammande_id FOREIGN KEY (Id_commande) REFERENCES commande (Id_commande) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE participants ADD CONSTRAINT etranger_seance FOREIGN KEY (Id_seance) REFERENCES seance (Id_seance) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE participants ADD CONSTRAINT etranger_participant_idUser FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE poste ADD CONSTRAINT etranger_user_poste FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE rating ADD CONSTRAINT ddz FOREIGN KEY (id_post) REFERENCES poste (Id_poste) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE seance ADD CONSTRAINT seance_id_coach FOREIGN KEY (id_coach) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE joueur MODIFY id INT NOT NULL');
        $this->addSql('ALTER TABLE joueur DROP PRIMARY KEY');
        $this->addSql('ALTER TABLE joueur ADD Emplacemment VARCHAR(255) NOT NULL, ADD Id_tournoi INT NOT NULL, ADD Id_utilisateur INT NOT NULL, CHANGE id Id_joueur INT AUTO_INCREMENT NOT NULL');
        $this->addSql('ALTER TABLE joueur ADD CONSTRAINT etranger_joueur_id_User FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE joueur ADD CONSTRAINT etranger_ID_Tournoi FOREIGN KEY (Id_tournoi) REFERENCES tournoi (Id_tournoi) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('CREATE INDEX etranger_ID_Tournoi ON joueur (Id_tournoi)');
        $this->addSql('CREATE INDEX etranger_joueur_id_User ON joueur (Id_utilisateur)');
        $this->addSql('ALTER TABLE joueur ADD PRIMARY KEY (Id_joueur)');
    }
}
