package useCase.prenotazioneAule.Control;

import factoryMethod.Factory;
import factoryMethod.LibreriaAttori.UtenteDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class DaoPrenotazione {

    // Ritorna la lista dei nomi delle aule disponibili
    public static ArrayList<String> returnAule(String proj, String mic, LocalDate data, int oraInizioUtente,
                                               int oraFineUtente) {

        ArrayList<String> listaAule = new ArrayList<>();

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

            // Esecuzione della query
            String query =  "SELECT nome " +
                            "FROM aula " +
                            "WHERE nome = nome";
            if (mic == "true")
                query = query + " and microfono= true ";
            if (proj == "true")
                query = query + " and proiettore= true ";

            query = query + " except ";

            query = query + " SELECT aula " +
                            " FROM prenotazione " +
                            " WHERE data = ' " + data + " ' " +
                            " and ( (orainizio <= " + oraInizioUtente + " and orafine <= " + oraFineUtente + ") or " +
                            " (orainizio <= " + oraInizioUtente + " and orafine >= " + oraFineUtente + ") or " +
                            " (orainizio >= " + oraInizioUtente + " and orainizio <= " + oraFineUtente + ") or " +
                            " (orafine >= " + oraInizioUtente + " and orafine <= " + oraFineUtente + ") )";

            ResultSet result = statement.executeQuery(query);


            // Registrazione dei risultati
            while (result.next()) {
                String aula = result.getString("nome");

                listaAule.add(aula);
            }

            // Chiusura della connessione
            result.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return listaAule;
    }


    // Ritorna il dizionario con valori del tipo <AULA, NUMERO POSTI>
    public static HashMap<String, Integer> AulaPosti(ArrayList<String> auleDisp) {

        HashMap<String, Integer> aula_posti = new HashMap<>();

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

            // Esecuzione della query
            String query =  "SELECT nome, numposti " +
                            "FROM aula " +
                            "WHERE nome = '" + auleDisp.get(0) + "'";

            for (int i = 1; i < auleDisp.size(); i++) {
                query = query + " or nome = '" + auleDisp.get(i) + "'";
            }

            ResultSet result = statement.executeQuery(query);


            // Registrazione dei risultati
            while (result.next()) {
                String aula = result.getString("nome");
                Integer num = result.getInt("numposti");

                aula_posti.put(aula, num); // Inserimento degli elementi nel dizionario
            }

            // Chiusura della connessione
            result.close();
            statement.close();
            connection.close();


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return aula_posti;
    }


    // Inserisce la prenotazione nel database
    public static boolean prenotaEvento(ArrayList<String> aulePrenotate, String evento, LocalDate data, int oraInizio,
                                        int orafine) {

        boolean validaPrenotazione = false;

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

            // Esecuzione dell'operazione CRUD (inserimento prenotazione)
            String insertEvent = "INSERT INTO evento (titolo, data, orainizio, orafine)" +
                        " VALUES ('" + evento + "' , '" + data + "' ," + oraInizio + " , " + orafine + ")";
            int result2 = statement.executeUpdate(insertEvent);

            int count = 0;
            for (int i = 0; i < aulePrenotate.size(); i++) {
                String insertPren = "INSERT INTO prenotazione (aula, tipoevento, data, orainizio, orafine)" +
                        "VALUES ('" + aulePrenotate.get(i) + "' , '" + evento + "' , '" + data + "' ," + oraInizio +
                        " , " + orafine + ")";
                int result = statement.executeUpdate(insertPren);
                count += result;
            }
            System.out.println("Aggiornate " + count + " tuple nella tabella PRENOTAZIONE");
            if (count > 0)
                validaPrenotazione = true;


            // Chiusura della connessione
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            return validaPrenotazione;
        }
    }
}
