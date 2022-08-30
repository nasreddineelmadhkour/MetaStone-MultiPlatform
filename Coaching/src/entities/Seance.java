package entities;


import java.sql.Time;
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aziz
 */
public class Seance {
    int ID_Seance;
    int ID_coach;
    Date date;
    Time duree;
    int NBR_Participant;
    String URL;
    float prix;

    public Seance(int ID_Seance, int ID_coach, Date date, Time duree, int NBR_Participant, String URL, float prix) {
        this.ID_Seance = ID_Seance;
        this.ID_coach = ID_coach;
        this.date = date;
        this.duree = duree;
        this.NBR_Participant = NBR_Participant;
        this.URL = URL;
        this.prix = prix;
    }

    public int getID_Seance() {
        return ID_Seance;
    }

    public int getID_coach() {
        return ID_coach;
    }

    public Date getDate() {
        return date;
    }

    public Time getDuree() {
        return duree;
    }

    public int getNBR_Participant() {
        return NBR_Participant;
    }

    public String getURL() {
        return URL;
    }

    public float getPrix() {
        return prix;
    }

    public void setID_Seance(int ID_Seance) {
        this.ID_Seance = ID_Seance;
    }

    public void setID_coach(int ID_coach) {
        this.ID_coach = ID_coach;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public void setNBR_Participant(int NBR_Participant) {
        this.NBR_Participant = NBR_Participant;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Seance{" + "ID_Seance=" + ID_Seance + ", ID_coach=" + ID_coach + ", date=" + date + ", duree=" + duree + ", NBR_Participant=" + NBR_Participant + ", URL=" + URL + ", prix=" + prix + '}';
    }
    
}
