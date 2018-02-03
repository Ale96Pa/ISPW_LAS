package exceptions;

public class NotDisponibilityException extends Exception {



    public NotDisponibilityException(){
        super("Non ci sono aule disponibili per la prenotazione richiesta.");
    }

    public NotDisponibilityException(Throwable cause){
        super(cause);
    }
}
