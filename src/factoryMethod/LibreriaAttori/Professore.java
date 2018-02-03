package factoryMethod.LibreriaAttori;

public class Professore implements Attore {

    // Attributi
    private int codice;
    private String NOME;
    private String COGNOME;
    private int CODICE_CORSO;
    private String pw;

    public Professore(int codice){
        this.codice = codice;
    }

    // Metodi
    public String getNOME() {
        return NOME;
    }

    public String getCOGNOME() {
        return COGNOME;
    }

    public int getCODICE_CORSO() {
        return CODICE_CORSO;
    }

    public String getPw() {
        return pw;
    }



    // In base al codice univoco della segretaria vengono ricercate in un DB le sue credenziali (SIMULAZIONE !!)
    @Override
    public void setAttore() {
        // 1. ricerca nel DB delle credenziali
        // 2. assegnamento delle credenziali (Simulazione della ricerca attraverso il codice univoco)
        NOME = String.valueOf(codice);
        COGNOME = String.valueOf(codice);
        CODICE_CORSO = codice;
        pw = String.valueOf(codice);
    }
}
