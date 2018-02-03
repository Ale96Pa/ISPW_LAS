package useCase.consultazioneAule.View;

import useCase.consultazioneAule.Control.ConfigurazioneDisponibilita;
import useCase.consultazioneAule.Model.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class BeanConsultaAule {


    // Attributi
    private static int giorno;
    private static int mese;
    private static int anno;
    private static int orainizio;
    private static int orafine;
    private static int numeroPosti;
    private static boolean microfono;
    private static boolean proiettore;


    // Dati inseriti dall'utente
    public static int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        BeanConsultaAule.giorno = giorno;
    }

    public static int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        BeanConsultaAule.mese = mese;
    }

    public static int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        BeanConsultaAule.anno = anno;
    }

    public static LocalDate getData() {
        LocalDate data = LocalDate.of(getAnno(), getMese(), getGiorno());
        return data;
    }

    public static int getOrainizio() {
        return orainizio;
    }

    public void setOrainizio(int orainizio) {
        BeanConsultaAule.orainizio = orainizio;
    }

    public static int getOrafine() {
        return orafine;
    }

    public void setOrafine(int orafine) {
        BeanConsultaAule.orafine = orafine;
    }

    public static int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        BeanConsultaAule.numeroPosti = numeroPosti;
    }

    public static boolean isMicrofono() {
        return microfono;
    }

    public void setMicrofono(boolean microfono) {
        BeanConsultaAule.microfono = microfono;
    }

    public static boolean isProiettore() {
        return proiettore;
    }

    public void setProiettore(boolean proiettore) {
        BeanConsultaAule.proiettore = proiettore;
    }


    public static void setDay(int day) {
        BeanConsultaAule.giorno = day;
    }

    public static void setMonth(int month) {
        BeanConsultaAule.mese = month;
    }

    public static void setYear(int year) {
        BeanConsultaAule.anno = year;
    }

    public static void setOrastar(int orastar) {
        BeanConsultaAule.orainizio = orastar;
    }

    public static void setOraend(int oraend) {
        BeanConsultaAule.orafine = oraend;
    }

    public static void setNumposti(int numposti) {
        BeanConsultaAule.numeroPosti = numposti;
    }

    public static void setMic(boolean mic) {
        BeanConsultaAule.microfono = mic;
    }

    public static void setProj(boolean proj) {
        BeanConsultaAule.proiettore = proj;
    }

    // Lista delle aule disponibili
    public ArrayList<String> auleDisponibili(){
        ArrayList<String> nomiAule = new ArrayList<String>();
        ArrayList<Aula> aule = ConfigurazioneDisponibilita.creaAuleDisponibili(getNumeroPosti(), isMicrofono(), isProiettore());
        int numeroAule = aule.size();
        for(int i=0; i<numeroAule; i++){
            nomiAule.add(aule.get(i).getNome());
        }
        return nomiAule;
    }

    public static ArrayList<String> availableRoom(){
        ArrayList<String> nomiAule = new ArrayList<String>();
        ArrayList<Aula> aule = ConfigurazioneDisponibilita.creaAuleDisponibili(getNumeroPosti(), isMicrofono(), isProiettore());
        int numeroAule = aule.size();
        for(int i=0; i<numeroAule; i++){
            nomiAule.add(aule.get(i).getNome());
        }
        return nomiAule;
    }
}