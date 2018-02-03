package factoryMethod.LibreriaAttori;

public class Segretaria implements Attore {

    // Attributi
    private int codice;
    private String NOME;
    private String COGNOME;
    private String DIPARTIMENTO;
    private int CODICECONTRATTO;

    // Costruttore
    public Segretaria(int codice){
        this.codice = codice;
    }

    // Metodi
    public String getNOME() {
        return NOME;
    }

    public String getCOGNOME() {
        return COGNOME;
    }

    public String getDIPARTIMENTO() {
        return DIPARTIMENTO;
    }

    public int getCODICECONTRATTO() {
        return CODICECONTRATTO;
    }



    // In base al codice univoco del professore vengono ricercate in un DB le sue credenziali (SIMULAZIONE !!)
    @Override
    public void setAttore() {
        // 1. ricerca nel DB delle credenziali
        // 2. assegnamento delle credenziali (Simulazione della ricerca attraverso il codice univoco)
        NOME = String.valueOf(codice);
        COGNOME = String.valueOf(codice);
        CODICECONTRATTO = codice;
        DIPARTIMENTO = String.valueOf(codice);
    }
}
