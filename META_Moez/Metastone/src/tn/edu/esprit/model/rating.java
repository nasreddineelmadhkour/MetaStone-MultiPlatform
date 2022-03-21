/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.model;

/**
 *
 * @author THEOLDISBACK
 */
public class rating {
    private int id;
    private double rate;
    private int id_poste;

    public rating() {
    }

    
  
    
    public rating(int id, double rate, int id_poste) {
        this.id = id;
        this.rate = rate;
        this.id_poste = id_poste;
    }

    
    
    
    
    
    
    
    
    
    
    
    @Override
    public String toString() {
        return "rating{" + "id=" + id + ", rate=" + rate + ", id_poste=" + id_poste + '}';
    }

    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getId_poste() {
        return id_poste;
    }

    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }
    
    
    
    
}
