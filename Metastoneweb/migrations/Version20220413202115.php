<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220413202115 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE collection DROP FOREIGN KEY etranger_collection_carte');
        $this->addSql('ALTER TABLE collection DROP FOREIGN KEY etranger_collection_user');
        $this->addSql('ALTER TABLE collection CHANGE Id_utilisateur Id_utilisateur INT DEFAULT NULL, CHANGE Id_carte Id_carte INT DEFAULT NULL');
        $this->addSql('ALTER TABLE collection ADD CONSTRAINT FK_FC4D6532C86AD69C FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur)');
        $this->addSql('ALTER TABLE collection ADD CONSTRAINT FK_FC4D6532AD27DC9B FOREIGN KEY (Id_carte) REFERENCES carte (Id_carte)');
        $this->addSql('ALTER TABLE commande DROP FOREIGN KEY etranger_cammande_user');
        $this->addSql('ALTER TABLE commande DROP FOREIGN KEY etrprod');
        $this->addSql('ALTER TABLE commande CHANGE Id_utilisateur Id_utilisateur INT DEFAULT NULL, CHANGE Id_produit Id_produit INT DEFAULT NULL');
        $this->addSql('ALTER TABLE commande ADD CONSTRAINT FK_6EEAA67DB8654687 FOREIGN KEY (Id_produit) REFERENCES merche (Id_produit)');
        $this->addSql('ALTER TABLE commande ADD CONSTRAINT FK_6EEAA67DC86AD69C FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur)');
        $this->addSql('ALTER TABLE commentaire DROP FOREIGN KEY etranger_poste_comnt');
        $this->addSql('ALTER TABLE commentaire DROP FOREIGN KEY etranger_user_comnt');
        $this->addSql('ALTER TABLE commentaire CHANGE Id_utilisateur Id_utilisateur INT DEFAULT NULL, CHANGE Id_poste Id_poste INT DEFAULT NULL');
        $this->addSql('ALTER TABLE commentaire ADD CONSTRAINT FK_67F068BCC86AD69C FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur)');
        $this->addSql('ALTER TABLE commentaire ADD CONSTRAINT FK_67F068BC6B7A2CCD FOREIGN KEY (Id_poste) REFERENCES poste (Id_poste)');
        $this->addSql('ALTER TABLE demande DROP FOREIGN KEY etranger_demande');
        $this->addSql('ALTER TABLE demande CHANGE Id_utilisateur Id_utilisateur INT DEFAULT NULL');
        $this->addSql('ALTER TABLE demande ADD CONSTRAINT FK_2694D7A5C86AD69C FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur)');
        $this->addSql('ALTER TABLE joueur DROP FOREIGN KEY etranger_ID_Tournoi');
        $this->addSql('ALTER TABLE joueur DROP FOREIGN KEY etranger_joueur_id_User');
        $this->addSql('ALTER TABLE joueur CHANGE Id_tournoi Id_tournoi INT DEFAULT NULL, CHANGE Id_utilisateur Id_utilisateur INT DEFAULT NULL');
        $this->addSql('ALTER TABLE joueur ADD CONSTRAINT FK_FD71A9C5C86AD69C FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur)');
        $this->addSql('ALTER TABLE joueur ADD CONSTRAINT FK_FD71A9C5896F737F FOREIGN KEY (Id_tournoi) REFERENCES tournoi (Id_tournoi)');
        $this->addSql('ALTER TABLE panier DROP FOREIGN KEY etranger_cammande_id');
        $this->addSql('ALTER TABLE panier DROP FOREIGN KEY etranger_produit_id');
        $this->addSql('ALTER TABLE panier CHANGE Id_produit Id_produit INT DEFAULT NULL, CHANGE Id_commande Id_commande INT DEFAULT NULL');
        $this->addSql('ALTER TABLE panier ADD CONSTRAINT FK_24CC0DF2B8654687 FOREIGN KEY (Id_produit) REFERENCES merche (Id_produit)');
        $this->addSql('ALTER TABLE panier ADD CONSTRAINT FK_24CC0DF2B8ADC53F FOREIGN KEY (Id_commande) REFERENCES commande (Id_commande)');
        $this->addSql('ALTER TABLE participants DROP FOREIGN KEY etranger_participant_idUser');
        $this->addSql('ALTER TABLE participants DROP FOREIGN KEY etranger_seance');
        $this->addSql('ALTER TABLE participants CHANGE Id_utilisateur Id_utilisateur INT DEFAULT NULL, CHANGE Id_seance Id_seance INT DEFAULT NULL');
        $this->addSql('ALTER TABLE participants ADD CONSTRAINT FK_716970927BBBCA40 FOREIGN KEY (Id_seance) REFERENCES seance (Id_seance)');
        $this->addSql('ALTER TABLE participants ADD CONSTRAINT FK_71697092C86AD69C FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur)');
        $this->addSql('ALTER TABLE poste DROP FOREIGN KEY etranger_user_poste');
        $this->addSql('ALTER TABLE poste CHANGE Id_utilisateur Id_utilisateur INT DEFAULT NULL');
        $this->addSql('ALTER TABLE poste ADD CONSTRAINT FK_7C890FABC86AD69C FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur)');
        $this->addSql('ALTER TABLE rating DROP FOREIGN KEY ddz');
        $this->addSql('ALTER TABLE rating CHANGE id_post id_post INT DEFAULT NULL');
        $this->addSql('ALTER TABLE rating ADD CONSTRAINT FK_D8892622D1AA708F FOREIGN KEY (id_post) REFERENCES poste (Id_poste)');
        $this->addSql('ALTER TABLE seance DROP FOREIGN KEY seance_id_coach');
        $this->addSql('ALTER TABLE seance CHANGE id_coach id_coach INT DEFAULT NULL');
        $this->addSql('ALTER TABLE seance ADD CONSTRAINT FK_DF7DFD0ED1DC2CFC FOREIGN KEY (id_coach) REFERENCES utilisateur (ID_utilisateur)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE collection DROP FOREIGN KEY FK_FC4D6532C86AD69C');
        $this->addSql('ALTER TABLE collection DROP FOREIGN KEY FK_FC4D6532AD27DC9B');
        $this->addSql('ALTER TABLE collection CHANGE Id_utilisateur Id_utilisateur INT NOT NULL, CHANGE Id_carte Id_carte INT NOT NULL');
        $this->addSql('ALTER TABLE collection ADD CONSTRAINT etranger_collection_carte FOREIGN KEY (Id_carte) REFERENCES carte (Id_carte) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE collection ADD CONSTRAINT etranger_collection_user FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE commande DROP FOREIGN KEY FK_6EEAA67DB8654687');
        $this->addSql('ALTER TABLE commande DROP FOREIGN KEY FK_6EEAA67DC86AD69C');
        $this->addSql('ALTER TABLE commande CHANGE Id_produit Id_produit INT NOT NULL, CHANGE Id_utilisateur Id_utilisateur INT NOT NULL');
        $this->addSql('ALTER TABLE commande ADD CONSTRAINT etranger_cammande_user FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE commande ADD CONSTRAINT etrprod FOREIGN KEY (Id_produit) REFERENCES merche (Id_produit) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE commentaire DROP FOREIGN KEY FK_67F068BCC86AD69C');
        $this->addSql('ALTER TABLE commentaire DROP FOREIGN KEY FK_67F068BC6B7A2CCD');
        $this->addSql('ALTER TABLE commentaire CHANGE Id_utilisateur Id_utilisateur INT NOT NULL, CHANGE Id_poste Id_poste INT NOT NULL');
        $this->addSql('ALTER TABLE commentaire ADD CONSTRAINT etranger_poste_comnt FOREIGN KEY (Id_poste) REFERENCES poste (Id_poste) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE commentaire ADD CONSTRAINT etranger_user_comnt FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE demande DROP FOREIGN KEY FK_2694D7A5C86AD69C');
        $this->addSql('ALTER TABLE demande CHANGE Id_utilisateur Id_utilisateur INT NOT NULL');
        $this->addSql('ALTER TABLE demande ADD CONSTRAINT etranger_demande FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE joueur DROP FOREIGN KEY FK_FD71A9C5C86AD69C');
        $this->addSql('ALTER TABLE joueur DROP FOREIGN KEY FK_FD71A9C5896F737F');
        $this->addSql('ALTER TABLE joueur CHANGE Id_utilisateur Id_utilisateur INT NOT NULL, CHANGE Id_tournoi Id_tournoi INT NOT NULL');
        $this->addSql('ALTER TABLE joueur ADD CONSTRAINT etranger_ID_Tournoi FOREIGN KEY (Id_tournoi) REFERENCES tournoi (Id_tournoi) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE joueur ADD CONSTRAINT etranger_joueur_id_User FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE panier DROP FOREIGN KEY FK_24CC0DF2B8654687');
        $this->addSql('ALTER TABLE panier DROP FOREIGN KEY FK_24CC0DF2B8ADC53F');
        $this->addSql('ALTER TABLE panier CHANGE Id_produit Id_produit INT NOT NULL, CHANGE Id_commande Id_commande INT NOT NULL');
        $this->addSql('ALTER TABLE panier ADD CONSTRAINT etranger_cammande_id FOREIGN KEY (Id_commande) REFERENCES commande (Id_commande) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE panier ADD CONSTRAINT etranger_produit_id FOREIGN KEY (Id_produit) REFERENCES merche (Id_produit) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE participants DROP FOREIGN KEY FK_716970927BBBCA40');
        $this->addSql('ALTER TABLE participants DROP FOREIGN KEY FK_71697092C86AD69C');
        $this->addSql('ALTER TABLE participants CHANGE Id_seance Id_seance INT NOT NULL, CHANGE Id_utilisateur Id_utilisateur INT NOT NULL');
        $this->addSql('ALTER TABLE participants ADD CONSTRAINT etranger_participant_idUser FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE participants ADD CONSTRAINT etranger_seance FOREIGN KEY (Id_seance) REFERENCES seance (Id_seance) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE poste DROP FOREIGN KEY FK_7C890FABC86AD69C');
        $this->addSql('ALTER TABLE poste CHANGE Id_utilisateur Id_utilisateur INT NOT NULL');
        $this->addSql('ALTER TABLE poste ADD CONSTRAINT etranger_user_poste FOREIGN KEY (Id_utilisateur) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE rating DROP FOREIGN KEY FK_D8892622D1AA708F');
        $this->addSql('ALTER TABLE rating CHANGE id_post id_post INT NOT NULL');
        $this->addSql('ALTER TABLE rating ADD CONSTRAINT ddz FOREIGN KEY (id_post) REFERENCES poste (Id_poste) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE seance DROP FOREIGN KEY FK_DF7DFD0ED1DC2CFC');
        $this->addSql('ALTER TABLE seance CHANGE id_coach id_coach INT NOT NULL');
        $this->addSql('ALTER TABLE seance ADD CONSTRAINT seance_id_coach FOREIGN KEY (id_coach) REFERENCES utilisateur (ID_utilisateur) ON UPDATE CASCADE ON DELETE CASCADE');
    }
}
