package useCase.consultazioneAule.Model;

public class Ora {

    // Attributo
    private int ora;
    private int minuto;
    private int secondo;

    // Costruttore
    public Ora(int ora) {
        this.ora = ora;
    }

    // Metodi
    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSecondo() {
        return secondo;
    }

    public void setSecondo(int secondo) {
        this.secondo = secondo;
    }
}
