package useCase.storicoPrenotazioni.Control;

import factoryMethod.Factory;
import factoryMethod.LibreriaAttori.UtenteDao;
import useCase.storicoPrenotazioni.Model.PrenotazioneStorico;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class DaoStorico {

    // Ritorna la lista dei nomi delle prenotazioni richieste
    public static ArrayList<PrenotazioneStorico> returnPrenotazioni(int annoAccademico) {

        LocalDate dataInizioAA = LocalDate.of(annoAccademico, 10, 1);
        LocalDate dataFineAA = LocalDate.of(annoAccademico+2, 2, 28);
        ArrayList<PrenotazioneStorico> listaPrenotazioni = new ArrayList<>();

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
            String query = " SELECT * " +
                            "FROM prenotazione " +
                            "WHERE data >= ' " + dataInizioAA +" ' and data <= ' " + dataFineAA +" ' ";
            ResultSet result = statement.executeQuery(query);


            // Registrazione dei risultati
            while (result.next()) {
                String aula = result.getString("aula");
                String evento = result.getString("tipoevento");
                Date date = result.getDate("data");
                int oraInizio = result.getInt("orainizio");
                int oraFine = result.getInt("orafine");

                // Creazione delle prenotazioni
                PrenotazioneStorico prenotazione = new PrenotazioneStorico(aula, evento, date, oraInizio, oraFine);

                // Aggiunta della prenotazione alla lista
                listaPrenotazioni.add(prenotazione);
            }

            // Chiusura della connessione
            result.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return listaPrenotazioni;
    }

}
