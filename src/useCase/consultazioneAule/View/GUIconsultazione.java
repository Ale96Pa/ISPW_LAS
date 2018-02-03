package useCase.consultazioneAule.View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import exceptions.InsertOraException;
import exceptions.InsertYearException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Objects;

public class GUIconsultazione extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Inizializzazione degli elementi grafici
    private Button button = new Button ("CONFERMA");
    private Label labelError = new Label("Inserisci dati");
    private Label labelAule = new Label("");
    private Label identifyAule = new Label("Aule disponibili:  ");

    private ComboBox<String> gg = new ComboBox<>();
    private ComboBox<String> mm = new ComboBox<>();
    private ComboBox<String> aa = new ComboBox<>();

    private ComboBox<String> oraDa = new ComboBox<>();
    private ComboBox<String> oraA = new ComboBox<>();

    private ComboBox<String> numPosti = new ComboBox<>();
    private ComboBox<String> proiettore = new ComboBox<>();
    private ComboBox<String> microfono = new ComboBox<>();



    @Override public void start(Stage stage) {
        stage.setTitle("Consultazione Aule");
        Scene scene = new Scene(new Group(), 850, 500);

        // Formattazione dei valori degli elementi grafici
        // ComboBox per la data
        gg.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13", "14","15","16","17",
                "18", "19","20","21","22","23","24","25","26","27","28","29","30","31");
        gg.setPromptText("1");
        mm.getItems().addAll("1","2","3","4","5","6", "7","8", "9","10","11", "12");
        mm.setPromptText("1");
        aa.getItems().addAll("2017","2018","2019","2020","2021");
        aa.setPromptText("2018");
        aa.setEditable(true);

        // ComboBox per la fascia oraria
        oraDa.getItems().addAll("8","9","10","11","12","13", "14","15","16","17","18");
        oraDa.setPromptText("8");
        oraA.getItems().addAll("9","10","11","12","13", "14","15","16","17","18");
        oraA.setPromptText("18");

        // ComboBox per il numer dei posti
        numPosti.getItems().addAll("50","100","150","200");
        numPosti.setPromptText("50");
        numPosti.setEditable(true);

        // ComboBox proiettore e microfono
        proiettore.getItems().addAll("Si","No");
        proiettore.setPromptText("No");
        microfono.getItems().addAll("Si","No");
        microfono.setPromptText("No");

        // Controllo del bottone
        button.setOnAction(e -> {
            try {
                registra();
                if (BeanConsultaAule.getAnno() < 2000 || BeanConsultaAule.getAnno() > 2100) {
                    errorAnno();
                    throw new InsertYearException();
                }
                else if (BeanConsultaAule.getOrainizio() >= BeanConsultaAule.getOrafine()) {
                    errorOra();
                    throw new InsertOraException();
                }
                else
                mostraAule();
            } catch (InsertYearException | InsertOraException e1) {
                e1.printStackTrace();
            }
        });

        // Inserimento dell'immagine
        Image image = new Image("Image\\logo.png");
        ImageView imgView = new ImageView(image);
        imgView.setFitHeight(150);
        imgView.setFitWidth(150);

        // Posizionamento degli elementi grafici su un GridPane
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        grid.add(imgView, 1, 0);

        grid.add(new javafx.scene.control.Label("Giorno"),3,1);
        grid.add(new javafx.scene.control.Label("Mese"),4,1);
        grid.add(new javafx.scene.control.Label("Anno"),5,1);
        grid.add(gg, 3,2);
        grid.add(mm,4,2);
        grid.add(aa,5,2);

        grid.add(new javafx.scene.control.Label("Fascia oraria: Da"),2,3);
        grid.add(oraDa,3,3);
        grid.add(new javafx.scene.control.Label("A"),4,3);
        grid.add(oraA,5,3);

        grid.add(new javafx.scene.control.Label("Numero posti"),0,7);
        grid.add(numPosti,1,7);
        grid.add(new javafx.scene.control.Label("Proiettore"),0,9);
        grid.add(proiettore,1,9);
        grid.add(new javafx.scene.control.Label("Microfono"),0,11);
        grid.add(microfono,1,11);

        grid.add(labelError, 4,9);
        grid.add(button, 4, 10);
        grid.add(labelAule, 2, 25);
        grid.add(identifyAule, 1, 25);

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

    // Costruzione dei modelli
    private void creaGiorno(){
        String giorno = gg.getValue();
        if (giorno == null)
            giorno = "1";
        BeanConsultaAule.setDay(Integer.parseInt(giorno));
    }

    private void creaMese(){
        String mese = mm.getValue();
        if(mese == null)
            mese = "1";
        BeanConsultaAule.setMonth(Integer.parseInt(mese));
    }

    private void creaAnno(){
        String anno = aa.getValue();
        if(anno == null)
            anno = "2018";
        BeanConsultaAule.setYear(Integer.parseInt(anno));
    }

    private void creaOraInizio(){
        String oraInizio = oraDa.getValue();
        if(oraInizio == null)
            oraInizio = "8";
        BeanConsultaAule.setOrastar(Integer.parseInt(oraInizio));
    }

    private void creaOraFine(){
        String oraFine = oraA.getValue();
        if(oraFine == null)
            oraFine = "18";
        BeanConsultaAule.setOraend(Integer.parseInt(oraFine));
    }

    private void creaNumeroPosti(){
        String posti = numPosti.getValue();
        if(posti == null)
            posti = "50";
        BeanConsultaAule.setNumposti(Integer.parseInt(posti));
    }

    private void creaProiettore(){
        String presenza = proiettore.getValue();
        if(presenza == null)
            presenza = "No";
        if(Objects.equals(presenza, "Si"))
            presenza = "true";
        else
            presenza = "false";
        BeanConsultaAule.setProj(Boolean.parseBoolean(presenza));
    }

    private void creaMicrofono(){
        String presenza = microfono.getValue();
        if(presenza == null)
            presenza = "No";
        if(Objects.equals(presenza, "Si"))
            presenza = "true";
        else
            presenza = "false";
        BeanConsultaAule.setMic(Boolean.parseBoolean(presenza));
    }

    private void registra(){
        creaGiorno();
        creaMese();
        creaAnno();

        creaOraInizio();
        creaOraFine();

        creaNumeroPosti();
        creaProiettore();
        creaMicrofono();
    }

    private void mostraAule(){
        ArrayList<String> aule = BeanConsultaAule.availableRoom();
        String listaAule = "";
        for(int i=0; i<aule.size(); i++)
            listaAule = listaAule + aule.get(i) + "    ";
        labelError.setText("");
        labelAule.setText(listaAule);
        if(aule.size() == 0){
            labelAule.setText("Non ci sono aule disponibili");
        }
    }

    private void errorAnno(){
        labelAule.setText("");
        labelError.setText("Errore inserimento anno");
    }
    private void errorOra(){
        labelAule.setText("");
        labelError.setText("Errore nell'orario");
    }

}