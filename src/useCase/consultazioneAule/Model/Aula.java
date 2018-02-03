package useCase.consultazioneAule.Model;


public class Aula {

    // Attributi
    private String nome;
    private NumeroPosti numeroPosti;
    private Microfono microfono;
    private Proiettore proiettore;

    // Costruttore
    public Aula(String nome, NumeroPosti numeroPosti, Microfono microfono, Proiettore proiettore) {
        this.nome = nome;
        this.numeroPosti = numeroPosti;
        this.microfono = microfono;
        this.proiettore = proiettore;
    }

    // Metodi
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NumeroPosti getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(NumeroPosti numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public Microfono getMicrofono() {
        return microfono;
    }

    public void setMicrofono(Microfono microfono) {
        this.microfono = microfono;
    }

    public Proiettore getProiettore() {
        return proiettore;
    }

    public void setProiettore(Proiettore proiettore) {
        this.proiettore = proiettore;
    }
}
