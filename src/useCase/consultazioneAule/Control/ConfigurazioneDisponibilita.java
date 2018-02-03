package useCase.consultazioneAule.Control;

import useCase.consultazioneAule.Model.Microfono;
import useCase.consultazioneAule.Model.NumeroPosti;
import useCase.consultazioneAule.View.BeanConsultaAule;
import useCase.consultazioneAule.Model.Aula;
import useCase.consultazioneAule.Model.Proiettore;
import java.util.ArrayList;
import java.util.HashSet;

public class ConfigurazioneDisponibilita {

    // Torna la lista delle AULE disponibili
    public static ArrayList<Aula> creaAuleDisponibili (int numPosti, boolean microfono, boolean proiettore) {

        ArrayList<Aula> auleDisp = new ArrayList<>();
        String posti = String.valueOf(numPosti);
        String mic = String.valueOf(microfono);
        String proj = String.valueOf(proiettore);

        ArrayList<String> listAule = DaoDisponibilita.returnAule(posti, mic, proj, BeanConsultaAule.getData(),
                BeanConsultaAule.getOrainizio(), BeanConsultaAule.getOrafine());

        System.out.println("Creo le aule disponibili ... ");


        listAule = eliminaDuplicati(listAule);
        NumeroPosti numeroPosti1 = new NumeroPosti(numPosti);
        Microfono microfono1 = new Microfono(microfono);
        Proiettore proiettore1 = new Proiettore(proiettore);
        int numeroAuleDisp = listAule.size();
        int i;
        for(i=0; i<numeroAuleDisp; i++){
            Aula newaula = new Aula(listAule.get(i), numeroPosti1, microfono1, proiettore1 );
            auleDisp.add(newaula);
        }

        System.out.println("Aule create! ");
        return auleDisp;
    }

    private static ArrayList<String> eliminaDuplicati(ArrayList<String> listaConDuplicati){
        java.util.Set setPmpListArticle=new HashSet(listaConDuplicati);
        return new ArrayList(setPmpListArticle);
    }
}
