package useCase.consultazioneAule.Model;

import java.time.LocalDate;

public class Proiettore {

    // Attributo
    private boolean proj;
    private String modello;
    private LocalDate dataUltimoCollaudo;
    private String casaProduttrice;
    private String marca;

    // Costruttore
    public Proiettore(boolean proj) {
        this.proj = proj;
    }

    // Metodi
    public boolean isProj() {
        return proj;
    }

    public void setProj(boolean proj) {
        this.proj = proj;
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
