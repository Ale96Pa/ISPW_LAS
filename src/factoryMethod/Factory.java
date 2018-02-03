package factoryMethod;

import factoryMethod.LibreriaAttori.Attore;
import factoryMethod.LibreriaAttori.Professore;
import factoryMethod.LibreriaAttori.Segretaria;
import factoryMethod.LibreriaAttori.UtenteDao;

public class Factory {

    public Attore creaAttore(int type) throws Exception{
        switch (type){
            case 1:
                UtenteDao utenteDao = new UtenteDao();
                utenteDao.setAttore();
                return utenteDao;
            case 2:
                Professore professore = new Professore(256);
                professore.setAttore();
                return professore;
            case 3:
                Segretaria segretaria = new Segretaria(987);
                segretaria.setAttore();
                return segretaria;
            default: throw new Exception("Attore inserito (" + type +") inesistente!");
        }
    }

    public UtenteDao creaUtenteDao(){
        UtenteDao u = new UtenteDao();
        u.setAttore();
        return u;
    }

    public Professore creaProfessore(int code){
        Professore p = new Professore(code);
        p.setAttore();
        return p;
    }

    public Segretaria creaSegretaria(int code){
        Segretaria s = new Segretaria(code);
        s.setAttore();
        return s;
    }
}
