package test;

import factoryMethod.Factory;
import factoryMethod.LibreriaAttori.Professore;
import factoryMethod.LibreriaAttori.Segretaria;

public class CreaAttori {

    private static void professore(){
        Factory factory = new Factory();
        System.out.println("Creazione professore ...");
        Professore p = factory.creaProfessore(257);
        System.out.println("... professore creato");
        System.out.println(p.getPw() + "\n");
    }

    private static void segretaria(){
        Factory factory = new Factory();
        System.out.println("Creazione segretaria ...");
        Segretaria s = factory.creaSegretaria(98745);
        System.out.println("... Segretaria creata");
        System.out.println(s.getCODICECONTRATTO() + "\n");
    }

    public static void main(String args[]){
        professore();
        segretaria();
    }

}
