import entities.Seance;
import services.SeanceService;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
public class Test {

    public static void main(String[] args) {
        Seance s1 = new Seance(5, 1,Date.valueOf(LocalDate.now()) , Time.valueOf(LocalTime.of(13, 0)), 10, "google", 20f);
        SeanceService manager = new SeanceService();
        try{
            //manager.ajouterSeance(s1);
            System.out.println("Avant Modification");
            ArrayList<Seance> seances = manager.getSeances();
            seances.forEach(s ->System.out.println(s));
            System.out.println("Aprés Modification");
            Seance s3 = seances.get(0);
            //s3.setPrix(90);
            //manager.modifierSeance(s3);
            manager.supprimerSeance(s3.getID_Seance());
            ArrayList<Seance> seancesUpdated= manager.getSeances();
            seancesUpdated.forEach(s ->System.out.println(s));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
