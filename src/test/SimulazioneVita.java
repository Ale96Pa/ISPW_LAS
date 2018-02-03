package test;

import thread.UtenteConsulta;
import thread.UtenteElimina;
import thread.UtentePrenota;

public class SimulazioneVita {

    public static void main(String args[]){

        UtentePrenota u1 = new UtentePrenota(5000, 1);
        u1.start();

        UtentePrenota u2 = new UtentePrenota(10000, 2);
        u2.start();

        UtenteElimina u3 = new UtenteElimina(8000);
        u3.start();

        UtenteConsulta u4 = new UtenteConsulta(4000, 4);
        u4.start();

        UtenteConsulta u5 = new UtenteConsulta(9000, 5);
        u5.start();

    }
}
