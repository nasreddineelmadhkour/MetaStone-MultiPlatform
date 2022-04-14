package tn.edu.esprit.Controller;

import tn.edu.esprit.model.Commentaire;
import tn.edu.esprit.model.Poste;



public interface MyListener {

    public void onClickListener(Poste poste);

    public void onClickListener(Commentaire comment);
  

    
}
