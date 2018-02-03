package exceptions;

public class InsertOraException extends Exception{

    public InsertOraException(){
        super("Errore nell'inserimento dell'orario: ora d'inizio e' MAGGIORE di ora fine");
    }

    public InsertOraException(Throwable cause){
        super(cause);
    }
}
