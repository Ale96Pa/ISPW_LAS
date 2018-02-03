/**
 * PATTERN GRASP: High Cohesion
 * Coesione alta di dati tra la classe Prenotazione e le classi Aula ed Evento (una sola area funzionale!)
 */

package useCase.prenotazioneAule.Model;

import useCase.consultazioneAule.Model.Aula;

public class Prenotazione {

    // Attributi
    private Aula aula;
    private Evento evento;

    // Costruttore
    public Prenotazione(Aula aula, Evento evento) {
        this.aula = aula;
        this.evento = evento;
    }


    // Metodi
    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
