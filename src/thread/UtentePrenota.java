package thread;

import useCase.prenotazioneAule.Control.ConfigurazionePrenotazione;
import useCase.prenotazioneAule.Control.DaoPrenotazione;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class UtentePrenota extends Thread {

    private int time;
    private int id;

    public UtentePrenota(int time, int id){
        this.time = time;
        this.id = id;
    }

    public void run(){
        try{
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalDate date = LocalDate.of(2010, 1, 1);
        int oraInizio = 8;
        int oraFine = 10;
        String titoloEvento = "UTENTE PRENOTA SIMULAZIONE";
        int numeroPostiNecessari = 25;
        boolean microfono = false;
        boolean proiettore = false;

        ArrayList<String> auleDisponibili;
        HashMap<String, Integer> aula_posti;
        ArrayList<String> aulePrenotate;

        System.out.println("Aule disponibili... UTENTE PRENOTA ID: " + id );
        auleDisponibili = DaoPrenotazione.returnAule(String.valueOf(proiettore), String.valueOf(microfono), date, oraInizio, oraFine);
        System.out.println(auleDisponibili + "\n");
        aula_posti = DaoPrenotazione.AulaPosti(auleDisponibili);
        aulePrenotate = ConfigurazionePrenotazione.aulePrenotate(aula_posti, auleDisponibili, numeroPostiNecessari);
        System.out.println("Aule prenotabili: " + aulePrenotate + "\n");
        System.out.println("Tentativo di inserimento prenotazione: UTENTE ID: " + id );
        boolean esito = DaoPrenotazione.prenotaEvento(aulePrenotate, titoloEvento, date, oraInizio, oraFine);
        System.out.println("Esito inserimento UTENTE ID: " + id +" : " + esito);
        System.out.println("FINE------------- UTENTE ID: " + id  + "\n\n");

    }

}
