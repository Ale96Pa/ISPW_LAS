package useCase.storicoPrenotazioni.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import useCase.storicoPrenotazioni.Control.DaoStorico;
import useCase.storicoPrenotazioni.Model.PrenotazioneStorico;

import java.util.ArrayList;

public class StoricoBean {

    // Attributi
    public static int anno;

    // Metodi
    public static int getAnno() {
        return anno;
    }

    public static void setAnnoAccademico(int anno){
        StoricoBean.anno = anno;
    }

    public void setAnno(int anno) {
        StoricoBean.anno = anno;
    }

    public static ArrayList<PrenotazioneStorico> storicoPrenotazioni(){

        ArrayList<PrenotazioneStorico> listaPrenotazioni;
        listaPrenotazioni = DaoStorico.returnPrenotazioni(getAnno());
        return listaPrenotazioni;
    }

    public static ObservableList<PrenotazioneStorico> setTable(){
        ArrayList<PrenotazioneStorico> listaPrenotazioni = storicoPrenotazioni();
        ObservableList<PrenotazioneStorico> prenotazioni = FXCollections.observableArrayList();

        if(listaPrenotazioni.size() == 0){
            return prenotazioni;
        }
        for(int i=0; i<listaPrenotazioni.size(); i++){
            PrenotazioneStorico p = new PrenotazioneStorico(listaPrenotazioni.get(i).getNomeAula(),
                    listaPrenotazioni.get(i).getTitoloEvento(), listaPrenotazioni.get(i).getData(),
                    listaPrenotazioni.get(i).getOraInizio(), listaPrenotazioni.get(i).getOraFine());
            prenotazioni.add(p);
        }
        return prenotazioni;

    }
}