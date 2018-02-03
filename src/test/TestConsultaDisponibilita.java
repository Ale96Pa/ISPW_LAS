package test;

import useCase.consultazioneAule.Control.DaoDisponibilita;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestConsultaDisponibilita {

    @Test
    // Test per verificare l'esattezza della query per l'occupazione delle aule
    public void TestConsulta(){

        ArrayList<String> testAuleDb;
        ArrayList<String> aspettativaAule = new ArrayList<>();
        aspettativaAule.add("A4");
        aspettativaAule.add("4");
        aspettativaAule.add("3");
        // L'aula A1 e' occupata (Non deve essere disponibile)

        LocalDate date = LocalDate.of(2018, 2, 10);
        int oraInizio = 8;
        int oraFine = 11;
        int numeroPosti = 100;
        boolean microfono = false;
        boolean proiettore = false;

        System.out.println("Accesso al DB per la verifica di disponibilita' ... ");
        testAuleDb = DaoDisponibilita.returnAule(String.valueOf(numeroPosti), String.valueOf(proiettore),
                String.valueOf(microfono), date, oraInizio, oraFine);
        System.out.println("Database interrogato correttamente!\n");
        System.out.println(testAuleDb + "\n");

        System.out.println("Test della creazione delle aule disponibili");

        assertEquals("test equals", aspettativaAule, testAuleDb);
    }

}
