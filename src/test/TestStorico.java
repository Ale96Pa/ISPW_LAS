package test;

import org.junit.Test;
import useCase.storicoPrenotazioni.Control.DaoStorico;
import useCase.storicoPrenotazioni.Model.PrenotazioneStorico;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestStorico {

    @Test
    // Test per verificare la condizione di assenza prenotazioni
    public void TestBase2(){
        ArrayList<PrenotazioneStorico> testPrenotazioniDb;
        ArrayList<PrenotazioneStorico> empty = new ArrayList<>();

        int annoAccademico = 2050;   // 2050/2051

        System.out.println("Accesso al DB per la ricerca di prenotazioni ... ");
        testPrenotazioniDb = DaoStorico.returnPrenotazioni(annoAccademico);

        assertEquals("test equals", empty, testPrenotazioniDb);
    }
}
