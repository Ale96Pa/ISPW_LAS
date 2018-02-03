package useCase.storicoPrenotazioni.Model;

import java.util.Date;

public class PrenotazioneStorico{

    // Attributi
    private String nomeAula;
    private String titoloEvento;
    private Date data;
    private int oraInizio;
    private int oraFine;

    // Costruttore
    public PrenotazioneStorico(String nomeAula, String titoloEvento, Date data, int oraInizio, int oraFine) {
        this.nomeAula = nomeAula;
        this.titoloEvento = titoloEvento;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }

    //Metodi
    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public String getTitoloEvento() {
        return titoloEvento;
    }

    public void setTitoloEvento(String titoloEvento) {
        this.titoloEvento = titoloEvento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(int oraInizio) {
        this.oraInizio = oraInizio;
    }

    public int getOraFine() {
        return oraFine;
    }

    public void setOraFine(int oraFine) {
        this.oraFine = oraFine;
    }
}
