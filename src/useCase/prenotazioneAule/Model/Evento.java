package useCase.prenotazioneAule.Model;

import useCase.consultazioneAule.Model.Ora;

import java.time.LocalDate;

public class Evento {

    // Attributi
    private String tipo;
    private LocalDate data;
    private Ora oraInizio;
    private Ora oraFine;

    // Costruttore
    public Evento(String tipo, LocalDate data, Ora oraInizio, Ora oraFine) {
        this.tipo = tipo;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }

    // Metodi
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Ora getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(Ora oraInizio) {
        this.oraInizio = oraInizio;
    }

    public Ora getOraFine() {
        return oraFine;
    }

    public void setOraFine(Ora oraFine) {
        this.oraFine = oraFine;
    }
}
