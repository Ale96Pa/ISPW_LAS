package useCase.consultazioneAule.Model;

import java.time.LocalDate;

public class Microfono {

    // Attributo
    private boolean mic;
    private String modello;
    private LocalDate dataUltimoCollaudo;
    private String casaProduttrice;
    private String marca;

    // Costruttore
    public Microfono(boolean mic) {
        this.mic = mic;
    }

    // Meotodi
    public boolean isMic() {
        return mic;
    }

    public void setMic(boolean mic) {
        this.mic = mic;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public LocalDate getDataUltimoCollaudo() {
        return dataUltimoCollaudo;
    }

    public void setDataUltimoCollaudo(LocalDate dataUltimoCollaudo) {
        this.dataUltimoCollaudo = dataUltimoCollaudo;
    }

    public String getCasaProduttrice() {
        return casaProduttrice;
    }

    public void setCasaProduttrice(String casaProduttrice) {
        this.casaProduttrice = casaProduttrice;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
