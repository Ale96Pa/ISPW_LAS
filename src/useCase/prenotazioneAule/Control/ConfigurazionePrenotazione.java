package useCase.prenotazioneAule.Control;
/**
// 1 - crea lista aule disponibili
// 2 - crea DIZIONARIO <aula, numposti>
// 3 - assegna le aule in base al numero di posti necessario (torna lista di stringhe)
// 4.A - inserici la prenotazione nel DB
// 4.B - ritorna la lista delle aule assegnate (String) alla view per farle visualizzare
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import useCase.consultazioneAule.Model.*;
import exceptions.NotDisponibilityException;
import useCase.prenotazioneAule.Model.Evento;
import useCase.prenotazioneAule.Model.Prenotazione;
import useCase.prenotazioneAule.View.PrenotazioneBean;

public class ConfigurazionePrenotazione {

    // Ritorna la lista delle aule da prenotare
    public static ArrayList<String> aulePrenotate (HashMap<String, Integer> aulePosti, ArrayList<String> auleDisp,
                                                   int postiNecessari){

        ArrayList<String> aule_prenotate = new ArrayList<>();
        int count = 0;

        try {
            for(int i=0; i<aulePosti.size(); i++) {
                count += aulePosti.get(auleDisp.get(i));
                aule_prenotate.add(auleDisp.get(i));
                if (count >= postiNecessari) {
                     return aule_prenotate;
                }
            }
            if (count < postiNecessari) {
                aule_prenotate.clear();
                throw new NotDisponibilityException();
            }
            } catch (NotDisponibilityException e) {
            e.printStackTrace();
        }


        return aule_prenotate;
    }

    // Ritorna la lista delle Prenotazioni da fare
    public static ArrayList<Prenotazione> creaPrenotazioni (boolean microfono, boolean proiettore, String title,
                                                            LocalDate data, int oraDa, int oraA, int numPostiNecessari){

        String mic = String.valueOf(microfono);
        String proj = String.valueOf(proiettore);

        Ora oraDa1 = new Ora(PrenotazioneBean.getOrainizio());
        Ora oraA1 = new Ora(PrenotazioneBean.getOrafine());
        NumeroPosti numeroPosti = new NumeroPosti(PrenotazioneBean.getNumeroPosti());
        Microfono microfono1 = new Microfono(PrenotazioneBean.isMicrofono());
        Proiettore proiettore1 = new Proiettore(PrenotazioneBean.isProiettore());

        Evento evento = new Evento(title, data, oraDa1, oraA1);

        ArrayList<String> auleDisponibili = DaoPrenotazione.returnAule(proj, mic, data, oraDa,  oraA);
        ArrayList<String> aulePrenotate = aulePrenotate(DaoPrenotazione.AulaPosti(auleDisponibili),
                auleDisponibili, numPostiNecessari);

        boolean esitoPren = DaoPrenotazione.prenotaEvento(aulePrenotate, title, data, oraDa, oraA);
        if(!esitoPren){
            aulePrenotate.clear();
        }

        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
        try {
            if (auleDisponibili.size() == 0){
                prenotazioni.clear();
                throw new NotDisponibilityException();
            }

            for(int i=0; i<aulePrenotate.size(); i++){
                Aula newAula = new Aula(aulePrenotate.get(i), numeroPosti, microfono1, proiettore1);
                Prenotazione pren = new Prenotazione(newAula, evento);
                prenotazioni.add(pren);
            }

        } catch (NotDisponibilityException e) {
            e.printStackTrace();
        } finally {
            return prenotazioni;
        }

    }

}
