package useCase.consultazioneAule.Model;

public class NumeroPosti {

    // Attributo
    private int numPosti;
    private String modelloSedute;
    private String casaProduttrice;
    private String materialeSedie;

    // Costruttore
    public NumeroPosti(int numPosti) {
        this.numPosti = numPosti;
    }

    //Metodi
    public int getNumPosti() {
        return numPosti;
    }

    public void setNumPosti(int numPosti) {
        this.numPosti = numPosti;
    }

    public String getModelloSedute() {
        return modelloSedute;
    }

    public void setModelloSedute(String modelloSedute) {
        this.modelloSedute = modelloSedute;
    }

    public String getCasaProduttrice() {
        return casaProduttrice;
    }

    public void setCasaProduttrice(String casaProduttrice) {
        this.casaProduttrice = casaProduttrice;
    }

    public String getMaterialeSedie() {
        return materialeSedie;
    }

    public void setMaterialeSedie(String materialeSedie) {
        this.materialeSedie = materialeSedie;
    }
}
