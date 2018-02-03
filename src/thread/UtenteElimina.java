package thread;

import factoryMethod.Factory;
import factoryMethod.LibreriaAttori.UtenteDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UtenteElimina extends Thread{

    private int time;

    public UtenteElimina(int time) {
        this.time = time;
    }

    public void run(){
        try{
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String titoloEvento = "UTENTE PRENOTA SIMULAZIONE";
        eliminaPrenotazione();

    }

    private void eliminaPrenotazione(){

        try {
            Factory factory = new Factory();
            UtenteDao u = factory.creaUtenteDao();

            // Caricamento del Driver
            String driver = u.getDriverClassName();
            Class.forName(driver);

            // Creazione della Connessione
            String urlDB =u.getDbUrl();
            String username = u.getUSER();
            String pw = u.getPASS();
            Connection connection = DriverManager.getConnection(urlDB, username, pw);

            // Creazione dello Statement per le interrogazioni
            Statement statement = connection.createStatement();

            // Esecuzione dell'operazione CRUD (eliminazione prenotazione)
                String deleteEvent = "DELETE FROM prenotazione" +
                                     " WHERE tipoevento = 'UTENTE PRENOTA SIMULAZIONE' ";
                int result = statement.executeUpdate(deleteEvent);

                String deleteEvent2 = "DELETE FROM evento" +
                                      " WHERE titolo = 'UTENTE PRENOTA SIMULAZIONE' ";
                int result2 = statement.executeUpdate(deleteEvent2);

                System.out.println("Eliminate " + result + " tupla/e \n");

            // Chiusura della connessione
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
