package thread;

import useCase.consultazioneAule.Control.DaoDisponibilita;

import java.time.LocalDate;
import java.util.ArrayList;

public class UtenteConsulta extends Thread {

    private int time;
    private int id;

    public UtenteConsulta(int time, int id){
        this.time = time;
        this.id = id;
    }

    public void run() {
        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalDate date = LocalDate.of(2010, 1, 1);
        int oraInizio = 8;
        int oraFine = 10;
        int numeroPosti = 25;
        boolean microfono = false;
        boolean proiettore = false;

        ArrayList<String> auleDisponibili;
        System.out.println("UTENTE CONSULTATARIO ID: " + id );
        auleDisponibili = DaoDisponibilita.returnAule(String.valueOf(numeroPosti), String.valueOf(proiettore),
                String.valueOf(microfono), date, oraInizio, oraFine);
        System.out.println("Consultate e trovate le aule disponibili:  " + auleDisponibili);
        System.out.println("FINE ------------------- UTENTE CONSULTATARIO ID: " + id);



    }
}
