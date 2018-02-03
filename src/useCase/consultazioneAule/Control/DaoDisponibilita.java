package useCase.consultazioneAule.Control;

import java.sql.*;
import factoryMethod.Factory;
import factoryMethod.LibreriaAttori.UtenteDao;
import java.time.LocalDate;
import java.util.*;

public class DaoDisponibilita {

    // Ritorna la lista dei nomi delle aule disponibili
    public static ArrayList<String> returnAule(String numeroPosti, String proj, String mic, LocalDate data,
                                               int oraInizioUtente, int oraFineUtente) {

        ArrayList<String> listaAule = new ArrayList<>();

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

            // Esecuzione della query
            String query =  "SELECT nome " +
                            "FROM aula " +
                            "WHERE numposti >= " + numeroPosti ;
            if (Objects.equals(mic, "true"))
                query = query + " and microfono= true ";
            if(Objects.equals(proj, "true"))
                query = query + " and proiettore= true ";

            query = query + " except ";

            query = query + " SELECT aula "+
                            " FROM prenotazione " +
                            " WHERE data = ' " + data +" ' " +
                            " and ( (orainizio <= " + oraInizioUtente + " and orafine <= " + oraFineUtente + ") or " +
                            " (orainizio <= " + oraInizioUtente + " and orafine >= " + oraFineUtente + ") or " +
                            " (orainizio >= " + oraInizioUtente + " and orainizio < " + oraFineUtente + ") or " +
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
}
