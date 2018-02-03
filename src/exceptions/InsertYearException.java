package exceptions;

public class InsertYearException extends Exception {

    public InsertYearException(){
        super("Errore nell'inserimento dell'anno: inserisci un anno compreso tra 2000 e 2100");
    }

    public InsertYearException(Throwable cause){
        super(cause);
    }
}
