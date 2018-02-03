package useCase.prenotazioneAule.View;

import useCase.consultazioneAule.Model.Aula;
import useCase.prenotazioneAule.Control.ConfigurazionePrenotazione;
import useCase.prenotazioneAule.Model.Prenotazione;

import java.time.LocalDate;
import java.util.ArrayList;

public class PrenotazioneBean {

    // Attributi
    private static int titoloEvento;
    private static int giorno;
    private static int mese;
    private static int anno;
    private static int orainizio;
    private static int orafine;
    private static int numeroPosti;
    private static boolean microfono;
    private static boolean proiettore;
    private  ArrayList<Aula> aule;

    // Costruttore
    public PrenotazioneBean() {
    }

    // Metodi

    public static String getTitoloEvento() {
        String title;
        if (titoloEvento == 1)
            title = "Test d ingresso";
        else
            title = "Seduta di laurea";
        return title;
    }

    public void setTitoloEvento(int titoloEvento) {
        this.titoloEvento = titoloEvento;
    }

    public static int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public static int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public static int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public static int getOrainizio() {
        return orainizio;
    }

    public void setOrainizio(int orainizio) {
        this.orainizio = orainizio;
    }

    public static int getOrafine() {
        return orafine;
    }

    public void setOrafine(int orafine) {
        this.orafine = orafine;
    }

    public static int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public static boolean isMicrofono() {
        return microfono;
    }

    public void setMicrofono(boolean microfono) {
        this.microfono = microfono;
    }

    public static boolean isProiettore() {
        return proiettore;
    }

    public void setProiettore(boolean proiettore) {
        this.proiettore = proiettore;
    }

    public ArrayList<Aula> getAule() {
        return aule;
    }

    public void setAule(ArrayList<Aula> aule) {
        this.aule = aule;
    }


    public static void setDay(int day) {
        PrenotazioneBean.giorno = day;
    }

    public static void setMonth(int month) {
        PrenotazioneBean.mese = month;
    }

    public static void setYear(int year) {
        PrenotazioneBean.anno = year;
    }

    public static void setOrastar(int orastar) {
        PrenotazioneBean.orainizio = orastar;
    }

    public static void setOraend(int oraend) {
        PrenotazioneBean.orafine = oraend;
    }

    public static void setNumposti(int numposti) {
        PrenotazioneBean.numeroPosti = numposti;
    }

    public static void setMic(boolean mic) {
        PrenotazioneBean.microfono = mic;
    }

    public static void setProj(boolean proj) {
        PrenotazioneBean.proiettore = proj;
    }

    public static void setEvent(int titoloEvento) {
        PrenotazioneBean.titoloEvento = titoloEvento;
    }

    // Lista delle aule prenotate
    public ArrayList<String> aulePrenotate(){
        ArrayList<String> nomiAule = new ArrayList<String>();
        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
        LocalDate data = LocalDate.of(getAnno(), getMese(), getGiorno());

        prenotazioni = ConfigurazionePrenotazione.creaPrenotazioni(isMicrofono(), isProiettore(), getTitoloEvento(),
                data, getOrainizio(), getOrafine(), getNumeroPosti());
        for(int i=0; i<prenotazioni.size(); i++){
            nomiAule.add(prenotazioni.get(i).getAula().getNome());
        }
        return nomiAule;
    }

    public static ArrayList<String> bookedRoom(){
        ArrayList<String> nomiAule = new ArrayList<String>();
        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
        LocalDate data = LocalDate.of(getAnno(), getMese(), getGiorno());

        prenotazioni = ConfigurazionePrenotazione.creaPrenotazioni(isMicrofono(), isProiettore(), getTitoloEvento(),
                data, getOrainizio(), getOrafine(), getNumeroPosti());
        for(int i=0; i<prenotazioni.size(); i++){
            nomiAule.add(prenotazioni.get(i).getAula().getNome());
        }
        return nomiAule;
    }

}
