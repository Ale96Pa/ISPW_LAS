package test;

import factoryMethod.Factory;
import factoryMethod.LibreriaAttori.UtenteDao;
import org.junit.After;
import org.junit.Test;
import useCase.prenotazioneAule.Control.ConfigurazionePrenotazione;
import useCase.prenotazioneAule.Control.DaoPrenotazione;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertFalse;

public class TestEccezione {

    @Test
    // Verifica dell'eccezione NotDisponibility (per troppi posti richiesti)
    public void TestPrenotazione(){

        ArrayList<String> auleDisponibili;
        HashMap<String, Integer> aula_posti;
        ArrayList<String> aulePrenotate;

        LocalDate date = LocalDate.of(2020, 5, 25);
        int oraInizio = 8;
        int oraFine = 10;
        String titoloEvento = "TEST ECCEZIONE";
        int numeroPostiNecessari = 80000020;
        boolean microfono = true;
        boolean proiettore = false;

        System.out.println("Verifica della disponibilita'");
        auleDisponibili = DaoPrenotazione.returnAule(String.valueOf(proiettore), String.valueOf(microfono), date, oraInizio, oraFine);
        System.out.println("Database per la disponibilita' interrogato!\n");

        System.out.println("Verifica della creazione del dizionario <Aula, Posti>");
        aula_posti = DaoPrenotazione.AulaPosti(auleDisponibili);
        System.out.println(aula_posti);
        System.out.println("Dizionario creato!\n");

        System.out.println("Verifica dell'assegnamento delle aule");
        aulePrenotate = ConfigurazionePrenotazione.aulePrenotate(aula_posti, auleDisponibili, numeroPostiNecessari);
        System.out.println(aulePrenotate);
        System.out.println("Assegnamento eseguito!\n");

        System.out.println("Verifica dell'operazione CRUD (insert) nel Database");
        boolean esito = DaoPrenotazione.prenotaEvento(aulePrenotate, titoloEvento, date, oraInizio, oraFine);
        System.out.println("CRUD concluso!\n");

        assertFalse(esito);
    }

    @Test
    // Verifica dell'eccezione NotDisponibility (per evento gia' inserito)
    public void TestPrenotazione2(){

        ArrayList<String> auleDisponibili;
        HashMap<String, Integer> aula_posti;
        ArrayList<String> aulePrenotate;

        LocalDate date = LocalDate.of(2018, 2, 10);
        int oraInizio = 8;
        int oraFine = 10;
        String titoloEvento = "ESAME";
        int numeroPostiNecessari = 20;
        boolean microfono = true;
        boolean proiettore = false;

        System.out.println("Verifica della disponibilita'");
        auleDisponibili = DaoPrenotazione.returnAule(String.valueOf(proiettore), String.valueOf(microfono), date, oraInizio, oraFine);
        System.out.println("Database per la disponibilita' interrogato!\n");

        System.out.println("Verifica della creazione del dizionario <Aula, Posti>");
        aula_posti = DaoPrenotazione.AulaPosti(auleDisponibili);
        System.out.println(aula_posti);
        System.out.println("Dizionario creato!\n");

        System.out.println("Verifica dell'assegnamento delle aule");
        aulePrenotate = ConfigurazionePrenotazione.aulePrenotate(aula_posti, auleDisponibili, numeroPostiNecessari);
        System.out.println(aulePrenotate);
        System.out.println("Assegnamento eseguito!\n");

        System.out.println("Verifica dell'operazione CRUD (insert) nel Database");
        boolean esito = DaoPrenotazione.prenotaEvento(aulePrenotate, titoloEvento, date, oraInizio, oraFine);
        System.out.println("CRUD concluso!\n");

        assertFalse(esito);
    }

    @After
    public void eliminaPrenotazione(){
        try {
            Factory factory = new Factory();
            UtenteDao u = factory.creaUtenteDao();

            // Caricamento del Driver
            String driver = u.getDriverClassName();
            Class.forName(driver);

            // Creazione della Connessione
            String urlDB = u.getDbUrl();
            String username = u.getUSER();
            String pw = u.getPASS();
            Connection connection = DriverManager.getConnection(urlDB, username, pw);

            // Creazione dello Statement per le interrogazioni
            Statement statement = connection.createStatement();

            // Esecuzione dell'operazione CRUD (eliminazione prenotazione)
            String deleteEvent = "DELETE FROM prenotazione" +
                                 " WHERE tipoevento = 'TEST ECCEZIONE' ";
            int result = statement.executeUpdate(deleteEvent);

            String deleteEvent2 = "DELETE FROM evento" +
                                  " WHERE titolo = 'TEST ECCEZIONE' ";
            int result2 = statement.executeUpdate(deleteEvent2);

            // Chiusura della connessione
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
